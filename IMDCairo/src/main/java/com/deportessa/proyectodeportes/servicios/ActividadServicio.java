/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios;

import com.deportessa.proyectodeportes.modelo.Actividad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mefisto
 */
@Local
public interface ActividadServicio {
    
    List<Actividad> findAll();
    
    Actividad find(Integer idActividad);
}
