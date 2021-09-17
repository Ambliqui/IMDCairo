/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.sgaejb_jpa.services.personaservice;

import com.arelance.sgajpa.domain.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author salvador
 */
@Local
public interface PersonaService {

    public List<Persona> listarPersonas();
    public Persona findPersonaById(Persona persona);
    public Persona findPersonaById(Integer id);
    public Persona findPersonaByEmail(Persona persona);
    public void addPersona(Persona persona);
    public void updatePersona(Persona persona);
    public void removePersona(Persona persona);
    public void refreshPersona(Persona persona);

}
