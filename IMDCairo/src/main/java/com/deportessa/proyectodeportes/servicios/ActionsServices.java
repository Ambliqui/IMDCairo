package com.deportessa.proyectodeportes.servicios;

import com.deportessa.proyectodeportes.frontController.FrontControlerLocal;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Esta clase nos va a hacer las veces de patron comando
 *
 * @author Mefisto
 */
@WebServlet(name = "ActionsServices", urlPatterns = {"/ActionsServices"})
public class ActionsServices extends HttpServlet {

    /**
     * Este metodo recoge el "accion" que nos llegue de cualquier formulario
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, FrontControlerLocal> accionesController = (Map<String, FrontControlerLocal>) request.getServletContext().getAttribute("accionesController");
        String ruta1 = request.getContextPath();
        String ruta2 = request.getLocalAddr();
        String ruta3 = request.getRequestURI();
        String ruta4 = request.getPathInfo();
        String ruta5 = request.getServletPath();
        String ruta6 = request.getContextPath();
        String ruta7 = request.getRequestURL().toString();
        String ruta8 = (String) request.getAttribute("javax.servlet.forward.request_uri");
        String ruta10 = request.getHeader("Referer");
        Enumeration<String> ruta9 = request.getHeaderNames();
       
        
        
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String uri = (String) request.getAttribute("javax.servlet.forward.request_uri");
        String prmstr = (String) request.getAttribute("javax.servlet.forward.query_string");
        String url = scheme + "://" + serverName + ":" + serverPort + uri + "?" + prmstr;

        FrontControlerLocal controller = accionesController.get(request.getParameter("accion"));
        controller.getDispatcher(request, response).forward(request, response);

    }

}
