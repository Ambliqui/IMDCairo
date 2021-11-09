/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.deportessa.proyectodeportes.daojpa.impl.postgre;

import com.deportessa.proyectodeportes.daojpa.DaoGenericoAbstracto;
import com.deportessa.proyectodeportes.daojpa.TransferenciaLocal;
import com.deportessa.proyectodeportes.daojpa.qulifiers.TransferenciaPostgre;
import com.deportessa.proyectodeportes.modelo.Transferencia;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Singleton
@TransferenciaPostgre
public class TransferenciaPostgreImpl extends DaoGenericoAbstracto<Transferencia, Integer> implements TransferenciaLocal {

    @PersistenceContext(unitName = "mysql")
    private EntityManager em;

    public TransferenciaPostgreImpl() {
        super(Transferencia.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
