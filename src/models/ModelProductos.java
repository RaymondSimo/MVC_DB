
package models;
import javax.swing.table.DefaultTableModel;
import sax.DBConnection;
import views.View_productos;
/**
 *
 * @author MATRIX
 */
public class ModelProductos {
    
    private DBConnection conection = new DBConnection(3306,"localhost", "acme_shop", "root", "1234");
    
    private int id_producto;
    private String producto;
    private String descripcion;
    private int precio_compra;
    private int precio_venta;
    private int existencias;
    private String marca;
    private String modelo;
    
    View_productos view_productos= new View_productos();
      public  DefaultTableModel tableModel = new DefaultTableModel(new String [] {"id_producto", "producto","descripcion","precio_compra","precio_venta","existencias","Marca","Modelo"}, 0);

    
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
        boolean executeQuery = getConection().executeQuery("SELECT id_producto, producto, descripcion,precio_compra,precio_venta,existencias,Marca,Modelo FROM productos;");
        getConection().moveNext();
        setValues();
    }
    public void setValues(){
        this.id_producto=conection.getInteger("id_producto");
        this.producto=conection.getString("producto");
        this.descripcion=conection.getString("descripcion");
        this.setPrecio_compra(conection.getInteger("precio_compra"));
        this.setPrecio_venta(conection.getInteger("precio_venta"));
        this.setExistencias(conection.getInteger("existencias"));
        this.marca=conection.getString("Marca");
        this.modelo=conection.getString("Modelo");
    }
     public void eliminarValues()
    {
        conection.executeUpdate ("delete from productos where id_producto="+id_producto);

           this.view_productos.jtf_producto.setText("");
             this.view_productos.jtf_descripcion.setText(""); 
             this.view_productos.jtf_precio_compra.setText("");
             this.view_productos.jtf_precio_venta.setText("");
             this.view_productos.jtf_existencias.setText("");
             this.view_productos.jtf_marca.setText("");
             this.view_productos.jtf_modelo.setText("");
             
             
             initValues();
             
    }
     public void Tabla() {
        while (conection.moveNext()) {
            setValues();
               tableModel.addRow(new Object []{id_producto, producto,descripcion,precio_compra,precio_venta,existencias,marca,modelo});
        }
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
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the precio_compra
     */
    public int getPrecio_compra() {
        return precio_compra;
    }

    /**
     * @param precio_compra the precio_compra to set
     */
    public void setPrecio_compra(int precio_compra) {
        this.precio_compra = precio_compra;
    }

    /**
     * @return the precio_venta
     */
    public int getPrecio_venta() {
        return precio_venta;
    }

    /**
     * @param precio_venta the precio_venta to set
     */
    public void setPrecio_venta(int precio_venta) {
        this.precio_venta = precio_venta;
    }

    /**
     * @return the existencias
     */
    public int getExistencias() {
        return existencias;
    }

    /**
     * @param existencias the existencias to set
     */
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
}
    

