package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ClienteVO;
import modelo.CuentaVO;
import vista.FrmBanco;

public class ControladorBanco implements ActionListener {

    FrmBanco vBanco = new FrmBanco();
    ClienteVO clienteVO = new ClienteVO();
    ClienteVO[] cuiNombreApellidoClientes = new ClienteVO[3];
    ClienteVO[] cliente = new ClienteVO[3];
    CuentaVO cuentaVO = new CuentaVO();
    DefaultTableModel modeloTablaMC;
    int numeroCuenta = 1000;

    public ControladorBanco(FrmBanco vBanco, ClienteVO clienteVO, CuentaVO cuentaVO) {
        this.vBanco = vBanco;
        this.clienteVO = clienteVO;
        this.cuentaVO = cuentaVO;
        this.vBanco.btnCrearCCl.addActionListener(this);
        this.vBanco.btnCrearCCu.addActionListener(this);
    }

    private void registrarCliente() {
        if (!this.vBanco.txtCuiCCl.getText().isBlank()
                && !this.vBanco.txtNombreCCl.getText().isBlank()
                && !this.vBanco.txtApellidoCCl.getText().isBlank()) {
            if (cuiNombreApellidoClientes[(cuiNombreApellidoClientes.length - 1)] == null) {
                for (int i = 0; i < cuiNombreApellidoClientes.length; i++) {
                    if (!verificarDuplicacionCui()) {
                        if (cuiNombreApellidoClientes[i] == null) {
                            this.clienteVO.setCuiCliente(this.vBanco.txtCuiCCl.getText());
                            this.clienteVO.setNombreCliente(this.vBanco.txtNombreCCl.getText());
                            this.clienteVO.setApellidoCliente(this.vBanco.txtApellidoCCl.getText());
                            cuiNombreApellidoClientes[i] = new ClienteVO(clienteVO.getCuiCliente(), clienteVO.getNombreCliente(), clienteVO.getApellidoCliente());
                            this.vBanco.jopMensaje.showMessageDialog(null, "¡Cliente creado con éxito!", "Información", JOptionPane.INFORMATION_MESSAGE);
                            limpiarCamposCCl();
                            break;
                        }
                    } else {
                        this.vBanco.jopMensaje.showMessageDialog(null, "El CUI ingresado ya existe en el sistema. No se aceptan CUI duplicados.",
                                "Advertencia", JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                }
            } else {
                this.vBanco.jopMensaje.showMessageDialog(null, "No es posible crear más clientes.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                limpiarCamposCCl();
            }
        } else {
            this.vBanco.jopMensaje.showMessageDialog(null, "Debe llenar todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    //ARREGLAAAAAAAAAAAAAAAAAR
    private void crearCuentaCliente() {
        for (int i = 0; i < cliente.length; i++) {
            if (cliente[i] == null) {
                this.clienteVO.setCuiCliente(cuiNombreApellidoClientes[this.vBanco.cmbClienteCCu.getSelectedIndex()].getCuiCliente());
                this.clienteVO.setNombreCliente(cuiNombreApellidoClientes[this.vBanco.cmbClienteCCu.getSelectedIndex()].getNombreCliente());
                this.clienteVO.setApellidoCliente(cuiNombreApellidoClientes[this.vBanco.cmbClienteCCu.getSelectedIndex()].getApellidoCliente());
                this.cuentaVO.setIdentificadorCuenta(numeroCuenta);
                this.cuentaVO.setClienteCuenta(cuiNombreApellidoClientes[this.vBanco.cmbClienteCCu.getSelectedIndex()].getCuiCliente());
                this.cuentaVO.setSaldoCuenta(0);
                this.clienteVO.agregarCuentaAsociada(cuentaVO);
                cliente[i] = new ClienteVO(this.clienteVO.getCuiCliente(), this.clienteVO.getNombreCliente(), this.clienteVO.getApellidoCliente(), this.clienteVO.getCuentasAsociadas());
                break;
            }
        }
    }

    private boolean verificarDuplicacionCui() {
        boolean duplicado = false;
        for (int i = 0; i < cuiNombreApellidoClientes.length; i++) {
            if (cuiNombreApellidoClientes[i] != null) {
                if (cuiNombreApellidoClientes[i].getCuiCliente().equals(this.vBanco.txtCuiCCl.getText())) {
                    duplicado = true;
                }
            }
        }
        return duplicado;
    }

    private void llenarComboBoxClienteCCu() {
        borrarComboBoxClienteCCu();
        for (int i = 0; i < cuiNombreApellidoClientes.length; i++) {
            if (cuiNombreApellidoClientes[i] != null) {
                this.vBanco.cmbClienteCCu.addItem(cuiNombreApellidoClientes[i].getCuiCliente()
                        + " - " + cuiNombreApellidoClientes[i].getNombreCliente() + " "
                        + cuiNombreApellidoClientes[i].getApellidoCliente());
            }
        }
    }

    private void borrarComboBoxClienteCCu() {
        this.vBanco.cmbClienteCCu.removeAllItems();
    }

    private void limpiarCamposCCl() {
        this.vBanco.txtCuiCCl.setText("");
        this.vBanco.txtNombreCCl.setText("");
        this.vBanco.txtApellidoCCl.setText("");
    }

    private void regresarEstadoInicialComboBoxClienteCCu() {
        this.vBanco.cmbClienteCCu.setSelectedIndex(0);
    }

    public void agregarFilaTabla() {
        this.vBanco.tblClientesMC.setEnabled(false);
        modeloTablaMC = (DefaultTableModel) this.vBanco.tblClientesMC.getModel();
        for (int i = 0; i < cuiNombreApellidoClientes.length; i++) {
            if (cuiNombreApellidoClientes[i] != null) {
                modeloTablaMC.addRow(new Object[]{cuiNombreApellidoClientes[i].getCuiCliente(),
                    cuiNombreApellidoClientes[i].getNombreCliente(),
                    cuiNombreApellidoClientes[i].getApellidoCliente()});
            }
        }
    }

    private void limpiarTabla() {
        modeloTablaMC = (DefaultTableModel) this.vBanco.tblClientesMC.getModel();
        modeloTablaMC.getDataVector().removeAllElements();
        this.vBanco.tblClientesMC.updateUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vBanco.btnCrearCCl) {
            registrarCliente();
            llenarComboBoxClienteCCu();
            limpiarTabla();
            agregarFilaTabla();
        }
        if (e.getSource() == this.vBanco.btnCrearCCu) {
            crearCuentaCliente();
            regresarEstadoInicialComboBoxClienteCCu();
        }
    }
}
