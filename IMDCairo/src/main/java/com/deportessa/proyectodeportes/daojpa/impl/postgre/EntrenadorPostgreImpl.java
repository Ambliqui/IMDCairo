/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.deportessa.proyectodeportes.daojpa.impl.postgre;

import com.deportessa.proyectodeportes.daojpa.DaoGenericoAbstracto;
import com.deportessa.proyectodeportes.daojpa.EntrenadorLocal;
import com.deportessa.proyectodeportes.daojpa.qulifiers.EntrenadorPostgre;
import com.deportessa.proyectodeportes.modelo.Entrenador;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Singleton
@EntrenadorPostgre
public class EntrenadorPostgreImpl extends DaoGenericoAbstracto<Entrenador, Integer> implements EntrenadorLocal {

    @PersistenceContext(unitName = "mysql")
    private EntityManager em;

    public EntrenadorPostgreImpl() {
        super(Entrenador.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
