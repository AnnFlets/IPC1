package modelo;

public class FrutaVO {
    private int posicionX;
    private int posicionY;

    /**
     * Constructor vacío
     */
    public FrutaVO() {
    }

    /**
     * Constructor con parámetros
     * @param posicionX -> Indica la posición en la que se encuentra la fruta en el eje horizontal
     * @param posicionY -> Indica la posición en la que se encuentra la fruta en el eje vertical
     */
    public FrutaVO(int posicionX, int posicionY) {
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
}