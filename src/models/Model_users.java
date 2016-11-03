
package models;
import sax.DBConnection;
import views.ViewUsuarios;
import views.ViewClientes;
import views.ViewCompras;
import views.ViewRegist_users;
import views.View_productos;
import views.View_provedores;
/**
 *
 * @author Raymond SIMOLY
 */
public class Model_users {
    
  private DBConnection conection = new DBConnection(3306,"localhost", "acme_shop", "root", "1234");
  public String usuario;
  public String contrasena;
  public String nivel;
  public String estado;
  
  public ViewUsuarios viewUsuarios = new ViewUsuarios();
 public ViewClientes viewClientes = new  ViewClientes();
 public ViewCompras viewCompras = new  ViewCompras();
 public ViewRegist_users viewRegist_users = new  ViewRegist_users();
  public View_productos view_productos = new  View_productos();
 public View_provedores view_provedores = new  View_provedores();
  
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
    
    public void init_Values(){
        String sql="SELECT * FROM users";
        conection.executeQuery(sql);
        conection.moveNext();
      
    }
    public boolean conntectedUser(){
        boolean tPragg=false;
        
     
     String query="SELECT * FROM users WHERE nombre_usuario='"+usuario+"'&& contrasena='"+contrasena+"'";
     conection.executeQuery(query);
      conection.moveNext();
      
      if(usuario.equals(conection.getString("nombre_usuario"))&&contrasena.equals(conection.getString("contrasena"))){
          tPragg=true;
          nivel=conection.getString("nivel");
          estado=conection.getString("estado");
      }
      return tPragg;
      
      
    }
    
    
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
}
