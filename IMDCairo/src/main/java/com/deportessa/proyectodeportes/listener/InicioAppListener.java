/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.listener;

import com.deportessa.proyectodeportes.servicios.ActividadServicioLocal;
import com.deportessa.proyectodeportes.vista.actividadDto.ActividadDTO;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author pryet
 */
public class InicioAppListener implements ServletContextListener {

    @Inject
    private ActividadServicioLocal actividadEJB;

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
