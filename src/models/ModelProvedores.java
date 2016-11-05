package models;

import sax.DBConnection;

/**
 *
 * @author Bnc
 */
public class ModelProvedores {

    public DBConnection conection = new DBConnection(3306, "localhost", "acme_shop", "root", "1234");

    private int id_proveedor;
    private String nombre;
    private String rfc;
    private String calle;
    private int numero;
    private String colonia;
    private String ciudad;
    private String estado;
    private String nombre_contacto;
    private int telefono;
    private String email;

    /**
     * @return the id_provedor
     */
    public int getId_proveedor() {
        return id_proveedor;
    }

    /**
     * @param id_proveedor the id_provedor to set
     */
    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
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

    /**
     * @return the nombre_contcacto
     */
    public String getNombre_contacto() {
        return nombre_contacto;
    }

    /**
     * @param nombre_contcacto the nombre_contcacto to set
     */
    public void setNombre_contcacto(String nombre_contcacto) {
        this.nombre_contacto = nombre_contcacto;
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

    public void initValues() {
        conection.executeQuery("SELECT id_proveedor, nombre, rfc, calle, numero, colonia, ciudad, estado, nombre_contacto, telefono, email FROM proveedores;");
        conection.moveNext();
        setValues();
    }

    public void setValues() {
        this.id_proveedor = conection.getInteger("id_proveedor");
        this.nombre = conection.getString("nombre");
        this.rfc = conection.getString("rfc");
        this.calle = conection.getString("calle");
        this.numero = conection.getInteger("numero");
        this.colonia = conection.getString("colonia");
        this.ciudad = conection.getString("ciudad");
        this.estado = conection.getString("estado");
        this.telefono = conection.getInteger("telefono");
        this.email = conection.getString("email");
        this.nombre_contacto = conection.getString("nombre_contacto");

    }

    public void moveNext() {
        conection.moveNext();
        setValues();
    }

    public void movePrevious() {
        conection.movePrevious();
        setValues();
    }

    public void moveFirst() {
        conection.moveFirst();
        setValues();
    }

    public void moveLast() {
        conection.moveLast();
        setValues();
    }

}
