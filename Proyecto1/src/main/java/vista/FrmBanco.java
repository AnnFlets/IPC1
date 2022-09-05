/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

/**
 *
 * @author Ana
 */
public class FrmBanco extends javax.swing.JFrame {

    /**
     * Creates new form FrmBanco
     */
    public FrmBanco() {
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

        jopMensaje = new javax.swing.JOptionPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCuiCCl = new javax.swing.JTextField();
        txtNombreCCl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtApellidoCCl = new javax.swing.JTextField();
        btnCrearCCl = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cmbClienteCCu = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnCrearCCu = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientesMC = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtCuiMC = new javax.swing.JTextField();
        btnBuscarCuentasMC = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCuentasAsociadasMC = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        cmbCuentaD = new javax.swing.JComboBox<>();
        txtMontoD = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAceptarD = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnA = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        cmbCuentaDebitarPS = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbTipoServicioPS = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtMontoPS = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnAceptarPS = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Banco");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jTabbedPane1.addTab("Inicio", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("CUI");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));
        jPanel2.add(txtCuiCCl, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 290, -1));

        txtNombreCCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCClActionPerformed(evt);
            }
        });
        jPanel2.add(txtNombreCCl, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 290, -1));

        jLabel2.setText("Nombre");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));

        jLabel3.setText("Apellido");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));
        jPanel2.add(txtApellidoCCl, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 290, -1));

        btnCrearCCl.setText("CREAR");
        jPanel2.add(btnCrearCCl, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, -1, -1));

        jTabbedPane1.addTab("Crear cliente", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.add(cmbClienteCCu, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 360, -1));

        jLabel4.setText("Cliente");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        btnCrearCCu.setText("CREAR");
        btnCrearCCu.setEnabled(false);
        jPanel3.add(btnCrearCCu, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, -1, -1));

        jTabbedPane1.addTab("Crear cuenta", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblClientesMC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CUI", "Nombre", "Apellido"
            }
        ));
        jScrollPane1.setViewportView(tblClientesMC);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 650, 270));

        jLabel5.setText("CUI");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, -1, -1));
        jPanel4.add(txtCuiMC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 320, -1));

        btnBuscarCuentasMC.setText("BUSCAR CUENTAS ASOCIADAS");
        btnBuscarCuentasMC.setEnabled(false);
        jPanel4.add(btnBuscarCuentasMC, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 260, 40));

        tblCuentasAsociadasMC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cuentas asociadas"
            }
        ));
        jScrollPane2.setViewportView(tblCuentasAsociadasMC);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 320, 140));

        jTabbedPane1.addTab("Mostrar clientes", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.add(cmbCuentaD, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 340, -1));
        jPanel5.add(txtMontoD, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 340, -1));

        jLabel6.setText("Cuenta");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        jLabel7.setText("Monto");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));

        btnAceptarD.setText("ACEPTAR");
        btnAceptarD.setEnabled(false);
        jPanel5.add(btnAceptarD, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, -1));

        jTabbedPane1.addTab("Depósito", jPanel5);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnA.setText("A");
        jPanel6.add(btnA, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        jTabbedPane1.addTab("Transferencia", jPanel6);

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.add(cmbCuentaDebitarPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 360, -1));

        jLabel8.setText("Cuenta a debitar");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        cmbTipoServicioPS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Luz eléctrica", "Agua", "Servicio telefónico" }));
        jPanel7.add(cmbTipoServicioPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 360, -1));

        jLabel9.setText("Monto");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, -1));
        jPanel7.add(txtMontoPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 360, -1));

        jLabel10.setText("Tipo de servicio");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, -1, -1));

        btnAceptarPS.setText("ACEPTAR");
        btnAceptarPS.setEnabled(false);
        jPanel7.add(btnAceptarPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, -1, -1));

        jTabbedPane1.addTab("Pago de servicios", jPanel7);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Detalle", "Crédito", "Débito", "Saldo disponible"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jPanel8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 710, 260));
        jPanel8.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 230, -1));
        jPanel8.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 230, -1));
        jPanel8.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 230, -1));

        jLabel11.setText("CUI");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        jLabel12.setText("Apellido");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, -1, -1));

        jLabel13.setText("Nombre");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));

        jTabbedPane1.addTab("Historial", jPanel8);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 750, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreCClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCClActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCClActionPerformed

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
            java.util.logging.Logger.getLogger(FrmBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBanco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnA;
    public javax.swing.JButton btnAceptarD;
    public javax.swing.JButton btnAceptarPS;
    public javax.swing.JButton btnBuscarCuentasMC;
    public javax.swing.JButton btnCrearCCl;
    public javax.swing.JButton btnCrearCCu;
    public javax.swing.JComboBox<String> cmbClienteCCu;
    public javax.swing.JComboBox<String> cmbCuentaD;
    public javax.swing.JComboBox<String> cmbCuentaDebitarPS;
    public javax.swing.JComboBox<String> cmbTipoServicioPS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    public javax.swing.JOptionPane jopMensaje;
    public javax.swing.JTable tblClientesMC;
    public javax.swing.JTable tblCuentasAsociadasMC;
    public javax.swing.JTextField txtApellidoCCl;
    public javax.swing.JTextField txtCuiCCl;
    public javax.swing.JTextField txtCuiMC;
    public javax.swing.JTextField txtMontoD;
    public javax.swing.JTextField txtMontoPS;
    public javax.swing.JTextField txtNombreCCl;
    // End of variables declaration//GEN-END:variables
}
