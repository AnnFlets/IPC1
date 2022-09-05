package controlador;

import extras.FechaHora;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ClienteVO;
import modelo.CuentaVO;
import modelo.TransaccionVO;
import vista.FrmBanco;

public class ControladorBanco implements ActionListener {

    //Objetos y variables
    FrmBanco vBanco = new FrmBanco();
    ClienteVO clienteVO = new ClienteVO();
    ClienteVO[] cliente = new ClienteVO[5];
    CuentaVO cuentaVO = new CuentaVO();
    CuentaVO[] cuenta = new CuentaVO[25];
    TransaccionVO transaccionVO = new TransaccionVO();
    FechaHora fechaYHora = new FechaHora();
    DefaultTableModel modeloTablaClienteMC;
    DefaultTableModel modeloTablaCuentaMC;
    DefaultTableModel modeloTablaTransaccionesH;
    int numeroCuenta = 1000;
    int numeroTransaccion = 100;
    int contadorCuenta = 0;
    double saldoCuenta = 0;

    //Constructor y asignación de escuchadores
    public ControladorBanco(FrmBanco vBanco, ClienteVO clienteVO, CuentaVO cuentaVO, TransaccionVO transaccionVO) {
        this.vBanco = vBanco;
        this.clienteVO = clienteVO;
        this.cuentaVO = cuentaVO;
        this.transaccionVO = transaccionVO;
        this.vBanco.btnCrearCCl.addActionListener(this);
        this.vBanco.btnCrearCCu.addActionListener(this);
        this.vBanco.btnBuscarCuentasMC.addActionListener(this);
        this.vBanco.btnAceptarD.addActionListener(this);
        this.vBanco.btnA.addActionListener(this);
        this.vBanco.btnAceptarPS.addActionListener(this);
        this.vBanco.btnMostrarTransaccionesH.addActionListener(this);
    }

    //---- CREAR CLIENTE ----
    private void registrarCliente() {
        if (!this.vBanco.txtCuiCCl.getText().isBlank()
                && !this.vBanco.txtNombreCCl.getText().isBlank()
                && !this.vBanco.txtApellidoCCl.getText().isBlank()) {
            if (cliente[(cliente.length - 1)] == null) {
                for (int i = 0; i < cliente.length; i++) {
                    if (!verificarDuplicacionCui()) {
                        if (cliente[i] == null) {
                            cliente[i] = new ClienteVO(this.vBanco.txtCuiCCl.getText(),
                                    this.vBanco.txtNombreCCl.getText(),
                                    this.vBanco.txtApellidoCCl.getText());
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

    //Retorna true si el CUI está duplicado, false si no
    private boolean verificarDuplicacionCui() {
        boolean duplicado = false;
        for (int i = 0; i < cliente.length; i++) {
            if (cliente[i] != null) {
                if (cliente[i].getCuiCliente().equals(this.vBanco.txtCuiCCl.getText())) {
                    duplicado = true;
                }
            }
        }
        return duplicado;
    }

    private void limpiarCamposCCl() {
        this.vBanco.txtCuiCCl.setText("");
        this.vBanco.txtNombreCCl.setText("");
        this.vBanco.txtApellidoCCl.setText("");
    }

    //---- CREAR CUENTA ----
    private void crearCuentaCliente() {
        ClienteVO clienteCuentas = cliente[this.vBanco.cmbClienteCCu.getSelectedIndex()];
        CuentaVO cuentaAsociada = new CuentaVO();
        if (verificarCuentasCliente()) {
            for (int i = 0; i < cliente.length; i++) {
                if (cliente[i] != null) {
                    cuentaAsociada.setIdentificadorCuenta(numeroCuenta);
                    cuentaAsociada.setClienteCuenta(cliente[this.vBanco.cmbClienteCCu.getSelectedIndex()].getCuiCliente());
                    cuentaAsociada.setSaldoCuenta(0);
                    clienteCuentas.agregarCuentaAsociada(cuentaAsociada);
                    cuenta[contadorCuenta] = new CuentaVO(cuentaAsociada.getIdentificadorCuenta(),
                            cuentaAsociada.getClienteCuenta(), cuentaAsociada.getSaldoCuenta());
                    this.vBanco.jopMensaje.showMessageDialog(null, "Cuenta creada con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                    numeroCuenta++;
                    contadorCuenta++;
                    break;
                }
            }
        } else {
            this.vBanco.jopMensaje.showMessageDialog(null, "No es posible crear más cuentas para el cliente seleccionado", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    //Retorna true si el cliente aún tiene espacio en el arreglo para crear otra cuenta, false si no
    private boolean verificarCuentasCliente() {
        boolean espacioDisponibleCuenta = false;
        CuentaVO[] cuentasCliente = cliente[this.vBanco.cmbClienteCCu.getSelectedIndex()].getCuentasAsociadas();
        if (cuentasCliente[cuentasCliente.length - 1] == null) {
            espacioDisponibleCuenta = true;
        }
        return espacioDisponibleCuenta;
    }

    private void llenarComboBoxClienteCCu() {
        borrarComboBoxClienteCCu();
        for (int i = 0; i < cliente.length; i++) {
            if (cliente[i] != null) {
                this.vBanco.cmbClienteCCu.addItem(cliente[i].getCuiCliente()
                        + " - " + cliente[i].getNombreCliente() + " "
                        + cliente[i].getApellidoCliente());
            }
        }
    }

    private void borrarComboBoxClienteCCu() {
        this.vBanco.cmbClienteCCu.removeAllItems();
    }

    private void regresarEstadoInicialComboBoxClienteCCu() {
        this.vBanco.cmbClienteCCu.setSelectedIndex(0);
    }

    //---- MOSTRAR CLIENTES ----
    private void agregarFilaTablaCliente() {
        this.vBanco.tblClientesMC.setEnabled(false);
        modeloTablaClienteMC = (DefaultTableModel) this.vBanco.tblClientesMC.getModel();
        for (int i = 0; i < cliente.length; i++) {
            if (cliente[i] != null) {
                modeloTablaClienteMC.addRow(new Object[]{cliente[i].getCuiCliente(),
                    cliente[i].getNombreCliente(),
                    cliente[i].getApellidoCliente()});
            }
        }
    }

    private void tablaCuentasAsociadas() {
        if (!this.vBanco.txtCuiMC.getText().isBlank()) {
            limpiarTablaCuenta();
            agregarFilaTablaCuenta();
        } else {
            this.vBanco.jopMensaje.showMessageDialog(null, "No ha ingresado un número de CUI.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void agregarFilaTablaCuenta() {
        this.vBanco.tblCuentasAsociadasMC.setEnabled(false);
        modeloTablaCuentaMC = (DefaultTableModel) this.vBanco.tblCuentasAsociadasMC.getModel();
        CuentaVO[] cuentasAsociadas = devolverCuentasCliente();
        if (cuentasAsociadas[0] != null) {
            if (cuentasAsociadas != null) {
                for (CuentaVO cuentaCliente : devolverCuentasCliente()) {
                    if (cuentaCliente != null) {
                        modeloTablaCuentaMC.addRow(new Object[]{cuentaCliente.getIdentificadorCuenta()});
                    }
                }
            }
        } else {
            this.vBanco.jopMensaje.showMessageDialog(null, "El cliente con número de CUI ingresado no tiene cuentas asociadas.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    //Retorna un arreglo con las cuentas del cliente con CUI ingresado
    private CuentaVO[] devolverCuentasCliente() {
        for (int i = 0; i < cliente.length; i++) {
            if (cliente[i].getCuiCliente().equals(this.vBanco.txtCuiMC.getText())) {
                return cliente[i].getCuentasAsociadas();
            }
        }
        return null;
    }

    //Verifica si existe un cliente con el CUI ingresado, retornando true si existe y false si no
    private boolean verificarExistenciaCliente() {
        boolean existe = false;
        for (int i = 0; i < cliente.length; i++) {
            if (cliente[i] != null && cliente[i].getCuiCliente().equals(this.vBanco.txtCuiMC.getText())) {
                return true;
            }
        }
        return existe;
    }

    private void limpiarTablaCliente() {
        modeloTablaClienteMC = (DefaultTableModel) this.vBanco.tblClientesMC.getModel();
        modeloTablaClienteMC.getDataVector().removeAllElements();
        this.vBanco.tblClientesMC.updateUI();
    }

    private void limpiarTablaCuenta() {
        modeloTablaCuentaMC = (DefaultTableModel) this.vBanco.tblCuentasAsociadasMC.getModel();
        modeloTablaCuentaMC.getDataVector().removeAllElements();
        this.vBanco.tblCuentasAsociadasMC.updateUI();
    }

    //---- DEPOSITAR ----
    private void realizarDeposito() {
        try {
            if (Double.parseDouble(this.vBanco.txtMontoD.getText()) > 0) {
                agreagarDepositoCuentaD();
            } else {
                this.vBanco.jopMensaje.showMessageDialog(null, "El monto del depósito debe ser mayor a 0.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            this.vBanco.jopMensaje.showMessageDialog(null, "El monto debe ser un número real.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void agreagarDepositoCuentaD() {
        CuentaVO cuentaTransacciones = cuenta[this.vBanco.cmbCuentaD.getSelectedIndex()];
        TransaccionVO transaccionRealizada = new TransaccionVO();
        for (int i = 0; i < cuenta.length; i++) {
            if (cuenta[i] != null) {
                transaccionRealizada.setNumeroTransaccion(numeroTransaccion);
                transaccionRealizada.setCuentaTransaccion(cuenta[this.vBanco.cmbCuentaD.getSelectedIndex()].getIdentificadorCuenta());
                transaccionRealizada.setFechaTransaccion(fechaYHora.devolverFechaHoraActual());
                transaccionRealizada.setDetalleTransaccion("Depósito");
                transaccionRealizada.setDebitoTransaccion(0);
                transaccionRealizada.setCreditoTransaccion(Double.parseDouble(this.vBanco.txtMontoD.getText()));
                saldoCuenta = cuentaTransacciones.getSaldoCuenta();
                transaccionRealizada.setSaldoTransaccion((double) Math.round((saldoCuenta + Double.parseDouble(this.vBanco.txtMontoD.getText())) * 100d) / 100d);
                cuentaTransacciones.agregarTransaccion(transaccionRealizada);
                cuentaTransacciones.setSaldoCuenta((double) Math.round((saldoCuenta + Double.parseDouble(this.vBanco.txtMontoD.getText())) * 100d) / 100d);
                this.vBanco.jopMensaje.showMessageDialog(null, "Depósito realizado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                regresarEstadoInicialD();
                numeroTransaccion++;
                break;
            }
        }
    }

    private void regresarEstadoInicialD() {
        this.vBanco.cmbCuentaD.setSelectedIndex(0);
        this.vBanco.txtMontoD.setText("");
    }

    //---- PAGO DE SERVICIOS ----
    private void realizarPago() {
        try {
            if (Double.parseDouble(this.vBanco.txtMontoPS.getText()) > 0) {
                if (Double.parseDouble(this.vBanco.txtMontoPS.getText()) <= cuenta[this.vBanco.cmbCuentaDebitarPS.getSelectedIndex()].getSaldoCuenta()) {
                    agregarPagoCuentaPS();
                } else {
                    this.vBanco.jopMensaje.showMessageDialog(null, "La cuenta de origen no tiene suficientes fondos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                this.vBanco.jopMensaje.showMessageDialog(null, "El monto del depósito debe ser mayor a 0.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            this.vBanco.jopMensaje.showMessageDialog(null, "El monto debe ser un número real.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void agregarPagoCuentaPS() {
        CuentaVO cuentaTransacciones = cuenta[this.vBanco.cmbCuentaDebitarPS.getSelectedIndex()];
        TransaccionVO transaccionRealizada = new TransaccionVO();
        for (int i = 0; i < cuenta.length; i++) {
            if (cuenta[i] != null) {
                transaccionRealizada.setNumeroTransaccion(numeroTransaccion);
                transaccionRealizada.setCuentaTransaccion(cuenta[this.vBanco.cmbCuentaDebitarPS.getSelectedIndex()].getIdentificadorCuenta());
                transaccionRealizada.setFechaTransaccion(fechaYHora.devolverFechaHoraActual());
                transaccionRealizada.setDetalleTransaccion("Pago de servicio - " + this.vBanco.cmbTipoServicioPS.getSelectedItem().toString());
                transaccionRealizada.setDebitoTransaccion(Double.parseDouble(this.vBanco.txtMontoPS.getText()));
                transaccionRealizada.setCreditoTransaccion(0);
                saldoCuenta = cuentaTransacciones.getSaldoCuenta();
                transaccionRealizada.setSaldoTransaccion((double) Math.round((saldoCuenta - Double.parseDouble(this.vBanco.txtMontoPS.getText())) * 100d) / 100d);
                cuentaTransacciones.agregarTransaccion(transaccionRealizada);
                cuentaTransacciones.setSaldoCuenta((double) Math.round((saldoCuenta - Double.parseDouble(this.vBanco.txtMontoPS.getText())) * 100d) / 100d);
                this.vBanco.jopMensaje.showMessageDialog(null, "Pago realizado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                regresarEstadoInicialPS();
                numeroTransaccion++;
                break;
            }
        }
    }

    private void regresarEstadoInicialPS() {
        this.vBanco.cmbCuentaDebitarPS.setSelectedIndex(0);
        this.vBanco.cmbTipoServicioPS.setSelectedIndex(0);
        this.vBanco.txtMontoPS.setText("");
    }

    //---- HISTORIAL ----
    private void mostrarDatosClienteTransaccion() {
        for (int i = 0; i < cliente.length; i++) {
            if (cliente[i] != null) {
                if (cliente[i].getCuiCliente().equals(cuenta[this.vBanco.cmbCuentaH.getSelectedIndex()].getClienteCuenta())) {
                    this.vBanco.txtCuiH.setText(cliente[i].getCuiCliente());
                    this.vBanco.txtNombreH.setText(cliente[i].getNombreCliente());
                    this.vBanco.txtApellidoH.setText(cliente[i].getApellidoCliente());
                }
            }
        }
    }

    private void agregarFilaTablaTransaccion() {
        this.vBanco.tblTransaccionesH.setEnabled(false);
        modeloTablaTransaccionesH = (DefaultTableModel) this.vBanco.tblTransaccionesH.getModel();
        int verificarExistenciaTransaccion = 0;
        for (TransaccionVO transaccion : cuenta[this.vBanco.cmbCuentaH.getSelectedIndex()].getTransaccionesRealizadas()) {
            if (transaccion != null) {
                if (modeloTablaTransaccionesH.getRowCount() <= 20) {
                    modeloTablaTransaccionesH.addRow(new Object[]{transaccion.getNumeroTransaccion(),
                        transaccion.getFechaTransaccion(), transaccion.getDetalleTransaccion(),
                        transaccion.getCreditoTransaccion(), transaccion.getDebitoTransaccion(),
                        transaccion.getSaldoTransaccion()
                    });
                    verificarExistenciaTransaccion++;
                }
            } else if (verificarExistenciaTransaccion == 0 && transaccion == null) {
                modeloTablaTransaccionesH.addRow(new Object[]{"-", "-", "-", "-", "-", "-"});
                this.vBanco.jopMensaje.showMessageDialog(null, "La cuenta seleccionada no tiene transacciones.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                verificarExistenciaTransaccion++;
            }
        }
    }

    private void limpiarTablaTransaccion() {
        modeloTablaTransaccionesH = (DefaultTableModel) this.vBanco.tblTransaccionesH.getModel();
        modeloTablaTransaccionesH.getDataVector().removeAllElements();
        this.vBanco.tblCuentasAsociadasMC.updateUI();
    }

    //---- COMPLEMENTARIOS ----
    //Llenar los comboBox que requieren de la misma información sobre las cuentas
    private void llenarComboBoxesCuentas() {
        borrarComboBoxesCuentas();
        for (int i = 0; i < cuenta.length; i++) {
            if (cuenta[i] != null) {
                for (int j = 0; j < cliente.length; j++) {
                    if (cliente[j] != null && cliente[j].getCuiCliente().equals(cuenta[i].getClienteCuenta())) {
                        this.vBanco.cmbCuentaD.addItem(cuenta[i].getIdentificadorCuenta() + " - "
                                + cliente[j].getNombreCliente() + " " + cliente[j].getApellidoCliente());
                        this.vBanco.cmbCuentaDebitarPS.addItem(cuenta[i].getIdentificadorCuenta() + " - "
                                + cliente[j].getNombreCliente() + " " + cliente[j].getApellidoCliente());
                        this.vBanco.cmbCuentaH.addItem(String.valueOf(cuenta[i].getIdentificadorCuenta()));
                    }
                }
            }
        }
    }

    //Borrar los elementos de los comboBox que tienen la misma información sobre las cuentas
    private void borrarComboBoxesCuentas() {
        this.vBanco.cmbCuentaD.removeAllItems();
        this.vBanco.cmbCuentaDebitarPS.removeAllItems();
        this.vBanco.cmbCuentaH.removeAllItems();
    }

    //Administración de clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vBanco.btnCrearCCl) {
            registrarCliente();
            llenarComboBoxClienteCCu();
            limpiarTablaCliente();
            agregarFilaTablaCliente();
            this.vBanco.btnCrearCCu.setEnabled(true);
            this.vBanco.btnBuscarCuentasMC.setEnabled(true);
        }
        if (e.getSource() == this.vBanco.btnCrearCCu) {
            crearCuentaCliente();
            regresarEstadoInicialComboBoxClienteCCu();
            llenarComboBoxesCuentas();
            this.vBanco.btnAceptarD.setEnabled(true);
            this.vBanco.btnAceptarPS.setEnabled(true);
            this.vBanco.btnMostrarTransaccionesH.setEnabled(true);
        }
        if (e.getSource() == this.vBanco.btnBuscarCuentasMC) {
            if (verificarExistenciaCliente()) {
                tablaCuentasAsociadas();
            } else {
                this.vBanco.jopMensaje.showMessageDialog(null, "No existe un cliente con el número de CUI ingresado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource() == this.vBanco.btnAceptarD) {
            realizarDeposito();
        }
        if (e.getSource() == this.vBanco.btnA) {
            algo();
        }
        if (e.getSource() == this.vBanco.btnAceptarPS) {
            realizarPago();
        }
        if (e.getSource() == this.vBanco.btnMostrarTransaccionesH) {
            mostrarDatosClienteTransaccion();
            limpiarTablaTransaccion();
            agregarFilaTablaTransaccion();
        }
    }

    private void algo() {
        System.out.println("A");
    }
}
