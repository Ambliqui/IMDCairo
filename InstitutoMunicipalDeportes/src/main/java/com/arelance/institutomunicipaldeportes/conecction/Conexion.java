/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.institutomunicipaldeportes.conecction;

import java.sql.SQLException;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;

/**
 *
 * @author Mefisto
 */
public class Conexion {

    private Connection conn;
    
    public Connection crearConexion() {
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/Sakila");
            try {
                conn = ds.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            return conn;
        } catch (NamingException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error de conexion");
            ex.getStackTrace();
            return null;
        }
    }
    
}
