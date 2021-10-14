/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa;

import com.deportessa.proyectodeportes.modelo.Inscripcion;
import com.deportessa.proyectodeportes.modelo.Transferencia;
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
public interface TransferenciaJpaControllerDao {
    
    public void create(Transferencia transferencia);

    public void edit(Transferencia transferencia) throws NonexistentEntityException, Exception;
    
    public void destroy(int id) throws NonexistentEntityException;
    
    public List<Transferencia> findTransferenciaEntities();

    public List<Transferencia> findTransferenciaEntities(int maxResults, int firstResult);

    public List<Transferencia> findTransferenciaEntities(boolean all, int maxResults, int firstResult);

    public Transferencia findTransferencia(int id);

    public int getTransferenciaCount();

}
