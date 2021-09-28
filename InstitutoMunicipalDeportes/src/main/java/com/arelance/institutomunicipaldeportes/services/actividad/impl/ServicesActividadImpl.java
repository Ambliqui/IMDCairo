/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.institutomunicipaldeportes.services.actividad.impl;

import com.arelance.institutomunicipaldeportes.model.actividadesDAO.ActividadDAO;
import com.arelance.institutomunicipaldeportes.model.beans.Actividad;
import com.arelance.institutomunicipaldeportes.model.beans.Usuario;
import java.util.List;
import javax.inject.Inject;
import com.arelance.institutomunicipaldeportes.services.actividad.ServicesActividad;

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
