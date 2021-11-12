/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.frontController;

import java.io.IOException;
import javax.ejb.Local;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.rmi.server.Dispatcher;

/**
 *
 * @author pryet
 */
@Local
@FunctionalInterface
public interface FrontControler {
    
    Dispatcher getRuta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException ;
    
    
}
