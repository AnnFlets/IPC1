package modelo;

public class TransaccionVO {
    //Declaración de variables
    private int numeroTransaccion;
    private int cuentaTransaccion;
    private String fechaTransaccion;
    private String detalleTransaccion;
    private double debitoTransaccion;
    private double creditoTransaccion;
    private double saldoTransaccion;

    //Constructo vacío
    public TransaccionVO() {
    }

    //Getters & Setters
    public int getNumeroTransaccion() {
        return numeroTransaccion;
    }

    public void setNumeroTransaccion(int numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    public int getCuentaTransaccion() {
        return cuentaTransaccion;
    }

    public void setCuentaTransaccion(int cuentaTransaccion) {
        this.cuentaTransaccion = cuentaTransaccion;
    }

    public String getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(String fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public String getDetalleTransaccion() {
        return detalleTransaccion;
    }

    public void setDetalleTransaccion(String detalleTransaccion) {
        this.detalleTransaccion = detalleTransaccion;
    }

    public double getDebitoTransaccion() {
        return debitoTransaccion;
    }

    public void setDebitoTransaccion(double debitoTransaccion) {
        this.debitoTransaccion = debitoTransaccion;
    }

    public double getCreditoTransaccion() {
        return creditoTransaccion;
    }

    public void setCreditoTransaccion(double creditoTransaccion) {
        this.creditoTransaccion = creditoTransaccion;
    }
    public double getSaldoTransaccion() {
        return saldoTransaccion;
    }

    public void setSaldoTransaccion(double saldoTransaccion) {
        this.saldoTransaccion = saldoTransaccion;
    }
}