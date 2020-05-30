package net.skillfactory.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    private static Connection con = null;

    public static Connection obtain(){

        if(con == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "root", "");
                System.out.println("Se ha conectado correctamente");
            }catch (SQLException e){
                e.printStackTrace();
                System.out.println("No se ha podido conectar");
            }catch (ClassNotFoundException e){
                e.printStackTrace();
                System.out.println("Dependencia no encontrada");
            }
        }

        return con;
    }

    public static void closeConnection(){

        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
