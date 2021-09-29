/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mefisto
 */
@Entity
@Table(name = "tarjeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjeta.findAll", query = "SELECT t FROM Tarjeta t"),
    @NamedQuery(name = "Tarjeta.findByIdTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.idTarjeta = :idTarjeta"),
    @NamedQuery(name = "Tarjeta.findByIdUsuarioTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.idUsuarioTarjeta = :idUsuarioTarjeta"),
    @NamedQuery(name = "Tarjeta.findByNumeroTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.numeroTarjeta = :numeroTarjeta"),
    @NamedQuery(name = "Tarjeta.findByMesTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.mesTarjeta = :mesTarjeta"),
    @NamedQuery(name = "Tarjeta.findByAnnoTajerta", query = "SELECT t FROM Tarjeta t WHERE t.annoTajerta = :annoTajerta"),
    @NamedQuery(name = "Tarjeta.findByCvv", query = "SELECT t FROM Tarjeta t WHERE t.cvv = :cvv")})
public class Tarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id_tarjeta")
    private int idTarjeta;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario_tarjeta")
    private Integer idUsuarioTarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_tarjeta")
    private int numeroTarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mes_tarjeta")
    private int mesTarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anno_tajerta")
    private int annoTajerta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cvv")
    private int cvv;
    @JoinColumn(name = "id_forma_pago_tarjeta", referencedColumnName = "id_forma_pago")
    @ManyToOne(optional = false)
    private FormaPago idFormaPagoTarjeta;
    @JoinColumns({
        @JoinColumn(name = "id_usuario_tarjeta", referencedColumnName = "id_usuario", insertable = false, updatable = false),
        @JoinColumn(name = "id_usuario_tarjeta", referencedColumnName = "id_usuario", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Tarjeta() {
    }

    public Tarjeta(Integer idUsuarioTarjeta) {
        this.idUsuarioTarjeta = idUsuarioTarjeta;
    }

    public Tarjeta(Integer idUsuarioTarjeta, int idTarjeta, int numeroTarjeta, int mesTarjeta, int annoTajerta, int cvv) {
        this.idUsuarioTarjeta = idUsuarioTarjeta;
        this.idTarjeta = idTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.mesTarjeta = mesTarjeta;
        this.annoTajerta = annoTajerta;
        this.cvv = cvv;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Integer getIdUsuarioTarjeta() {
        return idUsuarioTarjeta;
    }

    public void setIdUsuarioTarjeta(Integer idUsuarioTarjeta) {
        this.idUsuarioTarjeta = idUsuarioTarjeta;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getMesTarjeta() {
        return mesTarjeta;
    }

    public void setMesTarjeta(int mesTarjeta) {
        this.mesTarjeta = mesTarjeta;
    }

    public int getAnnoTajerta() {
        return annoTajerta;
    }

    public void setAnnoTajerta(int annoTajerta) {
        this.annoTajerta = annoTajerta;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public FormaPago getIdFormaPagoTarjeta() {
        return idFormaPagoTarjeta;
    }

    public void setIdFormaPagoTarjeta(FormaPago idFormaPagoTarjeta) {
        this.idFormaPagoTarjeta = idFormaPagoTarjeta;
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
        hash += (idUsuarioTarjeta != null ? idUsuarioTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarjeta)) {
            return false;
        }
        Tarjeta other = (Tarjeta) object;
        if ((this.idUsuarioTarjeta == null && other.idUsuarioTarjeta != null) || (this.idUsuarioTarjeta != null && !this.idUsuarioTarjeta.equals(other.idUsuarioTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arelance.imd.domain.Tarjeta[ idUsuarioTarjeta=" + idUsuarioTarjeta + " ]";
    }
    
}
