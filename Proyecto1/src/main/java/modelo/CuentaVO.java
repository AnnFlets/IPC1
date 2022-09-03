package modelo;

public class CuentaVO {
    //Declaración de variables
    private int identificadorCuenta;
    private String clienteCuenta;
    private int saldoCuenta;
    
    //Constructor vacío
    public CuentaVO() {
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

    public int getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(int saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    } 
}