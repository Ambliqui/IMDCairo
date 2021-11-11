
package com.deportessa.proyectodeportes.servicios;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Esta clase nos va a hacer las veces de patron comando
 * @author Mefisto
 */
@WebServlet(name = "ActionsServices", urlPatterns = {"/ActionsServices"})
public class ActionsServices extends HttpServlet {

    /**
     * Este metodo recoge el "accion" que nos llegue de cualquier formulario
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Map<String, ActionValidator> acciones = (Map<String, ActionValidator>) request.getServletContext().getAttribute("acciones");
        String actionKey = request.getParameter("accion");

        ActionValidator accion = acciones.get(actionKey);
        String page = accion.execute(request, response);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);

    }

}
