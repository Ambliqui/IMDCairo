/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.frontController.factory;

import javax.ejb.Local;
import com.deportessa.proyectodeportes.frontController.FrontControlerLocal;

/**
 *
 * @author pryet
 */
@Local
public interface AccionFactoryLocal {
    
    FrontControlerLocal getControlerLogin();
    FrontControlerLocal getRegistroDatosLogin();
    FrontControlerLocal getRegistroUsuario();
    FrontControlerLocal getInscripcion();
    FrontControlerLocal getModificar();
    FrontControlerLocal getPreprincipal();
    FrontControlerLocal getPreRegistroUsuario();
    FrontControlerLocal getBajaActividad();
    FrontControlerLocal getDetalleActividad();
    FrontControlerLocal getMisActividades();
    FrontControlerLocal getCerrarSesion();
    FrontControlerLocal getPerfilUsuario();
    FrontControlerLocal getBajaUsuario();
}
