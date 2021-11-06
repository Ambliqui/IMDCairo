/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deportessa.proyectodeportes.servicios.validaciones;

import com.deportessa.proyectodeportes.daojpa.factory.DaoAbstractFactoryLocal;
import com.deportessa.proyectodeportes.daojpa.factory.qualifiers.FactoryDaoMySql;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.servicios.excepciones.EmailNoFormateadoException;
import com.deportessa.proyectodeportes.servicios.excepciones.LongitudNoDeseadaException;
import com.deportessa.proyectodeportes.servicios.excepciones.CamposNoCoincidentesException;
import com.deportessa.proyectodeportes.servicios.excepciones.EmailNoExistsException;
import com.deportessa.proyectodeportes.servicios.excepciones.PasswordNoCoincidenteException;
import com.deportessa.proyectodeportes.servicios.excepciones.RangoNoDeseadoException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ValidacionesImpl implements Validaciones {

    @Inject
    @FactoryDaoMySql
    private DaoAbstractFactoryLocal daoFactoryLocal;

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
    public Optional<EmailNoFormateadoException> emailNoFormateado(String email) {
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            return Optional.empty();
        } else {
            return Optional.of(new EmailNoFormateadoException("El email no tiene el formato correcto"));
        }
    }

    @Override
    public Optional<EmailNoExistsException> emailNoExistente(String email) {
        //TODO: Cambiar a lo que nos devuelve realmente el metodo de la excepcion
        
        if (daoFactoryLocal.getClienteDaoLocal().findByEmail(email).isPresent()) {
            return Optional.empty();
        } else {
            return Optional.of(new EmailNoExistsException("El email no se encuentra en la base de datos"));
        }
    }

    @Override
    public Optional<PasswordNoCoincidenteException> passwordNoCoincidente(String email, String password) {
        
        Cliente cliente =  daoFactoryLocal.getClienteDaoLocal().findByEmail(email).get();
        
        if (cliente.getPassCliente().equals(password)) {
            return Optional.empty();
        } else {
            return Optional.of(new PasswordNoCoincidenteException("El password no es correcto"));
        }
    }

    @Override
    public Boolean campoNuloVacio(String campo) {
        if (campo != null && campo.trim().length() != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<LongitudNoDeseadaException> longitudCampo(String campo, Integer longitudMinima) {
        if (campo.trim().length() >= longitudMinima) {
            return Optional.empty();
        } else {
            LongitudNoDeseadaException exception = new LongitudNoDeseadaException("La longuitud mínima del campo debe ser: " + longitudMinima);
            return Optional.of(exception);
        }
    }

    @Override
    public Optional<RangoNoDeseadoException> rangoValores(Integer valor, Long minimo, Long maximo) {
        if (valor >= minimo && valor <= maximo) {
            return Optional.empty();
        } else {
            RangoNoDeseadoException exception = new RangoNoDeseadoException("El valor debe estar comprendido entre: " + minimo + " y " + maximo);
            return Optional.of(exception);
        }
    }
}
