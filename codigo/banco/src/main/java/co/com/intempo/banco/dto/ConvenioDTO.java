/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.intempo.banco.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 *
 * @author Dmoviliza
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ConvenioDTO {
    
    private Long id;
    private String nombreConvenio;
    private Boolean compesancionPago;

    public ConvenioDTO() {
    }
    
    public ConvenioDTO(Long id, String nombreConvenio, Boolean compesancionPago) {
        this.id = id;
        this.nombreConvenio = nombreConvenio;
        this.compesancionPago = compesancionPago;
    }
    
    
}
