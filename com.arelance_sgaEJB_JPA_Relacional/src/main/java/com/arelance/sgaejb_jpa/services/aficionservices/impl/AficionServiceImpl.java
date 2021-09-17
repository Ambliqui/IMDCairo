/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.sgaejb_jpa.services.aficionservices.impl;

import com.arelance.sgaejb_jpa.dao.aficion.AficionDAO;
import com.arelance.sgajpa.domain.Aficion;
import java.util.List;
import com.arelance.sgaejb_jpa.services.aficionservices.AficionService;
import javax.inject.Inject;

/**
 *
 * @author Mefisto
 */
public class AficionServiceImpl implements AficionService{

    @Inject
    AficionDAO aficionDAO;
    
    @Override
    public List<Aficion> findAllAficion() {
        return aficionDAO.findAllAficion();
    }

    @Override
    public void alta(Aficion aficion) {
        aficionDAO.altaAficion(aficion);
    }

    @Override
    public void modificar(Aficion aficion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
