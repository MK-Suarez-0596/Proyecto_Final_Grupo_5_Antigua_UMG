/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Producto;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author tonit
 * @author MK
 */
public class ProductoController {
    
    public static boolean crear(ProductoModel p) {
    String error = ProductoDAO.validarCamposObligatorios(p);
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(null, error, "Error de validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return ProductoDAO.create(p);
    }

    public static boolean actualizar(ProductoModel p) {
    String error = ProductoDAO.validarCamposObligatorios(p);
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(null, error, "Error de validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return ProductoDAO.update(p);
    }

    public static boolean eliminar(int id) {
        return ProductoDAO.delete(id);
    }

    public static ProductoModel buscar(int id) {
        return ProductoDAO.search(id);
    }

    public static List<ProductoModel> obtenerTodos() {
        return ProductoDAO.getAll();
    }

    public static List<String> obtenerCargos() {
        return ProductoDAO.getCategorias();
    }

}
