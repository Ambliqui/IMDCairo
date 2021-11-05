/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.deportessa.proyectodeportes.servicios.validaciones;

import com.deportessa.proyectodeportes.servicios.excepciones.CamposNoCoincidentesException;
import com.deportessa.proyectodeportes.servicios.excepciones.EmailNoExistsException;
import com.deportessa.proyectodeportes.servicios.excepciones.EmailNoFormateadoException;
import com.deportessa.proyectodeportes.servicios.excepciones.LongitudNoDeseadaException;
import java.util.Optional;

/**
 * Interfaz de las distintas validaciones de nuestro programa
 * @author Mefisto
 */
public interface Validaciones {
    
    Optional<CamposNoCoincidentesException> camposIdenticos(String campo1, String campo2);
    
    Optional<EmailNoExistsException> emailNoExistente(String email);
    
    Optional<EmailNoFormateadoException> emailNoFormateado(String email);
    
    Boolean campoRelleno (String campo);
    
    Optional<LongitudNoDeseadaException> longitudCampo(String campo, Integer longitudMinima);
    
}
