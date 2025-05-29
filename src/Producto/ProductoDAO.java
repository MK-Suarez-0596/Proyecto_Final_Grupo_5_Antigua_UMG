/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Producto;

import java.sql.*;
import java.util.*;
import Conexion.Conexion;
import java.sql.PreparedStatement;

/**
 *
 * @author tonit
 * @author MK
 */
public class ProductoDAO {
    
    public static boolean create(ProductoModel p){
        String sql = "INSERT INTO producto (producto, categoria, precio, estado, stock) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = new Conexion().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getProducto());
            ps.setString(2, p.getCategoria());
            ps.setDouble(3, p.getPrecio());
            ps.setBoolean(4, p.isEstado());
            ps.setInt(5, p.getStock());
            return ps.executeUpdate()>0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static boolean update(ProductoModel p) {
        String sql = "UPDATE producto SET producto=?, categoria=?, precio=?, estado=?, stock=? WHERE id=?";
        try (Connection con = new Conexion().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getProducto());
            ps.setString(2, p.getCategoria());
            ps.setDouble(3, p.getPrecio());
            ps.setBoolean(4, p.isEstado());
            ps.setInt(5, p.getStock());
            
            ps.setInt(6, p.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
     public static boolean delete(int id) {
        String sql = "DELETE FROM producto WHERE id=?";
        try (Connection con = new Conexion().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }   

    public static ProductoModel search(int id) {
        String sql = "SELECT * FROM producto WHERE id=?";
        try (Connection con = new Conexion().getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ProductoModel(
                        rs.getInt("id"),
                        rs.getString("producto"),
                        rs.getString("categoria"),
                        rs.getDouble("precio"),
                        rs.getBoolean("estado"),
                        rs.getInt("stock")
                );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static List<ProductoModel> getAll() {
        List<ProductoModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto ORDER BY id";
        
        try (Connection conn = new Conexion().getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                ProductoModel p = new ProductoModel();
                p.setId(rs.getInt("id"));
                p.setProducto(rs.getString("producto"));
                p.setCategoria(rs.getString("categoria"));
                p.setPrecio(rs.getDouble("precio"));
                p.setEstado(rs.getBoolean("estado"));
                p.setStock(rs.getInt("stock"));
                lista.add(p);
            }
        } catch (SQLException ex) {ex.printStackTrace();}
        return lista;
    }

public static String validarCamposObligatorios(ProductoModel p) {
    if (p.getProducto().isBlank()) return "El Producto no puede estar vacío.";
    if (p.getCategoria().isBlank()) return "La Categoria no puede estar vacía.";
    
    if (productoExiste(p.getProducto())) return "El Producto ya está registrado.";
    return ""; // todo OK
}

public static boolean productoExiste(String producto) {
    String sql = "SELECT 1 FROM producto WHERE producto = ?";
    try (Connection con = new Conexion().getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, producto);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    } catch (Exception ex) {
        ex.printStackTrace();
        return true;
    }
}
   
public static List<String> getCategorias() {
    List<String> lista = new ArrayList<>();
    String sql = "SELECT DISTINCT categoria FROM producto";

    try (Connection con = new Conexion().getConnection(); 
        PreparedStatement ps = con.prepareStatement(sql); 
        ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            lista.add(rs.getString("categoria"));
        }

    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return lista;
}
    
}
