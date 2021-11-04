/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deportessa.proyectodeportes.servicios.validaciones;

import com.deportessa.proyectodeportes.servicios.Excepciones.*;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    public Optional<EmailNoExistsException> emailNoExistente(String email) {
        if (true) {
            return Optional.empty();
        } else {
            return Optional.of( new EmailNoExistsException("El email no se encuentra en la base de datos"));
        }
    }

    @Override
    public Boolean campoRelleno(String campo) {
        if (campo != null && campo.trim().length() != 0) {
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
        if (campo.trim().length() >= longitudMinima) {
            return Optional.empty(); //LongitudNoDeseadaException exception = new LongitudNoDeseadaException("La longuitud no es la deseada");
//            return exception;
        } else {
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

    @Override
    public Optional<EmailNoFormateadoException> emailNoFormateado(String email) {
                // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(email);
 
        if (mather.find() == true) {
            return Optional.empty();
        } else {
            return Optional.of(new EmailNoFormateadoException("El email no tiene el formato correcto"));
        }
    }

}
