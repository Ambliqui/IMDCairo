/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios;

import javax.ejb.Local;

/**
 *
 * @author Mefisto
 */
@Local
@FunctionalInterface
public interface Factory {
    
    
    Crud createCrud();
    
}
