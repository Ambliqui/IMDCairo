/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.sgaejb_jpa.dao.persona;


import com.arelance.sgajpa.domain.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author salvador
 */
@Local
public interface PersonaDAO {
    public List<Persona> listarPersonas();
    public Persona findPersonaByEmail(Persona persona);
    public Persona findPersonaByID(Persona persona);
    public Persona findPersonaByID(int  id);
    public void addPersona(Persona persona);
    public void updatePersona(Persona persona);
    public void removePersona(Persona persona);
    void refreshPersona(Persona persona);
}
