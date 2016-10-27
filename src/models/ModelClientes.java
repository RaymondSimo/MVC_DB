
package models;
import javax.swing.table.DefaultTableModel;
import sax.DBConnection;
import views.ViewClientes;
/**
 *
 * @author Raymond SIMOLY
 */
public class ModelClientes {
  private DBConnection conection = new DBConnection(3306,"localhost", "acme_shop", "root", "1234");
  
  
  private int id_cliente;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private int telefono;
    private String email;
    private String rfc;
    private String calle;
    private int numero;
    private String colonia;
    private String ciudad;
    private String estado;
ViewClientes viewClientes = new ViewClientes();

    
  public  DefaultTableModel tableModel = new DefaultTableModel(new String [] {"id_cliente", "nombre","ap_paterno","ap_materno","telefono","email","rfc","calle","numero","colonia","ciudad","estado"}, 0);
  
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
        conection.executeQuery("SELECT id_cliente, nombre, ap_paterno, ap_materno, telefono, email, rfc, calle, numero, colonia, ciudad, estado FROM clientes;");
        conection.moveNext();
        setValues();
    }
    public void setValues(){
        this.id_cliente = conection.getInteger("id_cliente");
        this.nombre = conection.getString("nombre");
        this.ap_paterno = conection.getString("ap_paterno");
        this.ap_materno = conection.getString("ap_materno");
        this.telefono = conection.getInteger("telefono");
        this.email = conection.getString("email");
        this.rfc = conection.getString("rfc");
        this.calle = conection.getString("calle");
        this.numero = conection.getInteger("numero");
        this.colonia = conection.getString("colonia");
        this.ciudad = conection.getString("ciudad");
        this.estado = conection.getString("estado");
        
                
    }
    public void Tabla() {
        while (conection.moveNext()) {
            setValues();
               tableModel.addRow(new Object []{id_cliente, nombre,ap_paterno,ap_materno,telefono,email,rfc,calle,numero,colonia,ciudad,estado});
        }
    }
    public void eliminarValues()
    {
        conection.executeUpdate ("delete from clientes where id_cliente="+id_cliente);

           this.viewClientes.jtf_nombre.setText("");
             this.viewClientes.jtf_ap_materno.setText(""); 
             this.viewClientes.jtf_ap_paternno.getText();
             this.viewClientes.jtf_telefono.setText("");
             this.viewClientes.jtf_email.setText("");
             this.viewClientes.jtf_rfc.setText("");
             this.viewClientes.jtf_calle.setText("");
             this.viewClientes.jtf_numero.setText("");
             this.viewClientes.jtf_colonia.setText("");
             this.viewClientes.jtf_ciudad.setText("");
             this.viewClientes.jtf_estado.setText("");
             initValues();
    }
    /**
     * @return the ap_paterno
     */
    public String getAp_paterno() {
        return ap_paterno;
    }

    /**
     * @param ap_paterno the ap_paterno to set
     */
    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    /**
     * @return the ap_materno
     */
    public String getAp_materno() {
        return ap_materno;
    }

    /**
     * @param ap_materno the ap_materno to set
     */
    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }
}
