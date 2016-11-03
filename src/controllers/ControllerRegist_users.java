
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.ViewRegist_users;
import models.ModelRegist_users;
import sax.DBConnection;
/**
 *
 * @author Raymond SIMOLY
 */
public class ControllerRegist_users implements ActionListener{
     private DBConnection conection = new DBConnection(3306,"localhost", "acme_shop", "root", "1234");
    private final ModelRegist_users modelRegist_users;
    private final ViewRegist_users viewRegist_users;
    
    public ControllerRegist_users(ViewRegist_users viewRegist_users,ModelRegist_users modelRegist_users){
        this.modelRegist_users=modelRegist_users;
        this.viewRegist_users=viewRegist_users;
        
        
        this.viewRegist_users.jbtn_agregar.addActionListener(this);
        this.viewRegist_users.jbtn_edit.addActionListener(this);
        this.viewRegist_users.jbtn_first.addActionListener(this);
        this.viewRegist_users.jbtn_last.addActionListener(this);
        this.viewRegist_users.jbtn_next.addActionListener(this);
        this.viewRegist_users.jbtn_previous.addActionListener(this);
        
         initView();
        showData();
    }
        private void initView(){
        modelRegist_users.initValues();
        showValues();
    
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
         if(ae.getSource()==  viewRegist_users.jbtn_first){
          jbtnFirstActionPerformed();
        }
        else if(ae.getSource()==  viewRegist_users.jbtn_previous){
          jbtnPreviousActionPerformed();  
        }
        else if(ae.getSource()==  viewRegist_users.jbtn_next){
          jbtnNextActionPerformed();  
        }
        else if(ae.getSource()==  viewRegist_users.jbtn_last){
          jbtnLastActionPerformed();  
        }
        else if(ae.getSource()==  viewRegist_users.jbtn_agregar){
         agregarRegistro(); 
        }
        else if(ae.getSource()==  viewRegist_users.jbtn_guardar){
         guadarRegistro();   
        }
        else if(ae.getSource()==  viewRegist_users.jbtn_quitar){
            jbtnEliminarActionPerformed();
        }
        else if(ae.getSource()==  viewRegist_users.jbtn_edit)
          editarValues();   
    }
    
     private void jbtnFirstActionPerformed(){
        modelRegist_users.moveFirst();
        showValues();
    }
    
    private void jbtnPreviousActionPerformed(){
         modelRegist_users.movePrevious();
        showValues();
    }
    
    private void jbtnNextActionPerformed(){
         modelRegist_users.moveNext();
        showValues();
    }
    
    private void jbtnLastActionPerformed(){
        modelRegist_users.moveLast();
        showValues();
    }
    private void jbtnEliminarActionPerformed(){
         modelRegist_users.eliminarValues();
        showValues();
    }
    
     private void showData() {
        viewRegist_users.jTable_users.setModel(modelRegist_users.tableModel);
        modelRegist_users.Tabla();
    }
     
      public void editarValues(){
         Integer id_usuario=Integer.parseInt(viewRegist_users.jtf_id_usuario.getText());
         String nombre=this.viewRegist_users.jtf_nombre.getText();
         String nombre_usuario=this.viewRegist_users.jtf_usuario.getText();
             String contrasena=this.viewRegist_users.jtf_contrasena.getText(); 
             String nivel;
             int nivo=viewRegist_users.jCombo_nivel.getSelectedIndex();
             if(nivo==0){
                 nivel="Administrador";
             }
             else
                 nivel="Vendedor";
             
              String estado;
             int estadoRang=viewRegist_users.jCombo_estado.getSelectedIndex();
             if(estadoRang==0){
                 estado="Activo";
             }
             else
                 estado="Inactivo";

             
             
             conection.executeUpdate ( "update users set nombre='"+nombre+"',nombre_usuario='"+nombre_usuario+"',contrasena='"+contrasena+"',nivel='"+nivel+"',estado='"+estado+"' where id_usuario='"+this.viewRegist_users.jtf_id_usuario.getText()+"';");
       
       this.modelRegist_users.setValues();

     }
      
     public void guadarRegistro() {        
             Integer id_usuario=Integer.parseInt(viewRegist_users.jtf_id_usuario.getText());
             String nombre=this.viewRegist_users.jtf_nombre.getText();
             String nombre_usuario=this.viewRegist_users.jtf_usuario.getText(); 
             String contrasena=this.viewRegist_users.jtf_contrasena.getText();
             String nivel;
             
             int nivo=viewRegist_users.jCombo_nivel.getSelectedIndex();
             if(nivo==0){
                 nivel="Administrador";
             }
             else
                 nivel="Vendedor";
             String estado;
             int estadoRang=viewRegist_users.jCombo_estado.getSelectedIndex();
             if(estadoRang==0){
                 estado="Activo";
             }
             else
                 estado="Inactivo";

            conection.executeUpdate ( "insert into users (id_usuario,nombre,nombre_usuario,contrasena,nivel,estado)"+" values "
                    + "('"+ id_usuario+"','"+ nombre +"','"+ nombre_usuario +"','"+contrasena+"','"+nivel+"','"+estado+"');"); 
            
          //this.modelRegist_users.setValues();
          showValues();
       

    }
      public void agregarRegistro(){
         this.viewRegist_users.jtf_id_usuario.setText("");
         this.viewRegist_users.jtf_nombre.setText("");
         this.viewRegist_users.jtf_usuario.setText("");
         this.viewRegist_users.jtf_contrasena.setText("");
         
         
      }
    
     
    
    private void showValues(){
         viewRegist_users.jtf_id_usuario.setText(""+modelRegist_users.getId_usuario());
         viewRegist_users.jtf_nombre.setText(modelRegist_users.getNombre());
         viewRegist_users.jtf_usuario.setText(modelRegist_users.getNombre_usuario());
         viewRegist_users.jtf_contrasena.setText(modelRegist_users.getContrasena());
         viewRegist_users.jCombo_nivel.setSelectedItem(modelRegist_users.getNivel());
         viewRegist_users.jCombo_estado.setSelectedItem(modelRegist_users.getEstado());
         
        
    }
    
    
}
