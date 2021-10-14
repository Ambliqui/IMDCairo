/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author pryet
 */
public class InicioAppListener implements ServletContextListener {

//    @Inject
//    private ActividadServicioLocal actividadEJB;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        
//        List<ActividadDTO> lista=actividadEJB.obtenerActividades();
//        sce.getServletContext().setAttribute("listaActividades", lista);
//        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
