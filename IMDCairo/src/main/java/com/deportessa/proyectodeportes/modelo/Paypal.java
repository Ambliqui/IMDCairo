/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author pryet
 */
@Table(name = "paypal")
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id_pago")
public class Paypal extends MetodoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "correo")
    private String correo;

    public Paypal() {
    }

    public Paypal(String correo) {
        this.correo = correo;
    }
    
    @Override
    public void editarMetodoPago(MetodoPago metodoPago) {
        this.correo=((Paypal)metodoPago).correo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.correo);
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
        final Paypal other = (Paypal) obj;
        return Objects.equals(this.correo, other.correo);
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Paypal{" + "correo=" + correo + '}';
    }

   

}
