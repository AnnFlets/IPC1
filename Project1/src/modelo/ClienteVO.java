package modelo;

public class ClienteVO {
    //Declaración de variables
    private long cuiCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String[] cuentasAsociadasCliente = new String[5];
    
    //Constructor vacío
    public ClienteVO() {
    }
    
    //Constructor con parámetros
    public ClienteVO(long cuiCliente, String nombreCliente, String apellidoCliente) {
        this.cuiCliente = cuiCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }
    
    //Métodos Getter & Setter
    public long getCuiCliente() {
        return cuiCliente;
    }

    public void setCuiCliente(long cuiCliente) {
        this.cuiCliente = cuiCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String[] getCuentasAsociadasCliente() {
        return cuentasAsociadasCliente;
    }

    public void setCuentasAsociadasCliente(String[] cuentasAsociadasCliente) {
        this.cuentasAsociadasCliente = cuentasAsociadasCliente;
    }
}