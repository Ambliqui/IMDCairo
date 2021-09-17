/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.model.usuarioDAO;

import com.arelance.imd.domain.Usuario;
import javax.ejb.Local;

/**
 *
 * @author Mefisto
 */
@Local
public interface UsuarioDAO {

    Usuario findUserByID(Usuario usuario);
    boolean alta(Usuario usuario);
    boolean modificar(Usuario usuario);
}
