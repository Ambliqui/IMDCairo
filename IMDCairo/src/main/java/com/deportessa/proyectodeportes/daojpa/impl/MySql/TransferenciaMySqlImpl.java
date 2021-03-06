/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa.impl.MySql;

import com.deportessa.proyectodeportes.daojpa.DaoGenericoAbstracto;
import com.deportessa.proyectodeportes.modelo.Transferencia;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.deportessa.proyectodeportes.daojpa.TransferenciaLocal;
import com.deportessa.proyectodeportes.daojpa.qulifiers.TransferenciaMysql;
import javax.ejb.Singleton;

/**
 *
 * @author Antonio
 */
@Singleton
@TransferenciaMysql
public class TransferenciaMySqlImpl extends DaoGenericoAbstracto<Transferencia, Integer> implements TransferenciaLocal {

    @PersistenceContext(unitName = "mysql", name = "jdbc/Sakila")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransferenciaMySqlImpl() {
        super(Transferencia.class);
    }

}
