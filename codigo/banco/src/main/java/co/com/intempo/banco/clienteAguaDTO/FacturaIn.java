/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.intempo.banco.clienteAguaDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 *
 * @author Dmoviliza
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class FacturaIn {

    public Double valorFactura;

    public FacturaIn() {
    }

    public FacturaIn(Double valorFactura) {
        this.valorFactura = valorFactura;
    }

}
