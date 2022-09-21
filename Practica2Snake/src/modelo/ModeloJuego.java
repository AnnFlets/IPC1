package modelo;

public class ModeloJuego {
    public static final int TAMANIO_TABLERO = 10;
    private boolean estadoSnake = true;

    /**
     * Constructor vacío
     */
    public ModeloJuego() {
    }

    public boolean isEstadoSnake() {
        return estadoSnake;
    }

    public void setEstadoSnake(boolean estadoSnake) {
        this.estadoSnake = estadoSnake;
    }
}