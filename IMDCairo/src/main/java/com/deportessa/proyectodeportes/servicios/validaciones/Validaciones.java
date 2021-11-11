/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.deportessa.proyectodeportes.servicios.validaciones;

import com.deportessa.proyectodeportes.modelo.Actividad;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.servicios.excepciones.*;
import java.util.Optional;

/**
 * Interfaz de las distintas validaciones de nuestro programa
 * y algunas a futuro
 * @author Mefisto
 */
public interface Validaciones {
    
    Optional<CamposNoCoincidentesException> camposIdenticos(String nombreCampo1, String nombreCampo2, String campo1, String campo2);
        
    Boolean campoNuloVacio (String campo);
    
    Optional<CampoNoNumericoException> campoNumerico(String valor);
    
    Optional<LongitudNoDeseadaException> longitudCampo(String nombreCampo, String campo, Integer longitudMinima);
    
    Optional <LongitudNoDeseadaException> rangoLongitudCampo(String nombreCampo, String campo, Integer longitudMinima, Integer longitudMaxima);
    
    Optional<RangoNoDeseadoException> rangoValores(Integer valor, Integer minimo, Integer maximo);
    
    Optional<RangoNoDeseadoException> rangoValores(String campoNombre, String valor, Integer minimo, Integer maximo);
    
    Optional<EmailNoFormateadoException> emailNoFormateado(String email);
    
    Optional<EmailNoExistsException> emailNoExistente(String email);
    
    Optional<EmailRepetidoException> emailRepetido (String email);
    
    Optional<PasswordNoCoincidenteException> passwordNoCoincidente (String email, String password);
    
    Optional<UsuarioYaInscritoException> usuarioYaInscrito (Integer idCliente, Integer idActividad);
    
    Optional<UsuarioYaInscritoException> usuarioYaInscrito (Cliente cliente, Actividad actividad);
    
}
