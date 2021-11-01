/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa.impl.MySql;

import com.deportessa.proyectodeportes.daojpa.DaoGenericoAbstracto;
import com.deportessa.proyectodeportes.modelo.Entrenador;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.deportessa.proyectodeportes.daojpa.EntrenadorLocal;
import com.deportessa.proyectodeportes.daojpa.qulifiers.EntrenadorMysql;

/**
 *
 * @author Antonio
 */
@Stateless
@EntrenadorMysql
public class EntrenadorMySqlImpl extends DaoGenericoAbstracto<Entrenador, Integer> implements EntrenadorLocal {

     @PersistenceContext(unitName = "mysql", name = "jdbc/Sakila")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntrenadorMySqlImpl() {
        super(Entrenador.class);
    }
    
}
