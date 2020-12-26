/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.intempo.banco.logica;

import co.com.intempo.banco.dto.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;

/**
 *
 * @author Dmoviliza
 */
@Stateless
public class UsuarioLogica {

    public List<UsuarioDTO> listaUsuarios = new ArrayList();

    public UsuarioLogica() {
        listaUsuarios.add(new UsuarioDTO(1L, "Luis", 90000000D));
        listaUsuarios.add(new UsuarioDTO(2L, "Juan", 0D));
    }

    public UsuarioDTO obtner(Long usuarioId) {
        Optional<UsuarioDTO> optUsuario = listaUsuarios.stream().filter(u -> u.getId().equals(usuarioId)).findFirst();

        return optUsuario.isPresent() ? optUsuario.get() : null;
    }

    public Double obtnerSaldo(Long usuarioId) {
        Optional<UsuarioDTO> optUsuario = listaUsuarios.stream().filter(u -> u.getId().equals(usuarioId)).findFirst();

        return optUsuario.isPresent() ? optUsuario.get().getSaldo() : 0D;
    }
}
