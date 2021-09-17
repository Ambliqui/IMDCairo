/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.model.loginDAO.impl;

import com.arelance.imd.domain.Login;
import com.arelance.imd.model.loginDAO.LoginDAO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Mefisto
 */
@Stateless
public class LoginDAOImpl implements LoginDAO {

    @PersistenceContext(unitName = "IMDDB")
    EntityManager em;

    @Override
    public void alta(Login login) {
        em.persist(login);
    }

    @Override
    public Login findLoginById(Login login) {
        return em.find(Login.class, login.getIdUsuarioLogin());
    }

    @Override
    public Login findLoginByEmail(Login login) {
        Query query =em.createQuery("FROM Login l WHERE l.emailLogin =:email");
        query.setParameter("email", login.getEmailLogin());
        return (Login) query.getSingleResult();
    }

}
