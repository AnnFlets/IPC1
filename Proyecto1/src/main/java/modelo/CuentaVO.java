package modelo;

public class CuentaVO {
    //Declaración de variables
    private int identificadorCuenta;
    private String clienteCuenta;
    private double saldoCuenta;
    private TransaccionVO[] transaccionesRealizadas;
    
    //Constructor vacío
    public CuentaVO() {
    }
    
    //Constructor con parámetros
    public CuentaVO(int identificadorCuenta, String clienteCuenta, double saldoCuenta) {
        this.identificadorCuenta = identificadorCuenta;
        this.clienteCuenta = clienteCuenta;
        this.saldoCuenta = saldoCuenta;
        this.transaccionesRealizadas = new TransaccionVO[100];
    }
    
    //Método para agregar una transacción
    public void agregarTransaccion(TransaccionVO transaccion){
        for(int i = 0; i < transaccionesRealizadas.length; i++){
            if(transaccionesRealizadas[i] == null){
                transaccionesRealizadas[i] = transaccion;
                break;
            }
        }
    }

    //Métodos Getter & Setter
    public int getIdentificadorCuenta() {
        return identificadorCuenta;
    }

    public void setIdentificadorCuenta(int identificadorCuenta) {
        this.identificadorCuenta = identificadorCuenta;
    }

    public String getClienteCuenta() {
        return clienteCuenta;
    }

    public void setClienteCuenta(String clienteCuenta) {
        this.clienteCuenta = clienteCuenta;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public TransaccionVO[] getTransaccionesRealizadas() {
        return transaccionesRealizadas;
    }

    public void setTransaccionesRealizadas(TransaccionVO[] transaccionesRealizadas) {
        this.transaccionesRealizadas = transaccionesRealizadas;
    }
}