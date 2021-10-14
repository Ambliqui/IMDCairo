/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author pryet
 */
@Table(name = "transferencia")
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id_pago")
public class Transferencia extends MetodoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Column(name = "num_cuenta")
    private int numCuenta;

    public Transferencia() {
    }

    public Transferencia(int numCuenta) {
        this.numCuenta = numCuenta;
    }

//    public Transferencia(Cliente cliente) {
//        super(cliente);
//    }
    
    @Override
    public void editarMetodoPago(MetodoPago metodoPago) {
        this.numCuenta=((Transferencia)metodoPago).numCuenta;
    }
    

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.numCuenta;
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
        final Transferencia other = (Transferencia) obj;
        if (this.numCuenta != other.numCuenta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "numCuenta=" + numCuenta + '}';
    }

    
}
