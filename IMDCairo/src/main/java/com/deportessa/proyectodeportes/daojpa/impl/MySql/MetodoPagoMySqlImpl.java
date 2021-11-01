/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa.impl.MySql;

import com.deportessa.proyectodeportes.daojpa.DaoGenericoAbstracto;
import com.deportessa.proyectodeportes.modelo.MetodoPago;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.deportessa.proyectodeportes.daojpa.MetodoPagoLocal;
import com.deportessa.proyectodeportes.daojpa.qulifiers.MetodoPagoMysql;
import javax.ejb.Singleton;

/**
 *
 * @author Antonio
 */
@Singleton
@MetodoPagoMysql
public class MetodoPagoMySqlImpl extends DaoGenericoAbstracto<MetodoPago, Integer> implements MetodoPagoLocal {

    @PersistenceContext(unitName = "mysql", name = "jdbc/Sakila")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MetodoPagoMySqlImpl() {
        super(MetodoPago.class);
    }
    
}
