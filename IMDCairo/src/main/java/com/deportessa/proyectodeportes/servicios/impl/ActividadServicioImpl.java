/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios.impl;

import com.deportessa.proyectodeportes.daojpa.factory.DaoAbstractFactoryLocal;
import com.deportessa.proyectodeportes.daojpa.factory.qualifiers.FactoryDaoMySql;
import com.deportessa.proyectodeportes.modelo.Actividad;
import com.deportessa.proyectodeportes.servicios.ActividadServicio;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ActividadServicioImpl implements ActividadServicio {

    @Inject
    @FactoryDaoMySql
    private DaoAbstractFactoryLocal daoFactoryLocal;

    @Override
    public List<Actividad> findAll() {
        return daoFactoryLocal.getActividadDaoLocal().findAll();
    }

    @Override
    public Actividad find(Integer idActividad) {
        return daoFactoryLocal.getActividadDaoLocal().find(idActividad);
    }

}
