/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.services.inscripcion.impl;

import com.arelance.imd.domain.Inscripcion;
import com.arelance.imd.domain.Login;
import com.arelance.imd.domain.Usuario;
import com.arelance.imd.model.inscripcionesDAO.InscripcionesDAO;
import com.arelance.imd.services.inscripcion.ServicesInscripcion;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Mefisto
 */

public class ServicesInscripcionImpl implements ServicesInscripcion{

    @Inject
    InscripcionesDAO inscripcionesDAO;
    
    @Override
    public List<Inscripcion> finByUser(Login login) {
        return inscripcionesDAO.findByUser(login);
    }
    
}
