package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.FrutaVO;
import modelo.ModeloJuego;
import modelo.SnakeVO;
import vista.FrmSnake;

public class ControladorTablero implements ActionListener{
    FrmSnake vSnake = new FrmSnake();
    ModeloJuego modeloJuego = new ModeloJuego();
    JLabel[][] tablero;
    FrutaVO fruta;
    SnakeVO snake;
    MovimientoSnake movSnake;
    String dificultad = "";

    /**
     * Constructor vacío
     */
    public ControladorTablero() {
    }

    /**
     * Constructor con parámetro
     * @param vSnake -> Representa la vista, es decir, el JFrame
     * Se agrega una acción al botón de Nuevo Juego de la vista
     */
    public ControladorTablero(FrmSnake vSnake) {
        this.vSnake = vSnake;
        this.vSnake.btnNuevoJuego.addActionListener(this);
    }
    
    /**
     * Método que genera el tablero cuadriculado a base de JLabels
     * @param panel -> Representa el elemento panel de la vista
     * @return -> Retorna el arreglo de JLabels generado que representa el tablero
     */
    public JLabel[][] agregarLabelsCuadricula(JPanel panel){
        panel.removeAll();
        tablero = new JLabel[10][10];
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero[0].length; j++){
                tablero[i][j] = new JLabel();
                tablero[i][j].setOpaque(true);
                tablero[i][j].setBackground(Color.WHITE);
                panel.add(tablero[i][j]);
            }
        }
        panel.validate();
        return tablero;
    }
    
    /**
     * Método que genera la primera fruta del juego en una posición aleatoria del tablero
     */
    public void generarFrutaInicial(){
        fruta = new FrutaVO();
        fruta.setPosicionX((int) Math.round(Math.random() * (ModeloJuego.TAMANIO_TABLERO - 1)));
        fruta.setPosicionY((int) Math.round(Math.random() * (ModeloJuego.TAMANIO_TABLERO - 1)));
        tablero[fruta.getPosicionY()][fruta.getPosicionX()].setBackground(Color.YELLOW);
    }
    
    /**
     * Método que genera la serpiente inicial al 'centro' del tablero
     */
    public void generarSerpiente(){
        snake = new SnakeVO();
        snake.setTamanio(1);
        snake.setPosicionX(5);
        snake.setPosicionY(5);
        tablero[snake.getPosicionY()][snake.getPosicionX()].setBackground(Color.BLUE);
    }
    
    private void habilitarBotonesMovimiento(){
        this.vSnake.btnArriba.setEnabled(true);
        this.vSnake.btnAbajo.setEnabled(true);
        this.vSnake.btnIzquierda.setEnabled(true);
        this.vSnake.btnDerecha.setEnabled(true);
    }
    
    /**
     * Método para administrar las pulsaciones en el botón de Nuevo Juego
     * @param e -> Representa la acción o click del usuario
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vSnake.btnNuevoJuego){
            dificultad = String.valueOf(this.vSnake.cmbDificultad.getSelectedItem());
            habilitarBotonesMovimiento();
            tablero = agregarLabelsCuadricula(this.vSnake.pnlTablero);
            generarFrutaInicial();
            generarSerpiente();
            this.vSnake.lblTamanioSnake.setText(String.valueOf(snake.getTamanio()));
            this.vSnake.lblIntervaloSnake.setText("1000");
            this.modeloJuego.setEstadoSnake(true);
            movSnake = new MovimientoSnake(modeloJuego, vSnake, snake, fruta, tablero, dificultad);
            this.vSnake.cmbDificultad.setEnabled(false);
            this.vSnake.btnNuevoJuego.setEnabled(false);
        }
    }
}