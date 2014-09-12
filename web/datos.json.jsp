<%@page import="com.fpmislata.banco.persistencia.EntidadBancariaDAOImplJDBC"%>
<%@page import="com.fpmislata.banco.dominio.EntidadBancaria"%>
<%@page import="com.fpmislata.banco.persistencia.EntidadBancariaDAO"%>
<%
    
    EntidadBancariaDAOImplJDBC entidadBancariaDAO = new EntidadBancariaDAOImplJDBC();
    
    EntidadBancaria entidadBancaria = entidadBancariaDAO.get(1);
    
    EntidadBancaria entidadBancaria2 = new EntidadBancaria();
    entidadBancaria2.setIdEntidadBancaria(2);
    entidadBancaria2.setCodigoEntidad("4500");
    entidadBancaria2.setNombre("La caixa");

    /*entidadBancariaDAO.insert(entidadBancaria2);*/
    entidadBancariaDAO.update(entidadBancaria2);
    %>

{
    "idEntidadBancaria":<%=entidadBancaria.getIdEntidadBancaria() %>,
    "nombre":<%=entidadBancaria.getNombre() %>,
    "codigoEntidad":<%=entidadBancaria.getCodigoEntidad() %>,
    "fechaResultado":<%=entidadBancaria.getFechaCreacion() %>,
}
