/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa;

import com.deportessa.proyectodeportes.modelo.Actividad;
import com.deportessa.proyectodeportes.daojpa.exceptions.IllegalOrphanException;
import com.deportessa.proyectodeportes.daojpa.exceptions.NonexistentEntityException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mefisto
 */
@Local
public interface ActividadJpaControllerDao {

    public void create(Actividad actividad);

    public void edit(Actividad actividad)throws IllegalOrphanException, NonexistentEntityException, Exception;

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException;

    public List<Actividad> findActividadEntities();

    public List<Actividad> findActividadEntities(int maxResults, int firstResult);

    public List<Actividad> findActividadEntities(boolean all, int maxResults, int firstResult);

    public Actividad findActividad(Integer id);

    public int getActividadCount();
}
