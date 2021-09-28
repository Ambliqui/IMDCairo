/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.institutomunicipaldeportes.services.usuario.impl;

import com.arelance.institutomunicipaldeportes.model.beans.Usuario;
import com.arelance.institutomunicipaldeportes.model.usuarioDAO.UsuarioDAO;
import com.arelance.institutomunicipaldeportes.services.usuario.ServicesUsuario;
import javax.inject.Inject;

/**
 *
 * @author Mefisto
 */
public class ServicesUsuarioImpl implements ServicesUsuario {

    @Inject
    UsuarioDAO usuarioDAO;

    @Override
    public Usuario findUserById(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario findUserByEmail(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean alta(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
