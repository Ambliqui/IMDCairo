/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.services.inscripcion;

import com.arelance.imd.domain.Inscripcion;
import com.arelance.imd.domain.Login;
import com.arelance.imd.domain.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mefisto
 */

@Local
public interface ServicesInscripcion {
    
    List<Inscripcion> finByUser(Login login);
    
}
