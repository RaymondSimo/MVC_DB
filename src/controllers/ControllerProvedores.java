package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.View_provedores;
import models.ModelProvedores;
import sax.DBConnection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.HashMap;

public class ControllerProvedores implements ActionListener {

//    private Connection conexion;
//    private Statement st;
//    private ResultSet rs;
    private final View_provedores view_provedores;
    private final ModelProvedores modelProvedores;

//    DBConnection dbCon = new DBConnection(3306, "localhost", "acme_shop", "root", "1234");
    //
    public ControllerProvedores(View_provedores viewProvedores, ModelProvedores modelProvedores) {
        this.modelProvedores = modelProvedores;
        this.view_provedores = viewProvedores;

        this.view_provedores.jbtn_firds.addActionListener(this);
        this.view_provedores.jbtn_anterior.addActionListener(this);
        this.view_provedores.jbtn_buscar.addActionListener(this);
        this.view_provedores.jbtn_editar.addActionListener(this);
        this.view_provedores.jbtn_eliminar.addActionListener(this);
        this.view_provedores.jbtn_ultimo.addActionListener(this);
        this.view_provedores.jbtn_siguiente.addActionListener(this);
        this.view_provedores.jbtn_agregar.addActionListener(this);

        initView();
    }

    private void initView() {
        modelProvedores.initValues();
//        HashMap m = modelProvedores.conection.getTableList();
//        System.out.println(m.toString());
//        
//        HashMap m1 = modelProvedores.conection.getAllRow("proveedores", 5);
//        System.out.println(m1.toString());
//        
        showValues();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view_provedores.jbtn_firds) {
            jbtnFirstActionPerformed();
            System.out.println("First");
        } else if (e.getSource() == view_provedores.jbtn_anterior) {
            jbtnPreviousActionPerformed();
            System.out.println("Anteripr");
        } else if (e.getSource() == view_provedores.jbtn_siguiente) {
            jbtnNextActionPerformed();
            System.out.println("siguiente");
        } else if (e.getSource() == view_provedores.jbtn_ultimo) {
            jbtnLastActionPerformed();
            System.out.println("ultimo");
        }
    }

    private void jbtnFirstActionPerformed() {
        modelProvedores.moveFirst();
        showValues();
    }

    private void jbtnPreviousActionPerformed() {
        modelProvedores.movePrevious();
        showValues();
    }

    private void jbtnNextActionPerformed() {
        modelProvedores.moveNext();
        showValues();
    }

    private void jbtnLastActionPerformed() {
        modelProvedores.moveLast();
        showValues();
    }

    private void showValues() {
        modelProvedores.setValues();
        view_provedores.jtf_id_proveedor.setText("" + modelProvedores.getId_proveedor());
        view_provedores.jtf_nombre.setText(modelProvedores.getNombre());
        view_provedores.jtf_rfc.setText(modelProvedores.getRfc());
        view_provedores.jtf_calle.setText(modelProvedores.getCalle());
        view_provedores.jtf_numero.setText("" + modelProvedores.getNumero());
        view_provedores.jtf_colonia.setText("" + modelProvedores.getColonia());
        view_provedores.jtf_ciudad.setText("" + modelProvedores.getCiudad());
        view_provedores.jtf_estado.setText(modelProvedores.getEstado());
        view_provedores.jtf_nombre_cont.setText(modelProvedores.getNombre_contacto());
        view_provedores.jtf_telefono.setText("" + modelProvedores.getTelefono());
        view_provedores.jtf_email.setText(modelProvedores.getEmail());

    }

}
