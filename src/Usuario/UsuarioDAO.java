/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

/**
 *
 * @author tonit
 * @author MK
 * 
 */

import java.sql.*;
import java.util.*;
import Conexion.Conexion;
import java.sql.PreparedStatement;

public class UsuarioDAO {

public static boolean create(UsuarioModel e) {
        String sql = "INSERT INTO usuario (usuario, password, rol, direccion, email) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = new Conexion().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, e.getUsuario());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getRol());
            ps.setString(4, e.getDireccion());
            ps.setString(5, e.getEmail());
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean update(UsuarioModel e) {
        String sql = "UPDATE usuario SET usuario=?, password=?, rol=?, direccion=?, email=? WHERE id=?";
        try (Connection con = new Conexion().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, e.getUsuario());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getRol());
            ps.setString(4, e.getDireccion());
            ps.setString(5, e.getEmail());
            ps.setInt(6, e.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean delete(int id) {
        String sql = "DELETE FROM usuario WHERE id=?";
        try (Connection con = new Conexion().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static UsuarioModel search(int id) {
        String sql = "SELECT * FROM usuario WHERE id=?";
        try (Connection con = new Conexion().getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new UsuarioModel(
                        rs.getInt("id"),
                        rs.getString("usuario"),
                        rs.getString("password"),
                        rs.getString("rol"),
                        rs.getString("direccion"),
                        rs.getString("email")
                );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static List<UsuarioModel> getAll() {
        List<UsuarioModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario ORDER BY id";
        
        try (Connection conn = new Conexion().getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                UsuarioModel e = new UsuarioModel();
                e.setId(rs.getInt("id"));
                e.setUsuario(rs.getString("usuario"));
                e.setPassword(rs.getString("password"));
                e.setRol(rs.getString("rol"));
                e.setDireccion(rs.getString("direccion"));
                e.setEmail(rs.getString("email"));
                lista.add(e);
            }
        } catch (SQLException ex) {ex.printStackTrace();}
        return lista;
    }
    
    
public static String validarCamposObligatorios(UsuarioModel e) {
    if (e.getUsuario().isBlank()) return "El Usuario no puede estar vacío.";
    if (e.getPassword().isBlank()) return "La Contraseña no puede estar vacía.";
    if (e.getRol().isBlank()) return "El Rol no puede estar vacío.";
    if (e.getDireccion().isBlank()) return "La Direccion no puede estar vacía.";
    if (e.getEmail().isBlank()) return "El email no puede estar vacío.";
    
    if (emailExiste(e.getEmail())) return "El email ya está registrado.";
    if (usuarioExiste(e.getUsuario())) return "El Usuario ya está registrado.";

    return ""; // todo OK
}

public static boolean emailExiste(String email) {
    String sql = "SELECT 1 FROM usuario WHERE email = ?";
    try (Connection con = new Conexion().getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        return rs.next(); // Si encontró, retorna true
    } catch (Exception ex) {
        ex.printStackTrace();
        return true; // prevenir insert si falla
    }
}

public static boolean usuarioExiste(String usuario) {
    String sql = "SELECT 1 FROM usuario WHERE usuario = ?";
    try (Connection con = new Conexion().getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, usuario);
        ResultSet rs = ps.executeQuery();
        return rs.next(); // Si encontró, retorna true
    } catch (Exception ex) {
        ex.printStackTrace();
        return true; // prevenir insert si falla
    }
}

    
    
    public static List<String> getRoles() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT DISTINCT rol FROM usuario";
        
        try (Connection con = new Conexion().getConnection(); 
            PreparedStatement ps = con.prepareStatement(sql); 
            ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                lista.add(rs.getString("rol"));
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
}
