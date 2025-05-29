/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;
import java.util.List;

/**
 *
 * @author tonit
 */
public class ClienteController {
    

    public static boolean add(ClienteModel cliente) {
        ClienteDAO dao = new ClienteDAO();
        return dao.add(cliente);
    }

    // Método para editar un cliente
    public static boolean edit(ClienteModel cliente) {
        ClienteDAO dao = new ClienteDAO();
        return dao.edit(cliente);
    }

    // Método para eliminar un cliente por ID
    public static boolean errease(int id) {
        ClienteDAO dao = new ClienteDAO();
        return dao.errease(id);
    }

    // Método para obtener todos los clientes
    public static List<ClienteModel> getAll() {
        ClienteDAO dao = new ClienteDAO();
        return dao.getAll();
    }

    // Método para buscar un cliente por ID
    public static ClienteModel search(int id) {
        ClienteDAO dao = new ClienteDAO();
        return dao.search(id);
    }
}
