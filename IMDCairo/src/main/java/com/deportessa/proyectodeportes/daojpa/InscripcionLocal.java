/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa;

import com.deportessa.proyectodeportes.modelo.Inscripcion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Antonio
 */
@Local
public interface InscripcionLocal {

    void create(Inscripcion inscripcion);
    
    void edit(Inscripcion inscripcion);

    void remove(Inscripcion inscripcion);

    List<Inscripcion> findAll();

    List<Inscripcion> findRange(int[] range);

    int count();
    
}
