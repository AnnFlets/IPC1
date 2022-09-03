/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

/**
 *
 * @author Ana
 */
public class FrmRegistroCliente extends javax.swing.JFrame {

    /**
     * Creates new form FrmRegistroCliente
     */
    public FrmRegistroCliente() {
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

        jopMensajeRC = new javax.swing.JOptionPane();
        txtApellidoRC = new javax.swing.JTextField();
        txtCuiRC = new javax.swing.JTextField();
        txtNombreRC = new javax.swing.JTextField();
        lblApellidoRC = new javax.swing.JLabel();
        lblCuiRC = new javax.swing.JLabel();
        lblNombreRC = new javax.swing.JLabel();
        btnCrearRC = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear cliente");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtApellidoRC, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 310, -1));
        getContentPane().add(txtCuiRC, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 63, 310, -1));
        getContentPane().add(txtNombreRC, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 310, -1));

        lblApellidoRC.setText("Apellido");
        getContentPane().add(lblApellidoRC, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, -1, -1));

        lblCuiRC.setText("CUI");
        getContentPane().add(lblCuiRC, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        lblNombreRC.setText("Nombre");
        getContentPane().add(lblNombreRC, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        btnCrearRC.setText("CREAR");
        getContentPane().add(btnCrearRC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

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
            java.util.logging.Logger.getLogger(FrmRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegistroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCrearRC;
    public javax.swing.JOptionPane jopMensajeRC;
    private javax.swing.JLabel lblApellidoRC;
    private javax.swing.JLabel lblCuiRC;
    private javax.swing.JLabel lblNombreRC;
    public javax.swing.JTextField txtApellidoRC;
    public javax.swing.JTextField txtCuiRC;
    public javax.swing.JTextField txtNombreRC;
    // End of variables declaration//GEN-END:variables
}
