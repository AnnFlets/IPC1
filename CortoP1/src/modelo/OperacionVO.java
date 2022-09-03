package modelo;

public class OperacionVO {
    //Atributos
    int idProducto;
    String tipoOperacion;
    String fechaHoraOperacion;
    int entrada;
    int salida;

    //Constructor vacío
    public OperacionVO() {
    }

    //Constructor con parámetros
    public OperacionVO(int idProducto, String tipoOperacion, String fechaHoraOperacion, int entrada, int salida) {
        this.idProducto = idProducto;
        this.tipoOperacion = tipoOperacion;
        this.fechaHoraOperacion = fechaHoraOperacion;
        this.entrada = entrada;
        this.salida = salida;
    }

    //Getters & Setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getFechaHoraOperacion() {
        return fechaHoraOperacion;
    }

    public void setFechaHoraOperacion(String fechaHoraOperacion) {
        this.fechaHoraOperacion = fechaHoraOperacion;
    }

    public int getEntrada() {
        return entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public int getSalida() {
        return salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
    }   
}