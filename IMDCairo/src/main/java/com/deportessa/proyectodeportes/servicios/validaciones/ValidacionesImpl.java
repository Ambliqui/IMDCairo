/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deportessa.proyectodeportes.servicios.validaciones;

import javax.ejb.Stateless;

@Stateless
public class ValidacionesImpl implements Validaciones {

    @Override
    public Boolean camposIdenticos(String campo1, String campo2) {
        if (campo1.equalsIgnoreCase(campo2)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean campoRelleno(String campo) {
        if (campo != null && campo.trim().length() != 0 ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean campoRelleno(Integer campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean campoRelleno(Long campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean campoRelleno(Double campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean longitudCampo(String campo, Integer longitudMinima) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean longitudCampo(Integer campo, Integer valordMinimo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean longitudCampo(Long campo, Integer valordMinimo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean longitudCampo(Double campo, Integer valordMinimo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
