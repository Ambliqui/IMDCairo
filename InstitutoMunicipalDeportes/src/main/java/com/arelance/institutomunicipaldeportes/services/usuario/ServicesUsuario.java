/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.institutomunicipaldeportes.services.usuario;

import com.arelance.institutomunicipaldeportes.model.beans.Usuario;
import javax.ejb.Remote;

/**
 *
 * @author Mefisto
 */

@Remote
public interface ServicesUsuario {
    
    boolean alta(Usuario usuario);
    boolean modificar (Usuario usuario);
    Usuario findUserById(Usuario usuario);
    //TODO metodo sobrante
    Usuario findUserByEmail(Usuario usuario);
    
}
