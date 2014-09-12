/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpmislata.banco.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class ConnectionFactoryImplJDBC implements ConnectionFactory{

    @Override
    public Connection getConnection() {
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No esta instalado el Driver JDBC");
            e.printStackTrace();
        }

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1/banco", "root", "root");

        } catch (SQLException e) {
            System.out.println("Conexión fallida.");
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("Conexión realizada");
        } else {
            System.out.println("Fallo al realizar la conexión");
        }
        
        return connection;
    }

    @Override
    public void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactoryImplJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
