/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa;

import com.deportessa.proyectodeportes.modelo.Actividad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Antonio
 */
@Local
public interface ActividadLocal {

    void create(Actividad actividad);
    
    void edit(Actividad actividad);

    void remove(Actividad actividad);

    List<Actividad> findAll();
    
    Actividad find(Integer id);

    List<Actividad> findRange(int[] range);

    int count();
    
}
