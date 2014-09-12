/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia;

import com.fpmislata.banco.dominio.EntidadBancaria;
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
 * @author alumno
 */
public class EntidadBancariaDAOImplJDBC implements EntidadBancariaDAO {

    ConnectionFactory connectionFactory = new ConnectionFactoryImplJDBC();

    @Override
    public EntidadBancaria get(int idEntidadBancaria) throws SQLException {
        Connection connection = connectionFactory.getConnection();

        EntidadBancaria entidadBancaria;

        String select = "SELECT * FROM entidadbancaria WHERE idEntidad=?";

        PreparedStatement preparedStatement = connection.prepareStatement(select);
        preparedStatement.setInt(1, idEntidadBancaria);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next() == true) {

            entidadBancaria = new EntidadBancaria();

            entidadBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidad"));
            entidadBancaria.setCodigoEntidad(resultSet.getString("codigoEntidad"));
            entidadBancaria.setNombre(resultSet.getString("nombre"));
            entidadBancaria.setFechaCreacion(resultSet.getDate("fechaCreacion"));
            if (resultSet.next() == true) {
                throw new RuntimeException("Hay otra fila igual");
            }
        } else {
            entidadBancaria = null;
        }

        connection.close();
        return entidadBancaria;

    }

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) {
        Connection connection = connectionFactory.getConnection();

        String insert = "INSERT INTO entidadbancaria (idEntidad, codigoEntidad, nombre) VALUES (?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setInt(1, entidadBancaria.getIdEntidadBancaria());
            preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
            preparedStatement.setString(3, entidadBancaria.getNombre());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EntidadBancariaDAOImplJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entidadBancaria;
    }

    @Override
    public void delete(int idEntidadBancaria) {
        Connection connection = connectionFactory.getConnection();

        String deleteSQL = "DELETE FROM entidadbancaria WHERE idEntidad=?";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(deleteSQL);

            preparedStatement.setInt(1, idEntidadBancaria);

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EntidadBancariaDAOImplJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidadBancaria) {
        Connection connection = connectionFactory.getConnection();

        String update = "UPDATE entidadbancaria SET nombre=? WHERE idEntidad = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setInt(2, entidadBancaria.getIdEntidadBancaria());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EntidadBancariaDAOImplJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entidadBancaria;
    }

    @Override
    public List<EntidadBancaria> findAll() {
        Connection connection = connectionFactory.getConnection();

        List<EntidadBancaria> entidadesBancarias = new ArrayList<>();
        String selectAllSQL = "SELECT * FROM entidadbancaria";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(selectAllSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next() == true) {

                EntidadBancaria entidadBancaria = new EntidadBancaria();

                entidadBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidad"));
                entidadBancaria.setCodigoEntidad(resultSet.getString("codigoEntidad"));
                entidadBancaria.setNombre(resultSet.getString("nombre"));
                entidadesBancarias.add(entidadBancaria);
            }

            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(EntidadBancariaDAOImplJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entidadesBancarias;
    }
}
