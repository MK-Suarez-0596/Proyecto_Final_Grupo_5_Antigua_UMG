/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

/**
 *
 * @author MK
 */

import java.util.List;
import javax.swing.JOptionPane;


public class UsuarioController {
    
    public static boolean crear(UsuarioModel e) {
    String error = UsuarioDAO.validarCamposObligatorios(e);
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(null, error, "Error de validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return UsuarioDAO.create(e);
    }

    public static boolean actualizar(UsuarioModel e) {
    String error = UsuarioDAO.validarCamposObligatorios(e);
        if (!error.isEmpty()) {
            JOptionPane.showMessageDialog(null, error, "Error de validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return UsuarioDAO.update(e);
    }

    public static boolean eliminar(int id) {
        return UsuarioDAO.delete(id);
    }

    public static UsuarioModel buscar(int id) {
        return UsuarioDAO.search(id);
    }

    public static List<UsuarioModel> obtenerTodos() {
        return UsuarioDAO.getAll();
    }

    public static List<String> obtenerRoles() {
        return UsuarioDAO.getRoles();
    }
}
