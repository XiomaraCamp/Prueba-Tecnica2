/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jc997
 */
public class Conexion {
    
    Connection conexion = null;

    String base = "prueba"; //Nombre de la base de datos
    String url = "jdbc:mysql://localhost:3306/" + base; //Direccion, puerto y nombre de la Base de Datos
    String user = "root"; //Usuario de Acceso a MySQL
    String password = "12345678"; //Password del usuario

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
         Connection   conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "12345678");
           System.out.println("Conexion Exitosa");
            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
