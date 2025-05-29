/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleado;


import java.sql.*;
import java.util.*;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.util.Date;
/**
 *
 * @author tonit
 * @author MK
 */
public class EmpleadoDAO {
public static boolean create(EmpleadoModel e) {
        String sql = "INSERT INTO empleado (nombre, apellido, puesto, telefono, direccion, estado, fecha_ingreso, salario, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = new Conexion().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setString(3, e.getCargo());
            ps.setString(4, e.getTelefono());
            ps.setString(5, e.getDireccion());
            ps.setBoolean(6, e.isEstado());
            ps.setDate(7, e.getFechaIngreso() != null ? new java.sql.Date(e.getFechaIngreso().getTime()) : null);
            ps.setDouble(8, e.getSalario());
            ps.setString(9, e.getEmail());
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean update(EmpleadoModel e) {
        String sql = "UPDATE empleado SET nombre=?, apellido=?, puesto=?, telefono=?, direccion=?, estado=?, fecha_ingreso=?, salario=?, email=? WHERE id=?";
        try (Connection con = new Conexion().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setString(3, e.getCargo());
            ps.setString(4, e.getTelefono());
            ps.setString(5, e.getDireccion());
            ps.setBoolean(6, e.isEstado());
            ps.setDate(7, e.getFechaIngreso() != null ? new java.sql.Date(e.getFechaIngreso().getTime()) : null);
            ps.setDouble(8, e.getSalario());
            ps.setString(9, e.getEmail());
            ps.setInt(10, e.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean delete(int id) {
        String sql = "DELETE FROM empleado WHERE id=?";
        try (Connection con = new Conexion().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static EmpleadoModel search(int id) {
        String sql = "SELECT * FROM empleado WHERE id=?";
        try (Connection con = new Conexion().getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new EmpleadoModel(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("puesto"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getBoolean("estado"),
                        rs.getDate("fecha_ingreso"),
                        rs.getDouble("salario"),
                        rs.getString("email")
                );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static List<EmpleadoModel> getAll() {
        List<EmpleadoModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleado ORDER BY id";
        
        try (Connection conn = new Conexion().getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                EmpleadoModel e = new EmpleadoModel();
                e.setId(rs.getInt("id")); // ID visible en la tabla
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setCargo(rs.getString("puesto")); // recuerda: en BD es "puesto"
                e.setTelefono(rs.getString("telefono"));
                e.setDireccion(rs.getString("direccion"));
                e.setEstado(rs.getBoolean("estado"));
                e.setFechaIngreso(rs.getDate("fecha_ingreso"));
                e.setSalario(rs.getDouble("salario"));
                e.setEmail(rs.getString("email"));
                lista.add(e);
            }
        } catch (SQLException ex) {ex.printStackTrace();}
        return lista;
    }
    
    
public static String validarCamposObligatorios(EmpleadoModel e) {
    if (e.getNombre().isBlank()) return "El nombre no puede estar vacío.";
    if (e.getApellido().isBlank()) return "El apellido no puede estar vacío.";
    if (e.getCargo().isBlank()) return "El puesto no puede estar vacío.";
    if (e.getTelefono().isBlank()) return "El teléfono no puede estar vacío.";
    if (e.getFechaIngreso() == null) return "La fecha de ingreso no puede estar vacía.";
    if (e.getEmail().isBlank()) return "El email no puede estar vacío.";

    // Validación de unicidad para email
    if (emailExiste(e.getEmail())) return "El email ya está registrado.";

    return ""; // todo OK
}

public static boolean emailExiste(String email) {
    String sql = "SELECT 1 FROM empleado WHERE email = ?";
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

    
    
    public static List<String> getCargos() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT DISTINCT puesto FROM empleado";
        
        try (Connection con = new Conexion().getConnection(); 
            PreparedStatement ps = con.prepareStatement(sql); 
            ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                lista.add(rs.getString("puesto"));
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
