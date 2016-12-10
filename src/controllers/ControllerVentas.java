
package controllers;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.ModelVentas;
import views.ViewVentas;
import models.Model_users;
import sax.DBConnection;
import views.ViewUsuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
/**
 *
 * @author Raymond SIMOLY
 */
public class ControllerVentas  implements ActionListener{
    private final ModelVentas modelVentas;
    private final ViewVentas viewVentas;
    ViewUsuarios viewUuario =new ViewUsuarios();
    Model_users model_users= new Model_users();
    DefaultTableModel modelo= new DefaultTableModel();
    private DBConnection conection = new DBConnection(3306, "localhost", "acme_shop", "root", "1234");
   private Connection conectar;
    private ResultSet rs;
    private Connection conexion;    
    private Statement st; 
    
    /**
     *
     * @param viewVentas
     * @param modelVentas
     */
    public ControllerVentas(ViewVentas viewVentas, ModelVentas modelVentas){
        this.modelVentas = modelVentas;
        this.viewVentas= viewVentas;
        this.viewVentas.jbtn_buscar_id_producto.addActionListener(this);
        this.viewVentas.jbtn_cancelar_venta.addActionListener(this);
        this.viewVentas.jbtn_cerrar_venta.addActionListener(this);
        this.viewVentas.jbtn_masP.addActionListener(this);
        this.viewVentas.jbtn_buscar_cliente.addActionListener(this);
        this.viewVentas.jbtn_nueva_venta.addActionListener(this);
        this.viewVentas.jbtn_buscar_rfc.addActionListener(this);
        this.viewVentas.jbtn_calcularV.addActionListener(this);
        this.viewVentas.jbtn_terminarV.addActionListener(this);
        this.viewVentas.jtf_cantidad.addKeyListener(keyAdapter);
        this.viewVentas.jtf_id_cliente.addKeyListener(keyAdapter);
        this.viewVentas.jtf_id_product.addKeyListener(keyAdapter);
        
        initView1();
       showValues1();
    }
    private void initView1() {
        this.viewVentas.jtf_fecha.setText(this.modelVentas.FechaActual());
        this.viewVentas.jtf_hora.setText(this.modelVentas.HoraActual());
        
    }
    private void initView2() {
        modelVentas.conntectedCostumer(Integer.parseInt(viewVentas.jtf_id_cliente.getText()));
       showValues2();
    }
     private void initView3() {
        modelVentas.conntectedCostum(viewVentas.jtf_rfc.getText());
       showValues2();
    }private void initView4() {
       conProducto(Integer.parseInt(viewVentas.jtf_id_product.getText()));
        this.viewVentas.jtf_precioP.setText(""+modelVentas.getPrecio_producto());
       showValues3();
    }
    
        public void calculPrecio(){
        this.modelVentas.setCantidad_producto(Integer.parseInt(""+this.viewVentas.jtf_cantidad.getText()));
        this.modelVentas.setPrecio_producto(Integer.parseInt(""+this.viewVentas.jtf_precioP.getText()));
        this.viewVentas.jtf_cantidad_por_P.setText(""+this.modelVentas.subtotal());
        
    }

     

    @Override
    public void actionPerformed(ActionEvent ae) {
        
       if(ae.getSource()==viewVentas.jbtn_buscar_cliente){
           
               initView2();
            
           
         //viewVentas.jtf_vendedor.setText(model_users.getNombre());
        
           //System.out.println(viewUuario.jtf_usuario.getText());
      //  viewVentas.jtf_id_usuario.setText(""+model_users.getId_usuario());
         
       }
       else if(ae.getSource()==viewVentas.jbtn_buscar_rfc){
           
           initView3();
       }
       else if(ae.getSource()==viewVentas.jbtn_buscar_id_producto){
           initView4();
           
       }
       else if(ae.getSource()==viewVentas.jbtn_calcularV){
          if("".equals(viewVentas.jtf_cliente.getText()))
          {
          JOptionPane.showMessageDialog(null, "No puede vender sin los datos del cliente:" );  
          }
          else if("".equals(viewVentas.jtf_cantidad.getText())){
            JOptionPane.showMessageDialog(null, "Tiene que buscar un producto y ingresar una cantidad:" );  
          }
          else  if(Double.parseDouble(viewVentas.jtf_cantidad.getText())>Double.parseDouble(viewVentas.jtf_existencia.getText()))
          {
             JOptionPane.showMessageDialog(null, "La cantidad que ingrese no existe:" );
            viewVentas.jtf_cantidad_por_P.setText("");
             viewVentas.jtf_subtotal.setText("");
         
        }
          else{
         double resto=Double.parseDouble(viewVentas.jtf_existencia.getText())-Double.parseDouble(viewVentas.jtf_cantidad.getText());
        JOptionPane.showMessageDialog(null, "Ahora existe(n) solo:" +resto+ "de este producto");
        desContar();
        calculPrecio();
           verTable();
           total();
           Habilitar();
           guadarVentas();
           
           
          }
          
       }
       else if(ae.getSource()==viewVentas.jbtn_masP){
          masProducto();
          JOptionPane.showMessageDialog(null, "Ingrese el id del nuevo producto");
       }
       else if(ae.getSource()==viewVentas.jbtn_nueva_venta){
           cleanViewer();
            modelVentas.verTable();
       }
       else if(ae.getSource()==viewVentas.jbtn_cerrar_venta){
           cerrarVenta();
       }
       else if(ae.getSource()==viewVentas.jbtn_cancelar_venta){
           
           RollBk();
       }
       else if(ae.getSource()==viewVentas.jbtn_terminarV){
        ComIt();
        generarNumeroFactura();
        insertardetalleVenta();
        this.viewVentas.jtf_NumF.setEditable(false);
      }
    }
    
    public void masProducto(){
        viewVentas.jtf_nombreP.setText("");
        viewVentas.jtf_precioP.setText("");
        viewVentas.jtf_existencia.setText("");
        viewVentas.jtf_cantidad.setText("");
        viewVentas.jtf_cantidad_por_P.setText("");
    }
    public void cerrarVenta(){
        //this.exit();
        Window w = SwingUtilities.getWindowAncestor(this.viewVentas);
        w.setVisible(false);
    }
    private void verTable(){
        viewVentas.jTable.setModel(modelVentas.tableModel);
        modelVentas.verTabla();
    }
    
     private void showValues1() {
        modelVentas.initValues1();
        this.viewVentas.jtf_vendedor.setText(this.modelVentas.getVendedor());
        this.viewVentas.jtf_id_usuario.setText(""+this.modelVentas.getId_usuario());
       
    }
     private void showValues2() {
     //viewVentas.jtf_id_cliente.setText(""+this.modelVentas.getId_cliente());
    viewVentas.jtf_cliente.setText(modelVentas.getCliente());
     viewVentas.jtf_telefono.setText(modelVentas.getTelefono());
     viewVentas.jtf_calle.setText(modelVentas.getCalle());
     viewVentas.jtf_numero.setText("" + modelVentas.getNumero());
     viewVentas.jtf_colonia.setText(modelVentas.getColonia());
     viewVentas.jtf_ciudad.setText(modelVentas.getCiudad());
     viewVentas.jtf_estado.setText(modelVentas.getEstado());

     }
     public void StartTr(){
        conection.executeQuery("Start transaction");
     }
     public void RollBk(){
         
      int confirm = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea cancelar este registro?", "Aviso", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION)
            
        
        conection.executeQuery("Rollback");
        JOptionPane.showMessageDialog(null, "El registro se ha cancelado con exito");
     }
     public void ComIt(){
        int confirm = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea guardar este registro?", "Aviso", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION)
        conection.executeQuery("Commit");
        JOptionPane.showMessageDialog(null, "El registro se ha guardado definitivamente");
         
     }
     public void desContar(){
     int cant=Integer.parseInt(viewVentas.jtf_cantidad.getText());
     int existentes=Integer.parseInt(this.viewVentas.jtf_existencia.getText());
     int existancia=existentes-cant;
                    
      conection.executeUpdate("update productos set existencias='"+existancia+"' where id_producto='"+viewVentas.jtf_id_product.getText()+"';" );
        
     }
     
      private void showValues3() {
      
      viewVentas.jtf_nombreP.setText(modelVentas.getNombre_producto());
      viewVentas.jtf_precioP.setText(""+this.modelVentas.getPrecio_producto());
      viewVentas.jtf_existencia.setText(""+this.modelVentas.getExistencia());
      
      
      }
      public void conProducto(int id_producto){
        String query="SELECT * FROM productos WHERE id_producto='"+id_producto+"'";
        modelVentas.conection.executeQuery(query);
        modelVentas.conection.moveNext();
        modelVentas.setValues3();
        
          
      }
        public void total(){
        double sub=0;
        double iva=0;
        double cantT=0;
       
         
        for(int i=0; i<viewVentas.jTable.getRowCount();i++){
        sub=sub+Double.parseDouble(modelVentas.tableModel.getValueAt(i,4).toString());
           
        }
        viewVentas.jtf_subtotal.setText(String.valueOf(sub));
         iva=(sub*10)/100;
         viewVentas.jtf_iva.setText(String.valueOf(iva));
         cantT=sub+iva;
         viewVentas.jtf_total.setText(String.valueOf(cantT));

    }
         public void guadarVentas() {
         int confirm = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desa guardar esta venta?", "Aviso", JOptionPane.YES_NO_OPTION);
         if(confirm == JOptionPane.YES_OPTION)
        StartTr();
        conection.executeUpdate("insert into ventas (fecha,id_cliente,IVA,subtotal,total)"+ " values "
                + "('"+viewVentas.jtf_fecha.getText()+"','"+viewVentas.jtf_id_cliente.getText()+"','"+viewVentas.jtf_iva.getText()+"','"+viewVentas.jtf_subtotal.getText()+"','"+viewVentas.jtf_total.getText()+"');");
        
    }
         public void insertardetalleVenta() {
       
        conection.executeUpdate("insert into detalle_venta (id_venta,id_producto,cantidad,total_producto,precio)"+ " values "
                + "('"+viewVentas.jtf_NumF.getText()+"','"+viewVentas.jtf_id_product.getText()+"','"+viewVentas.jtf_cantidad.getText()+"','"+viewVentas.jtf_subtotal.getText()+"','"+viewVentas.jtf_precioP.getText()+"');");
        
    }
     public  void Habilitar(){
   this.viewVentas.jtf_calle.setEditable(false);
    this.viewVentas.jtf_ciudad.setEditable(false);
    this.viewVentas.jtf_cliente.setEditable(false);
    this.viewVentas.jtf_estado.setEditable(false);
    this.viewVentas.jtf_colonia.setEditable(false);
    this.viewVentas.jtf_nombreP.setEditable(false);
    this.viewVentas.jtf_numero.setEditable(false);
     this.viewVentas.jtf_precioP.setEditable(false);
    this.viewVentas.jtf_existencia.setEditable(false);
    this.viewVentas.jtf_telefono.setEditable(false);
    this.viewVentas.jtf_cantidad_por_P.setEditable(false);
    this.viewVentas.jtf_iva.setEditable(false);
    this.viewVentas.jtf_subtotal.setEditable(false);
    this.viewVentas.jtf_total.setEditable(false);
    this.viewVentas.jtf_id_usuario.setEditable(false);
    this.viewVentas.jtf_vendedor.setEditable(false);
    this.viewVentas.jtf_fecha.setEditable(false);
    this.viewVentas.jtf_hora.setEditable(false);
    this.viewVentas.jtf_cantidad.requestFocus();
    
}
         public void cleanViewer(){
             this.viewVentas.jtf_calle.setText("");
             this.viewVentas.jtf_cantidad_por_P.setText("");
             this.viewVentas.jtf_ciudad.setText("");
             this.viewVentas.jtf_cliente.setText("");
             this.viewVentas.jtf_colonia.setText("");
             this.viewVentas.jtf_estado.setText("");
             this.viewVentas.jtf_existencia.setText("");
             this.viewVentas.jtf_id_cliente.setText("");
             this.viewVentas.jtf_iva.setText("");
             this.viewVentas.jtf_nombreP.setText("");
             this.viewVentas.jtf_numero.setText("");
             this.viewVentas.jtf_precioP.setText("");
             this.viewVentas.jtf_rfc.setText("");
             this.viewVentas.jtf_subtotal.setText("");
             this.viewVentas.jtf_telefono.setText("");
             this.viewVentas.jtf_total.setText("");
             this.viewVentas.jtf_cantidad.setText("");
            
         }
         
        void generarNumeroFactura(){
        try {
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/acme_shop", "root", "1234");
        String sql ="SELECT id_venta FROM ventas ORDER BY id_venta DESC LIMIT 1";
         
        st = conexion.createStatement(); 
            java.sql.Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                viewVentas.jtf_NumF.setText(rs.getString("id_venta"));
            
            }
                                  
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        private final KeyAdapter keyAdapter = new java.awt.event.KeyAdapter() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (((c < '0') || (c > '9')) && (c != '\b') && (c != '.')) {
                evt.consume();  // ignorar el evento de teclado
            }
        }
    };
        /*public void reporteVenta(){
            try
        {
            
        
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/acme_shop","root","1234"); 
            
             String sql= "SELECT * FROM ventas";
     JasperReport  Report = JasperCompileManager.compileReport("C:\\Users\\Raymond SIMOLY\\Desktop\\Database cuarto\\MC\\MVC_DB\\src\\Reportes\\reporteVenta.jrxml"); 
       JasperPrint   mostrarReporte=JasperFillManager.fillReport(Report,null,conexion);
        JasperViewer viewReport= new  JasperViewer(mostrarReporte);
        viewReport.setTitle("Mi primer Reporte");
        viewReport.setExtendedState(Frame.MAXIMIZED_BOTH);
        viewReport.setVisible(true);
         }catch(Exception e)
         {
         
         }
        }
        @Override
      public void keyTyped(KeyEvent ke) {
        viewVentas.jtf_cancelar_venta.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String codigo = (viewVentas.jtf_cancelar_venta.getText());
                viewVentas.jtf_cancelar_venta.setText(codigo);
                viewVentas.jtf_cancelar_venta.repaint();
                filtro();
            }
        });
    }
      public void filtro(){
          int code=1234;
      }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }*/
     
       
    
}
