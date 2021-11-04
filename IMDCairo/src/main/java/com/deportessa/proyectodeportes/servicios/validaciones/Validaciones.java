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
 *
 * @author Mefisto
 */
public interface Validaciones {
    
    Optional<CamposNoCoincidentesException> camposIdenticos(String campo1, String campo2);
    
    Optional<EmailNoExistsException> emailNoExistente(String email);
    
    Optional<EmailNoFormateadoException> emailNoFormateado(String email);
    
    Boolean campoRelleno (String campo);
    
    Boolean campoRelleno (Integer campo);
    
    Boolean campoRelleno (Long campo);
    
    Boolean campoRelleno (Double campo);
    
    Optional<LongitudNoDeseadaException> longitudCampo(String campo, Integer longitudMinima);
    
    Optional<LongitudNoDeseadaException> longitudCampo(Integer campo, Integer valordMinimo);
    
    LongitudNoDeseadaException longitudCampo(Long campo, Integer valordMinimo);
    
    LongitudNoDeseadaException longitudCampo(Double campo, Integer valordMinimo);
    
}
