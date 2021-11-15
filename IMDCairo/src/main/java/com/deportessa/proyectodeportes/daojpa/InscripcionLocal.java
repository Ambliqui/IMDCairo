/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.daojpa;

import com.deportessa.proyectodeportes.modelo.ActividadMetodoPagoPK;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import com.deportessa.proyectodeportes.servicios.dto.InscripcionDTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Antonio
 */
@Local
public interface InscripcionLocal {

    void create(Inscripcion inscripcion);
    
    void edit(Inscripcion inscripcion);

    void remove(Inscripcion inscripcion);

    List<Inscripcion> findAll();
    
    Inscripcion find(ActividadMetodoPagoPK id);

    List<Inscripcion> findRange(int[] range);

    int count();
    
    List<InscripcionDTO> getinscripcionDTO(Cliente cliente);
    
}
