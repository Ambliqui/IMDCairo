/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa.impl.MySql;

import com.deportessa.proyectodeportes.daojpa.DaoGenericoAbstracto;
import com.deportessa.proyectodeportes.modelo.Paypal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.deportessa.proyectodeportes.daojpa.PaypalLocal;
import com.deportessa.proyectodeportes.daojpa.qulifiers.PaypalMysql;

/**
 *
 * @author Antonio
 */
@Stateless
@PaypalMysql
public class PaypalMySqlImpl extends DaoGenericoAbstracto<Paypal, Integer> implements PaypalLocal {

     @PersistenceContext(unitName = "mysql", name = "jdbc/Sakila")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaypalMySqlImpl() {
        super(Paypal.class);
    }
    
}
