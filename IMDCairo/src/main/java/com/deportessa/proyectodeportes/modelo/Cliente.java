/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pryet
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email_cliente",columnDefinition = "varchar(255) unique")
    private String emailCliente;
    
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 45)
    @Column(name = "pass_cliente")
    private String passCliente;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido_1_cliente")
    private String apellido1Cliente;

    @Size(max = 45)
    @Column(name = "telefono_cliente")
    private String telefonoCliente;

    @Basic(optional = false)
    @Column(name = "fecha_registro_cliente",columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistroCliente;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "id_cliente")
    private List<MetodoPago> metodosPagoCliente;
    
    @PrePersist
    private void asginarFecha() {
        this.fechaRegistroCliente = new Date();
    }

    public Cliente(String emailCliente, String passCliente, String nombreCliente, String apellido1Cliente, String telefonoCliente) {
        this.emailCliente = emailCliente;
        this.passCliente = passCliente;
        this.nombreCliente = nombreCliente;
        this.apellido1Cliente = apellido1Cliente;
        this.telefonoCliente = telefonoCliente;
    }

    public void addMPago(MetodoPago mPago){
        if(this.metodosPagoCliente==null){
            metodosPagoCliente=new ArrayList<>();
        }
        metodosPagoCliente.add(mPago);
    }
    
    public Cliente() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getPassCliente() {
        return passCliente;
    }

    public void setPassCliente(String passCliente) {
        this.passCliente = passCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellido1Cliente() {
        return apellido1Cliente;
    }

    public void setApellido1Cliente(String apellido1Cliente) {
        this.apellido1Cliente = apellido1Cliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public Date getFechaRegistroCliente() {
        return fechaRegistroCliente;
    }

    public void setFechaRegistroCliente(Date fechaRegistroCliente) {
        this.fechaRegistroCliente = fechaRegistroCliente;
    }

    public List<MetodoPago> getMetodosPagoCliente() {
        return metodosPagoCliente;
    }

    public void setMetodosPagoCliente(List<MetodoPago> metodosPagoCliente) {
        this.metodosPagoCliente = metodosPagoCliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.emailCliente);
        hash = 79 * hash + Objects.hashCode(this.passCliente);
        hash = 79 * hash + Objects.hashCode(this.nombreCliente);
        hash = 79 * hash + Objects.hashCode(this.apellido1Cliente);
        hash = 79 * hash + Objects.hashCode(this.telefonoCliente);
        hash = 79 * hash + Objects.hashCode(this.fechaRegistroCliente);
        hash = 79 * hash + Objects.hashCode(this.metodosPagoCliente);
        hash = 79 * hash + Objects.hashCode(this.idCliente);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.emailCliente, other.emailCliente)) {
            return false;
        }
        if (!Objects.equals(this.passCliente, other.passCliente)) {
            return false;
        }
        if (!Objects.equals(this.nombreCliente, other.nombreCliente)) {
            return false;
        }
        if (!Objects.equals(this.apellido1Cliente, other.apellido1Cliente)) {
            return false;
        }
        if (!Objects.equals(this.telefonoCliente, other.telefonoCliente)) {
            return false;
        }
        if (!Objects.equals(this.fechaRegistroCliente, other.fechaRegistroCliente)) {
            return false;
        }
        if (!Objects.equals(this.metodosPagoCliente, other.metodosPagoCliente)) {
            return false;
        }
        return Objects.equals(this.idCliente, other.idCliente);
    }

    @Override
    public String toString() {
        return "Cliente{" + "emailCliente=" + emailCliente + ", passCliente=" + passCliente + ", nombreCliente=" + nombreCliente + ", apellido1Cliente=" + apellido1Cliente +", telefonoCliente=" + telefonoCliente + ", fechaRegistroCliente=" + fechaRegistroCliente + ", metodosPagoCliente=" + metodosPagoCliente + ", idCliente=" + idCliente + '}';
    }

}
