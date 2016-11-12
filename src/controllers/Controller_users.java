
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.Model_users;
import sax.DBConnection;
import views.ViewUsuarios;
import views.ViewMain;
/**
 *
 * @author Raymond SIMOLY
 */
public class Controller_users implements ActionListener{
     private DBConnection conection = new DBConnection(3306,"localhost", "acme_shop", "root", "1234");
    Model_users model_users;
    ViewUsuarios viewUsuarios;
     ViewMain viewMain ;

    public Controller_users( ViewUsuarios viewUsuarios, Model_users model_users,ViewMain viewMain) {
        this.model_users=model_users;
        this.viewUsuarios=viewUsuarios;
        this.viewMain=viewMain;

this.viewUsuarios.jbtn_enter.addActionListener(this);
unitView();

    }
    
    

    
/*private void jbtnEnterActionPerformed(){
    model_users.conntectedUser();
 
    
}*/


    @Override
    public void actionPerformed(ActionEvent ae) {
        model_users.usuario=viewUsuarios.jtf_usuario.getText();
        model_users.contrasena=viewUsuarios.jtf_password.getText();
        if(ae.getSource()==viewUsuarios.jbtn_enter){
            
            
          //  jbtnEnterActionPerformed();
            
            if(model_users.conntectedUser()){
                JOptionPane.showMessageDialog(viewUsuarios, " Bienvenido " + model_users.getUsuario() +"," + " ha ingresado con exito al sistema");
                System.out.println("success");
                
                if(model_users.nivel.equals("Administrador")&&model_users.estado.equals("Activo")){
                    System.out.println("bravo");
                   viewMain.jm_catalogos.setEnabled(true);
                   
                    viewMain.jm_bar.setEnabled(true);
                    viewMain.jm_archivos.setEnabled(true);
                    viewMain.jm_operciones.setEnabled(true);
                    viewMain.jmiUsuarios.setEnabled(true);
                    viewMain.jm_acerca.setEnabled(true);
                    viewMain.jm_reportes.setEnabled(true);
                    viewMain.jmenu_logout.setEnabled(true);
                    this.viewUsuarios.jtf_usuario.setText("");
                    this.viewUsuarios.jtf_password.setText("");
                }
                
                else if(model_users.nivel.equals("Vendedor")&&model_users.estado.equals("Activo")){
                    System.out.println("felicitaciones");
                    viewMain.jmiClientes.setEnabled(false);
                    viewMain.jm_catalogos.setEnabled(false);
                    viewMain.jm_bar.setEnabled(false);
                    viewMain.jmiUsuarios.setEnabled(false);
                    viewMain.jm_operciones.setEnabled(true);
                    viewMain.jm_acerca.setEnabled(true);
                    viewMain.jmenu_logout.setEnabled(true);
                    this.viewUsuarios.jtf_usuario.setText("");
                    this.viewUsuarios.jtf_password.setText("");
                }
                 if(model_users.estado.equals("Inactivo")){
                  JOptionPane.showMessageDialog(null, "Lo sentimos, usted es un usuario inactivo en el sistema");  
                }
                
            }
            else
                JOptionPane.showMessageDialog(viewUsuarios, "Por favor ingrese un usuario y una contraseña correctos");
            
            
            
        }
    }
    private void unitView(){
        viewUsuarios.setVisible(true);
        model_users.init_Values();
    }
}
