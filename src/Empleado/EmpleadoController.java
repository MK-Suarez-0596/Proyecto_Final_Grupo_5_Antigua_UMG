/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleado;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author tonit
 */
public class EmpleadoController {

    public static boolean crear(EmpleadoModel e) {
    String error = EmpleadoDAO.validarCamposObligatorios(e);
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(null, error, "Error de validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return EmpleadoDAO.create(e);
    }

    public static boolean actualizar(EmpleadoModel e) {
    String error = EmpleadoDAO.validarCamposObligatorios(e);
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(null, error, "Error de validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return EmpleadoDAO.update(e);
    }

    public static boolean eliminar(int id) {
        return EmpleadoDAO.delete(id);
    }

    public static EmpleadoModel buscar(int id) {
        return EmpleadoDAO.search(id);
    }

    public static List<EmpleadoModel> obtenerTodos() {
        return EmpleadoDAO.getAll();
    }

    public static List<String> obtenerCargos() {
        return EmpleadoDAO.getCargos();
    }
}
