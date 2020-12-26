/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.intempo.banco.logica;

import co.com.intempo.banco.clinteGasDTO.Body;
import co.com.intempo.banco.clinteGasDTO.Envelope;
import co.com.intempo.banco.clinteGasDTO.EnvelopeResponse;
import co.com.intempo.banco.clinteGasDTO.ReferenciaFactura;
import co.com.intempo.banco.dto.MensajeDTO;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Dmoviliza
 */
@Stateless
public class ClenteGas implements ConeccionClientePago {

    public static String URL_AGUA = "http://130.211.116.156:80/gas-service/PagosService";

    private static final String ACCION_CONSULTAR = "consultar";

    @Override
    public Double consultarFactura(Long idFactura) {
        try {
            Envelope env = new Envelope();
            env.setBody(new Body());
            env.getBody().setReferenciaFactura(new ReferenciaFactura());
            env.getBody().getReferenciaFactura().setReferenciaFactura(idFactura.toString());

            EnvelopeResponse response = consumirServicio(env, URL_AGUA, ACCION_CONSULTAR);
            if (response == null) {
                return null;
            }

            return response.getBody().getResultadoConsulta().getTotalPagar();
        } catch (Exception ex) {
            System.err.println("No se pudo consumir el servicio de consulta de factura");
            return 0D;
        }
    }

    @Override
    public MensajeDTO pagarFactura(Long idFactura, Double valorFactura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private EnvelopeResponse consumirServicio(Envelope request, String endpoint, String accion)
            throws Exception {
        JAXBContext jaxbrequest = JAXBContext.newInstance(Envelope.class);
        JAXBContext jaxbresponse = JAXBContext.newInstance(EnvelopeResponse.class);

        Marshaller marshaller = jaxbrequest.createMarshaller();
        HttpURLConnection connection = null;
        try {
            //Create connection
            URL url = new URL(endpoint);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
            connection.setRequestProperty("Accept-Encoding", "gzip,deflate,text/plain");
            connection.setRequestProperty("Host", "130.211.116.156:80");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("User-Agent", "Apache-HttpClient/4.1.1 (java 1.5)");
            connection.setRequestProperty("SOAPAction", accion);

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            marshaller.marshal(request, baos);//connection.getOutputStream()
            System.err.println(new String(baos.toByteArray()));
            marshaller.marshal(request, connection.getOutputStream());

            Unmarshaller unmarshaller = jaxbresponse.createUnmarshaller();
            try (InputStream is = connection.getInputStream();) {
                Object response = unmarshaller.unmarshal(is);
                return ((EnvelopeResponse) response);
            }
        } catch (SocketTimeoutException ex) {
            System.err.println("No se pudo completar el envio por intermitencia del servicio");
        } catch (SocketException ex) {
            System.err.println(ex);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }
}
