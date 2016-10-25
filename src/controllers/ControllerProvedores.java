
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.View_provedores;
import models.ModelProvedores;
import sax.DBConnection;

public class ControllerProvedores implements ActionListener {
    
   private final View_provedores view_provedores;
   private final ModelProvedores modelProvedores; 
   //
       public ControllerProvedores(View_provedores viewProvedores, ModelProvedores modelProvedores){
        this.modelProvedores=modelProvedores;
        this.view_provedores  =viewProvedores;
      
   
        this.view_provedores.jbtn_firds.addActionListener(this);
        this.view_provedores.jbtn_anterior.addActionListener(this);
        this.view_provedores.jbtn_buscar.addActionListener(this);
        this.view_provedores.jbtn_editar.addActionListener(this);
        this.view_provedores.jbtn_eliminar.addActionListener(this);
        this.view_provedores.jbtn_ultimo.addActionListener(this);
        this.view_provedores.jbtn_siguiente.addActionListener(this);
        this.view_provedores.jbtn_agregar.addActionListener(this);
        
           initView();
    }
        private void initView(){
        modelProvedores.initValues();
        showValues();
    }
       
        
       
    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==view_provedores.jbtn_firds){
          jbtnFirstActionPerformed();
        }
        else if(e.getSource()==view_provedores.jbtn_anterior){
          jbtnPreviousActionPerformed();  
        }
        else if(e.getSource()==view_provedores.jbtn_siguiente){
          jbtnNextActionPerformed();  
        }
        else if(e.getSource()==view_provedores.jbtn_ultimo){
          jbtnLastActionPerformed();  
        }
    }
     private void jbtnFirstActionPerformed(){
        modelProvedores.moveFirst();
        showValues();
    }
    
    private void jbtnPreviousActionPerformed(){
         modelProvedores.movePrevious();
        showValues();
    }
    
    private void jbtnNextActionPerformed(){
         modelProvedores.moveNext();
        showValues();
    }
    
    private void jbtnLastActionPerformed(){
         modelProvedores.moveLast();
        showValues();
    }
    
    
     private void showValues(){
        view_provedores.jtf_id_proveedor.setText(""+modelProvedores.getId_proveedor());
        view_provedores.jtf_nombre.setText(modelProvedores.getNombre());
        view_provedores.jtf_rfc.setText(modelProvedores.getRfc());
        view_provedores.jtf_calle.setText(modelProvedores.getCalle());
        view_provedores.jtf_numero.setText(""+modelProvedores.getNumero());
        view_provedores.jtf_colonia.setText(""+modelProvedores.getColonia());
        view_provedores.jtf_ciudad.setText(""+modelProvedores.getCiudad());
        view_provedores.jtf_estado.setText(modelProvedores.getEstado());
        view_provedores.jtf_numero_cont.setText(modelProvedores.getNombre_contacto());
        view_provedores.jtf_telefono.setText(""+modelProvedores.getTelefono());
        view_provedores.jtf_email.setText(modelProvedores.getEmail());
        
        
      
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
