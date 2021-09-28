/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.institutomunicipaldeportes.model.loginDAO.impl;

import com.arelance.institutomunicipaldeportes.model.beans.Login;
import com.arelance.institutomunicipaldeportes.model.loginDAO.LoginDAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Mefisto
 */
public class LoginDAOImpl implements LoginDAO {

    @PersistenceContext(unitName = "IMDDB")
    EntityManager em;

    @Override
    public void alta(Login login) {
        em.persist(login);
    }

    @Override
    public Login findLoginById(Login login) {
        return em.find(Login.class, login.getIdLogin());
    }

    @Override
    public Login findLoginByEmail(Login login) {
        Query query =em.createQuery("from Login l WHERE l.email =:email");
        query.setParameter("email", login.getEmail());
        return (Login) query.getSingleResult();
    }

}
