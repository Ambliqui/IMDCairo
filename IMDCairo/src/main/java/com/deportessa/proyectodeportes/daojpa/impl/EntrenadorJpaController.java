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
import com.deportessa.proyectodeportes.modelo.Actividad;
import com.deportessa.proyectodeportes.modelo.Entrenador;
import com.deportessa.proyectodeportes.daojpa.exceptions.IllegalOrphanException;
import com.deportessa.proyectodeportes.daojpa.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author pryet
 */
public class EntrenadorJpaController implements Serializable {

    public EntrenadorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Entrenador entrenador) {
        if (entrenador.getActividadListEntrenador() == null) {
            entrenador.setActividadListEntrenador(new ArrayList<Actividad>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Actividad> attachedActividadListEntrenador = new ArrayList<Actividad>();
            for (Actividad actividadListEntrenadorActividadToAttach : entrenador.getActividadListEntrenador()) {
                actividadListEntrenadorActividadToAttach = em.getReference(actividadListEntrenadorActividadToAttach.getClass(), actividadListEntrenadorActividadToAttach.getIdActividad());
                attachedActividadListEntrenador.add(actividadListEntrenadorActividadToAttach);
            }
            entrenador.setActividadListEntrenador(attachedActividadListEntrenador);
            em.persist(entrenador);
            for (Actividad actividadListEntrenadorActividad : entrenador.getActividadListEntrenador()) {
                Entrenador oldIdEntrenadorActividadOfActividadListEntrenadorActividad = actividadListEntrenadorActividad.getIdEntrenadorActividad();
                actividadListEntrenadorActividad.setIdEntrenadorActividad(entrenador);
                actividadListEntrenadorActividad = em.merge(actividadListEntrenadorActividad);
                if (oldIdEntrenadorActividadOfActividadListEntrenadorActividad != null) {
                    oldIdEntrenadorActividadOfActividadListEntrenadorActividad.getActividadListEntrenador().remove(actividadListEntrenadorActividad);
                    oldIdEntrenadorActividadOfActividadListEntrenadorActividad = em.merge(oldIdEntrenadorActividadOfActividadListEntrenadorActividad);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Entrenador entrenador) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Entrenador persistentEntrenador = em.find(Entrenador.class, entrenador.getIdEntrenador());
            List<Actividad> actividadListEntrenadorOld = persistentEntrenador.getActividadListEntrenador();
            List<Actividad> actividadListEntrenadorNew = entrenador.getActividadListEntrenador();
            List<String> illegalOrphanMessages = null;
            for (Actividad actividadListEntrenadorOldActividad : actividadListEntrenadorOld) {
                if (!actividadListEntrenadorNew.contains(actividadListEntrenadorOldActividad)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Actividad " + actividadListEntrenadorOldActividad + " since its idEntrenadorActividad field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Actividad> attachedActividadListEntrenadorNew = new ArrayList<Actividad>();
            for (Actividad actividadListEntrenadorNewActividadToAttach : actividadListEntrenadorNew) {
                actividadListEntrenadorNewActividadToAttach = em.getReference(actividadListEntrenadorNewActividadToAttach.getClass(), actividadListEntrenadorNewActividadToAttach.getIdActividad());
                attachedActividadListEntrenadorNew.add(actividadListEntrenadorNewActividadToAttach);
            }
            actividadListEntrenadorNew = attachedActividadListEntrenadorNew;
            entrenador.setActividadListEntrenador(actividadListEntrenadorNew);
            entrenador = em.merge(entrenador);
            for (Actividad actividadListEntrenadorNewActividad : actividadListEntrenadorNew) {
                if (!actividadListEntrenadorOld.contains(actividadListEntrenadorNewActividad)) {
                    Entrenador oldIdEntrenadorActividadOfActividadListEntrenadorNewActividad = actividadListEntrenadorNewActividad.getIdEntrenadorActividad();
                    actividadListEntrenadorNewActividad.setIdEntrenadorActividad(entrenador);
                    actividadListEntrenadorNewActividad = em.merge(actividadListEntrenadorNewActividad);
                    if (oldIdEntrenadorActividadOfActividadListEntrenadorNewActividad != null && !oldIdEntrenadorActividadOfActividadListEntrenadorNewActividad.equals(entrenador)) {
                        oldIdEntrenadorActividadOfActividadListEntrenadorNewActividad.getActividadListEntrenador().remove(actividadListEntrenadorNewActividad);
                        oldIdEntrenadorActividadOfActividadListEntrenadorNewActividad = em.merge(oldIdEntrenadorActividadOfActividadListEntrenadorNewActividad);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = entrenador.getIdEntrenador();
                if (findEntrenador(id) == null) {
                    throw new NonexistentEntityException("The entrenador with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Entrenador entrenador;
            try {
                entrenador = em.getReference(Entrenador.class, id);
                entrenador.getIdEntrenador();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The entrenador with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Actividad> actividadListEntrenadorOrphanCheck = entrenador.getActividadListEntrenador();
            for (Actividad actividadListEntrenadorOrphanCheckActividad : actividadListEntrenadorOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Entrenador (" + entrenador + ") cannot be destroyed since the Actividad " + actividadListEntrenadorOrphanCheckActividad + " in its actividadListEntrenador field has a non-nullable idEntrenadorActividad field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(entrenador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Entrenador> findEntrenadorEntities() {
        return findEntrenadorEntities(true, -1, -1);
    }

    public List<Entrenador> findEntrenadorEntities(int maxResults, int firstResult) {
        return findEntrenadorEntities(false, maxResults, firstResult);
    }

    private List<Entrenador> findEntrenadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Entrenador.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Entrenador findEntrenador(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Entrenador.class, id);
        } finally {
            em.close();
        }
    }

    public int getEntrenadorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Entrenador> rt = cq.from(Entrenador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
