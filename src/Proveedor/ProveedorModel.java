/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proveedor;

/**
 *
 * @author MK
 */
public class ProveedorModel {
    private String nit;
    private String proveedor;
    private String telef_empre;
    private String contacto;
    private String telef_contacto;
    private String direccion;

   public ProveedorModel() {
        this.nit = "";
        this.proveedor = "";
        this.telef_empre = "";
        this.contacto = "";
        this.telef_contacto = "";
        this.direccion = "";
    }
    public ProveedorModel(String nit, String proveedor, String telef_empre, String contacto, String telef_contacto, String direccion) {
        this.nit = nit;
        this.proveedor = proveedor;
        this.telef_empre = telef_empre;
        this.contacto = contacto;
        this.telef_contacto = telef_contacto;
        this.direccion = direccion;
    }

    public String getNit() {return nit;}
    public void setNit(String nit) {this.nit = nit;}

    public String getProveedor() {return proveedor;}
    public void setProveedor(String proveedor) {this.proveedor = proveedor;}

    public String getTelef_empre() {return telef_empre;}
    public void setTelef_empre(String telef_empre) {this.telef_empre = telef_empre;}

    public String getContacto() {return contacto;}
    public void setContacto(String contacto) {this.contacto = contacto;}

    public String getTelef_contacto() {return telef_contacto;}
    public void setTelef_contacto(String telef_contacto) {this.telef_contacto = telef_contacto;}

    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    
}