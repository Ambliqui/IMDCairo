/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.model.pagosDAO.impl;

import com.arelance.imd.domain.FormaPago;
import com.arelance.imd.domain.Usuario;
import com.arelance.imd.model.pagosDAO.PagosDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mefisto
 */
@Stateless
public class PagosDAOImpl implements PagosDAO {

//    Conexion conexion = new Conexion();
    @PersistenceContext(unitName = "IMDDB")
    EntityManager em;

    @Override
    public List<FormaPago> metodosPagoUsuario(Usuario usuario) {

        return null;

//        String SQL = "SELECT id_usuario, nombre_usuario, nombre_forma_pago, id_forma_pago_tarjeta AS codigo_pago"
//                + " FROM usuario"
//                + " INNER JOIN"
//                    + " (SELECT id_usuario_tarjeta, id_forma_pago_tarjeta, nombre_forma_pago"
//                    + " FROM tarjeta"
//                        + " INNER JOIN forma_pago"
//                        + " ON id_forma_pago_tarjeta = id_forma_pago"
//                    + " WHERE id_usuario_tarjeta = ?"
//                + " UNION"
//                    + " SELECT id_usuario_transferencia, id_forma_pago_transferencia, nombre_forma_pago"
//                    + " FROM transferencia"
//                        + " INNER JOIN forma_pago"
//                        + " ON id_forma_pago_transferencia = id_forma_pago"
//                    + " WHERE id_usuario_transferencia = ?)"
//                + " AS pagos"
//                + " ON id_usuario = id_usuario_tarjeta;";
//        List<FormaPago> metodoPagos = new ArrayList<>();
//
//        try (Connection conn = conexion.crearConexion()) {
//            PreparedStatement stmt = conn.prepareStatement(SQL);
//            stmt.setInt(1, usuario.getId());
//            stmt.setInt(2, usuario.getId());
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                metodoPagos.add(new FormaPago(
//                        rs.getInt(4),
//                        rs.getString(3)));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(PagosDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return metodoPagos;
    }

}
