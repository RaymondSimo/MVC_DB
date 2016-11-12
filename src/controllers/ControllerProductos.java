
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import views.View_productos;
import models.ModelProductos;
import sax.DBConnection;
/**
 *
 * @author MATRIX
 */



public class ControllerProductos implements ActionListener {
   
    private final View_productos view_productos;
    private final ModelProductos modelProductos;
    private DBConnection conection = new DBConnection(3306,"localhost", "acme_shop", "root", "1234");
    
    
    public ControllerProductos(View_productos view_productos, ModelProductos modelProductos){
        this.view_productos = view_productos;
        this.modelProductos= modelProductos;
        
        this.view_productos.jbtnFirst.addActionListener(this);
        this.view_productos.jbtnPrevious.addActionListener(this);
        this.view_productos.jbtnNext.addActionListener(this);
        this.view_productos.jbtnLast.addActionListener(this);
        this.view_productos.jbtn_agregar.addActionListener(this);
        this.view_productos.jbtn_buscar.addActionListener(this);
        this.view_productos.jbtn_editar.addActionListener(this);
        this.view_productos.jbtn_eliminar.addActionListener(this);
        this.view_productos.jbtn_guardar.addActionListener(this);
        
        initView();
        showData();
    }
     void Limpiar(){
         while(view_productos.J_tabla.getRowCount()!=0){
             ((DefaultTableModel)view_productos.J_tabla.getModel()).removeRow(0);
         }
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
       
       else if(e.getSource()==view_productos.jbtn_agregar){
         agregarRegistro();
        
       }
       
       
        else if(e.getSource()==view_productos.jbtn_eliminar){
         modelProductos.eliminarValues();
          initView();
          Limpiar();
          showData();
        }
        else if(e.getSource()==view_productos.jbtn_editar){
          editarValues();
           initView();
          Limpiar();
          showData();
        }
       else if(e.getSource()==view_productos.jbtn_guardar){
          guadarRegistro(); 
           initView();
          Limpiar();
          showData();
       }
        
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
     public void agregarRegistro(){
        this.view_productos.jtf_producto.setText("");
        this.view_productos.jtf_descripcion.setText("");
        this.view_productos.jtf_precio_compra.setText("");
        this.view_productos.jtf_precio_venta.setText("");
        this.view_productos.jtf_existencias.setText("");
        this.view_productos.jtf_marca.setText("");
        this.view_productos.jtf_modelo.setText("");
           
    }
     private void showData() {
        view_productos.J_tabla.setModel(modelProductos.tableModel);
         this.modelProductos.Tabla();
          this.modelProductos.setValues();
     }
     public void guadarRegistro() {        
             
             String producto=this.view_productos.jtf_id_producto.getText();
             String descripcion=this.view_productos.jtf_producto.getText(); 
             Integer precio_compra=Integer.parseInt(view_productos.jtf_precio_compra.getText());
             Integer precio_venta=Integer.parseInt(view_productos.jtf_precio_venta.getText());
             Integer existencias=Integer.parseInt(view_productos.jtf_existencias.getText());
             String marca=this.view_productos.jtf_marca.getText();
             String modelo=this.view_productos.jtf_modelo.getText();
       
             

            conection.executeUpdate("insert into productos (producto, descripcion,precio_compra,precio_venta,existencias,Marca,Modelo)"+" values "
                    + "('"+producto+"','"+descripcion+"','"+precio_compra+"','"+precio_venta+"','"+existencias+"','"+marca+"','"+modelo+"');"); 
            
           this.modelProductos.setValues();
           modelProductos.initValues();
           showValues();

    }
    
     public void editarValues(){
         Integer id_producto=Integer.parseInt(view_productos.jtf_id_producto.getText());
         String producto=this.  view_productos.jtf_producto.getText(); 
             String descripcion=this.view_productos.jtf_descripcion.getText();
             Integer precio_compra=Integer.parseInt(  view_productos.jtf_precio_compra.getText());
             Integer precio_venta=Integer.parseInt(view_productos.jtf_precio_venta.getText());
             Integer existencias=Integer.parseInt(view_productos.jtf_existencias.getText());
             String marca=this.view_productos.jtf_marca.getText();
             String modelo=this.view_productos.jtf_modelo.getText();
             
             
             conection.executeUpdate ( "update productos set id_producto='"+id_producto+"',producto='"+producto+"',descripcion='"+descripcion+"',precio_compra='"+precio_compra+"',precio_venta='"+precio_venta+"',existencias='"+existencias+"',marca='"+marca+"',modelo='"+modelo+"'where id_producto='"+this.view_productos.jtf_id_producto.getText()+"';");
       
       this.modelProductos.setValues();
       modelProductos.initValues();
       showValues();
     }
    
    
    private void showValues(){
        view_productos.jtf_id_producto.setText(""+modelProductos.getId_producto());
        view_productos.jtf_producto.setText(modelProductos.getProducto());
        view_productos.jtf_descripcion.setText(modelProductos.getDescripcion());
        view_productos.jtf_precio_compra.setText(""+modelProductos.getPrecio_compra());
        view_productos.jtf_precio_venta.setText(""+modelProductos.getPrecio_venta());
        view_productos.jtf_existencias.setText(""+modelProductos.getExistencias());
        view_productos.jtf_marca.setText(modelProductos.getMarca());
        view_productos.jtf_modelo.setText(modelProductos.getModelo());
    }

}
    

