/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Producto;

/**
 *
 * @author tonit
 * @author MK
 */
public class ProductoModel {
    
    private int id;
    private String producto;
    private String categoria;
    private double precio;
    private boolean estado;
    private int stock;

    
    public ProductoModel() {
        this.id = 0;
        this.producto = "";
        this.categoria = "";
        this.precio = 0.00;
        this.estado = false;
        this.stock = 0;
    }  
    
    public ProductoModel(int id, String producto, String categoria, double precio, boolean estado, int stock) {
        this.id = id;
        this.producto = producto;
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
        this.stock = stock;
    }  
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getProducto() {return producto;}
    public void setProducto(String nombre) {this.producto = nombre;}

    public String getCategoria() {return categoria;}
    public void setCategoria(String categoria) {this.categoria = categoria;}

    public double getPrecio() {return precio;}
    public void setPrecio(double precio) {this.precio = precio;}

    public boolean isEstado() {return estado;}
    public void setEstado(boolean estado) {this.estado = estado;}

    public int getStock() {return stock;}
    public void setStock(int stock) {this.stock = stock;}
    
        
    
}
