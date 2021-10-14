/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.excepcionesAntiguas;

/**
 *
 * @author Antonio
 */
public class YaEstasInscritoException extends Exception {

    public YaEstasInscritoException(String ya_tienes_esta_actividad_adquirida) {
        super(ya_tienes_esta_actividad_adquirida);
    }
    
}
