package com.isil.jdbc;

import java.sql.*;


public class MainApp {

    public static void main(String[] args)  throws Exception{

        String jdbcUrl = "jdbc:mysql://localhost:3306/DESA";

        //cargar el driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //crear la conexion
        Connection con = DriverManager.getConnection(jdbcUrl, "root", "root");

        //crear el statement
        Statement st= con.createStatement();

        //ejecutar la sentencia SQL
        //consulta
        //ResultSet rs = st.executeQuery("select * from Users");

        //Insertar
        //int filasAfectadas= st.executeUpdate("insert into Users values(1,'Juan','987456123','Vancuver')");

        //Actualizar
        //int filasAfectadas=st.executeUpdate("update Users set name ='Christian' where name='Cueva'");

        //Eliminar
        //int filasAfectadas=st.executeUpdate("delete from Users where idUser=4");

        //System.out.println("Filas Afectadas: "+filasAfectadas);

        //Crear prepared statment
        //prepared statement para mantenimiento
        PreparedStatement preparedStatement = con.prepareStatement("insert into Users values(?,?,?,?)");
preparedStatement.setInt(1, 8);
preparedStatement.setString(2,"Marta");
preparedStatement.setString(3,"985514581");
preparedStatement.setString(4,"Bogota");

int filasAfectadas= preparedStatement.executeUpdate();
        System.out.println("Filas afectadas: "+filasAfectadas);

    //prepared statement para consulta
    PreparedStatement preparedStatement2= con.prepareStatement("SELECT * FROM USERS WHERE idUser=?");
    preparedStatement2.setInt(1,5);

    ResultSet rs= preparedStatement2.executeQuery();
//procesar el resultado
        while(rs.next()){
            System.out.println(rs.getString("idUser") + " " +
                    rs.getString("name") +
                    " " + rs.getString("phone") +
                    " " + rs.getString("city"));
        }
    }
}



