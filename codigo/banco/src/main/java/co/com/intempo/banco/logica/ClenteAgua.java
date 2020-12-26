/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.intempo.banco.logica;

import co.com.intempo.banco.clienteAguaDTO.FacturaIn;
import co.com.intempo.banco.clienteAguaDTO.FacturaOut;
import co.com.intempo.banco.clienteAguaDTO.RespuestaDTO;
import co.com.intempo.banco.dto.MensajeDTO;
import co.com.intempo.banco.util.Constantes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author Dmoviliza
 */
@Stateless
public class ClenteAgua implements ConeccionClientePago {

    private final Integer TIME_OUT = 5000;
    private final String APPLICATION_JSON = "application/json";
    private final String CONTENT_TYPE = "Content-Type";

    private final Integer CODIGO_404 = 404;
    private final Integer CODIGO_200 = 200;

    public static String URL_AGUA = "http://130.211.116.156/servicios/pagos/v1/payments/";

    @Override
    public Double consultarFactura(Long idFactura) {
        JsonDeserializer<Date> deser = new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonElement je, java.lang.reflect.Type type, JsonDeserializationContext jdc) throws JsonParseException {
                return je == null ? null : new Date(je.getAsLong());
            }
        };

        Gson gjson = new GsonBuilder().registerTypeAdapter(Date.class, deser).create();

        Client client = Client.create();
        client.setConnectTimeout(TIME_OUT);
        client.setReadTimeout(TIME_OUT);
        WebResource webResource = client.resource(URL_AGUA + idFactura.toString());
        ClientResponse response = webResource.accept(APPLICATION_JSON)
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .get(ClientResponse.class);
        if (response.getStatus() != 200) {
            return null;
        }
        String json = response.getEntity(String.class);
        System.err.println("json " + json);
        FacturaOut facturaOut = gjson.fromJson(json, FacturaOut.class);

        return facturaOut.getValorFactura();
    }

    @Override
    public MensajeDTO pagarFactura(Long idFactura, Double valorFactura) {

        MensajeDTO mensajeDTO = new MensajeDTO();
        mensajeDTO.setCodigoResultado(Constantes.CodigosRespuesta.FALLIDO);

        RespuestaDTO output = new RespuestaDTO();

        FacturaIn facturaIn = new FacturaIn(valorFactura);
        Gson gjson = new Gson();
        Client client = Client.create();
        client.setConnectTimeout(TIME_OUT);
        client.setReadTimeout(TIME_OUT);
        WebResource webResource = client.resource(URL_AGUA + idFactura.toString());
        String in = gjson.toJson(facturaIn);
        System.err.println("in " + in);
        ClientResponse response = webResource.accept(APPLICATION_JSON)
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .post(ClientResponse.class, gjson.toJson(facturaIn));

        if (response != null
                && CODIGO_404.equals(response.getStatus())) {
            String json = response.getEntity(String.class);
            System.err.println("json " + json);
            output = gjson.fromJson(json, RespuestaDTO.class);
            if (CODIGO_200.equals(response.getStatus())) {
                mensajeDTO.setCodigoResultado(Constantes.CodigosRespuesta.EXITOSO);
            }
            mensajeDTO.setMensaje(output.getMensaje());
            return mensajeDTO;
        }

        return null;
    }

}
