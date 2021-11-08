/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa.impl.MySql;

import com.deportessa.proyectodeportes.daojpa.DaoGenericoAbstracto;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.deportessa.proyectodeportes.daojpa.InscripcionLocal;
import com.deportessa.proyectodeportes.daojpa.qulifiers.InscripcionMysql;
import com.deportessa.proyectodeportes.modelo.ActividadMetodoPagoPK;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.servicios.dto.InscripcionDTO;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Antonio
 */
@Singleton
@InscripcionMysql
public class InscripcionMySqlImpl extends DaoGenericoAbstracto<Inscripcion, ActividadMetodoPagoPK> implements InscripcionLocal {

     @PersistenceContext(unitName = "mysql", name = "jdbc/Sakila")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InscripcionMySqlImpl() {
        super(Inscripcion.class);
    }

    @Override
    public List<InscripcionDTO> getinscripcionDTO(Cliente cliente) {
        String query="Select new com.deportessa.proyectodeportes.servicios.dto.InscripcionDTO(c,a,i,m) "
                + "From Cliente c Join c.metodosPagoCliente m Join m.inscripciones i Join i.actividad a "
                + "Where c.idCliente= :idCliente";
        return em.createQuery(query).setParameter("idCliente", cliente.getIdCliente()).getResultList();
    }

//    @Override
//    public Optional<Inscripcion> find(ActividadMetodoPagoPK id) {
//        String query="Select i From Inscripcion i Where i.actividadMetodoPagoPK= :inscripcionPK ";
//        return em.createQuery(query).setParameter("inscripcionPK", id).getResultStream().findFirst();
//    }
    
}
