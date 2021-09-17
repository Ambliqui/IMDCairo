/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.sgaejb_jpa.dao.persona.impl;

import com.arelance.sgaejb_jpa.dao.persona.PersonaDAO;
import com.arelance.sgajpa.domain.Persona;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author salvador
 */
@Stateless
public class PersonaDAOImpl implements PersonaDAO {

    @PersistenceContext(unitName = "sgaPU")
    EntityManager em;

    @Override
    public List<Persona> listarPersonas() {
        return em.createNamedQuery("Persona.findAll").getResultList();
    }

    @Override
    public Persona findPersonaByID(int id) {
        return em.find(Persona.class, id);
    }

    @Override
    public Persona findPersonaByID(Persona persona) {
        return em.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public Persona findPersonaByEmail(Persona persona) {
        Query query = em.createQuery("from Persona p where p.email= :email");
        query.setParameter("email", persona.getEmail());
        return (Persona) query.getSingleResult();
    }

    @Override
    public void addPersona(Persona persona) {
        em.persist(persona);
    }

    @Override
    public void updatePersona(Persona persona) {
        em.merge(persona);
    }

    @Override
    public void removePersona(Persona persona) {
        em.remove(em.merge(persona));
    }

    @Override
    public void refreshPersona(Persona persona) {
        em.refresh(em.merge(persona));
    }
}
