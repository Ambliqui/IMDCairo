/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa.impl.MySql;

import com.deportessa.proyectodeportes.daojpa.DaoGenericoAbstracto;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.deportessa.proyectodeportes.daojpa.InscripcionLocal;
import com.deportessa.proyectodeportes.daojpa.qulifiers.InscripcionMysql;
import javax.ejb.Singleton;

/**
 *
 * @author Antonio
 */
@Singleton
@InscripcionMysql
public class InscripcionMySqlImpl extends DaoGenericoAbstracto<Inscripcion, Integer> implements InscripcionLocal {

     @PersistenceContext(unitName = "mysql", name = "jdbc/Sakila")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InscripcionMySqlImpl() {
        super(Inscripcion.class);
    }
    
}
