
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import models.*;
import views.*;

public class ControllerMain implements ActionListener{
     ViewMain viewMain;
     ModelMain modelMain;
     
    JPanel views[];
    
    public ControllerMain(ViewMain viewMain,ModelMain modelMain, JPanel[] views){
        this.viewMain = viewMain;
        this.modelMain = modelMain;
        
        
        this.views=views;
        this.viewMain.jmiClientes.addActionListener(this);
        this.viewMain.jmi_iniciar_sesion.addActionListener(this);
        this.viewMain.jmiUsuarios.addActionListener(this);
        this.viewMain.jmiProductos.addActionListener(this);
        this.viewMain.jmiProveedores.addActionListener(this);
        this.viewMain.jmiCompras.addActionListener(this);
        this.viewMain.jmiVentas.addActionListener(this);
        this.viewMain.jmicerrarSesion.addActionListener(this);
        this.viewMain.jmi_salir.addActionListener(this);
        
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
        else if(ae.getSource()==viewMain.jmicerrarSesion){
            close();
        }
        else if(ae.getSource()==viewMain.jmi_salir){
            logOut();
        }
    }
    
    public void jmiClientessActionPerformed(){
        viewMain.setContentPane(views[2]);
        viewMain.revalidate();
        viewMain.repaint();
    }
    public void jmiProductosActionPerformed(){
        viewMain.setContentPane(views[3]);
        viewMain.revalidate();
        viewMain.repaint();
    }
    public void jmiProveedoresActionPerformed(){
        viewMain.setContentPane(views[4]);
        viewMain.revalidate();
        viewMain.repaint();
    }
    public void jmi_iniciar_sesionActionPerformed(){
        viewMain.setContentPane(views[0]);
        viewMain.revalidate();
        viewMain.repaint();
    }
    public void jmiUsuariosActionPerformed(){
        viewMain.setContentPane( views[1]);
        viewMain.revalidate();
        viewMain.repaint();
    }
    public void jmiComprasActionPerformed(){
        viewMain.setContentPane( views[5]);
        viewMain.revalidate();
        viewMain.repaint();
    }
    private void initView(){
        viewMain.setTitle("MVC Panel DataBase");
        viewMain.setLocationRelativeTo(null);
        viewMain.setVisible(true);
    }
    public void close() {
        int confirm = JOptionPane.showConfirmDialog(null, "¿Desea abandonar el sistma?", "Aviso", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION)
            System.exit(0);
    
            

    }
    public void logOut() {
        int confirm = JOptionPane.showConfirmDialog(null, "¿Desea salir ?", "Aviso", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION)
            
                    viewMain.jm_catalogos.setEnabled(false);
                    viewMain.jm_bar.setEnabled(false);
                    viewMain.jm_reportes.setEnabled(false);
                    viewMain.jm_operciones.setEnabled(false);
                    viewMain.jm_acerca.setEnabled(false);
                    viewMain.jmiUsuarios.setEnabled(false);
                    viewMain.jmenu_logout.setEnabled(false);
                    
    
            

    }
}
