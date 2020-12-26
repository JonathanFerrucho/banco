/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.intempo.banco.logica;

import co.com.intempo.banco.dto.ConvenioDTO;
import co.com.intempo.banco.dto.MensajeDTO;
import javax.ejb.Stateless;

/**
 *
 * @author Dmoviliza
 */
@Stateless
public class ConvenioLogica {
    
    //@EJB
    //private ClenteAgua clenteAgua;
    
    public Double consultarValorFactura(ConvenioDTO convenioDTO, Long idFactura){
        ClenteAgua clenteAgua= new ClenteAgua();
                
        if(convenioDTO.getCompesancionPago()){
            return clenteAgua.consultarFactura(idFactura);
        }else{
            
        }
        return 0D;
    }
    
        public MensajeDTO pagarFacTura(ConvenioDTO convenioDTO, Long idFactura, Double valorFactura){
        ClenteAgua clenteAgua= new ClenteAgua();
                
        if(convenioDTO.getCompesancionPago()){
            return clenteAgua.pagarFactura(idFactura, valorFactura);
        }else{
            
        }
        return null;
    }
}