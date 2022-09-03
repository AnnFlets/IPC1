package modelo;

public class OperacionVO {
    String tipoOperacion;
    String fechaHoraOperacion;
    int cantidadOperacion;

    public OperacionVO() {
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

    public int getCantidadOperacion() {
        return cantidadOperacion;
    }

    public void setCantidadOperacion(int cantidadOperacion) {
        this.cantidadOperacion = cantidadOperacion;
    }
}