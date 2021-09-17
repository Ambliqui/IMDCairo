/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.imd.model.actividadesDAO.impl;

import com.arelance.imd.domain.Actividad;
import com.arelance.imd.domain.FormaPago;
import com.arelance.imd.domain.Usuario;
import com.arelance.imd.model.actividadesDAO.ActividadDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mefisto
 */
@Stateless
public class ActividadDAOImpl implements ActividadDAO {

    @PersistenceContext(unitName = "IMDDB")
    EntityManager em;

    @Override
    public List<Actividad> findAll() {
        return em.createNamedQuery("Actividad.findAll").getResultList();
    }

    @Override
    public Actividad searchActivity(Actividad actividad) {
        return em.find(Actividad.class, actividad.getIdActividad());
    }

    @Override
    public List<Actividad> inscripcionesUsuario(Usuario usuario) {

//        String SQL = "SELECT nombre_usuario, nombre_actividad, nombre_forma_pago "
//                    + "FROM Forma_Pago "
//                    + "INNER JOIN (Usuario "
//                    + "INNER JOIN (Actividad "
//                    + "INNER JOIN Inscripcion "
//                    + "ON Id_Actividad = id_actividad_inscripcion) "
//                    + "ON Id_Usuario = Id_usuario_inscripcion) "
//                    + "ON Id_Forma_Pago = forma_pago_inscripcion "
//                    + "WHERE id_usuario = ?;";
//
        List<Actividad> actividades = new ArrayList<>();
//
        return actividades;
    }

    @Override
    public boolean inscripcion(Usuario usuario, Actividad actividad, FormaPago metodoPago) {

//        String SQL = "INSERT INTO actividades_cairo.inscripcion "
//                + "(id_usuario_inscripcion, id_actividad_inscripcion, forma_pago_inscripcion)"
//                + " VALUES (?, ?, ?);";
//        
//        try (Connection conn = conexion.crearConexion()) {
//            PreparedStatement stmt = conn.prepareStatement(SQL);
//            stmt.setInt(1, usuario.getId());
//            stmt.setInt(2, actividad.getId());
//            stmt.setInt(3, metodoPago.getIdMetodo());
//            stmt.executeUpdate();
////            ResultSet rs = stmt.executeQuery();
////            while (rs.next()) {
////                actividad.setId(rs.getInt(1));
////                actividad.setNombre(rs.getString(2));
////                actividad.setPrecio(rs.getDouble(3));
////                actividad.setLugar(rs.getString(4));
////                actividad.setEntrenador(rs.getInt(5));
////                actividad.setDescripcion(rs.getString(6));
////                actividad.setCalendario(rs.getString(7));
////                actividad.setHoraInicio(rs.getString(8));
////                actividad.setHoraFin(rs.getString(9));
////            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ActividadDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return true;
    }

    @Override
    public Actividad comprobarInscripcion(Usuario usuario, Actividad actividad) {

//        String SQL = "SELECT id_usuario_inscripcion, id_actividad_inscripcion"
//                    + " FROM inscripcion"
//                    + " WHERE id_usuario_inscripcion = ?"
//                    + " AND id_actividad_inscripcion = ?;";
//        
//        try (Connection conn = conexion.crearConexion()) {
//            PreparedStatement stmt = conn.prepareStatement(SQL);
//            stmt.setInt(1, usuario.getId());
//            stmt.setInt(2, actividad.getId());
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                actividad.setId(rs.getInt(1));
//                actividad.setNombre(rs.getString(2));
//                actividad.setPrecio(rs.getDouble(3));
//                actividad.setLugar(rs.getString(4));
//                actividad.setEntrenador(rs.getInt(5));
//                actividad.setDescripcion(rs.getString(6));
//                actividad.setCalendario(rs.getString(7));
//                actividad.setHoraInicio(rs.getString(8));
//                actividad.setHoraFin(rs.getString(9));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ActividadDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
        return actividad;
    }

}
