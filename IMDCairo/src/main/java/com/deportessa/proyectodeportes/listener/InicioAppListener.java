/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.listener;

import com.deportessa.proyectodeportes.daojpa.factory.DaoAbstractFactoryLocal;
import com.deportessa.proyectodeportes.servicios.ActionController;
import com.deportessa.proyectodeportes.servicios.qualifiers.DatosPersonalesQ;
import com.deportessa.proyectodeportes.servicios.qualifiers.LoginQ;
import com.deportessa.proyectodeportes.servicios.qualifiers.RegistroUsuarioServicioQ;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author pryet
 */
public class InicioAppListener implements ServletContextListener {

    // @Inject
    // ActividadServicio actividadServicio;
    @Inject
    private DaoAbstractFactoryLocal daoFactoryLocal;

    @Inject
    @LoginQ
    private ActionController login;

    @Inject
    @RegistroUsuarioServicioQ
    private ActionController registroUsuario;

    @Inject
    @DatosPersonalesQ
    private ActionController datosUsuario;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        final Map<String, ActionController> acciones = new HashMap<>();
        acciones.put("Login", login);
        acciones.put("Siguiente", registroUsuario);
        acciones.put("Registrar", datosUsuario);

        //TODO: Poner actividades en Contexto
        // sce.getServletContext().setAttribute("listaActividades", daoFactoryLocal.getActividadDaoLocal().findAll());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
