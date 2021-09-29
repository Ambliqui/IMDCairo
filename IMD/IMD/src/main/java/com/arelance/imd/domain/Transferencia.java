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
@Table(name = "transferencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transferencia.findAll", query = "SELECT t FROM Transferencia t"),
    @NamedQuery(name = "Transferencia.findByIdTransferencia", query = "SELECT t FROM Transferencia t WHERE t.idTransferencia = :idTransferencia"),
    @NamedQuery(name = "Transferencia.findByIdUsuarioTransferencia", query = "SELECT t FROM Transferencia t WHERE t.idUsuarioTransferencia = :idUsuarioTransferencia"),
    @NamedQuery(name = "Transferencia.findByCuentaTransferencia", query = "SELECT t FROM Transferencia t WHERE t.cuentaTransferencia = :cuentaTransferencia")})
public class Transferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id_transferencia")
    private int idTransferencia;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario_transferencia")
    private Integer idUsuarioTransferencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuenta_transferencia")
    private int cuentaTransferencia;
    @JoinColumn(name = "id_forma_pago_transferencia", referencedColumnName = "id_forma_pago")
    @ManyToOne(optional = false)
    private FormaPago idFormaPagoTransferencia;
    @JoinColumns({
        @JoinColumn(name = "id_usuario_transferencia", referencedColumnName = "id_usuario", insertable = false, updatable = false),
        @JoinColumn(name = "id_usuario_transferencia", referencedColumnName = "id_usuario", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Transferencia() {
    }

    public Transferencia(Integer idUsuarioTransferencia) {
        this.idUsuarioTransferencia = idUsuarioTransferencia;
    }

    public Transferencia(Integer idUsuarioTransferencia, int idTransferencia, int cuentaTransferencia) {
        this.idUsuarioTransferencia = idUsuarioTransferencia;
        this.idTransferencia = idTransferencia;
        this.cuentaTransferencia = cuentaTransferencia;
    }

    public int getIdTransferencia() {
        return idTransferencia;
    }

    public void setIdTransferencia(int idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public Integer getIdUsuarioTransferencia() {
        return idUsuarioTransferencia;
    }

    public void setIdUsuarioTransferencia(Integer idUsuarioTransferencia) {
        this.idUsuarioTransferencia = idUsuarioTransferencia;
    }

    public int getCuentaTransferencia() {
        return cuentaTransferencia;
    }

    public void setCuentaTransferencia(int cuentaTransferencia) {
        this.cuentaTransferencia = cuentaTransferencia;
    }

    public FormaPago getIdFormaPagoTransferencia() {
        return idFormaPagoTransferencia;
    }

    public void setIdFormaPagoTransferencia(FormaPago idFormaPagoTransferencia) {
        this.idFormaPagoTransferencia = idFormaPagoTransferencia;
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
        hash += (idUsuarioTransferencia != null ? idUsuarioTransferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transferencia)) {
            return false;
        }
        Transferencia other = (Transferencia) object;
        if ((this.idUsuarioTransferencia == null && other.idUsuarioTransferencia != null) || (this.idUsuarioTransferencia != null && !this.idUsuarioTransferencia.equals(other.idUsuarioTransferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arelance.imd.domain.Transferencia[ idUsuarioTransferencia=" + idUsuarioTransferencia + " ]";
    }
    
}
