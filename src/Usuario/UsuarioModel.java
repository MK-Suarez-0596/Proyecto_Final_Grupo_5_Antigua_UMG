/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

/**
 *
 * @author tonit
 */
public class UsuarioModel {
    
    private int id;
    private String Usuario;
    private String password;
    private String rol;
    private String direccion;
    private String email;

    public UsuarioModel() {
        this.id = 0;
        this.Usuario = "";
        this.password = "";
        this.rol = "";
        this.direccion = "";
        this.email = "";

    }
    
    public UsuarioModel(int id, String Usuario, String password, String rol, String direccion, String email) {
        this.id = id;
        this.Usuario = Usuario;
        this.password = password;
        this.rol = rol;
        this.direccion = direccion;
        this.email = email;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
