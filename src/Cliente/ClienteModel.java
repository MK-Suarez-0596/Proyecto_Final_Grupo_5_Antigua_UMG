/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

/**
 *
 * @author tonit
 * @reviewer MK
 */
public class ClienteModel {
    private int id;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
    
    public ClienteModel() {
        this.id = 0;
        this.nombre = "";
        this.telefono = "";
        this.direccion = "";
        this.email = "";
    }

    public ClienteModel(int id, String nombre, String telefono, String direccion, String email) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    
    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    

 
    
}
