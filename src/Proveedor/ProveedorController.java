/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proveedor;


import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MK
 */
public class ProveedorController {
  
    public static boolean crear(ProveedorModel p) {
    String error = ProveedorDAO.validarCamposObligatorios(p);
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(null, error, "Error de validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return ProveedorDAO.create(p);
    }

    public static boolean actualizar(ProveedorModel p) {
    String error = ProveedorDAO.validarCamposObligatorios(p);
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(null, error, "Error de validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return ProveedorDAO.update(p);
    }

    public static boolean eliminar(String nit) {
        return ProveedorDAO.delete(nit);
    }

    public static ProveedorModel buscar(String nit) {
        return ProveedorDAO.search(nit);
    }

    public static List<ProveedorModel> obtenerTodos() {
        return ProveedorDAO.getAll();
    }

    
}
