/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios.excepciones;

/**
 *
 * @author Mefisto
 */
public class EmailNoExistsException extends Exception{

    public EmailNoExistsException(String string) {
        super(string);
    }
    
}
