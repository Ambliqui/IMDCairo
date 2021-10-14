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
public class TarjetaRepetidaException extends Exception {

    public TarjetaRepetidaException(String ya_existe_esta_tarjeta) {
        super(ya_existe_esta_tarjeta);
    }
    
}
