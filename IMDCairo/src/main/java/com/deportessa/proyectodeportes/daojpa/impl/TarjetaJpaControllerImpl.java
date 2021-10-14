/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa.impl;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import com.deportessa.proyectodeportes.modelo.Tarjeta;
import com.deportessa.proyectodeportes.prueba.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import com.deportessa.proyectodeportes.daojpa.TarjetaJpaControllerDao;

/**
 *
 * @author pryet
 */
public class TarjetaJpaControllerImpl implements TarjetaJpaControllerDao {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @Override
    public void create(Tarjeta tarjeta) {
        if (tarjeta.getInscripciones() == null) {
            tarjeta.setInscripciones(new ArrayList<Inscripcion>());
        }
        List<Inscripcion> attachedInscripciones = new ArrayList<Inscripcion>();
        for (Inscripcion inscripcionesInscripcionToAttach : tarjeta.getInscripciones()) {
            inscripcionesInscripcionToAttach = em.getReference(inscripcionesInscripcionToAttach.getClass(), inscripcionesInscripcionToAttach.getActividadMetodoPagoPK());
            attachedInscripciones.add(inscripcionesInscripcionToAttach);
        }
        tarjeta.setInscripciones(attachedInscripciones);
        em.persist(tarjeta);
        for (Inscripcion inscripcionesInscripcion : tarjeta.getInscripciones()) {
            com.deportessa.proyectodeportes.modelo.MetodoPago oldMetodoPagoOfInscripcionesInscripcion = inscripcionesInscripcion.getMetodoPago();
            inscripcionesInscripcion.setMetodoPago(tarjeta);
            inscripcionesInscripcion = em.merge(inscripcionesInscripcion);
            if (oldMetodoPagoOfInscripcionesInscripcion != null) {
                oldMetodoPagoOfInscripcionesInscripcion.getInscripciones().remove(inscripcionesInscripcion);
                oldMetodoPagoOfInscripcionesInscripcion = em.merge(oldMetodoPagoOfInscripcionesInscripcion);
            }
        }
    }

    @Override
    public void edit(Tarjeta tarjeta) throws NonexistentEntityException, Exception {
        try {
            Tarjeta persistentTarjeta = em.find(Tarjeta.class, tarjeta.getIdPago());
            List<Inscripcion> inscripcionesOld = persistentTarjeta.getInscripciones();
            List<Inscripcion> inscripcionesNew = tarjeta.getInscripciones();
            List<Inscripcion> attachedInscripcionesNew = new ArrayList<Inscripcion>();
            for (Inscripcion inscripcionesNewInscripcionToAttach : inscripcionesNew) {
                inscripcionesNewInscripcionToAttach = em.getReference(inscripcionesNewInscripcionToAttach.getClass(), inscripcionesNewInscripcionToAttach.getActividadMetodoPagoPK());
                attachedInscripcionesNew.add(inscripcionesNewInscripcionToAttach);
            }
            inscripcionesNew = attachedInscripcionesNew;
            tarjeta.setInscripciones(inscripcionesNew);
            tarjeta = em.merge(tarjeta);
            for (Inscripcion inscripcionesOldInscripcion : inscripcionesOld) {
                if (!inscripcionesNew.contains(inscripcionesOldInscripcion)) {
                    inscripcionesOldInscripcion.setMetodoPago(null);
                    inscripcionesOldInscripcion = em.merge(inscripcionesOldInscripcion);
                }
            }
            for (Inscripcion inscripcionesNewInscripcion : inscripcionesNew) {
                if (!inscripcionesOld.contains(inscripcionesNewInscripcion)) {
                    Tarjeta oldMetodoPagoOfInscripcionesNewInscripcion = (Tarjeta) inscripcionesNewInscripcion.getMetodoPago();
                    inscripcionesNewInscripcion.setMetodoPago(tarjeta);
                    inscripcionesNewInscripcion = em.merge(inscripcionesNewInscripcion);
                    if (oldMetodoPagoOfInscripcionesNewInscripcion != null && !oldMetodoPagoOfInscripcionesNewInscripcion.equals(tarjeta)) {
                        oldMetodoPagoOfInscripcionesNewInscripcion.getInscripciones().remove(inscripcionesNewInscripcion);
                        oldMetodoPagoOfInscripcionesNewInscripcion = em.merge(oldMetodoPagoOfInscripcionesNewInscripcion);
                    }
                }
            }
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tarjeta.getIdPago();
                if (findTarjeta(id) == null) {
                    throw new NonexistentEntityException("The tarjeta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    @Override
    public void destroy(int id) throws NonexistentEntityException {

        Tarjeta tarjeta;
        try {
            tarjeta = em.getReference(Tarjeta.class, id);
            tarjeta.getIdPago();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The tarjeta with id " + id + " no longer exists.", enfe);
        }
        List<Inscripcion> inscripciones = tarjeta.getInscripciones();
        for (Inscripcion inscripcionesInscripcion : inscripciones) {
            inscripcionesInscripcion.setMetodoPago(null);
            inscripcionesInscripcion = em.merge(inscripcionesInscripcion);
        }
        em.remove(tarjeta);
    }

    @Override
    public List<Tarjeta> findTarjetaEntities() {
        return findTarjetaEntities(true, -1, -1);
    }

    @Override
    public List<Tarjeta> findTarjetaEntities(int maxResults, int firstResult) {
        return findTarjetaEntities(false, maxResults, firstResult);
    }

    @Override
    public List<Tarjeta> findTarjetaEntities(boolean all, int maxResults, int firstResult) {

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Tarjeta.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    @Override
    public Tarjeta findTarjeta(int id) {
            return em.find(Tarjeta.class, id);
    }

    @Override
    public int getTarjetaCount() {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tarjeta> rt = cq.from(Tarjeta.class
            );
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
    }
}
