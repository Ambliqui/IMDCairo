/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa;

import com.deportessa.proyectodeportes.modelo.Actividad;
import com.deportessa.proyectodeportes.modelo.ActividadMetodoPagoPK;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import com.deportessa.proyectodeportes.modelo.MetodoPago;
import com.deportessa.proyectodeportes.daojpa.exceptions.NonexistentEntityException;
import com.deportessa.proyectodeportes.daojpa.exceptions.PreexistingEntityException;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Mefisto
 */
@Local
public interface InscripcionJpaControllerDao {
    
    public void create(Inscripcion inscripcion) throws PreexistingEntityException, Exception;

    public void edit(Inscripcion inscripcion) throws NonexistentEntityException, Exception;

    public void destroy(ActividadMetodoPagoPK id) throws NonexistentEntityException;

    public List<Inscripcion> findInscripcionEntities();

    public List<Inscripcion> findInscripcionEntities(int maxResults, int firstResult);

    public List<Inscripcion> findInscripcionEntities(boolean all, int maxResults, int firstResult);

    public Inscripcion findInscripcion(ActividadMetodoPagoPK id);

    public int getInscripcionCount();
}
