package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.View_provedores;
import models.ModelProvedores;
import sax.DBConnection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.HashMap;

public class ControllerProvedores implements ActionListener {
  private DBConnection conection = new DBConnection(3306,"localhost", "acme_shop", "root", "1234");

//    private Connection conexion;
//    private Statement st;
//    private ResultSet rs;
    private final View_provedores view_provedores;
    private final ModelProvedores modelProvedores;

//    DBConnection dbCon = new DBConnection(3306, "localhost", "acme_shop", "root", "1234");
    //
    public ControllerProvedores(View_provedores viewProvedores, ModelProvedores modelProvedores) {
        this.modelProvedores = modelProvedores;
        this.view_provedores = viewProvedores;

        this.view_provedores.jbtn_firds.addActionListener(this);
        this.view_provedores.jbtn_anterior.addActionListener(this);
        this.view_provedores.jbtn_buscar.addActionListener(this);
        this.view_provedores.jbtn_editar.addActionListener(this);
        this.view_provedores.jbtn_eliminar.addActionListener(this);
        this.view_provedores.jbtn_ultimo.addActionListener(this);
        this.view_provedores.jbtn_siguiente.addActionListener(this);
        this.view_provedores.jbtn_agregar.addActionListener(this);
        this.view_provedores.jbtn_guardar.addActionListener(this);

        initView();
        showData();
    }

    private void initView() {
        modelProvedores.initValues();
        showValues();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view_provedores.jbtn_firds) {
            jbtnFirstActionPerformed();
            System.out.println("First");
        } else if (e.getSource() == view_provedores.jbtn_anterior) {
            jbtnPreviousActionPerformed();
            System.out.println("Anteripr");
        } else if (e.getSource() == view_provedores.jbtn_siguiente) {
            jbtnNextActionPerformed();
            System.out.println("siguiente");
        } else if (e.getSource() == view_provedores.jbtn_ultimo) {
            jbtnLastActionPerformed();
            System.out.println("ultimo");
        }
            
            else if(e.getSource()==view_provedores.jbtn_agregar){
            agregarRegistro();    
        }
            else if(e.getSource()==view_provedores.jbtn_guardar){
             guadarRegistro();   
            }
            else if(e.getSource()==view_provedores.jbtn_editar){
                editarValues();
            }
            else if(e.getSource()==view_provedores.jbtn_eliminar){
                modelProvedores.eliminarValues();
            }
    }

    private void jbtnFirstActionPerformed() {
        modelProvedores.moveFirst();
        showValues();
    }

    private void jbtnPreviousActionPerformed() {
        modelProvedores.movePrevious();
        showValues();
    }

    private void jbtnNextActionPerformed() {
        modelProvedores.moveNext();
        showValues();
    }

    private void jbtnLastActionPerformed() {
        modelProvedores.moveLast();
        showValues();
    }

    
    public void agregarRegistro(){
        this.view_provedores.jtf_nombre.setText("");
         this.view_provedores.jtf_nombre_cont.setText("");
        this.view_provedores.jtf_telefono.setText("");
         this.view_provedores.jtf_email.setText("");
        this.view_provedores.jtf_rfc.setText("");
         this.view_provedores.jtf_calle.setText("");
        this.view_provedores.jtf_numero.setText("");
         this.view_provedores.jtf_colonia.setText("");
        this.view_provedores.jtf_ciudad.setText("");
         this.view_provedores.jtf_estado.setText("");   
    }
      private void showData() {
        view_provedores.jTable2.setModel(modelProvedores.tableModel);
        this.modelProvedores.Tabla();
          this.modelProvedores.setValues();
      }
     public void guadarRegistro() {        
       
         String nombre=this.view_provedores.jtf_nombre.getText();
             String nombre_contacto=this.view_provedores.jtf_nombre_cont.getText();
             Integer telefono=Integer.parseInt(view_provedores.jtf_telefono.getText());
             String email=this.view_provedores.jtf_email.getText();
             String rfc=this.view_provedores.jtf_rfc.getText();
             String calle=this.view_provedores.jtf_calle.getText();
              Integer numero=Integer.parseInt(view_provedores.jtf_numero.getText());
             String colonia=this.view_provedores.jtf_colonia.getText();
             String ciudad=this.view_provedores.jtf_ciudad.getText();
             String estado=this.view_provedores.jtf_estado.getText();

            conection.executeUpdate("insert into proveedores (nombre,rfc,calle,numero,colonia,ciudad,estado,nombre_contacto,telefono,email)"+" values "
                    + "('"+nombre+"','"+rfc+"','"+calle+"','"+numero+"','"+colonia+"','"+ciudad+"','"+estado+"','"+nombre_contacto+"','"+telefono+"','"+email+"');"); 
            
           this.modelProvedores.setValues();
          
          modelProvedores.initValues();
          showValues();
    }
     public void editarValues(){
         Integer id_cliente=Integer.parseInt(view_provedores.jtf_id_proveedor.getText());
         String nombre=this.view_provedores.jtf_nombre.getText();
             String nombre_contacto=this.view_provedores.jtf_nombre_cont.getText();
             Integer telefono=Integer.parseInt(view_provedores.jtf_telefono.getText());
             String email=this.view_provedores.jtf_email.getText();
             String rfc=this.view_provedores.jtf_rfc.getText();
             String calle=this.view_provedores.jtf_calle.getText();
              Integer numero=Integer.parseInt(view_provedores.jtf_numero.getText());
             String colonia=this.view_provedores.jtf_colonia.getText();
             String ciudad=this.view_provedores.jtf_ciudad.getText();
             String estado=this.view_provedores.jtf_estado.getText();
             
             conection.executeUpdate ( "update proveedores set nombre='"+nombre+"',rfc='"+rfc+"',calle='"+calle+"',numero='"+numero+"',colonia='"+colonia+"',ciudad='"+ciudad+"',estado='"+estado+"',nombre_contacto='"+nombre_contacto+"',telefono='"+telefono+"',email='"+email+"' where id_proveedor='"+this.view_provedores.jtf_id_proveedor.getText()+"';");
       
       this.modelProvedores.setValues();
       
       modelProvedores.initValues();
        showValues();

     }
     private void showValues() {
        modelProvedores.setValues();
        view_provedores.jtf_id_proveedor.setText(""+modelProvedores.getId_proveedor());
        view_provedores.jtf_nombre.setText(modelProvedores.getNombre());
        view_provedores.jtf_rfc.setText(modelProvedores.getRfc());
        view_provedores.jtf_calle.setText(modelProvedores.getCalle());
        view_provedores.jtf_numero.setText(""+modelProvedores.getNumero());
        view_provedores.jtf_colonia.setText(modelProvedores.getColonia());
        view_provedores.jtf_ciudad.setText(modelProvedores.getCiudad());
        view_provedores.jtf_estado.setText(modelProvedores.getEstado());
        view_provedores.jtf_nombre_cont.setText(modelProvedores.getNombre_contacto());
        view_provedores.jtf_telefono.setText(""+modelProvedores.getTelefono());
        view_provedores.jtf_email.setText(modelProvedores.getEmail());

    }

}
