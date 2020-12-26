/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.intempo.banco.logica;

import co.com.intempo.banco.clinteGasDTO.Body;
import co.com.intempo.banco.clinteGasDTO.Envelope;
import co.com.intempo.banco.clinteGasDTO.ReferenciaFactura;
import co.com.intempo.banco.dto.MensajeDTO;
import javax.ejb.Stateless;

/**
 *
 * @author Dmoviliza
 */
@Stateless
public class ClenteGas implements ConeccionClientePago {

    public static String URL_AGUA = "http://130.211.116.156:80/gas-service/PagosService/";

    @Override
    public Double consultarFactura(Long idFactura) {

        return null;
    }

    @Override
    public MensajeDTO pagarFactura(Long idFactura, Double valorFactura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void cargaArchivoComparendos(Long datos, String endpoint) throws Exception {
        //RespuestaSimitDTO respuesta = new RespuestaSimitDTO();
        //respuesta.setEndpoint(endpoint);
        //crear el envelope
        Envelope env = new Envelope();
        env.setBody(new Body());
        env.getBody().setReferenciaFactura(new ReferenciaFactura());
        /*
        EnvelopeResponse response = consumirServicio(env, endpoint, ACCION_CARGAARCHIVOCOMPARENDO, respuesta);
        if (response == null) {
            return null;
        }
        respuesta.setRespuesta(response.getBody().getCargaArchivoComparendosResponse().getRespuesta());
        return respuesta;
        */
    }
}
