/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios.helper;

/**
 *
 * @author pryet
 */
public enum FormatoFecha {
    
    DD_MM_AAAA("dd-MM-yyyy"),
    DD_MM_AA("dd-MM-yy"),
    DD_MM_AAAA_HH_MIN_SEG("dd-MM-yyyy/hh:mm:ss");
    
    private final String formato;

    private FormatoFecha(String formato) {
        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }
    
    
    
}
