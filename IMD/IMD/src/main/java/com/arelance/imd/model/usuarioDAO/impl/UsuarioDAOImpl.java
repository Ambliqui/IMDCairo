/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.model.usuarioDAO.impl;

import com.arelance.imd.domain.Usuario;
import com.arelance.imd.model.usuarioDAO.UsuarioDAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Mefisto
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    @PersistenceContext(unitName = "IMDDB")
    EntityManager em;

    @Override
    public Usuario findUserByID(Usuario usuario) {
        return em.find(Usuario.class, usuario.getIdUsuario());
    }

    @Override
    public boolean alta(Usuario usuario) {
        em.persist(em);
        return true;
    }

    @Override
    public boolean modificar(Usuario usuario) {
        em.merge(usuario);
        return true;
    }

}