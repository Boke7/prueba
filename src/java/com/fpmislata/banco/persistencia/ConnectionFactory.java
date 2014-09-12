/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpmislata.banco.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author alumno
 */
public interface ConnectionFactory {
    public Connection getConnection();
    public void close(Connection connection);
}
