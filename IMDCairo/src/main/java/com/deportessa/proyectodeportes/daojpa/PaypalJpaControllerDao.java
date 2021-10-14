/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa;

import com.deportessa.proyectodeportes.modelo.Inscripcion;
import com.deportessa.proyectodeportes.modelo.Paypal;
import com.deportessa.proyectodeportes.prueba.exceptions.NonexistentEntityException;
import java.util.ArrayList;
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
public interface PaypalJpaControllerDao {

    public void create(Paypal paypal);

    public void edit(Paypal paypal) throws NonexistentEntityException, Exception;

    public void destroy(int id) throws NonexistentEntityException;

    public List<Paypal> findPaypalEntities();

    public List<Paypal> findPaypalEntities(int maxResults, int firstResult);

    public List<Paypal> findPaypalEntities(boolean all, int maxResults, int firstResult);

    public Paypal findPaypal(int id);

    public int getPaypalCount();
}
