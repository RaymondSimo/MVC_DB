
package models;

import javax.swing.table.DefaultTableModel;
import sax.DBConnection;

/**
 *
 * @author Raymond SIMOLY
 */
public class ModelCompras {  private DBConnection conection = new DBConnection(3306,"localhost", "acme_shop", "root", "1234");

  
  private String vendedor;
  private String fecha;
  private String cliente;
  private String rfc;
  private int id_cliente;
  private int id_usuario;
  private int id_producto;
  private int precio_producto;
  private int cantidad_producto;
  private int subtotal;
  private int iva;
  private int total;
  private String nombre_producto;
  private int TotPorPrecio;
  private int id_compra;
  
  
  public  DefaultTableModel tableModel = new DefaultTableModel(new String [] {"id_compra", "producto","cantidad","total*precio"}, 0);

    /**
     * @return the vendedor
     */
    public String getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * @return the id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the id_producto
     */
    public int getId_producto() {
        return id_producto;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * @return the precio_producto
     */
    public int getPrecio_producto() {
        return precio_producto;
    }

    /**
     * @param precio_producto the precio_producto to set
     */
    public void setPrecio_producto(int precio_producto) {
        this.precio_producto = precio_producto;
    }

    /**
     * @return the cantidad_producto
     */
    public int getCantidad_producto() {
        return cantidad_producto;
    }

    /**
     * @param cantidad_producto the cantidad_producto to set
     */
    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    /**
     * @return the subtotal
     */
    public int getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the iva
     */
    public int getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(int iva) {
        this.iva = iva;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the nombre_producto
     */
    public String getNombre_producto() {
        return nombre_producto;
    }

    /**
     * @param nombre_producto the nombre_producto to set
     */
    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    /**
     * @return the TotPorPrecio
     */
    public int getTotPorPrecio() {
        return TotPorPrecio;
    }

    /**
     * @param TotPorPrecio the TotPorPrecio to set
     */
    public void setTotPorPrecio(int TotPorPrecio) {
        this.TotPorPrecio = TotPorPrecio;
    }

    /**
     * @return the id_compra
     */
    public int getId_compra() {
        return id_compra;
    }

    /**
     * @param id_compra the id_compra to set
     */
    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }
  
  
}
