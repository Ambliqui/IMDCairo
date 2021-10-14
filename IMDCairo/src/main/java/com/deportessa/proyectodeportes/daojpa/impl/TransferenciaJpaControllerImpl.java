/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa.impl;

import com.deportessa.proyectodeportes.daojpa.TransferenciaJpaControllerDao;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import com.deportessa.proyectodeportes.modelo.Transferencia;
import com.deportessa.proyectodeportes.prueba.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pryet
 */
@Stateless
public class TransferenciaJpaControllerImpl implements TransferenciaJpaControllerDao {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    public void create(Transferencia transferencia) {
        if (transferencia.getInscripciones() == null) {
            transferencia.setInscripciones(new ArrayList<Inscripcion>());
        }

        List<Inscripcion> attachedInscripciones = new ArrayList<Inscripcion>();
        for (Inscripcion inscripcionesInscripcionToAttach : transferencia.getInscripciones()) {
            inscripcionesInscripcionToAttach = em.getReference(inscripcionesInscripcionToAttach.getClass(), inscripcionesInscripcionToAttach.getActividadMetodoPagoPK());
            attachedInscripciones.add(inscripcionesInscripcionToAttach);
        }
        transferencia.setInscripciones(attachedInscripciones);
        em.persist(transferencia);
        for (Inscripcion inscripcionesInscripcion : transferencia.getInscripciones()) {
            com.deportessa.proyectodeportes.modelo.MetodoPago oldMetodoPagoOfInscripcionesInscripcion = inscripcionesInscripcion.getMetodoPago();
            inscripcionesInscripcion.setMetodoPago(transferencia);
            inscripcionesInscripcion = em.merge(inscripcionesInscripcion);
            if (oldMetodoPagoOfInscripcionesInscripcion != null) {
                oldMetodoPagoOfInscripcionesInscripcion.getInscripciones().remove(inscripcionesInscripcion);
                oldMetodoPagoOfInscripcionesInscripcion = em.merge(oldMetodoPagoOfInscripcionesInscripcion);
            }
        }

    }

    @Override
    public void edit(Transferencia transferencia) throws NonexistentEntityException, Exception {

        try {
            Transferencia persistentTransferencia = em.find(Transferencia.class, transferencia.getIdPago());
            List<Inscripcion> inscripcionesOld = persistentTransferencia.getInscripciones();
            List<Inscripcion> inscripcionesNew = transferencia.getInscripciones();
            List<Inscripcion> attachedInscripcionesNew = new ArrayList<Inscripcion>();
            for (Inscripcion inscripcionesNewInscripcionToAttach : inscripcionesNew) {
                inscripcionesNewInscripcionToAttach = em.getReference(inscripcionesNewInscripcionToAttach.getClass(), inscripcionesNewInscripcionToAttach.getActividadMetodoPagoPK());
                attachedInscripcionesNew.add(inscripcionesNewInscripcionToAttach);
            }
            inscripcionesNew = attachedInscripcionesNew;
            transferencia.setInscripciones(inscripcionesNew);
            transferencia = em.merge(transferencia);
            for (Inscripcion inscripcionesOldInscripcion : inscripcionesOld) {
                if (!inscripcionesNew.contains(inscripcionesOldInscripcion)) {
                    inscripcionesOldInscripcion.setMetodoPago(null);
                    inscripcionesOldInscripcion = em.merge(inscripcionesOldInscripcion);
                }
            }
            for (Inscripcion inscripcionesNewInscripcion : inscripcionesNew) {
                if (!inscripcionesOld.contains(inscripcionesNewInscripcion)) {
                    Transferencia oldMetodoPagoOfInscripcionesNewInscripcion = (Transferencia) inscripcionesNewInscripcion.getMetodoPago();
                    inscripcionesNewInscripcion.setMetodoPago(transferencia);
                    inscripcionesNewInscripcion = em.merge(inscripcionesNewInscripcion);
                    if (oldMetodoPagoOfInscripcionesNewInscripcion != null && !oldMetodoPagoOfInscripcionesNewInscripcion.equals(transferencia)) {
                        oldMetodoPagoOfInscripcionesNewInscripcion.getInscripciones().remove(inscripcionesNewInscripcion);
                        oldMetodoPagoOfInscripcionesNewInscripcion = em.merge(oldMetodoPagoOfInscripcionesNewInscripcion);
                    }
                }
            }
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = transferencia.getIdPago();
                if (findTransferencia(id) == null) {
                    throw new NonexistentEntityException("The transferencia with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    @Override
    public void destroy(int id) throws NonexistentEntityException {

        Transferencia transferencia;
        try {
            transferencia = em.getReference(Transferencia.class, id);
            transferencia.getIdPago();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The transferencia with id " + id + " no longer exists.", enfe);
        }
        List<Inscripcion> inscripciones = transferencia.getInscripciones();
        for (Inscripcion inscripcionesInscripcion : inscripciones) {
            inscripcionesInscripcion.setMetodoPago(null);
            inscripcionesInscripcion = em.merge(inscripcionesInscripcion);
        }
        em.remove(transferencia);
    }

    @Override
    public List<Transferencia> findTransferenciaEntities() {
        return findTransferenciaEntities(true, -1, -1);
    }

    @Override
    public List<Transferencia> findTransferenciaEntities(int maxResults, int firstResult) {
        return findTransferenciaEntities(false, maxResults, firstResult);
    }

    @Override
    public List<Transferencia> findTransferenciaEntities(boolean all, int maxResults, int firstResult) {

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Transferencia.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    @Override
    public Transferencia findTransferencia(int id) {
        return em.find(Transferencia.class, id);
    }

    @Override
    public int getTransferenciaCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Transferencia> rt = cq.from(Transferencia.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
