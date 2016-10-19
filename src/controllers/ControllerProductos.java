
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.View_productos;
import models.ModelProductos;
/**
 *
 * @author MATRIX
 */



public class ControllerProductos implements ActionListener {
    
    private final View_productos view_productos;
    private final ModelProductos modelProductos;
    
    
    public ControllerProductos(View_productos view_productos, ModelProductos modelProductos){
        this.view_productos = view_productos;
        this.modelProductos= modelProductos;
        
        this.view_productos.jbtnFirst.addActionListener(this);
        this.view_productos.jbtnPrevious.addActionListener(this);
        this.view_productos.jbtnNext.addActionListener(this);
        this.view_productos.jbtnLast.addActionListener(this);
        
        initView();
    }
            
    private void initView(){
        modelProductos.initValues();
        showValues();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==view_productos.jbtnFirst)
           jbtnFirstActionPerformed();
       else if(e.getSource()==view_productos.jbtnPrevious)
           jbtnPreviousActionPerformed();
       else if(e.getSource()==view_productos.jbtnNext)
           jbtnNextActionPerformed();
       else if(e.getSource()==view_productos.jbtnLast)
           jbtnLastActionPerformed();
    }
    
    private void jbtnFirstActionPerformed(){
        modelProductos.moveFirst();
        showValues();
    }
    
    private void jbtnPreviousActionPerformed(){
        modelProductos.movePrevious();
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
        view_productos.jtf_id_productos.setText(""+modelProductos.getId_producto());
        view_productos.jtf_producto.setText(modelProductos.getProducto());
        view_productos.jtf_descripcion.setText(modelProductos.getDescripcion());
        view_productos.jtf_precio_compra.setText(modelProductos.getPrecio_compra());
        view_productos.jtf_precio_venta.setText(modelProductos.getPrecio_venta());
    }
}
    

