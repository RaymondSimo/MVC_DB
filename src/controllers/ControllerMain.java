
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import models.*;
import views.*;

public class ControllerMain implements ActionListener{
   private final  ViewMain viewMain;
    private final ModelMain modelMain;
    private final ViewClientes viewClientes;
     private final View_productos view_productos;
     private final View_provedores view_provedores;
     private final ViewUsuarios viewUsuarios;
    private final ViewRegist_users viewRegist_users;
    
    public ControllerMain(ViewMain viewMain, ViewClientes viewClientes, View_provedores view_provedores, View_productos view_productos, ViewUsuarios viewUsuarios, ViewRegist_users viewRegist_users, ModelMain modelMain){
        this.viewMain=viewMain;
        this.viewClientes=viewClientes;
        this.modelMain=modelMain;
        this.view_productos=view_productos;
        this.view_provedores=view_provedores;
        this.viewUsuarios=viewUsuarios;
        this.viewRegist_users= viewRegist_users;
        
        
        this.viewMain.jmiClientes.addActionListener(this);
        this.viewMain.jmi_iniciar_sesion.addActionListener(this);
        this.viewMain.jmiUsuarios.addActionListener(this);
        this.viewMain.jmiProductos.addActionListener(this);
        this.viewMain.jmiProveedores.addActionListener(this);
        this.viewMain.jmiCompras.addActionListener(this);
        this.viewMain.jmiVentas.addActionListener(this);
        
        
        
        initView();
    }

    

    

      
    

    
    

    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==viewMain.jmiClientes){
          jmiClientessActionPerformed(); 
        }
        else if(ae.getSource()==viewMain.jmiProductos){
            jmiProductosActionPerformed();
        }
        else if(ae.getSource()==viewMain.jmiProveedores){
            jmiProveedoresActionPerformed();
        }
        else if(ae.getSource()==viewMain.jmi_iniciar_sesion){
            jmi_iniciar_sesionActionPerformed();
        }
        else if(ae.getSource()==viewMain.jmiUsuarios){
            jmiUsuariosActionPerformed();
        }
    }
    
    public void jmiClientessActionPerformed(){
        viewMain.setContentPane(viewClientes);
        viewMain.revalidate();
        viewMain.repaint();
    }
    public void jmiProductosActionPerformed(){
        viewMain.setContentPane(view_productos);
        viewMain.revalidate();
        viewMain.repaint();
    }
    public void jmiProveedoresActionPerformed(){
        viewMain.setContentPane(view_provedores);
        viewMain.revalidate();
        viewMain.repaint();
    }
    public void jmi_iniciar_sesionActionPerformed(){
        viewMain.setContentPane(viewUsuarios);
        viewMain.revalidate();
        viewMain.repaint();
    }
    public void jmiUsuariosActionPerformed(){
        viewMain.setContentPane(viewRegist_users);
        viewMain.revalidate();
        viewMain.repaint();
    }
    
    private void initView(){
        viewMain.setTitle("MVC Panel DataBase");
        viewMain.setLocationRelativeTo(null);
        viewMain.setVisible(true);
    }

    
}
