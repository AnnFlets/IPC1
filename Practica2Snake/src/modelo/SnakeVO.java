package modelo;

public class SnakeVO {
    private int posicionX;
    private int posicionY;
    private int tamanio;

    /**
     * Constructor vacío
     */
    public SnakeVO() {
    }

    /**
     * Constructor con parámetros
     * @param posicionX -> Indica la posición en la que se encuentra la serpiente en el eje horizontal
     * @param posicionY -> Indica la posición en la que se encuentra la serpiente en el eje vertical
     */
    public SnakeVO(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
}