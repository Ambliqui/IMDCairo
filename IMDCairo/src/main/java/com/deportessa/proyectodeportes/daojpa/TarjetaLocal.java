/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa;

import com.deportessa.proyectodeportes.modelo.Tarjeta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Antonio
 */
@Local
public interface TarjetaLocal {

    void create(Tarjeta tarjeta);
    
    void edit(Tarjeta tarjeta);

    void remove(Tarjeta tarjeta);

    List<Tarjeta> findAll();
    
    Tarjeta find(Integer id);

    List<Tarjeta> findRange(int[] range);

    int count();
    
}
