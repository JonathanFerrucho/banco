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
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private Double saldo;

    public UsuarioDTO() {
    }
    
    public UsuarioDTO(Long id, String nombre, Double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
    }
}
