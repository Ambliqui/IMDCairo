/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.frontController;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javax.ejb.Singleton;
import javax.inject.Inject;


/**
 *
 * @author pryet
 */
@Singleton
public class FrontControlerManager implements FrontControllerManagerLocal {
    private final ResourceBundle bdAcciones = ResourceBundle.getBundle("bundle.acciones");
    @Inject
    private AccionFactoryLocal accionFactory;
    private Map<String,FrontControler> acciones;


    public FrontControlerManager() {
        acciones=new HashMap<>();
        acciones.put(bdAcciones.getString("Login"), accionFactory.getControlerLogin());
        acciones.put(bdAcciones.getString("Siguiente"), accionFactory.getRegistroDatosLogin());
        acciones.put(bdAcciones.getString("Registrar"), value);
        acciones.put(bdAcciones.getString("Inscribirse"), value);

    }
    
    

    @Override
    public Map<String, FrontControler> getAcciones() {
        return acciones;
    }

    @Override
    public void setAcciones(Map<String, FrontControler> dispatchers) {
        this.acciones = dispatchers;
    }
    
    @Override
    public String getString(){
        return bdAcciones.getString("Login");
    }
    
}
