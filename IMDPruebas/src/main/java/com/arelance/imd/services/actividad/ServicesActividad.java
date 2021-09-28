/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.services.actividad;

import com.arelance.imd.domain.Actividad;
import com.arelance.imd.domain.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mefisto
 */
@Local
public interface ServicesActividad {
    
    List<Actividad> findAll();
    Actividad searchActivity(Actividad actividad);
    List<Actividad> inscripcionesUsuario(Usuario usuario);
    
}
