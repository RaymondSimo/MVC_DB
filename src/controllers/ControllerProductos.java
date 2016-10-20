/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
/**
 *
 * @author MATRIX
 */
public class ControllerProductos {
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.Viewproductos;
import models.ModelProductos;

public class ControllerProductos implements ActionListener {
    
    private final Viewproductos viewProductos;
    private final ModelProductos modelProductos;
    
    
    public ControllerContacts(ViewProductos viewProductos, ModelProductos modelProductos){
        this.viewProductos = viewProductos;
        this.modelProductos= modelProductos;
        
        this.viewProductos.jbtnFirst.addActionListener(this);
        this.viewProductos.jbtnPrevious.addActionListener(this);
        this.viewProductos.jbtnNext.addActionListener(this);
        this.viewProductos.jbtnLast.addActionListener(this);
        
        initView();
    }
            
    private void initView(){
        modelProductos.initValues();
        getValues();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==viewProductos.jbtnFirst)
           jbtnFirstActionPerformed();
       else if(e.getSource()==viewProductos.jbtnPrevious)
           jbtnPreviousActionPerformed();
       else if(e.getSource()==viewProductos.jbtnNext)
           jbtnNextActionPerformed();
       else if(e.getSource()==viewProductos.jbtnLast)
           jbtnLastActionPerformed();
    }
    
    private void jbtnFirstActionPerformed(){
        modelProductos.moveFirst();
        showValues();
    }
    
    private void jbtnPreviousActionPerformed(){
        modelProductos.movePreviousActionPerformed();
        showValues();
    }
    
    private void jbtnNextActionPerformed(){
        modelProductos.moveNext();
        showValues();
    }
    
    private void jbtnLastActionPerformed(){
        modelProductos.moveLast();
        showValues();
    }
    
    private void showValues(){
        viewProductos.jtfId_producto.setText(""+modelProductos.getId_producto());
        viewProductos.jtfProducto.setText(modelProductos.getProducto());
        viewProductos.jtfDescripcion.setText(modelProductos.getDescripcion());
        viewProductos.jtfPrecio_compra.setText(modelProductos.getPrecio_compra());
        viewProductos.jtfPrecio_venta.setText(modelProductos.getPrecio_venta());
    }
}
    
}
