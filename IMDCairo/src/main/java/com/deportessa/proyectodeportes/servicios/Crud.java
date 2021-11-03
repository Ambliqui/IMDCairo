/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mefisto
 */
@Local
public interface Crud<T> {

    
    void create(T t);

    void update(T t);

    void delete(T t);

    T read(Integer n);
    
    List<T> readAll();

}
