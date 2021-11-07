package com.deportessa.proyectodeportes.servicios;

import com.deportessa.proyectodeportes.servicios.validaciones.Validaciones;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.deportessa.proyectodeportes.servicios.qualifiers.DatosPersonalesQ;

/**
 * Servlet para validar los campos de entrada del formulario de datos perosonales
 * del Cliente
 * @author Mefisto
 */
@DatosPersonalesQ
public class DatosPersonalesServlet implements ActionController {

    @Inject
    private Validaciones validaciones;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Exception> exceptions = new ArrayList<>();

        validaciones.longitudCampo("Nombre", request.getParameter("nombre"), 4).ifPresent((error) -> exceptions.add(error));
        validaciones.longitudCampo("Apellidos",request.getParameter("apellidos"), 4).ifPresent((error) -> exceptions.add(error));
        validaciones.campoNumerico(request.getParameter("telefono")).ifPresent((error) -> exceptions.add(error));
//        if () {
            validaciones.longitudCampo("Telefono",request.getParameter("telefono"), 9).ifPresent((error) -> exceptions.add(error));
//        }

        String metodoPago = request.getParameter("metodoPago");

        switch (metodoPago) {
            case "tarjeta":
//                validaciones.longitudCampo("Numero de Tarjeta: ", request.getParameter("numeroTarjeta"), 4).ifPresent((error) -> exceptions.add(error));
//                validaciones.rangoValores(Integer.parseInt(request.getParameter("mesTarjeta")), 1L, 12L);
//                validaciones.longitudCampo("Mes Tarjeta: ", request.getParameter("mesTarjeta"), 4).ifPresent((error) -> exceptions.add(error));
//                validaciones.longitudCampo("Año Tarjeta: ", request.getParameter("annoTarjeta"), 4).ifPresent((error) -> exceptions.add(error));
//                validaciones.longitudCampo("CVS: ", request.getParameter("cvsTarjeta"), 4).ifPresent((error) -> exceptions.add(error));
                break;
            case "paypal":
//                validaciones.emailNoFormateado(request.getParameter("cuentaPaypal")).ifPresent((error) -> exceptions.add(error));
                break;
            case "transferencia":
//                validaciones.longitudCampo("IBAN: ",  request.getParameter("IBAN"), 4).ifPresent((error) -> exceptions.add(error));
                break;
            default:
        }

        if (exceptions.isEmpty()) {
            return "/PostRegistroDatosPersonalesServlet";
        } else {

            //Recuperamos lo que nos ha escrito el cliente para volver a mostrarlo en pantalla
            request.setAttribute("nombre", request.getParameter("nombre"));
            request.setAttribute("apellidos", request.getParameter("apellidos"));
            request.setAttribute("telefono", request.getParameter("telefono"));
            
            switch (metodoPago) {
                case "tarjeta":
                    request.setAttribute("numeroTarjeta", request.getParameter("numeroTarjeta"));
                    request.setAttribute("mesTarjeta", request.getParameter("mesTarjeta"));
                    request.setAttribute("annoTarjeta", request.getParameter("annoTarjeta"));
                    request.setAttribute("cvsTarjeta", request.getParameter("cvsTarjeta"));
                    break;
//                case "paypal":
//                    request.setAttribute("cuentaPaypal", request.getParameter("cuentaPaypal"));
//                    break;
//                case "transferencia":
//                    request.setAttribute("IBAN", request.getParameter("IBAN"));
//                    break;
                default:
            }

            //Devolvemos los errores
            request.setAttribute("errores", exceptions);
            return "/PreRegistroDatosPersonalesServlet";
        }

    }
}
