/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.deportessa.proyectodeportes.daojpa.impl.postgre;

import com.deportessa.proyectodeportes.daojpa.DaoGenericoAbstracto;
import com.deportessa.proyectodeportes.daojpa.TarjetaLocal;
import com.deportessa.proyectodeportes.daojpa.qulifiers.TarjetaPostgre;
import com.deportessa.proyectodeportes.modelo.Tarjeta;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Singleton
@TarjetaPostgre
public class TarjetaPostgreImpl extends DaoGenericoAbstracto<Tarjeta, Integer> implements TarjetaLocal{

    @PersistenceContext(unitName = "mysql")
    private EntityManager em;

    public TarjetaPostgreImpl() {
        super(Tarjeta.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
