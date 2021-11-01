/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa.impl.MySql;

import com.deportessa.proyectodeportes.daojpa.DaoGenericoAbstracto;
import com.deportessa.proyectodeportes.modelo.Actividad;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.deportessa.proyectodeportes.daojpa.ActividadLocal;
import com.deportessa.proyectodeportes.daojpa.qulifiers.ActividadMysql;
import javax.ejb.Singleton;

/**
 *
 * @author Antonio
 */
@Singleton
@ActividadMysql
public class ActividadMySqlImpl extends DaoGenericoAbstracto<Actividad,Integer> implements ActividadLocal {

    @PersistenceContext(unitName = "mysql", name = "jdbc/Sakila")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadMySqlImpl() {
        super(Actividad.class);
    }
    
}
