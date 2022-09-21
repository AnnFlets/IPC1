package practica2snake;

import controlador.ControladorTablero;
import vista.FrmSnake;

public class Practica2Snake {

    public static void main(String[] args) {
        //Vista
        FrmSnake vSnake = new FrmSnake();
        //Controlador
        ControladorTablero cTablero = new ControladorTablero(vSnake);
        //Configuración inicial de la vista
        vSnake.setVisible(true);
        vSnake.setLocationRelativeTo(null);
        vSnake.setResizable(false);
    } 
}