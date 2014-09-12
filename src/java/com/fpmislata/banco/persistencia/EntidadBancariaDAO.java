package com.fpmislata.banco.persistencia;

import com.fpmislata.banco.dominio.EntidadBancaria;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface EntidadBancariaDAO{

    ConnectionFactory connection = new ConnectionFactoryImplJDBC();
    
    public EntidadBancaria get(int idEntidadBancaria) throws SQLException;
    public EntidadBancaria insert(EntidadBancaria entidadBancaria);
    public void delete(int idEntidadBancaria);
    public EntidadBancaria update(EntidadBancaria entidadBancaria);
    public List<EntidadBancaria> findAll();  
}
