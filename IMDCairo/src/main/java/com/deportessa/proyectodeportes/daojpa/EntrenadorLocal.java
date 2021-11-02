/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa;

import com.deportessa.proyectodeportes.modelo.Entrenador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Antonio
 */
@Local
public interface EntrenadorLocal {

    void create(Entrenador entrenador);
    
    void edit(Entrenador entrenador);

    void remove(Entrenador entrenador);

    List<Entrenador> findAll();
    
    Entrenador find(Integer id);

    List<Entrenador> findRange(int[] range);

    int count();
    
}
