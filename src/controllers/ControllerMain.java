
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import models.*;
import views.*;
/**
 *
 * @author Raymond SIMOLY
 */
public class ControllerMain implements ActionListener{
   private final  ViewMain viewMain;
    private final ModelMain modelMain;
    private final ViewClientes viewClientes;
     private final View_productos view_productos;
     private final View_provedores view_provedores;
    
    
    public ControllerMain(ViewMain viewMain, ViewClientes viewClientes, View_provedores view_provedores, View_productos view_productos, ModelMain modelMain){
        this.viewMain=viewMain;
        this.viewClientes=viewClientes;
        this.modelMain=modelMain;
        this.view_productos=view_productos;
        this.view_provedores=view_provedores;
        
        
        
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
    
    private void initView(){
        viewMain.setTitle("MVC Panel DataBase");
        viewMain.setLocationRelativeTo(null);
        viewMain.setVisible(true);
    }
}
