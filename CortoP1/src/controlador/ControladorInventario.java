package controlador;

import Extras.FechaHora;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.OperacionVO;
import modelo.ProductoVO;
import vista.FrmInventario;

public class ControladorInventario implements ActionListener {

    //Objetos y arreglos a utilizar
    FrmInventario vInventario = new FrmInventario();
    ProductoVO pvo = new ProductoVO();
    OperacionVO ovo = new OperacionVO();
    ProductoVO[] productosCreados = new ProductoVO[50];
    OperacionVO[] operacionesCreadas = new OperacionVO[200];
    OperacionVO[] operacionesProducto;
    FechaHora fechaHora = new FechaHora();
    DefaultTableModel modeloTabla;
    int existencias = 0;
    int contador = 0;

    //Constructor con parámetros. Además, se otorga un escuchador a los botones 
    //para poder detectar y manejar acciones al pulsarlos. También, desabilitamos
    //las pestanias del Tabbed Pane, para que se llegue a ellas por medio de los botones
    public ControladorInventario(FrmInventario vInventario, ProductoVO pvo, OperacionVO ovo) {
        this.vInventario = vInventario;
        this.pvo = pvo;
        this.ovo = ovo;
        this.vInventario.btnCrearProductoRP.addActionListener(this);
        this.vInventario.btnAceptarES.addActionListener(this);
        this.vInventario.btnMostrarInventarioH.addActionListener(this);
        this.vInventario.btnPestaniaRP.addActionListener(this);
        this.vInventario.btnPestaniaES.addActionListener(this);
        this.vInventario.btnPestaniaH.addActionListener(this);
        this.vInventario.jtpPestanias.setEnabledAt(0, false);
        this.vInventario.jtpPestanias.setEnabledAt(1, false);
        this.vInventario.jtpPestanias.setEnabledAt(2, false);
    }

    //Añade un nuevo producto a un arreglo, colocando en una posición su código y el nombre del mismo
    private void agregarProductoRP() {
        if (!(this.vInventario.txtNombreProductoRP.getText().isBlank())) {
            for (int i = 0; i < productosCreados.length; i++) {
                if (productosCreados[i] == null) {
                    pvo.setIdProducto(i);
                    pvo.setNombreProducto(this.vInventario.txtNombreProductoRP.getText());
                    productosCreados[i] = new ProductoVO(pvo.getIdProducto(), pvo.getNombreProducto());
                    this.vInventario.jopMensaje.showMessageDialog(null, "Producto creado con éxito");
                    break;
                }
            }
        }
    }

    //A través del nombre del producto, devuelve el código del mismo.
    private int devolverCodigoProducto(String productoSeleccionado) {
        int idProducto = 0;
        for (int i = 0; i < productosCreados.length; i++) {
            if (productoSeleccionado == productosCreados[i].getNombreProducto()) {
                idProducto = productosCreados[i].getIdProducto();
                break;
            }
        }
        return idProducto;
    }

    //Añade una nueva operación a un arreglo, colocando el código del producto, el tipo de operación, 
    //la fecha y hora de realización de la misma, la cantidad que entró y salió de producto
    private void agregarEntradaSalidaES() {
        try {
            if (!(this.vInventario.txtCantidadProductoES.getText().isBlank())) {
                for (int i = 0; i < operacionesCreadas.length; i++) {
                    if (operacionesCreadas[i] == null) {
                        ovo.setIdProducto(devolverCodigoProducto(this.vInventario.cmbProductoES.getSelectedItem().toString()));
                        ovo.setTipoOperacion(this.vInventario.cmbTipoES.getSelectedItem().toString());
                        ovo.setFechaHoraOperacion(fechaHora.devolverFechaHoraActual());
                        if (ovo.getTipoOperacion().equals("Entrada")) {
                            if (Integer.parseInt(this.vInventario.txtCantidadProductoES.getText()) < 1) {
                                this.vInventario.jopMensaje.showMessageDialog(null, "Debe ingresar una cantidad mayor a 0");
                                break;
                            } else {
                                ovo.setEntrada(Integer.parseInt(this.vInventario.txtCantidadProductoES.getText()));
                                ovo.setSalida(0);
                            }
                        } else {
                            if (Integer.parseInt(this.vInventario.txtCantidadProductoES.getText()) < 1) {
                                this.vInventario.jopMensaje.showMessageDialog(null, "Debe ingresar una cantidad mayor a 0");
                                break;
                            } else {
                                ovo.setSalida(Integer.parseInt(this.vInventario.txtCantidadProductoES.getText()));
                                ovo.setEntrada(0);
                            }
                        }
                        operacionesCreadas[i] = new OperacionVO(ovo.getIdProducto(), ovo.getTipoOperacion(), ovo.getFechaHoraOperacion(), ovo.getEntrada(), ovo.getSalida());
                        this.vInventario.jopMensaje.showMessageDialog(null, "Operación guardada con éxito");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("[Error-Operación]: " + e);
            this.vInventario.jopMensaje.showMessageDialog(null, "Error, debe ingresar un número entero", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Limpia el campo de texto del registro de productos
    private void limpiarCampoRP() {
        this.vInventario.txtNombreProductoRP.setText("");
    }

    //Limpia el campo de texto y selecciona el primer item que contiene el combobox
    private void limpiarCampoES() {
        this.vInventario.txtCantidadProductoES.setText("");
        this.vInventario.cmbProductoES.setSelectedIndex(0);
        this.vInventario.cmbTipoES.setSelectedIndex(0);
    }

    //Agrega los nombres de los productos registrados como items del combobox perteneciente
    //a la pestaña de Entradas y Salidas
    private void llenarComboBoxProductosES() {
        for (int i = 0; i < productosCreados.length; i++) {
            if (productosCreados[i] != null) {
                this.vInventario.cmbProductoES.addItem(productosCreados[i].getNombreProducto());
            }
        }
    }

    //Agrega los nombres de los productos registrados como items del combobox perteneciente
    //a la pestaña de Historial
    private void llenarComboBoxProductosH() {
        for (int i = 0; i < productosCreados.length; i++) {
            if (productosCreados[i] != null) {
                this.vInventario.cmbProductosH.addItem(productosCreados[i].getNombreProducto());
            }
        }
    }

    //Elimina todos los items del combobox perteneciente a la pestaña de Entradas y Salidas
    private void borrarComboBoxProductoES() {
        this.vInventario.cmbProductoES.removeAllItems();
    }

    //Elimina todos los items del combobox perteneciente a la pestaña de Historial
    private void borrarComboBoxProductoH() {
        this.vInventario.cmbProductosH.removeAllItems();
    }

    //Obtiene la cantidad total de operaciones realizadas con un producto en específico
    public int obtenerCantidadOperacionesProducto() {
        int codigoProducto = devolverCodigoProducto(this.vInventario.cmbProductosH.getSelectedItem().toString());
        int cantidadOperaciones = 0;
        for (int i = 0; i < operacionesCreadas.length; i++) {
            if (operacionesCreadas[i] != null) {
                if (operacionesCreadas[i].getIdProducto() == codigoProducto) {
                    cantidadOperaciones++;
                }
            }
        }
        return cantidadOperaciones;
    }

    //Agrega cada una de las operaciones, de un producto determinado, en la tabla del historial
    public void obtenerOperacionesProducto() {
        OperacionVO[] operacionesProducto = new OperacionVO[obtenerCantidadOperacionesProducto()];
        int i = 0;
        for (int j = 0; j < operacionesCreadas.length; j++) {
            if (operacionesCreadas[j] != null && operacionesCreadas[j].getIdProducto() == devolverCodigoProducto(this.vInventario.cmbProductosH.getSelectedItem().toString()) && i < obtenerCantidadOperacionesProducto()) {
                operacionesProducto[i] = operacionesCreadas[j];
                if (i == 0) {
                    existencias = operacionesProducto[i].getEntrada();
                    agregarFilaTabla(new Object[]{
                        operacionesProducto[i].getFechaHoraOperacion(),
                        operacionesProducto[i].getTipoOperacion(),
                        operacionesProducto[i].getEntrada(),
                        operacionesProducto[i].getSalida(),
                        existencias});
                    i++;
                } else {
                    if (operacionesProducto[i].getTipoOperacion().equals("Entrada")) {
                        existencias += operacionesProducto[i].getEntrada();
                        agregarFilaTabla(new Object[]{
                            operacionesProducto[i].getFechaHoraOperacion(),
                            operacionesProducto[i].getTipoOperacion(),
                            operacionesProducto[i].getEntrada(),
                            operacionesProducto[i].getSalida(),
                            existencias});
                    } else {
                        existencias = existencias - operacionesProducto[i].getSalida();
                        agregarFilaTabla(new Object[]{
                            operacionesProducto[i].getFechaHoraOperacion(),
                            operacionesProducto[i].getTipoOperacion(),
                            operacionesProducto[i].getEntrada(),
                            operacionesProducto[i].getSalida(),
                            existencias});
                    }
                    i++;
                }
            }
        }
    }

    //Verifica que exista por lo menos un producto registrado
    private int verificarIngresoProducto() {
        int posicionLlena = 0;
        for (int i = 0; i < productosCreados.length; i++) {
            if (!(productosCreados[i] == null)) {
                posicionLlena = 1;
            }
        }
        return posicionLlena;
    }

    //Agrega una fila a la tabla
    public void agregarFilaTabla(Object[] informacionFila) {
        modeloTabla = (DefaultTableModel) this.vInventario.tblInventarioProductosH.getModel();
        modeloTabla.addRow(informacionFila);
        
    }

    //Eliminar todas las filas de la tabla
    private void limpiarTabla() {
        modeloTabla = (DefaultTableModel) this.vInventario.tblInventarioProductosH.getModel();
        modeloTabla.getDataVector().removeAllElements();
        this.vInventario.tblInventarioProductosH.updateUI();
    }

    //Administra las pulsaciones en los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vInventario.btnCrearProductoRP) {
            agregarProductoRP();
            borrarComboBoxProductoES();
            borrarComboBoxProductoH();
            llenarComboBoxProductosES();
            llenarComboBoxProductosH();
            limpiarCampoRP();
        }
        if (e.getSource() == vInventario.btnAceptarES) {
            agregarEntradaSalidaES();
            limpiarCampoES();
        }
        if (e.getSource() == vInventario.btnMostrarInventarioH) {
            if(contador == 0){
                obtenerOperacionesProducto();
            }else{
                limpiarTabla();
                obtenerOperacionesProducto();
            }
            contador++;
        }
        if (e.getSource() == vInventario.btnPestaniaRP) {
            this.vInventario.jtpPestanias.setSelectedIndex(0);
        }
        if (e.getSource() == vInventario.btnPestaniaES) {
            if (verificarIngresoProducto() == 1) {
                this.vInventario.jtpPestanias.setSelectedIndex(1);
            } else {
                this.vInventario.jopMensaje.showMessageDialog(null, "No hay productos registrados");
            }
        }

        if (e.getSource() == vInventario.btnPestaniaH) {
            if (verificarIngresoProducto() == 1) {
                this.vInventario.jtpPestanias.setSelectedIndex(2);
            } else {
                this.vInventario.jopMensaje.showMessageDialog(null, "No hay productos registrados");
            }
        }
    }
}