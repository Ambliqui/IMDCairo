/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.sgaejb_jpa.dao.aficion;

import com.arelance.sgajpa.domain.Aficion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mefisto
 */

@Local
public interface AficionDAO {
    
    List<Aficion> findAllAficion ();
    void altaAficion(Aficion aficion);
    void modificar (Aficion aficion);
}
