/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.deportessa.proyectodeportes.daojpa.impl.postgre;

import com.deportessa.proyectodeportes.daojpa.DaoGenericoAbstracto;
import com.deportessa.proyectodeportes.daojpa.MetodoPagoLocal;
import com.deportessa.proyectodeportes.daojpa.qulifiers.MetodoPagoPostgre;
import com.deportessa.proyectodeportes.modelo.MetodoPago;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Singleton
@MetodoPagoPostgre
public class MetodoPagoPostgreImpl extends DaoGenericoAbstracto<MetodoPago, Integer> implements MetodoPagoLocal{

     @PersistenceContext(unitName = "postgre")
    private EntityManager em;

    public MetodoPagoPostgreImpl() {
        super(MetodoPago.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
