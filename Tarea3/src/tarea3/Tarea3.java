package tarea3;

import controlador.ControladorArchivo;
import vista.FrmVentana;

public class Tarea3 {

    public static void main(String[] args) {
        //Vista
        FrmVentana vVentana = new FrmVentana();
        //Controlador
        ControladorArchivo cArchivo = new ControladorArchivo(vVentana);
        //Configuración inicial de la vista
        vVentana.setVisible(true);
        vVentana.setLocationRelativeTo(null);
        vVentana.setResizable(false);
    }
}