/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.deportessa.proyectodeportes.servicios.validaciones;

/**
 *
 * @author Mefisto
 */
public interface Validaciones {
    
    Boolean camposIdenticos(String campo1, String campo2);
    
    Boolean campoRelleno (String campo);
    
    Boolean campoRelleno (Integer campo);
    
    Boolean campoRelleno (Long campo);
    
    Boolean campoRelleno (Double campo);
    
    Boolean longitudCampo(String campo, Integer longitudMinima);
    
    Boolean longitudCampo(Integer campo, Integer valordMinimo);
    
    Boolean longitudCampo(Long campo, Integer valordMinimo);
    
    Boolean longitudCampo(Double campo, Integer valordMinimo);
    
}
