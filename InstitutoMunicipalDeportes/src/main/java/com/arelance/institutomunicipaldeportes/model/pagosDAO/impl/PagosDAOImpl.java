/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.institutomunicipaldeportes.model.pagosDAO.impl;

import com.arelance.institutomunicipaldeportes.conecction.Conexion;
import com.arelance.institutomunicipaldeportes.model.beans.MetodoPago;
import com.arelance.institutomunicipaldeportes.model.beans.Usuario;
import com.arelance.institutomunicipaldeportes.model.pagosDAO.PagosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mefisto
 */
public class PagosDAOImpl implements PagosDAO {

    Conexion conexion = new Conexion();

    @Override
    public List<MetodoPago> metodosPagoUsuario(Usuario usuario) {

        String SQL = "SELECT id_usuario, nombre_usuario, nombre_forma_pago, id_forma_pago_tarjeta AS codigo_pago"
                + " FROM usuario"
                + " INNER JOIN"
                    + " (SELECT id_usuario_tarjeta, id_forma_pago_tarjeta, nombre_forma_pago"
                    + " FROM tarjeta"
                        + " INNER JOIN forma_pago"
                        + " ON id_forma_pago_tarjeta = id_forma_pago"
                    + " WHERE id_usuario_tarjeta = ?"
                + " UNION"
                    + " SELECT id_usuario_transferencia, id_forma_pago_transferencia, nombre_forma_pago"
                    + " FROM transferencia"
                        + " INNER JOIN forma_pago"
                        + " ON id_forma_pago_transferencia = id_forma_pago"
                    + " WHERE id_usuario_transferencia = ?)"
                + " AS pagos"
                + " ON id_usuario = id_usuario_tarjeta;";
        List<MetodoPago> metodoPagos = new ArrayList<>();

        try (Connection conn = conexion.crearConexion()) {
            PreparedStatement stmt = conn.prepareStatement(SQL);
            stmt.setInt(1, usuario.getId());
            stmt.setInt(2, usuario.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                metodoPagos.add(new MetodoPago(
                        rs.getInt(4),
                        rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PagosDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return metodoPagos;
    }

}
