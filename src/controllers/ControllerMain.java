
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
     
    
    
    public ControllerMain(ViewMain viewMain, ViewClientes viewClientes, ModelMain modelMain){
        this.viewMain=viewMain;
        this.viewClientes=viewClientes;
        this.modelMain=modelMain;
        
        
        
        this.viewMain.jmiClientes.addActionListener(this);
        
        initView();
    }

    

    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==viewMain.jmiClientes)
          jmiClientessActionPerformed();  
    }
    
    public void jmiClientessActionPerformed(){
        viewMain.setContentPane(viewClientes);
        viewMain.revalidate();
        viewMain.repaint();
    }
    
    private void initView(){
        viewMain.setTitle("MVC Panel DataBase");
        viewMain.setLocationRelativeTo(null);
        viewMain.setVisible(true);
    }
}
