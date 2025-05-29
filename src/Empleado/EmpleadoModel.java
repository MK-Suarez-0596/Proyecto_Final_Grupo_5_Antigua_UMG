/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleado;

import java.util.Date;

/**
 *
 * @author tonit
 * @author MK
 */
public class EmpleadoModel {
    private int id;
    private String nombre;
    private String apellido;
    private String cargo;
    private String telefono;
    private String direccion;
    private boolean estado;
    private Date fechaIngreso;
    private double salario;
    private String email;

    public EmpleadoModel() {
        this.id = 0;
        this.nombre = "";
        this.apellido = "";
        this.cargo = "";
        this.telefono = "";
        this.direccion = "";
        this.estado = false;
        this.fechaIngreso = null;
        this.salario = 0.00;
        this.email = "";
    }

    public EmpleadoModel(int id, String nombre, String apellido, String cargo, String telefono, String direccion, boolean estado, Date fechaIngreso, double salario, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
        this.fechaIngreso = fechaIngreso;
        this.salario = salario;
        this.email = email;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getCargo() {return cargo;}
    public void setCargo(String cargo) {this.cargo = cargo;}

    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}

    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}

    public boolean isEstado() {return estado;}
    public void setEstado(boolean estado) {this.estado = estado;}

    public Date getFechaIngreso() {return fechaIngreso;}
    public void setFechaIngreso(Date fechaIngreso) {this.fechaIngreso = fechaIngreso;}
    
    public double getSalario() {return salario;}
    public void setSalario(double salario) {this.salario = salario;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

}
