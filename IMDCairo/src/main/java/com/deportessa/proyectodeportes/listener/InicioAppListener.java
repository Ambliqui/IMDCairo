/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.listener;

import com.deportessa.proyectodeportes.daojpa.factory.DaoAbstractFactoryLocal;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.deportessa.proyectodeportes.servicios.ActionValidator;
import com.deportessa.proyectodeportes.servicios.qualifiers.ActionValidatorDatosPersonalesImplQ;
import com.deportessa.proyectodeportes.servicios.qualifiers.ActionValidatorInscripcionQ;
import com.deportessa.proyectodeportes.servicios.qualifiers.ActionValidatorRegistroUsuarioQ;
import com.deportessa.proyectodeportes.servicios.qualifiers.ActionValidatorLoginQ;

/**
 * Web application lifecycle listener.
 *
 * @author pryet
 */
public class InicioAppListener implements ServletContextListener {


    //Inyeccion de dependencias
    @Inject
    private DaoAbstractFactoryLocal daoFactoryLocal;

    @Inject
    @ActionValidatorLoginQ
    private ActionValidator login;

    @Inject
    @ActionValidatorRegistroUsuarioQ
    private ActionValidator registroUsuario;

    @Inject
    @ActionValidatorDatosPersonalesImplQ
    private ActionValidator datosUsuario;
    
    @Inject
    @ActionValidatorInscripcionQ
    private ActionValidator inscripcionActividad;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        //Mapa
        
        
        
        //Mapa para el comando de la aplicacion
        Map<String, ActionValidator> acciones = new HashMap<>();
        acciones.put("Login", login);
        acciones.put("Siguiente", registroUsuario);
        acciones.put("Registrar", datosUsuario);
        acciones.put("Inscribirse", inscripcionActividad);
        sce.getServletContext().setAttribute("acciones", acciones);
        
        
        //Subimos las actividades al contexto
        sce.getServletContext().setAttribute("listaActividades", daoFactoryLocal.getActividadDaoLocal().findAll());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
