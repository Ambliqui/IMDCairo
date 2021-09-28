/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.services.actividad.impl;

import com.arelance.imd.domain.Actividad;
import com.arelance.imd.domain.Usuario;
import com.arelance.imd.model.actividadesDAO.ActividadDAO;
import java.util.List;
import javax.inject.Inject;
import com.arelance.imd.services.actividad.ServicesActividad;

/**
 *
 * @author Mefisto
 */

public class ServicesActividadImpl implements ServicesActividad {

    @Inject
    ActividadDAO actividadDAO;

    @Override
    public List<Actividad> findAll() {
        return actividadDAO.findAll();
    }

    @Override
    public Actividad searchActivity(Actividad actividad) {
        return actividadDAO.searchActivity(actividad);
    }

    @Override
    public List<Actividad> inscripcionesUsuario(Usuario usuario) {
        return actividadDAO.inscripcionesUsuario(usuario);
    }
    
}
