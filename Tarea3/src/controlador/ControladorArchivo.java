package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelo.ArchivoDAO;
import modelo.ArchivoVO;
import vista.FrmVentana;

public class ControladorArchivo implements ActionListener {
    FrmVentana vVentana = new FrmVentana();
    ArchivoVO archivoVO = new ArchivoVO();
    ArchivoDAO archivoDAO = new ArchivoDAO(archivoVO);
    String[] filas;
    String[] columnas;
    DefaultTableModel modeloTabla;

    /**
     * Controlador con parámetro
     * @param vVentana -> recibe la vista, es decir, el JFrame
     * Asigna un escuchador al botón
     */
    public ControladorArchivo(FrmVentana vVentana) {
        this.vVentana = vVentana;
        this.vVentana.btnBuscar.addActionListener(this);
    }

    /**
     * Método que controla la búsqueda del archivo, estableciendo la ruta y contenido del mismo
     */
    private void abrirMiArchivo() {
        this.archivoVO = new ArchivoVO();
        this.archivoDAO = new ArchivoDAO(archivoVO);
        this.archivoVO.setCadena("");
        this.archivoVO.setRuta("");
        this.vVentana.fileChooserArchivo.setApproveButtonText("Abrir");
        this.vVentana.fileChooserArchivo.showOpenDialog(null);
        this.archivoVO.setRuta(this.vVentana.fileChooserArchivo.getSelectedFile() + "");
        if (!this.archivoVO.getRuta().equals("null")) {
            this.vVentana.txtRuta.setText(this.archivoVO.getRuta());
            this.archivoDAO.abrirArchivo();
            limpiarTabla();
            llenarTabla();
        } else {
            System.err.println("[Error-Selección]: No se seleccionó ningún archivo.");
        }
    }

    /**
     * Método que llena las filas de la tabla con la información leída del archivo
     */
    private void llenarTabla() {
        modeloTabla = (DefaultTableModel) this.vVentana.tblInformacion.getModel();
        filas = this.archivoVO.getCadena().split("\n");
        for (int i = 0; i < filas.length; i++) {
            columnas = filas[i].split(",");
            if (columnas.length == 5) {
                if (columnas[1].equals("cui") || columnas[1].equals("CUI") || columnas[1].equals("Cui")) {
                    continue;
                } else {
                    modeloTabla.addRow(new Object[]{columnas[0], columnas[1], columnas[2], columnas[3], columnas[4]});
                }
            }else{
                System.err.println("[Error-Datos]: La fila no cuenta con la cantidad de datos necesarios.");
            }
        }
    }

    /**
     * Método para eliminar todas las filas de la tabla
     */
    private void limpiarTabla() {
        modeloTabla = (DefaultTableModel) this.vVentana.tblInformacion.getModel();
        modeloTabla.getDataVector().removeAllElements();
        this.vVentana.tblInformacion.updateUI();
    }

    /**
     * Método para administrar la pulsación del usuario en el botón de búsqueda
     * @param e -> representa la acción o click del usuario
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vVentana.btnBuscar) {
            abrirMiArchivo();
        }
    }
}