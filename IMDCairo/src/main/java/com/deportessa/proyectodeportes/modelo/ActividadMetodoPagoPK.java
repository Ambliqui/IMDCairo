/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author pryet
 */
@Embeddable
public class ActividadMetodoPagoPK implements Serializable {


    @NotNull
    @Column(name = "id_actividad_inscripcion")
    private int idActividadInscripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pago_inscripcion")
    private int idPagoInscripcion;

    public ActividadMetodoPagoPK() {
    }

    public ActividadMetodoPagoPK(int idActividadInscripcion, int idPagoInscripcion) {
        this.idActividadInscripcion = idActividadInscripcion;
        this.idPagoInscripcion = idPagoInscripcion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.idActividadInscripcion;
        hash = 79 * hash + this.idPagoInscripcion;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ActividadMetodoPagoPK other = (ActividadMetodoPagoPK) obj;
        if (this.idActividadInscripcion != other.idActividadInscripcion) {
            return false;
        }
        return this.idPagoInscripcion == other.idPagoInscripcion;
    }
    
    public int getIdActividadInscripcion() {
        return idActividadInscripcion;
    }

    public void setIdActividadInscripcion(int idActividadInscripcion) {
        this.idActividadInscripcion = idActividadInscripcion;
    }

    public int getIdPagoInscripcion() {
        return idPagoInscripcion;
    }

    public void setIdPagoInscripcion(int idPagoInscripcion) {
        this.idPagoInscripcion = idPagoInscripcion;
    }



    

}
