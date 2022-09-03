package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import modelo.ClienteDAO;
import modelo.ClienteVO;
import vista.FrmRegistroCliente;

public class ControladorRegistroCliente implements ActionListener{

    FrmRegistroCliente vRegistroCliente = new FrmRegistroCliente();
    ClienteVO clienteVO = new ClienteVO();
    ClienteDAO clienteDAO = new ClienteDAO();

    public ControladorRegistroCliente(FrmRegistroCliente vRegistroC, ClienteVO clienteVO, ClienteDAO clienteDAO) {
        this.vRegistroCliente = vRegistroC;
        this.clienteVO = clienteVO;
        this.clienteDAO = clienteDAO;
        this.vRegistroCliente.btnCrearRC.addActionListener(this);
    }

    private int registrarDatosCliente() {
        try {
            this.clienteVO.setCuiCliente(Long.valueOf(vRegistroCliente.txtCuiRC.getText()));
            this.clienteVO.setNombreCliente(vRegistroCliente.txtNombreRC.getText());
            this.clienteVO.setApellidoCliente(vRegistroCliente.txtApellidoRC.getText());
        } catch (Exception e) {
            System.err.println("[Error_Crear_Cliente]: " + e);
            return 1;
        }
        return 0;
    }

    private void limpiarCampos() {
        this.vRegistroCliente.txtCuiRC.setText("");
        this.vRegistroCliente.txtNombreRC.setText("");
        this.vRegistroCliente.txtApellidoRC.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vRegistroCliente.btnCrearRC) {
            if (!this.vRegistroCliente.txtCuiRC.getText().isEmpty()
                    && !this.vRegistroCliente.txtNombreRC.getText().isEmpty()
                    && !this.vRegistroCliente.txtApellidoRC.getText().isEmpty()) {
                if (registrarDatosCliente() == 0) {
                    clienteDAO.almacenarUsuarios();
                    vRegistroCliente.jopMensajeRC.showMessageDialog(vRegistroCliente, "Cliente creado con éxito");
                    limpiarCampos();
                } else {
                    vRegistroCliente.jopMensajeRC.showMessageDialog(vRegistroCliente, "Error en el CUI. Debe ser un valor numérico.");
                }
            } else {
                vRegistroCliente.jopMensajeRC.showMessageDialog(vRegistroCliente, "Debe llenar todos los campos");
            }
        }
    }
}