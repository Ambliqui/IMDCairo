/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.deportessa.proyectodeportes.servicios;

import java.io.IOException;
import java.util.List;
import javax.ejb.Local;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mefisto
 */

@Local
@FunctionalInterface
public interface ActionValidator {
    
    public List<Exception> execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
}
