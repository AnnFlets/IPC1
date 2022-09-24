package modelo;

public class ArchivoVO {
    private String cadena;
    private String ruta;

    /**
     * Constructor vacío
     */
    public ArchivoVO() {
    }

    /**
     * Getters & Setters
     */
    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}