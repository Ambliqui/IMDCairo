/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.model.inscripcionesDAO;

import com.arelance.imd.domain.Inscripcion;
import com.arelance.imd.domain.Login;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mefisto
 */
@Local
public interface InscripcionesDAO {
    
    List<Inscripcion> findByUser(Login login);
    
}
