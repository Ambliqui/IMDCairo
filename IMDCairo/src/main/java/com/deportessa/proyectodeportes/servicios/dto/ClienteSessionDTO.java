/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deportessa.proyectodeportes.servicios.dto;

import java.util.Objects;

/**
 *
 * @author Mefisto
 */
public class ClienteSessionDTO {
    
    Integer idCliente;
    DatosPersonalesVO datosPersonalesVO;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.idCliente);
        hash = 37 * hash + Objects.hashCode(this.datosPersonalesVO);
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
        final ClienteSessionDTO other = (ClienteSessionDTO) obj;
        if (!Objects.equals(this.idCliente, other.idCliente)) {
            return false;
        }
        if (!Objects.equals(this.datosPersonalesVO, other.datosPersonalesVO)) {
            return false;
        }
        return true;
    }
    
    public ClienteSessionDTO(Integer idCliente, DatosPersonalesVO datosPersonalesVO) {
        this.idCliente = idCliente;
        this.datosPersonalesVO = datosPersonalesVO;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public DatosPersonalesVO getDatosPersonalesVO() {
        return datosPersonalesVO;
    }

    public void setDatosPersonalesVO(DatosPersonalesVO datosPersonalesVO) {
        this.datosPersonalesVO = datosPersonalesVO;
    }
    
}
