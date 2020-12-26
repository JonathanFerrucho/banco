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
public class FacturaOut {
    private Long idFactura;
    private Double valorFactura;
}
