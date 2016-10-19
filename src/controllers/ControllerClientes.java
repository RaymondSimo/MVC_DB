
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelClientes;
import views.ViewClientes;
/**
 *
 * @author Raymond SIMOLY
 */
public class ControllerClientes implements ActionListener{
    private final ModelClientes modelClientes;
    private final ViewClientes viewClientes;
    
    public ControllerClientes(ViewClientes viewClientes, ModelClientes modelClientes){
        this.modelClientes=modelClientes;
        this.viewClientes=viewClientes;
        
        this.viewClientes.jbtn_agregar.addActionListener(this);
        this.viewClientes.jbtn_anterior.addActionListener(this);
        this.viewClientes.jbtn_buscar.addActionListener(this);
        this.viewClientes.jbtn_editar.addActionListener(this);
        this.viewClientes.jbtn_eliminar.addActionListener(this);
        this.viewClientes.jbtn_primero.addActionListener(this);
        this.viewClientes.jbtn_siguiente.addActionListener(this);
        this.viewClientes.jbtn_ultimo.addActionListener(this);
        
        initView();
    }
        private void initView(){
        modelClientes.initValues();
        showValues();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==viewClientes.jbtn_primero){
          jbtnFirstActionPerformed();
        }
        else if(ae.getSource()==viewClientes.jbtn_anterior){
          jbtnPreviousActionPerformed();  
        }
        else if(ae.getSource()==viewClientes.jbtn_siguiente){
          jbtnNextActionPerformed();  
        }
        else if(ae.getSource()==viewClientes.jbtn_ultimo){
          jbtnLastActionPerformed();  
        }
    }
    
    
    private void jbtnFirstActionPerformed(){
        modelClientes.moveFirst();
        showValues();
    }
    
    private void jbtnPreviousActionPerformed(){
         modelClientes.movePrevious();
        showValues();
    }
    
    private void jbtnNextActionPerformed(){
         modelClientes.moveNext();
        showValues();
    }
    
    private void jbtnLastActionPerformed(){
         modelClientes.moveLast();
        showValues();
    }
    
    private void showValues(){
        viewClientes.jtf_id_cliente.setText(""+modelClientes.getId_cliente());
        viewClientes.jtf_nombre.setText(modelClientes.getNombre());
        viewClientes.jtf_ap_paternno.setText(modelClientes.getAp_paterno());
        viewClientes.jtf_ap_materno.setText(modelClientes.getAp_materno());
        viewClientes.jtf_telefono.setText(""+modelClientes.getTelefono());
        viewClientes.jtf_email.setText(modelClientes.getEmail());
        viewClientes.jtf_rfc.setText(modelClientes.getRfc());
        viewClientes.jtf_calle.setText(modelClientes.getCalle());
        viewClientes.jtf_numero.setText(""+modelClientes.getNumero());
        viewClientes.jtf_colonia.setText(modelClientes.getColonia());
        viewClientes.jtf_ciudad.setText(""+modelClientes.getCiudad());
        viewClientes.jtf_estado.setText(modelClientes.getEstado());
    }

   
}
                




    

