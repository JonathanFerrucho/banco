/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.intempo.banco.logica;

import co.com.intempo.banco.dto.ConvenioDTO;
import co.com.intempo.banco.dto.MensajeDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;

/**
 *
 * @author Dmoviliza
 */
@Stateless
public class ConvenioLogica {

    //@EJB
    //private ClenteAgua clenteAgua;
    public List<ConvenioDTO> Listaconvenios = new ArrayList();

    public ConvenioLogica() {
        Listaconvenios.add(new ConvenioDTO(1L, "Agua", Boolean.TRUE));
        Listaconvenios.add(new ConvenioDTO(2L, "Gas", Boolean.FALSE));
    }

    public ConvenioDTO obtner(Long convenioId) {
        Optional<ConvenioDTO> optConvenioDTO = Listaconvenios.stream().filter(u -> u.getId().equals(convenioId)).findFirst();

        return optConvenioDTO.isPresent() ? optConvenioDTO.get() : null;
    }


    public Double consultarValorFactura(ConvenioDTO convenioDTO, Long idFactura) {

        if (convenioDTO.getCompesancionPago()) {
            ClenteAgua clenteAgua = new ClenteAgua();
            return clenteAgua.consultarFactura(idFactura);
        } else {
            ClenteGas clenteGas = new ClenteGas();
            return clenteGas.consultarFactura(idFactura);
        }
    }

    public MensajeDTO pagarFacTura(ConvenioDTO convenioDTO, Long idFactura, Double valorFactura) {
        ClenteAgua clenteAgua = new ClenteAgua();

        if (convenioDTO.getCompesancionPago()) {
            return clenteAgua.pagarFactura(idFactura, valorFactura);
        } else {

        }
        return null;
    }
}
