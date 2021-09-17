/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.sgaejb_jpa.dao.aficion.impl;

import com.arelance.sgaejb_jpa.dao.aficion.AficionDAO;
import com.arelance.sgajpa.domain.Aficion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mefisto
 */
@Stateless
public class AficionDAOImpl implements AficionDAO {

    @PersistenceContext(unitName = "sgaPU")
    EntityManager em;

    @Override
    public List<Aficion> findAllAficion() {
        return  em.createNamedQuery("Aficion.findAll").getResultList();
    }

    @Override
    public void altaAficion(Aficion aficion) {
        em.persist(aficion);
    }

    @Override
    public void modificar(Aficion aficion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
