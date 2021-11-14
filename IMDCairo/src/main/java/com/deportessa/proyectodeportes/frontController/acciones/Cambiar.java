/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deportessa.proyectodeportes.frontController.acciones;

import com.deportessa.proyectodeportes.daojpa.factory.DaoAbstractFactoryLocal;
import com.deportessa.proyectodeportes.daojpa.qulifiers.CambiarMetodoPago;
import com.deportessa.proyectodeportes.frontController.FrontControlerLocal;
import com.deportessa.proyectodeportes.modelo.Actividad;
import com.deportessa.proyectodeportes.modelo.ActividadMetodoPagoPK;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import com.deportessa.proyectodeportes.modelo.MetodoPago;
import com.deportessa.proyectodeportes.servicios.dto.InscripcionDTO;
import java.io.IOException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antonio
 */
@Stateless
@CambiarMetodoPago
public class Cambiar implements FrontControlerLocal {

    @Inject
    private DaoAbstractFactoryLocal daoFactoryLocal;

    @Override
    public RequestDispatcher getDispatcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cliente cliente = (Cliente) request.getSession(false).getAttribute("clienteSession");
        List<InscripcionDTO> listaDTO = daoFactoryLocal.getInscripcionDaoLocal().getinscripcionDTO(cliente);
        Inscripcion inscripcion;
        Actividad actividad = daoFactoryLocal.getActividadDaoLocal().find(Integer.parseInt(request.getParameter("idActividad")));
        for (InscripcionDTO inscripcionDTO : listaDTO) {
            if (inscripcionDTO.getactividad().getIdActividad() == actividad.getIdActividad()) {
                inscripcion = inscripcionDTO.getInscripcion();
                MetodoPago mp = daoFactoryLocal.getMetodoPagoDaoLocal().find(Integer.parseInt(request.getParameter("metodoPago")));
                Inscripcion nueva = new Inscripcion(actividad, mp);
                nueva.setFechaAlta(inscripcion.getFechaAlta());

                MetodoPago mpAntiguo = inscripcion.getMetodoPago();

                List<Inscripcion> listaIns = mpAntiguo.getInscripciones();
                listaIns.remove(inscripcion);
                mpAntiguo.setInscripciones(listaIns);
                daoFactoryLocal.getMetodoPagoDaoLocal().edit(mpAntiguo);
                daoFactoryLocal.getInscripcionDaoLocal().remove(inscripcion);
                mp.addInscripcion(nueva);
                daoFactoryLocal.getMetodoPagoDaoLocal().edit(mpAntiguo);
                daoFactoryLocal.getMetodoPagoDaoLocal().edit(mp);
                break;
            }
        }
        return request.getRequestDispatcher("./preMisActividades");

    }

}
