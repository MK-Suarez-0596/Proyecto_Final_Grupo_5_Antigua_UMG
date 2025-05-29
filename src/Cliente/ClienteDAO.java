/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;
import Cliente.ClienteModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import Conexion.Conexion;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author tonit
 * @reviewer MK
 */
public class ClienteDAO {
    public List<ClienteModel> getAll() {
        List<ClienteModel> lista = new ArrayList<>();
        try (Connection conn = new Conexion().getConnection()) {
            String sql = "SELECT * FROM cliente";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ClienteModel c = new ClienteModel(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    rs.getString("email")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean add(ClienteModel c) {
        try (Connection conn = new Conexion().getConnection()) {
            String sql = "INSERT INTO cliente (nombre, telefono, direccion, email) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getTelefono());
            stmt.setString(3, c.getDireccion());
            stmt.setString(4, c.getEmail());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean edit(ClienteModel c) {
        try (Connection conn = new Conexion().getConnection()) {
            String sql = "UPDATE cliente SET nombre = ?, telefono = ?, direccion = ?, email = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getTelefono());
            stmt.setString(3, c.getDireccion());
            stmt.setString(4, c.getEmail());
            stmt.setInt(5, c.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean errease(int id) {
        try (Connection conn = new Conexion().getConnection()) {
            String sql = "DELETE FROM cliente WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
   public ClienteModel search(int id) {
    ClienteModel cliente = null;
    try (Connection conn = new Conexion().getConnection()) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            cliente = new ClienteModel(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("telefono"),
                rs.getString("direccion"),
                rs.getString("email")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return cliente;
}

    
}
