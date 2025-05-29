/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;


import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * @author MK
 */

public class Login_DAO {
    public boolean Validacion(Login_Model login) {
        boolean acceso = false;

        try {
            Conexion conexion = new Conexion();
            Connection conn = conexion.getConnection();

            String sql = "SELECT * FROM usuario WHERE usuario = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, login.getUsuario());
            stmt.setString(2, login.getPassword());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                acceso = true;
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error al validar usuario: " + e.getMessage());
        }

        return acceso;
    }

}
