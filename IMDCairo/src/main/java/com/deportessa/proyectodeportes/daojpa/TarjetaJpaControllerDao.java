/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa;

import com.deportessa.proyectodeportes.modelo.Inscripcion;
import com.deportessa.proyectodeportes.modelo.Tarjeta;
import com.deportessa.proyectodeportes.prueba.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Mefisto
 */
public interface TarjetaJpaControllerDao {
    
    public void create(Tarjeta tarjeta);
        
    public void edit(Tarjeta tarjeta) throws NonexistentEntityException, Exception;
    
    public void destroy(int id) throws NonexistentEntityException;

    public List<Tarjeta> findTarjetaEntities();

    public List<Tarjeta> findTarjetaEntities(int maxResults, int firstResult);

    public List<Tarjeta> findTarjetaEntities(boolean all, int maxResults, int firstResult);

    public Tarjeta findTarjeta(int id);

    public int getTarjetaCount();
}
