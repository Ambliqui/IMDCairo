/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deportessa.proyectodeportes.servicios.validaciones;

import com.deportessa.proyectodeportes.servicios.Excepciones.CamposNoCoincidentesException;
import com.deportessa.proyectodeportes.servicios.Excepciones.LongitudNoDeseadaException;
import java.util.Optional;
import javax.ejb.Stateless;

@Stateless
public class ValidacionesImpl implements Validaciones {

    @Override
    public Optional<CamposNoCoincidentesException> camposIdenticos(String campo1, String campo2) {
        if (campo1.equals(campo2)) {
            return Optional.empty();
        } else {
            CamposNoCoincidentesException exception = new CamposNoCoincidentesException("Los campos no coindicen");
            return Optional.of(exception);
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
    public Optional<LongitudNoDeseadaException> longitudCampo(String campo, Integer longitudMinima) {
        if(campo.trim().length()>= longitudMinima){
            return Optional.empty(); //LongitudNoDeseadaException exception = new LongitudNoDeseadaException("La longuitud no es la deseada");
//            return exception;
        }else{
            LongitudNoDeseadaException exception = new LongitudNoDeseadaException("La longuitud no es la deseada");
            return Optional.of(exception);
        }
    }

    @Override
    public Optional<LongitudNoDeseadaException> longitudCampo(Integer campo, Integer valordMinimo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LongitudNoDeseadaException longitudCampo(Long campo, Integer valordMinimo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LongitudNoDeseadaException longitudCampo(Double campo, Integer valordMinimo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
