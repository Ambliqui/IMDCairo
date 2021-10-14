/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa.impl;

import com.deportessa.proyectodeportes.modelo.Actividad;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.deportessa.proyectodeportes.modelo.Entrenador;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.deportessa.proyectodeportes.daojpa.ActividadJpaControllerDao;
import com.deportessa.proyectodeportes.prueba.exceptions.IllegalOrphanException;
import com.deportessa.proyectodeportes.prueba.exceptions.NonexistentEntityException;

/**
 *
 * @author pryet
 */
@Stateless
public class ActividadJpaControllerImpl implements ActividadJpaControllerDao {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @Override
    public void create(Actividad actividad) {
        if (actividad.getInscripciones() == null) {
            actividad.setInscripciones(new ArrayList<Inscripcion>());
        }
        Entrenador idEntrenadorActividad = actividad.getIdEntrenadorActividad();
        if (idEntrenadorActividad != null) {
            idEntrenadorActividad = em.getReference(idEntrenadorActividad.getClass(), idEntrenadorActividad.getIdEntrenador());
            actividad.setIdEntrenadorActividad(idEntrenadorActividad);
        }
        List<Inscripcion> attachedInscripciones = new ArrayList<Inscripcion>();
        for (Inscripcion inscripcionesInscripcionToAttach : actividad.getInscripciones()) {
            inscripcionesInscripcionToAttach = em.getReference(inscripcionesInscripcionToAttach.getClass(), inscripcionesInscripcionToAttach.getActividadMetodoPagoPK());
            attachedInscripciones.add(inscripcionesInscripcionToAttach);
        }
        actividad.setInscripciones(attachedInscripciones);
        em.persist(actividad);
        if (idEntrenadorActividad != null) {
            idEntrenadorActividad.getActividadListEntrenador().add(actividad);
            idEntrenadorActividad = em.merge(idEntrenadorActividad);
        }
        for (Inscripcion inscripcionesInscripcion : actividad.getInscripciones()) {
            Actividad oldActividadOfInscripcionesInscripcion = inscripcionesInscripcion.getActividad();
            inscripcionesInscripcion.setActividad(actividad);
            inscripcionesInscripcion = em.merge(inscripcionesInscripcion);
            if (oldActividadOfInscripcionesInscripcion != null) {
                oldActividadOfInscripcionesInscripcion.getInscripciones().remove(inscripcionesInscripcion);
                oldActividadOfInscripcionesInscripcion = em.merge(oldActividadOfInscripcionesInscripcion);
            }
        }
    }

    @Override
    public void edit(Actividad actividad) throws IllegalOrphanException, NonexistentEntityException, Exception {
        try {
            Actividad persistentActividad = em.find(Actividad.class, actividad.getIdActividad());
            Entrenador idEntrenadorActividadOld = persistentActividad.getIdEntrenadorActividad();
            Entrenador idEntrenadorActividadNew = actividad.getIdEntrenadorActividad();
            List<Inscripcion> inscripcionesOld = persistentActividad.getInscripciones();
            List<Inscripcion> inscripcionesNew = actividad.getInscripciones();
            List<String> illegalOrphanMessages = null;
            for (Inscripcion inscripcionesOldInscripcion : inscripcionesOld) {
                if (!inscripcionesNew.contains(inscripcionesOldInscripcion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Inscripcion " + inscripcionesOldInscripcion + " since its actividad field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idEntrenadorActividadNew != null) {
                idEntrenadorActividadNew = em.getReference(idEntrenadorActividadNew.getClass(), idEntrenadorActividadNew.getIdEntrenador());
                actividad.setIdEntrenadorActividad(idEntrenadorActividadNew);
            }
            List<Inscripcion> attachedInscripcionesNew = new ArrayList<Inscripcion>();
            for (Inscripcion inscripcionesNewInscripcionToAttach : inscripcionesNew) {
                inscripcionesNewInscripcionToAttach = em.getReference(inscripcionesNewInscripcionToAttach.getClass(), inscripcionesNewInscripcionToAttach.getActividadMetodoPagoPK());
                attachedInscripcionesNew.add(inscripcionesNewInscripcionToAttach);
            }
            inscripcionesNew = attachedInscripcionesNew;
            actividad.setInscripciones(inscripcionesNew);
            actividad = em.merge(actividad);
            if (idEntrenadorActividadOld != null && !idEntrenadorActividadOld.equals(idEntrenadorActividadNew)) {
                idEntrenadorActividadOld.getActividadListEntrenador().remove(actividad);
                idEntrenadorActividadOld = em.merge(idEntrenadorActividadOld);
            }
            if (idEntrenadorActividadNew != null && !idEntrenadorActividadNew.equals(idEntrenadorActividadOld)) {
                idEntrenadorActividadNew.getActividadListEntrenador().add(actividad);
                idEntrenadorActividadNew = em.merge(idEntrenadorActividadNew);
            }
            for (Inscripcion inscripcionesNewInscripcion : inscripcionesNew) {
                if (!inscripcionesOld.contains(inscripcionesNewInscripcion)) {
                    Actividad oldActividadOfInscripcionesNewInscripcion = inscripcionesNewInscripcion.getActividad();
                    inscripcionesNewInscripcion.setActividad(actividad);
                    inscripcionesNewInscripcion = em.merge(inscripcionesNewInscripcion);
                    if (oldActividadOfInscripcionesNewInscripcion != null && !oldActividadOfInscripcionesNewInscripcion.equals(actividad)) {
                        oldActividadOfInscripcionesNewInscripcion.getInscripciones().remove(inscripcionesNewInscripcion);
                        oldActividadOfInscripcionesNewInscripcion = em.merge(oldActividadOfInscripcionesNewInscripcion);
                    }
                }
            }
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = actividad.getIdActividad();
                if (findActividad(id) == null) {
                    throw new NonexistentEntityException("The actividad with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    @Override
    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        Actividad actividad;
        try {
            actividad = em.getReference(Actividad.class, id);
            actividad.getIdActividad();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The actividad with id " + id + " no longer exists.", enfe);
        }
        List<String> illegalOrphanMessages = null;
        List<Inscripcion> inscripcionesOrphanCheck = actividad.getInscripciones();
        for (Inscripcion inscripcionesOrphanCheckInscripcion : inscripcionesOrphanCheck) {
            if (illegalOrphanMessages == null) {
                illegalOrphanMessages = new ArrayList<String>();
            }
            illegalOrphanMessages.add("This Actividad (" + actividad + ") cannot be destroyed since the Inscripcion " + inscripcionesOrphanCheckInscripcion + " in its inscripciones field has a non-nullable actividad field.");
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        Entrenador idEntrenadorActividad = actividad.getIdEntrenadorActividad();
        if (idEntrenadorActividad != null) {
            idEntrenadorActividad.getActividadListEntrenador().remove(actividad);
            idEntrenadorActividad = em.merge(idEntrenadorActividad);
        }
        em.remove(actividad);
    }

    @Override
    public List<Actividad> findActividadEntities() {
        return findActividadEntities(true, -1, -1);
    }

    @Override
    public List<Actividad> findActividadEntities(int maxResults, int firstResult) {
        return findActividadEntities(false, maxResults, firstResult);
    }

    @Override
    public List<Actividad> findActividadEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Actividad.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    @Override
    public Actividad findActividad(Integer id) {
        return em.find(Actividad.class, id);
    }

    @Override
    public int getActividadCount() {
        
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Actividad> rt = cq.from(Actividad.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
