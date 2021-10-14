package com.deportessa.proyectodeportes.daojpa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import com.deportessa.proyectodeportes.modelo.MetodoPago;
import com.deportessa.proyectodeportes.prueba.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author pryet
 */

@Local
public interface MetodoPagoJpaControllerDao{

    public void create(MetodoPago metodoPago);

    public void edit(MetodoPago metodoPago) throws NonexistentEntityException, Exception;

    public void destroy(int id) throws NonexistentEntityException;

    public List<MetodoPago> findMetodoPagoEntities();

    public List<MetodoPago> findMetodoPagoEntities(int maxResults, int firstResult);

    public List<MetodoPago> findMetodoPagoEntities(boolean all, int maxResults, int firstResult);
    
    public MetodoPago findMetodoPago(int id);

    public int getMetodoPagoCount();
    
}
