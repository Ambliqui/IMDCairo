/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.model.actividadesDAO;

import com.arelance.imd.domain.Actividad;
import com.arelance.imd.domain.FormaPago;
import com.arelance.imd.domain.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mefisto
 */

@Local
public interface ActividadDAO {
    
    List<Actividad> findAll();
    Actividad searchActivity(Actividad actividad);
    boolean inscripcion(Usuario usuario, Actividad actividad, FormaPago formaPago);
    List<Actividad> inscripcionesUsuario (Usuario usuario);
    //TO DO CAI devolver la actividad con el metodo de pago
    Actividad comprobarInscripcion(Usuario usuario, Actividad actividad);
}
