/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.intempo.banco.servicio;

import co.com.intempo.banco.dto.MensajeDTO;
import co.com.intempo.banco.dto.PagoDTO;
import co.com.intempo.banco.logica.PagoLogica;
import com.wordnik.swagger.annotations.Api;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Dmoviliza
 */
@Stateless
@Path("/pago")
@Api(value = "/pago", description = "Servicios para el pago de facturas")
public class PagoServicio {

    @EJB
    private PagoLogica logica;

    @GET
    @Path("/prueba")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Servicio de Prueba deconexion")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 500, message = "Error en el servidor")})
    public boolean conexion() {
        return true;
    }

    @POST
    @Path("/pagar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Servicio de para pagar ",
            notes = "servicio para pagar servicios con entidades que tengan "
            + "convenios")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 500, message = "Error en el servidor")})
    public MensajeDTO pagarFactura(@HeaderParam("usuarioId") Long usuarioId, PagoDTO pagoDTO) {
        return logica.pagar(usuarioId, pagoDTO);
    }

}
