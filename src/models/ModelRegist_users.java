
package models;

import javax.swing.table.DefaultTableModel;
import sax.DBConnection;
import views.ViewRegist_users;

/**
 *
 * @author Raymond SIMOLY
 */
public class ModelRegist_users {
  private DBConnection conection = new DBConnection(3306,"localhost", "acme_shop", "root", "1234");
  private int id_usuario;
  private String nombre;
  private String nombre_usuario;
  private String nivel;
  private String estado;
  private String contrasena;
  
  ViewRegist_users viewRegist_users= new ViewRegist_users();
  public  DefaultTableModel tableModel = new DefaultTableModel(new String [] {"nombre_usuario","nivel","estado"}, 0);

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
     * @return the usuario
     */
    

    /**
     * @return the nivel
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
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
        conection.executeQuery("SELECT id_usuario, nombre, nombre_usuario, contrasena, nivel, estado FROM users;");
        conection.moveNext();
        setValues();
    }
    public void setValues(){
        this.id_usuario = conection.getInteger("id_usuario");
        this.nombre = conection.getString("nombre");
        this.nombre_usuario = conection.getString("nombre_usuario");
        this.contrasena=conection.getString("contrasena");
        this.nivel= conection.getString("nivel");
        this.estado = conection.getString("estado");
      
    }
    public void eliminarValues()
    {
        conection.executeUpdate ("delete from users where id_usuario="+id_usuario);

           this.viewRegist_users.jtf_nombre.setText("");
             this.viewRegist_users.jtf_usuario.setText("");
             this.viewRegist_users.jtf_contrasena.setText("");
             this.viewRegist_users.jCombo_nivel.setSelectedItem("");
             this.viewRegist_users.jCombo_estado.setSelectedItem("");
             initValues();
    }
    
     
     public void Tabla() {
        while (conection.moveNext()) {
            setValues();
               tableModel.addRow(new Object []{nombre_usuario,nivel,estado});
         
        }
        
    } 

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the nombre_usuario
     */
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    /**
     * @param nombre_usuario the nombre_usuario to set
     */
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
  
  
}
