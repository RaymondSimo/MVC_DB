
package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import sax.DBConnection;
import views.ViewVentas;
/**
 *
 * @author Raymond SIMOLY
 */
public class ModelVentas { 
public DBConnection conection = new DBConnection(3306,"localhost", "acme_shop", "root", "1234");
  ViewVentas viewVentas=new ViewVentas();
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
  private double total;
  private double cantidadPorP;
  private String nombre_producto;
  private int TotPorPrecio;
  private int id_compra;
  private String estado;
  private String colonia;
  private String ciudad;
  private String calle;
  private String telefono;
  private int numero;
  public int existencias;
  private Calendar calendario = new GregorianCalendar();
  
 //public DefaultTableModel modelo= new DefaultTableModel();
  
  
  
public  DefaultTableModel tableModel = new DefaultTableModel(new String [] {"id_producto", "Producto","Precio","Cantidad","Subtotal"}, 0);

  
         
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

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the existencia
     */
    public int getExistencia() {
        return getExistencias();
    }

    /**
     * @param existencia the existencia to set
     */
    public void setExistencia(int existencia) {
        this.setExistencias(getExistencias());
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
      

    
    
    
  public void initValues1(){
        String query="SELECT * FROM users;";
    boolean executeQuery = conection.executeQuery(query);
        conection.moveNext();
        setValues1();
    }
  public void conntectedCostumer(int id_cliente){
        String query="SELECT * FROM clientes WHERE id_cliente='"+id_cliente+"'";
        conection.executeQuery(query);
        conection.moveNext();
        setValues2();
          
    }
   public void conntectedCostum(String rfc){
        String query="SELECT * FROM clientes WHERE rfc='"+rfc+"'";
        conection.executeQuery(query);
        conection.moveNext();
        setValues2();
          
    }
   public void conProducto(int id_producto){
        String query="SELECT * FROM productos WHERE id_producto='"+id_producto+"'";
        conection.executeQuery(query);
        conection.moveNext();
        setValues3();
       
          
    }
   public void llenarVentas(int id_venta){
     String query="SELECT * FROM ventas WHERE id_venta='"+id_venta+"'";
        conection.executeQuery(query);
        conection.moveNext();
        setValues4();  
   }
   
  
  public void setValues1(){
    this.id_usuario = conection.getInteger("id_usuario");
    
    this.vendedor = conection.getString("nombre");
         

  }
   
  public void setValues3(){
        id_producto=conection.getInteger("id_producto");
        nombre_producto = conection.getString("producto");
        precio_producto = conection.getInteger("precio_venta");
        existencias=conection.getInteger("existencias");
        
  }
  public void setValues4(){
        setSubtotal(conection.getInteger("subtotal"));
        fecha = conection.getString("fecha");
        setIva(conection.getInteger("IVA"));
        setTotal(conection.getInteger("total"));
        
  }
  
    public void setValues2(){
        cliente = conection.getString("nombre");
        calle=conection.getString("calle");
        numero=conection.getInteger("numero");
        ciudad=conection.getString("ciudad");
        colonia=conection.getString("colonia");
        estado=conection.getString("estado");
      telefono=conection.getString("telefono");

        }
    public static String FechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return formateador.format(ahora);
    }
     public String HoraActual() {
        Date dtFechaActual = new Date ();
        DateFormat dfLocal = new SimpleDateFormat("HH:mm:ss");

        return dfLocal.format(dtFechaActual);
}
         public void verTabla(){
    tableModel.addRow(new Object[]{id_producto,nombre_producto,precio_producto, getCantidad_producto(),subtotal()});
    setValues3();

    }
         public void verTable(){
             try{
 
			while(viewVentas.jTable.getRowCount()>0){
				tableModel.removeRow(0);
			}
 
		}catch(Exception e){
				System.out.println(e);
		}
       /*for (int i = 0; i <=viewVentas.jTable.getRowCount(); i++) {
           tableModel.removeRow(i);
           i-=1;
           viewVentas.jTable.setModel(new DefaultTableModel());
           
       }*/
       

    }
         
         public double subtotal(){
            double sub=precio_producto*getCantidad_producto();
                return sub;
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
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the cantidadPorP
     */
    public double getCantidadPorP() {
        return cantidadPorP;
    }

    /**
     * @param cantidadPorP the cantidadPorP to set
     */
    public void setCantidadPorP(double cantidadPorP) {
        this.cantidadPorP = cantidadPorP;
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

     
     
    
   
  
}
    /**
     * @return the TotPorPrecio
     */
  
  
  

