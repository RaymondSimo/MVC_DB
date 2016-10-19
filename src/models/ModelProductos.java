
package models;
import sax.DBConnection;
/**
 *
 * @author MATRIX
 */
public class ModelProductos {
    
    private DBConnection conection = new DBConnection(3306,"localhost", "acme_shop", "root", "1234");
    
    private int id_producto;
    private String producto;
    private String descripcion;
    private String precio_compra;
    private String precio_venta;
    private String existencias;
    
    public void moveNext(){
        getConection().moveNext();
        setValues();
    }
    
    public void movePrevious(){
        getConection().movePrevious();
        setValues();
    }
    
    public void moveFirst(){
        getConection().moveFirst();
        setValues();
    }
    
    public void moveLast(){
        getConection().moveLast();
        setValues();
    }
    
    public void initValues(){
        getConection().executeQuery("SELECT id_producto, producto, descripcion,precio_compra,precio_venta,existencias FROM productos;");
        getConection().moveNext();
        setValues();
    }
    public void setValues(){
        this.setId_producto(getConection().getInteger("id_producto"));
        this.setProducto(getConection().getString("producto"));
        this.setDescripcion(getConection().getString("descripcion"));
        this.setPrecio_compra(getConection().getString("precio_compra"));
        this.setPrecio_venta(getConection().getString("precio_venta"));
        this.setExistencias(getConection().getString("existencias"));
                
    }

    /**
     * @return the conection
     */
    public DBConnection getConection() {
        return conection;
    }

    /**
     * @param conection the conection to set
     */
    public void setConection(DBConnection conection) {
        this.conection = conection;
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
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the precio_compra
     */
    public String getPrecio_compra() {
        return precio_compra;
    }

    /**
     * @param precio_compra the precio_compra to set
     */
    public void setPrecio_compra(String precio_compra) {
        this.precio_compra = precio_compra;
    }

    /**
     * @return the precio_venta
     */
    public String getPrecio_venta() {
        return precio_venta;
    }

    /**
     * @param precio_venta the precio_venta to set
     */
    public void setPrecio_venta(String precio_venta) {
        this.precio_venta = precio_venta;
    }

    /**
     * @return the existencias
     */
    public String getExistencias() {
        return existencias;
    }

    /**
     * @param existencias the existencias to set
     */
    public void setExistencias(String existencias) {
        this.existencias = existencias;
    }
}
    

