/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jc997
 */

public class RegistrosDAL {

    Connection conexion;

    public RegistrosDAL() throws ClassNotFoundException {
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }

    public List<Registros> listarRegistros() {

        PreparedStatement ps;
        ResultSet rs;

        List<Registros> lista = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("SELECT id, titulo, autor, año FROM registro");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String año = rs.getString ("año");

                Registros registro = new Registros(id,titulo, autor, año);
                lista.add(registro);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error al listar productos: " + e.toString());
            return null;
        }
    }

    public Registros mostarRegistro(int _id) {

        PreparedStatement ps;
        ResultSet rs;
        Registros registro = null;

        List<Registros> lista = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("SELECT id, titulo, autor, año FROM registro WHERE id=?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String año = rs.getString ("año");

                registro = new Registros(id,titulo, autor, año);
            }
            return registro;
        } catch (SQLException e) {
            System.out.println("Error al mostrar registro: " + e.toString());
            return null;
        }
    }

    public boolean insertar(Registros registro) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("INSERT INTO registro (titulo, autor, año) VALUES (?,?,?)");
            ps.setString(1, registro.getTitulo());
            ps.setString(2, registro.getAutor());
            ps.setString(3, registro.getAño());
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar registro : " + e.toString());
            return false;
        }
    }

   

     public boolean eliminar(int _id) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("DELETE FROM registro WHERE id=?");
            ps.setInt(1, _id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar registro: " + e.toString());
            return false;
        }
    }

    

}