/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author MATRIX
 */
public class ModelProductos {
    import sax.DBConnection;
    private DBConnection conection = new DBConnection(3306,"localhost", "agenda", "root", "");
    
    private int id_producto;
    private String producto;
    private String descripcion;
    private String precio_compra;
    private String precio_venta;
    private String existencias;

    public int getIdContacto() {
        return id_producto;
    }

    public void setIdContacto(int idContacto) {
        this.id_producto = id_producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto= producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(String email) {
        this.precio_compra = precio_compra;
    }
    public String getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(String email) {
        this.precio_venta = precio_venta;
    }
    public String getExistencias() {
        return existencias;
    }

    public void setExistencias(String email) {
        this.existencias = existencias;
    }
    public void moveNext(){
        conection.moveNext();
        setValues();
    }
    
    public void movePrevious(){
        conection.movePrevious();
        setValues();
    }
    
    public void moveFirst(){
        conection.moveFirst();
        setValues();
    }
    
    public void moveLast(){
        conection.moveLast();
        setValues();
    }
    
    public void initValues(){
        conection.executeQuery("SELECT id_producto, producto, descripcion,precio_compra,precio_venta,existencias FROM productos;");
        conection.moveNext();
        setValues();
    }
    public void setValues(){
        this.id_producto = conection.getInteger("id_producto");
        this.producto = conection.getString("producto");
        this.descripcion = conection.getString("descripcion");
        this.precio_compra = conection.getString("precio_compra");
        this.precio_venta = conection.getString("precio_venta");
        this.existencias = conection.getString("existencias");
                
    }
}
    

