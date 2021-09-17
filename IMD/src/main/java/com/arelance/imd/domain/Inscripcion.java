/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.domain;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mefisto
 */
@Entity
@Table(name = "inscripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscripcion.findAll", query = "SELECT i FROM Inscripcion i"),
    @NamedQuery(name = "Inscripcion.findByIdUsuarioInscripcion", query = "SELECT i FROM Inscripcion i WHERE i.inscripcionPK.idUsuarioInscripcion = :idUsuarioInscripcion"),
    @NamedQuery(name = "Inscripcion.findByIdActividadInscripcion", query = "SELECT i FROM Inscripcion i WHERE i.inscripcionPK.idActividadInscripcion = :idActividadInscripcion")})
public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InscripcionPK inscripcionPK;
    @JoinColumn(name = "id_actividad_inscripcion", referencedColumnName = "id_actividad", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Actividad actividad;
    @JoinColumn(name = "forma_pago_inscripcion", referencedColumnName = "id_forma_pago")
    @ManyToOne(optional = false)
    private FormaPago formaPagoInscripcion;
    @JoinColumns({
        @JoinColumn(name = "id_usuario_inscripcion", referencedColumnName = "id_usuario", insertable = false, updatable = false),
        @JoinColumn(name = "id_usuario_inscripcion", referencedColumnName = "id_usuario", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Usuario usuario;

    public Inscripcion() {
    }

    public Inscripcion(InscripcionPK inscripcionPK) {
        this.inscripcionPK = inscripcionPK;
    }

    public Inscripcion(int idUsuarioInscripcion, int idActividadInscripcion) {
        this.inscripcionPK = new InscripcionPK(idUsuarioInscripcion, idActividadInscripcion);
    }

    public InscripcionPK getInscripcionPK() {
        return inscripcionPK;
    }

    public void setInscripcionPK(InscripcionPK inscripcionPK) {
        this.inscripcionPK = inscripcionPK;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public FormaPago getFormaPagoInscripcion() {
        return formaPagoInscripcion;
    }

    public void setFormaPagoInscripcion(FormaPago formaPagoInscripcion) {
        this.formaPagoInscripcion = formaPagoInscripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inscripcionPK != null ? inscripcionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscripcion)) {
            return false;
        }
        Inscripcion other = (Inscripcion) object;
        if ((this.inscripcionPK == null && other.inscripcionPK != null) || (this.inscripcionPK != null && !this.inscripcionPK.equals(other.inscripcionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arelance.imd.domain.Inscripcion[ inscripcionPK=" + inscripcionPK + " ]";
    }
    
}
