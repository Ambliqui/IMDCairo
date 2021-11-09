/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.deportessa.proyectodeportes.daojpa.impl.postgre;

import com.deportessa.proyectodeportes.daojpa.DaoGenericoAbstracto;
import com.deportessa.proyectodeportes.daojpa.InscripcionLocal;
import com.deportessa.proyectodeportes.daojpa.qulifiers.InscripcionPostgre;
import com.deportessa.proyectodeportes.modelo.ActividadMetodoPagoPK;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import com.deportessa.proyectodeportes.servicios.dto.InscripcionDTO;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Singleton
@InscripcionPostgre
public class InscripcionPostgreImpl extends DaoGenericoAbstracto<Inscripcion, Integer> implements InscripcionLocal {

    @PersistenceContext(unitName = "mysql")
    private EntityManager em;

    public InscripcionPostgreImpl() {
        super(Inscripcion.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<InscripcionDTO> getinscripcionDTO(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Inscripcion find(ActividadMetodoPagoPK id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
