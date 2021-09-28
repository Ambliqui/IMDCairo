/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mefisto
 */
@Embeddable
public class InscripcionPK implements Serializable {

//    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario_inscripcion")
    private int idUsuarioInscripcion;
//    @Basic(optional = false)
    @NotNull
    @Column(name = "id_actividad_inscripcion")
    private int idActividadInscripcion;

    public InscripcionPK() {
    }

    public InscripcionPK(int idUsuarioInscripcion, int idActividadInscripcion) {
        this.idUsuarioInscripcion = idUsuarioInscripcion;
        this.idActividadInscripcion = idActividadInscripcion;
    }

    public int getIdUsuarioInscripcion() {
        return idUsuarioInscripcion;
    }

    public void setIdUsuarioInscripcion(int idUsuarioInscripcion) {
        this.idUsuarioInscripcion = idUsuarioInscripcion;
    }

    public int getIdActividadInscripcion() {
        return idActividadInscripcion;
    }

    public void setIdActividadInscripcion(int idActividadInscripcion) {
        this.idActividadInscripcion = idActividadInscripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuarioInscripcion;
        hash += (int) idActividadInscripcion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscripcionPK)) {
            return false;
        }
        InscripcionPK other = (InscripcionPK) object;
        if (this.idUsuarioInscripcion != other.idUsuarioInscripcion) {
            return false;
        }
        if (this.idActividadInscripcion != other.idActividadInscripcion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arelance.imd.domain.InscripcionPK[ idUsuarioInscripcion=" + idUsuarioInscripcion + ", idActividadInscripcion=" + idActividadInscripcion + " ]";
    }
    
}
