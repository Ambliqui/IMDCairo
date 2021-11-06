/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.servicios;

import com.deportessa.proyectodeportes.servicios.dto.InscripcionDTO;
import com.deportessa.proyectodeportes.modelo.Cliente;
import com.deportessa.proyectodeportes.modelo.Inscripcion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pryet
 */
@Local
public interface InscripcionServicio {
    List<Inscripcion> getInscripciones(Cliente cliente);
    List<InscripcionDTO> getInscripcionesDTO(Cliente cliente);
    void baja(Integer idActividad, Integer idPago);
}
