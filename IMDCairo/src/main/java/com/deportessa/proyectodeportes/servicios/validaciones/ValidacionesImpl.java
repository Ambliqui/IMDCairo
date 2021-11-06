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
import com.deportessa.proyectodeportes.servicios.excepciones.EmailRepetidoException;
import com.deportessa.proyectodeportes.servicios.excepciones.PasswordNoCoincidenteException;
import com.deportessa.proyectodeportes.servicios.excepciones.RangoNoDeseadoException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Implementacion de las distintas validaciones
 * @author Mefisto
 */


@Stateless
public class ValidacionesImpl implements Validaciones {

    @Inject
    @FactoryDaoMySql
    private DaoAbstractFactoryLocal daoFactoryLocal;

    /**
     * Metodo para comprobar que dos campos son iguales diferenciando mayusculas y minusculas
     * @author Mefisto
     * @param nombreCampo1  Nombre del primer campo a validar
     * @param nombreCampo2  Nombre del segundo campo a validar
     * @param campo1    Valor del primer campo a validar
     * @param campo2    Valor del segundo campo a validar
     * @return          Devuelve una excepcion personalizada
     * @see <CamposNoCoincidentesException>
     */
    @Override
    public Optional<CamposNoCoincidentesException> camposIdenticos(String nombreCampo1, String nombreCampo2, String campo1, String campo2) {
        if (campo1.equals(campo2)) {
            return Optional.empty();
        } else {
            CamposNoCoincidentesException exception = new CamposNoCoincidentesException("Los campos " + nombreCampo1 + " y " + nombreCampo2 + " no coindicen");
            return Optional.of(exception);
        }
    }
    
    /**
     * Metodo dummy para desarrolar, no está testeado
     * @author      Mefisto
     * @param campo Valor a comprobar
     * @return      Boolean
     */
    @Override
    public Boolean campoNuloVacio(String campo) {
        if (campo != null && campo.trim().length() != 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Mide la longitud de una cadena quitando los espacios
     * @author Mefisto
     * @param nombreCampo
     * @param campo
     * @param longitudMinima
     * @return Devuelve una excepcion personalizada
     * @see <LongitudNoDeseadaException>
     */
    @Override
    public Optional<LongitudNoDeseadaException> longitudCampo(String nombreCampo, String campo, Integer longitudMinima) {
        if (campo.trim().length() >= longitudMinima) {
            return Optional.empty();
        } else {
            LongitudNoDeseadaException exception = new LongitudNoDeseadaException(nombreCampo + ": La longuitud mínima del campo debe ser: " + longitudMinima);
            return Optional.of(exception);
        }
    }

    /**
     * Comprueba que el valor que pasamos esta un un rango que le definimos
     * @author Mefisto
     * @param valor     Valor a comprobar
     * @param minimo    Valor minimo establecido
     * @param maximo    Valor maximo establecido
     * @return          Devuelve una excepcion personalizada
     * @see             <RangoNoDeseadoException>
     */
    @Override
    public Optional<RangoNoDeseadoException> rangoValores(Integer valor, Long minimo, Long maximo) {
        if (valor >= minimo && valor <= maximo) {
            return Optional.empty();
        } else {
            RangoNoDeseadoException exception = new RangoNoDeseadoException("El valor debe estar comprendido entre: " + minimo + " y " + maximo);
            return Optional.of(exception);
        }
    }
    
    /**
     * Sobrecarga del metodo (a desallorar)
     * @author Mefisto
     * @param valor
     * @param minimo
     * @param maximo
     * @return 
     */
    @Override
    public Optional<RangoNoDeseadoException> rangoValores(String valor, Long minimo, Long maximo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Comprueba si un texto tiene formato de email
     * @author Mefisto
     * @param email Campo a comprobar
     * @return      Devuelve una excepcion personalizada
     * @see         <EmailNoFormateadoException>
     */
    @Override
    public Optional<EmailNoFormateadoException> emailNoFormateado(String email) {
        //TODO: Pasar a bundle
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            return Optional.empty();
        } else {
            return Optional.of(new EmailNoFormateadoException("El email no tiene el formato correcto"));
        }
    }

    /**
     * Comprueba si un email existe en nuestra base de datos
     * Tiene que tener un metodo para buscar dicho email
     * @author      Mefisto
     * @param email Valor a comprobar
     * @return      Devuelve una excepcion personalizada envuelta en un Optional
     * @see         <EmailNoExistsException>
     */
    @Override
    public Optional<EmailNoExistsException> emailNoExistente(String email) {

        if (daoFactoryLocal.getClienteDaoLocal().findByEmail(email).isPresent()) {
            return Optional.empty();
        } else {
            return Optional.of(new EmailNoExistsException("El email no se encuentra en la base de datos"));
        }
    }

    /**
     * Comprueba si el email existe en la base de datos
     * Tiene que tener un metodo para buscar dicho email
     * @author      Mefisto
     * @param email Valor a comprobar
     * @return      Devuelve una excepcion personalizada envuelta en un Optional
     * @see         <EmailRepetidoException>
     */
    @Override
    public Optional<EmailRepetidoException> emailRepetido(String email) {
        if (daoFactoryLocal.getClienteDaoLocal().findByEmail(email).isPresent()) {
            return Optional.of(new EmailRepetidoException("El email ya existe en la base de datos"));
        } else {
            return Optional.empty();
        }
    }

    /**
     * Busca un Cliente por email y comprueba si coincide el usuario que le pasamos
     * @param email     Cliente a buscar
     * @param password  Password a comprobar
     * @return          Devuelve una excepcion personalizada envuelta en un Optional
     * @see             <PasswordNoCoincidenteException>
     */
    @Override
    public Optional<PasswordNoCoincidenteException> passwordNoCoincidente(String email, String password) {

        Cliente cliente = daoFactoryLocal.getClienteDaoLocal().findByEmail(email).get();

        if (cliente.getPassCliente().equals(password)) {
            return Optional.empty();
        } else {
            return Optional.of(new PasswordNoCoincidenteException("El password no es correcto"));
        }
    }
}
