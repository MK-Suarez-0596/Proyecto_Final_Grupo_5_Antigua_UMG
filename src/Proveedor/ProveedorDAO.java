/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proveedor;

/**
 *
 * @author MK
 */

import java.sql.*;
import java.util.*;
import Conexion.Conexion;
import java.sql.PreparedStatement;

public class ProveedorDAO {
    public static boolean create(ProveedorModel p) {
        String sql = "INSERT INTO proveedor (nit, proveedor, telefono_empresa, contacto, telefono_contacto, direccion) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = new Conexion().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNit());
            ps.setString(2, p.getProveedor());
            ps.setString(3, p.getTelef_empre());
            ps.setString(4, p.getContacto());
            ps.setString(5, p.getTelef_contacto());
            ps.setString(6, p.getDireccion());
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean update(ProveedorModel p) {
        String sql = "UPDATE proveedor SET proveedor=?, telefono_empresa=?, contacto=?, telefono_contacto=?, direccion=? WHERE nit=?";
        try (Connection con = new Conexion().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getProveedor());
            ps.setString(2, p.getTelef_empre());
            ps.setString(3, p.getContacto());
            ps.setString(4, p.getTelef_contacto());
            ps.setString(5, p.getDireccion());
            ps.setString(6, p.getNit());

            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean delete(String nit) {
        String sql = "DELETE FROM proveedor WHERE nit=?";
        try (Connection con = new Conexion().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nit);
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static ProveedorModel search(String nit) {
        String sql = "SELECT * FROM proveedor WHERE nit=?";
        try (Connection con = new Conexion().getConnection(); 
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nit);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ProveedorModel(
                        rs.getString("nit"),
                        rs.getString("proveedor"),
                        rs.getString("telefono_empresa"),
                        rs.getString("contacto"),
                        rs.getString("telefono_contacto"),
                        rs.getString("direccion")

                );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static List<ProveedorModel> getAll() {
        List<ProveedorModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM proveedor ORDER BY nit";
        
        try (Connection conn = new Conexion().getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                ProveedorModel p = new ProveedorModel();
                p.setNit(rs.getString("nit"));
                p.setProveedor(rs.getString("proveedor"));
                p.setTelef_empre(rs.getString("telefono_empresa"));
                p.setContacto(rs.getString("contacto"));
                p.setTelef_contacto(rs.getString("telefono_contacto"));
                p.setDireccion(rs.getString("direccion"));
                lista.add(p);
            }
        } catch (SQLException ex) {ex.printStackTrace();}
        return lista;
    }
    
    
public static String validarCamposObligatorios(ProveedorModel p) {
    if (p.getNit().isBlank()) return "El NIT no puede estar vacío.";
    if (p.getProveedor().isBlank()) return "El Proveedor no puede estar vacío.";
    if (p.getTelef_empre().isBlank()) return "El Telefono de la Empresa no puede estar vacío.";
    if (p.getContacto().isBlank()) return "El Contacto no puede estar vacío.";
    if (p.getTelef_contacto()== null) return "El Telefono del Contacto no puede estar vacía.";
    if (p.getDireccion().isBlank()) return "La Direccion no puede estar vacía.";
    
   if (nitExiste(p.getNit())) return "El NIT ya está registrado.";

    return "";
}

public static boolean nitExiste(String nit) {
    String sql = "SELECT 1 FROM proveedor WHERE nit = ?";
    try (Connection con = new Conexion().getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, nit);
        ResultSet rs = ps.executeQuery();
        return rs.next(); // Si encontró, retorna true
    } catch (Exception ex) {
        ex.printStackTrace();
        return true; // prevenir insert si falla
    }
}
   
}
