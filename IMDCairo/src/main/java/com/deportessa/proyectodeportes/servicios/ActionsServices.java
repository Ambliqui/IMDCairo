
package com.deportessa.proyectodeportes.servicios;

import com.deportessa.proyectodeportes.servicios.qualifiers.LoginQ;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.deportessa.proyectodeportes.servicios.qualifiers.DatosPersonalesQ;
import com.deportessa.proyectodeportes.servicios.qualifiers.RegistroUsuarioServicioQ;

/**
 * Esta clase nos va a hacer las veces de patron comando
 * @author Mefisto
 */
@WebServlet(name = "ActionsServices", urlPatterns = {"/ActionsServices"})
public class ActionsServices extends HttpServlet {

    //Inyeccion de dependencias
    @Inject
    @LoginQ
    private ActionController login;

    @Inject
    @RegistroUsuarioServicioQ
    private ActionController registroUsuario;
    
    @Inject
    @DatosPersonalesQ
    private ActionController datosUsuario;

    private final Map<String, ActionController> acciones = new HashMap<>();

    /**
     * Inicializacion de los pares del mapa
     * @throws ServletException 
     */
    @Override
    public void init() throws ServletException {
        super.init();
        acciones.put("Login", login);
        acciones.put("Siguiente", registroUsuario);
        acciones.put("Registrar", datosUsuario);
    }

    /**
     * Este metodo recoge el "accion" que nos llegue de cualquier formulario
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //TODO: Traer el mapa de validaciones del contexto
        String actionKey = request.getParameter("accion");

        ActionController accion = acciones.get(actionKey);
        String page = accion.execute(request, response);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);

    }

}
