/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.deportessa.proyectodeportes.daojpa.impl.postgre;

import com.deportessa.proyectodeportes.daojpa.DaoGenericoAbstracto;
import com.deportessa.proyectodeportes.daojpa.PaypalLocal;
import com.deportessa.proyectodeportes.daojpa.qulifiers.PaypalPostgre;
import com.deportessa.proyectodeportes.modelo.Paypal;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Singleton
@PaypalPostgre
public class PaypalPostgreImpl extends DaoGenericoAbstracto<Paypal, Integer> implements PaypalLocal {

    @PersistenceContext(unitName = "mysql")
    private EntityManager em;

    public PaypalPostgreImpl() {
        super(Paypal.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
