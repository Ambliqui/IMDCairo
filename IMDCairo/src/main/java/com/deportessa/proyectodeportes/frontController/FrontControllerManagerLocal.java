/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.frontController;

import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author pryet
 */
@Local
public interface FrontControllerManagerLocal {

    Map<String, FrontControler> getAcciones();

    String getString();

    void setAcciones(Map<String, FrontControler> dispatchers);
    
}
