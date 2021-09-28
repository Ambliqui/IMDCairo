/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.institutomunicipaldeportes.model.usuarioDAO.impl;

import com.arelance.institutomunicipaldeportes.model.beans.Login;
import com.arelance.institutomunicipaldeportes.model.beans.Usuario;
import com.arelance.institutomunicipaldeportes.model.usuarioDAO.UsuarioDAO;
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
        return em.find(Usuario.class, usuario.getId());
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
