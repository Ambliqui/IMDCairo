/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.sgaejb_jpa.services.personaservice.impl;

import com.arelance.sgaejb_jpa.dao.persona.PersonaDAO;
import com.arelance.sgaejb_jpa.services.personaservice.PersonaService;
import com.arelance.sgajpa.domain.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author salvador
 */
public class PersonaServiceImpl implements PersonaService {

    @Inject
    private PersonaDAO personaDAO;

    @Override
    public List<Persona> listarPersonas() {
        return personaDAO.listarPersonas();
    }

    @Override
    public Persona findPersonaByEmail(Persona persona) {
        return personaDAO.findPersonaByEmail(persona);
    }

    @Override
    public void addPersona(Persona persona) {
        personaDAO.addPersona(persona);
    }

    @Override
    public void updatePersona(Persona persona) {
        personaDAO.updatePersona(persona);
    }

    @Override
    public void removePersona(Persona persona) {
        personaDAO.removePersona(persona);
    }

    @Override
    public Persona findPersonaById(Persona persona) {
        return personaDAO.findPersonaByID(persona);

    }

    @Override
    public Persona findPersonaById(Integer id) {
        return personaDAO.findPersonaByID(id);
    }

    @Override
    public void refreshPersona(Persona persona) {
        personaDAO.refreshPersona(persona);
    }

}
