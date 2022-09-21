package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.FrutaVO;
import modelo.ModeloJuego;
import modelo.SnakeVO;
import vista.FrmSnake;

public class MovimientoSnake implements Runnable, ActionListener {

    Thread hilo;
    FrmSnake vSnake = new FrmSnake();
    SnakeVO snake = new SnakeVO();
    FrutaVO fruta = new FrutaVO();
    ModeloJuego modeloJuego = new ModeloJuego();
    JLabel[][] tablero = new JLabel[10][10];
    String direccion = "";
    String dificultad = "";
    int contadorFrutas = 1;
    int velocidad = 1000;

    /**
     * Constructor vacío
     */
    public MovimientoSnake() {
    }

    /**
     * Constructor con parámetros
     *
     * @param modeloJuego -> Representa el estado de la serpiente, si está viva
     * o no
     * @param vSnake -> Representa la vista, el JFrame
     * @param snake -> Representa la serpiente (posición en X y Y, y su tamanio)
     * @param fruta -> Representa la fruta (posición en X y Y)
     * @param tablero -> Representa el arreglo de JLabels de la vista
     * @param dificultad -> Representa el valor seleccionado en el comboBox de
     * la vista Se inicializa y comienza a ejecutarse el hilo Se agrega una
     * acción a los botones de movimiento de la vista
     */
    public MovimientoSnake(ModeloJuego modeloJuego, FrmSnake vSnake, SnakeVO snake, FrutaVO fruta, JLabel[][] tablero, String dificultad) {
        this.vSnake = vSnake;
        this.snake = snake;
        this.fruta = fruta;
        this.dificultad = dificultad;
        this.modeloJuego = modeloJuego;
        this.tablero = tablero;
        hilo = new Thread(this, "Hilo Movimiento");
        hilo.start();
        this.vSnake.btnArriba.addActionListener(this);
        this.vSnake.btnAbajo.addActionListener(this);
        this.vSnake.btnIzquierda.addActionListener(this);
        this.vSnake.btnDerecha.addActionListener(this);
    }

    /**
     * Método del hilo
     */
    @Override
    public void run() {
        try {
            while (verificarExistenciaSnake()) {
                if (contadorFrutas != 25) {
                    moverSnake();
                    verificarComerFruta();
                    Thread.sleep(velocidad);
                } else {
                    this.modeloJuego.setEstadoSnake(false);
                    this.vSnake.jopMensaje.showMessageDialog(null, "La serpiente ha alcanzado su tamaño máximo.",
                            "Información", JOptionPane.INFORMATION_MESSAGE);
                    deshabilitarBotonesMovimiento();
                }
            }
            this.vSnake.cmbDificultad.setEnabled(true);
            this.vSnake.btnNuevoJuego.setEnabled(true);
        } catch (InterruptedException e) {
            System.err.println("[Error-Hilo]: " + e.getMessage());
        }
    }

    /**
     * Método que genera una fruta nueva en una posición aleatoria del tablero
     */
    private void generarFruta() {
        fruta = new FrutaVO();
        int posicionX = (int) Math.round(Math.random() * (ModeloJuego.TAMANIO_TABLERO - 1));
        int posicionY = (int) Math.round(Math.random() * (ModeloJuego.TAMANIO_TABLERO - 1));
        while (posicionX == this.snake.getPosicionX() && posicionY == this.snake.getPosicionY()) {
            posicionX = (int) Math.round(Math.random() * (ModeloJuego.TAMANIO_TABLERO - 1));
            posicionY = (int) Math.round(Math.random() * (ModeloJuego.TAMANIO_TABLERO - 1));
        }
        fruta.setPosicionX(posicionX);
        fruta.setPosicionY(posicionY);
        tablero[fruta.getPosicionY()][fruta.getPosicionX()].setBackground(Color.YELLOW);
    }

    /**
     * Método que verifica si la serpiente se come una fruta (Si están en la
     * misma posición X y Y)
     */
    private void verificarComerFruta() {
        if (this.snake.getPosicionX() == this.fruta.getPosicionX()
                && this.snake.getPosicionY() == this.fruta.getPosicionY()) {
            contadorFrutas++;
            this.vSnake.lblTamanioSnake.setText(String.valueOf(contadorFrutas));
            generarFruta();
            cambiarVelocidadSnake();
            this.vSnake.lblIntervaloSnake.setText(String.valueOf(velocidad));
        }
    }

    /**
     * Método que calcula, dependiendo de la dificultad, la nueva velocidad a la
     * que debe moverse la serpiente
     */
    private void cambiarVelocidadSnake() {
        int restarVelocidad = 0;
        switch (dificultad) {
            case "Fácil":
                restarVelocidad = (int) Math.round(velocidad * 0.03);
                velocidad = velocidad - restarVelocidad;
                break;
            case "Medio":
                restarVelocidad = (int) Math.round(velocidad * 0.06);
                velocidad = velocidad - restarVelocidad;
                break;
            case "Difícil":
                restarVelocidad = (int) Math.round(velocidad * 0.09);
                velocidad = velocidad - restarVelocidad;
                break;
        }
    }

    /**
     * Método que retorna el estado de la serpiente
     *
     * @return -> true = viva | false = muerta
     */
    private boolean verificarExistenciaSnake() {
        return this.modeloJuego.isEstadoSnake();
    }

    private void deshabilitarBotonesMovimiento() {
        this.vSnake.btnArriba.setEnabled(false);
        this.vSnake.btnAbajo.setEnabled(false);
        this.vSnake.btnIzquierda.setEnabled(false);
        this.vSnake.btnDerecha.setEnabled(false);
    }

    /**
     * Método que se manda a llamar al momento en que la serpiente choca con un
     * muro
     */
    private void chocarConMuro() {
        this.modeloJuego.setEstadoSnake(false);
        this.vSnake.jopMensaje.showMessageDialog(null, "La serpiente ha chocado con un muro.",
                "Advertencia", JOptionPane.WARNING_MESSAGE);
        deshabilitarBotonesMovimiento();
    }

    /**
     * Método para controlar el movimiento de la Serpiente
     */
    private void moverSnake() {
        int posicionY = this.snake.getPosicionY();
        int posicionX = this.snake.getPosicionX();
        switch (direccion) {
            case "arriba":
                if (posicionY > 0) {
                    this.tablero[posicionY][posicionX].setBackground(Color.WHITE);
                    this.snake.setPosicionY(posicionY - 1);
                    this.tablero[this.snake.getPosicionY()][posicionX].setBackground(Color.BLUE);
                } else {
                    chocarConMuro();
                }
                break;
            case "abajo":
                if (posicionY < (ModeloJuego.TAMANIO_TABLERO - 1)) {
                    this.tablero[posicionY][posicionX].setBackground(Color.WHITE);
                    this.snake.setPosicionY(posicionY + 1);
                    this.tablero[this.snake.getPosicionY()][posicionX].setBackground(Color.BLUE);
                } else {
                    chocarConMuro();
                }
                break;
            case "izquierda":
                if (posicionX > 0) {
                    this.tablero[posicionY][posicionX].setBackground(Color.WHITE);
                    this.snake.setPosicionX(posicionX - 1);
                    this.tablero[posicionY][this.snake.getPosicionX()].setBackground(Color.BLUE);
                } else {
                    chocarConMuro();
                }
                break;
            case "derecha":
                if (posicionX < (ModeloJuego.TAMANIO_TABLERO - 1)) {
                    this.tablero[posicionY][posicionX].setBackground(Color.WHITE);
                    this.snake.setPosicionX(posicionX + 1);
                    this.tablero[posicionY][this.snake.getPosicionX()].setBackground(Color.BLUE);
                } else {
                    chocarConMuro();
                }
                break;
        }
    }

    /**
     * Método para administrar las pulsaciones en los botones de movimiento
     *
     * @param e -> Representa la acción o click del usuario
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vSnake.btnArriba) {
            direccion = "arriba";
        }
        if (e.getSource() == this.vSnake.btnAbajo) {
            direccion = "abajo";
        }
        if (e.getSource() == this.vSnake.btnIzquierda) {
            direccion = "izquierda";
        }
        if (e.getSource() == this.vSnake.btnDerecha) {
            direccion = "derecha";
        }
    }
}
