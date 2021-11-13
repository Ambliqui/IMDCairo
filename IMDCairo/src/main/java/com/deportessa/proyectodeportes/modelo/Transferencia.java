/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deportessa.proyectodeportes.modelo;

import java.io.Serializable;
import java.util.Objects;
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
    @Column(name = "num_cuenta",unique = true)
    private int numCuenta;
    
    @NotNull
    @Column(name = "pais_cuenta")
    private String paisCuenta;    
    
    @NotNull
    @Column(name = "entidad_cuenta")
    private Integer entidadCuenta;    

    @NotNull
    @Column(name = "oficina_cuenta")
    private Integer oficinaCuenta;

    @NotNull
    @Column(name = "dc_cuenta")
    private Integer dcCuenta;
    
    @NotNull
    @Column(name = "numero_cuenta")
    private Integer numeroCuenta;
    
    public Transferencia() {
    }

    public Transferencia(int numCuenta, String paisCuenta, Integer entidadCuenta, Integer oficinaCuenta, Integer dcCuenta, Integer numeroCuenta) {
        this.numCuenta = numCuenta;
        this.paisCuenta = paisCuenta;
        this.entidadCuenta = entidadCuenta;
        this.oficinaCuenta = oficinaCuenta;
        this.dcCuenta = dcCuenta;
        this.numeroCuenta = numeroCuenta;
    }

    public Transferencia(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    @Override
    public void editarMetodoPago(MetodoPago metodoPago) {
        this.numCuenta=((Transferencia)metodoPago).numCuenta;
        this.paisCuenta = ((Transferencia)metodoPago).paisCuenta;
        this.entidadCuenta = ((Transferencia)metodoPago).entidadCuenta;
        this.oficinaCuenta = ((Transferencia)metodoPago).oficinaCuenta;
        this.dcCuenta = ((Transferencia)metodoPago).dcCuenta;
        this.numeroCuenta = ((Transferencia)metodoPago).numeroCuenta;
    }    

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getPaisCuenta() {
        return paisCuenta;
    }

    public void setPaisCuenta(String paisCuenta) {
        this.paisCuenta = paisCuenta;
    }

    public Integer getEntidadCuenta() {
        return entidadCuenta;
    }

    public void setEntidadCuenta(Integer entidadCuenta) {
        this.entidadCuenta = entidadCuenta;
    }

    public Integer getOficinaCuenta() {
        return oficinaCuenta;
    }

    public void setOficinaCuenta(Integer oficinaCuenta) {
        this.oficinaCuenta = oficinaCuenta;
    }

    public Integer getDcCuenta() {
        return dcCuenta;
    }

    public void setDcCuenta(Integer dcCuenta) {
        this.dcCuenta = dcCuenta;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.numCuenta;
        hash = 89 * hash + Objects.hashCode(this.paisCuenta);
        hash = 89 * hash + Objects.hashCode(this.entidadCuenta);
        hash = 89 * hash + Objects.hashCode(this.oficinaCuenta);
        hash = 89 * hash + Objects.hashCode(this.dcCuenta);
        hash = 89 * hash + Objects.hashCode(this.numeroCuenta);
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
        if (!Objects.equals(this.paisCuenta, other.paisCuenta)) {
            return false;
        }
        if (!Objects.equals(this.entidadCuenta, other.entidadCuenta)) {
            return false;
        }
        if (!Objects.equals(this.oficinaCuenta, other.oficinaCuenta)) {
            return false;
        }
        if (!Objects.equals(this.dcCuenta, other.dcCuenta)) {
            return false;
        }
        if (!Objects.equals(this.numeroCuenta, other.numeroCuenta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "numCuenta=" + numCuenta + ", paisCuenta=" + paisCuenta + ", entidadCuenta=" + entidadCuenta + ", oficinaCuenta=" + oficinaCuenta + ", dcCuenta=" + dcCuenta + ", numeroCuenta=" + numeroCuenta + '}';
    }

    @Override
    public String getDatos() {
        return String.valueOf(this.numCuenta);
    }

    
}
