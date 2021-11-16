package com.deportessa.proyectodeportes.servicios;

import com.deportessa.proyectodeportes.frontController.FrontControlerLocal;
import java.io.IOException;
import java.util.Enumeration;
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

        String ruta10 = request.getHeader("Referer");


        FrontControlerLocal controller = accionesController.get(request.getParameter("accion"));
        controller.getDispatcher(request, response).forward(request, response);

    }

}
