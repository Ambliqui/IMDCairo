/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa;

import com.deportessa.proyectodeportes.modelo.MetodoPago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Antonio
 */
@Local
public interface MetodoPagoLocal{

    void create(MetodoPago metodoPago);
    
    void edit(MetodoPago metodoPago);

    void remove(MetodoPago metodoPago);

    List<MetodoPago> findAll();
    
    MetodoPago find(Integer id);

    List<MetodoPago> findRange(int[] range);

    int count();
    
}
