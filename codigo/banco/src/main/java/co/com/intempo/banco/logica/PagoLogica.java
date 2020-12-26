/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.intempo.banco.logica;

import co.com.intempo.banco.dto.MensajeDTO;
import co.com.intempo.banco.dto.PagoDTO;
import co.com.intempo.banco.dto.UsuarioDTO;
import co.com.intempo.banco.util.Constantes;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Dmoviliza
 */
@Stateless
public class PagoLogica {

    @EJB
    private UsuarioLogica usuarioLogica;
    @EJB
    private ConvenioLogica convenioLogica;

    public MensajeDTO pagar(Long usuarioId, PagoDTO pagoDTO) {
        MensajeDTO mensajeDTO = new MensajeDTO();
        mensajeDTO.setCodigoResultado(Constantes.CodigosRespuesta.FALLIDO);

        UsuarioDTO usuarioDTO = usuarioLogica.obtner(usuarioId);
        if (usuarioDTO == null) {
            mensajeDTO.setMensaje("Usuario no registrado");
            return mensajeDTO;
        }

        Double valorFactura = convenioLogica.consultarValorFactura(pagoDTO.getConvenio(), pagoDTO.getNumeroReferencia());

        Double saldo = usuarioLogica.obtnerSaldo(usuarioId);
        if (saldo == null || saldo <= 0L
                || valorFactura > saldo) {
            mensajeDTO.setMensaje("Actualmente no cuenta con saldo disponible para pagar la factura");
            return mensajeDTO;
        }

        return convenioLogica.pagarFacTura(pagoDTO.getConvenio(), pagoDTO.getNumeroReferencia(), valorFactura);
    }
}
