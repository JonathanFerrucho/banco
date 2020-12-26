/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.intempo.banco.logica;

import co.com.intempo.banco.dto.MensajeDTO;
import javax.ejb.Local;

/**
 *
 * @author Dmoviliza
 */
@Local
public interface ConeccionClientePago{

    public Double consultarFactura(Long idFactura);

    public MensajeDTO pagarFactura(Long idFactura, Double valorFactura);
}
