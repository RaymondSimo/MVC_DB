package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.ModelClientes;
import views.ViewClientes;
import sax.DBConnection;

/**
 *
 * @author Raymond SIMOLY
 */
public class ControllerClientes implements ActionListener, KeyListener, ItemListener{

    private final ModelClientes modelClientes;
    private final ViewClientes viewClientes;
    private DBConnection conection = new DBConnection(3306, "localhost", "acme_shop", "root", "1234");
    private TableRowSorter trsFiltro;
    public ControllerClientes(ViewClientes viewClientes, ModelClientes modelClientes) {
        this.modelClientes = modelClientes;
        this.viewClientes = viewClientes;

        this.viewClientes.jbtn_agregar.addActionListener(this);
        this.viewClientes.jbtn_anterior.addActionListener(this);
        this.viewClientes.jbtn_editar.addActionListener(this);
        this.viewClientes.jbtn_eliminar.addActionListener(this);
        this.viewClientes.jbtn_primero.addActionListener(this);
        this.viewClientes.jbtn_siguiente.addActionListener(this);
        this.viewClientes.jbtn_ultimo.addActionListener(this);
        //this.viewClientes.jbtn_buscar.addActionListener(this);
        this.viewClientes.jbtn_guardar.addActionListener(this);
       
        this.viewClientes.comboFiltro.addItemListener(this);
        
        this.viewClientes.txtFiltro.addKeyListener(this);
        
        initView();
        
        showData();
    }

    private void initView() {
        modelClientes.initValues();
        showValues();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == viewClientes.jbtn_primero) {
            jbtnFirstActionPerformed();
        } else if (ae.getSource() == viewClientes.jbtn_anterior) {
            jbtnPreviousActionPerformed();
        } else if (ae.getSource() == viewClientes.jbtn_siguiente) {
            jbtnNextActionPerformed();
        } else if (ae.getSource() == viewClientes.jbtn_ultimo) {
            jbtnLastActionPerformed();
        } else if (ae.getSource() == viewClientes.jbtn_agregar) {
            agregarRegistro();
        } else if (ae.getSource() == viewClientes.jbtn_guardar) {
            guadarRegistro();
            
           this.modelClientes.Tabla();
            System.out.println("Bravo");
        } else if (ae.getSource() == viewClientes.jbtn_eliminar) {
            jbtnEliminarActionPerformed();
            
            this.modelClientes.Tabla();
            System.out.println("Excelente");
        } else if (ae.getSource() == viewClientes.jbtn_editar) {
            editarValues();
            
            this.modelClientes.Tabla();
            System.out.println("Muy bien");
        }
        
        

    }

    private void jbtnFirstActionPerformed() {
        modelClientes.moveFirst();
        showValues();
    }

    private void jbtnPreviousActionPerformed() {
        modelClientes.movePrevious();
        showValues();
    }

    private void jbtnNextActionPerformed() {
        modelClientes.moveNext();
        showValues();
    }

    private void jbtnLastActionPerformed() {
        modelClientes.moveLast();
        showValues();
    }

    private void jbtnEliminarActionPerformed() {
        modelClientes.eliminarValues();
        showValues();
    }

    public void agregarRegistro() {
        this.viewClientes.jtf_nombre.setText("");
        this.viewClientes.jtf_ap_paternno.setText("");
        this.viewClientes.jtf_ap_materno.setText("");
        this.viewClientes.jtf_telefono.setText("");
        this.viewClientes.jtf_email.setText("");
        this.viewClientes.jtf_rfc.setText("");
        this.viewClientes.jtf_calle.setText("");
        this.viewClientes.jtf_numero.setText("");
        this.viewClientes.jtf_colonia.setText("");
        this.viewClientes.jtf_ciudad.setText("");
        this.viewClientes.jtf_estado.setText("");
        
    }

    public void guadarRegistro() {

        String nombre = this.viewClientes.jtf_nombre.getText();
        String ap_paterno = this.viewClientes.jtf_ap_materno.getText();
        String ap_materno = this.viewClientes.jtf_ap_paternno.getText();
        String telefono = this.viewClientes.jtf_telefono.getText();
        String email = this.viewClientes.jtf_email.getText();
        String rfc = this.viewClientes.jtf_rfc.getText();
        String calle = this.viewClientes.jtf_calle.getText();
        Integer numero = Integer.parseInt(viewClientes.jtf_numero.getText());
        String colonia = this.viewClientes.jtf_colonia.getText();
        String ciudad = this.viewClientes.jtf_ciudad.getText();
        String estado = this.viewClientes.jtf_estado.getText();

        conection.executeUpdate("insert into clientes (nombre,ap_paterno,ap_materno,telefono,email,rfc,calle,numero,colonia,ciudad,estado)" + " values "
                + "('" + nombre + "','" + ap_paterno + "','" + ap_materno + "','" + telefono + "','" + email + "','" + rfc + "','" + calle + "','" + numero + "','" + colonia + "','" + ciudad + "','" + estado + "');");

        this.modelClientes.setValues();

        modelClientes.initValues();
        
    }

    private void showData() {
        this.modelClientes.limpiaTabla();
        
        viewClientes.J_tabla.setModel(modelClientes.tableModel);

    }

    public void editarValues() {
        Integer id_cliente = Integer.parseInt(viewClientes.jtf_id_cliente.getText());
        String nombre = this.viewClientes.jtf_nombre.getText();
        String ap_paterno = this.viewClientes.jtf_ap_materno.getText();
        String ap_materno = this.viewClientes.jtf_ap_paternno.getText();
        String telefono = this.viewClientes.jtf_telefono.getText();
        String email = this.viewClientes.jtf_email.getText();
        String rfc = this.viewClientes.jtf_rfc.getText();
        String calle = this.viewClientes.jtf_calle.getText();
        Integer numero = Integer.parseInt(viewClientes.jtf_numero.getText());
        String colonia = this.viewClientes.jtf_colonia.getText();
        String ciudad = this.viewClientes.jtf_ciudad.getText();
        String estado = this.viewClientes.jtf_estado.getText();

        conection.executeUpdate("update clientes set nombre='" + nombre + "',ap_paterno='" + ap_paterno + "',ap_materno='" + ap_materno + "',telefono='" + telefono + "',email='" + email + "',rfc='" + rfc + "',calle='" + calle + "',numero='" + numero + "',colonia='" + colonia + "',ciudad='" + ciudad + "',estado='" + estado + "' where id_cliente='" + this.viewClientes.jtf_id_cliente.getText() + "';");

        this.modelClientes.setValues();

        modelClientes.initValues();
       
    }

    private void showValues() {
        viewClientes.jtf_id_cliente.setText("" + modelClientes.getId_cliente());
        viewClientes.jtf_nombre.setText(modelClientes.getNombre());
        viewClientes.jtf_ap_paternno.setText(modelClientes.getAp_paterno());
        viewClientes.jtf_ap_materno.setText(modelClientes.getAp_materno());
        viewClientes.jtf_telefono.setText("" + modelClientes.getTelefono());
        viewClientes.jtf_email.setText(modelClientes.getEmail());
        viewClientes.jtf_rfc.setText(modelClientes.getRfc());
        viewClientes.jtf_calle.setText(modelClientes.getCalle());
        viewClientes.jtf_numero.setText("" + modelClientes.getNumero());
        viewClientes.jtf_colonia.setText(modelClientes.getColonia());
        viewClientes.jtf_ciudad.setText(modelClientes.getCiudad());
        viewClientes.jtf_estado.setText(modelClientes.getEstado());

    }
    public void Actualizar(){
        Integer id_cliente = Integer.parseInt(viewClientes.jtf_id_cliente.getText());
        String nombre = this.viewClientes.jtf_nombre.getText();
        String ap_paterno = this.viewClientes.jtf_ap_materno.getText();
        String ap_materno = this.viewClientes.jtf_ap_paternno.getText();
        String telefono = this.viewClientes.jtf_telefono.getText();
        String email = this.viewClientes.jtf_email.getText();
        String rfc = this.viewClientes.jtf_rfc.getText();
        String calle = this.viewClientes.jtf_calle.getText();
        Integer numero = Integer.parseInt(viewClientes.jtf_numero.getText());
        String colonia = this.viewClientes.jtf_colonia.getText();
        String ciudad = this.viewClientes.jtf_ciudad.getText();
        String estado = this.viewClientes.jtf_estado.getText();
        try {
         conection.executeUpdate("UPDATE clientes SET id_cliente='"+id_cliente+"',nombre='"+nombre+"',ap_paterno='"+ap_paterno+"',ap_materno='"+ap_materno+"',telefono='"+telefono+"',email='"+email+"',rfc='"+rfc+"',calle='"+calle+"',calle='"+calle+"',numero='"+numero+"',colonia='"+colonia+"',ciudad='"+ciudad+"',estado='"+estado+"' WHERE id_cliente='" +this.viewClientes.jtf_id_cliente.getText()+"';");
       
        this.modelClientes.setValues();
    } catch (Exception e) {
        System.out.print(e.getMessage());
    }
 
}
    public void filtro() {
        int columnaABuscar = 0;
        
        if (viewClientes.comboFiltro.getSelectedItem() == "id_cliente") {
            columnaABuscar = 0;
        }
        if (viewClientes.comboFiltro.getSelectedItem().toString() == "Nombre") {
            columnaABuscar = 1;
        }
        if (viewClientes.comboFiltro.getSelectedItem() == "Ap_paterno") {
            columnaABuscar = 2;
        }
        if (viewClientes.comboFiltro.getSelectedItem() == "Ap_materno") {
            columnaABuscar = 3;
        }
        if (viewClientes.comboFiltro.getSelectedItem() == "Telefono") {
            columnaABuscar = 4;
        }
        if (viewClientes.comboFiltro.getSelectedItem() == "Email") {
            columnaABuscar = 5;
        }
        if (viewClientes.comboFiltro.getSelectedItem() == "RFC") {
            columnaABuscar = 6;
        }
        if (viewClientes.comboFiltro.getSelectedItem() == "Calle") {
            columnaABuscar = 7;
        }
        if (viewClientes.comboFiltro.getSelectedItem() == "Numero") {
            columnaABuscar = 8;
        }
        if (viewClientes.comboFiltro.getSelectedItem() == "Colonia") {
            columnaABuscar = 9;
        }
        if (viewClientes.comboFiltro.getSelectedItem() == "Ciudad") {
            columnaABuscar = 10;
        }
        if (viewClientes.comboFiltro.getSelectedItem() == "Estado") {
            columnaABuscar = 11;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(viewClientes.txtFiltro.getText(), columnaABuscar));
    }
    
    
    


    @Override
    public void keyTyped(KeyEvent ke) {
        viewClientes.txtFiltro.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (viewClientes.txtFiltro.getText());
                viewClientes.txtFiltro.setText(cadena);
                viewClientes.repaint();
                filtro();
            }
        });
        trsFiltro = new TableRowSorter(viewClientes.J_tabla.getModel());
        viewClientes.J_tabla.setRowSorter(trsFiltro);
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
       
    }
    public void llenarTabla(){
        /*DefaultTableModel modeloT =new DefaultTableModel(new String [] {"id_cliente", "nombre","ap_paterno","ap_materno","telefono","email","rfc","calle","numero","colonia","ciudad","estado"}, 0);
        viewClientes.J_tabla.setModel(modeloT);
        modeloT.fireTableRowsUpdated(0,modelClientes.getId_cliente());
        modeloT.findColumn(modelClientes.getNombre());
        modeloT.findColumn(modelClientes.getAp_materno());
        modeloT.findColumn(modelClientes.getAp_materno());
        modeloT.findColumn(modelClientes.getTelefono());
        modeloT.findColumn(modelClientes.getEmail());
        modeloT.findColumn(modelClientes.getRfc());
        modeloT.findColumn(modelClientes.getCalle());
        modeloT.findColumn(modelClientes.getNombre());
        modeloT.findColumn(modelClientes.getColonia());
        modeloT.findColumn(modelClientes.getCiudad());
        modeloT.findColumn(modelClientes.getEstado());
        
        Object[] column=new Object[12];*/
        modelClientes.limpiaTabla();
        
        modelClientes.setValues();
        
        
    }
    };
    


