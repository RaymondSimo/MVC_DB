
package views;

/**
 *
 * @author Raymond SIMOLY
 */
public class ViewMain extends javax.swing.JFrame {

    /**
     * Creates new form ViewMain
     */
    public ViewMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jm_bar = new javax.swing.JMenuBar();
        jm_archivos = new javax.swing.JMenu();
        jmi_iniciar_sesion = new javax.swing.JMenuItem();
        jmiUsuarios = new javax.swing.JMenuItem();
        jm_catalogos = new javax.swing.JMenu();
        jmiClientes = new javax.swing.JMenuItem();
        jmiProductos = new javax.swing.JMenuItem();
        jmiProveedores = new javax.swing.JMenuItem();
        jm_operciones = new javax.swing.JMenu();
        jmiCompras = new javax.swing.JMenuItem();
        jmiVentas = new javax.swing.JMenuItem();
        jm_reportes = new javax.swing.JMenu();
        jm_acerca = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jm_archivos.setText("Archivos");

        jmi_iniciar_sesion.setText("Iniciar sesion");
        jm_archivos.add(jmi_iniciar_sesion);

        jmiUsuarios.setText("Usuarios");
        jm_archivos.add(jmiUsuarios);

        jm_bar.add(jm_archivos);

        jm_catalogos.setText("Catalogos");

        jmiClientes.setText("Clientes");
        jm_catalogos.add(jmiClientes);

        jmiProductos.setText("Productos");
        jm_catalogos.add(jmiProductos);

        jmiProveedores.setText("Proveedores");
        jm_catalogos.add(jmiProveedores);

        jm_bar.add(jm_catalogos);

        jm_operciones.setText("Operacioes");

        jmiCompras.setText("Compras");
        jm_operciones.add(jmiCompras);

        jmiVentas.setText("Ventas");
        jm_operciones.add(jmiVentas);

        jm_bar.add(jm_operciones);

        jm_reportes.setText("Reportes");
        jm_bar.add(jm_reportes);

        jm_acerca.setText("A cerca de");
        jm_bar.add(jm_acerca);

        setJMenuBar(jm_bar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenu jm_acerca;
    public javax.swing.JMenu jm_archivos;
    public javax.swing.JMenuBar jm_bar;
    public javax.swing.JMenu jm_catalogos;
    public javax.swing.JMenu jm_operciones;
    public javax.swing.JMenu jm_reportes;
    public javax.swing.JMenuItem jmiClientes;
    public javax.swing.JMenuItem jmiCompras;
    public javax.swing.JMenuItem jmiProductos;
    public javax.swing.JMenuItem jmiProveedores;
    public javax.swing.JMenuItem jmiUsuarios;
    public javax.swing.JMenuItem jmiVentas;
    public javax.swing.JMenuItem jmi_iniciar_sesion;
    // End of variables declaration//GEN-END:variables
}
