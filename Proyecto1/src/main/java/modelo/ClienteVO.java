package modelo;

public class ClienteVO {
    //Declaración de variables
    private String cuiCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private CuentaVO[] cuentasAsociadas;
    
    //Constructor vacío
    public ClienteVO() {
    }
    
    //Constructor con parámetros
    public ClienteVO(String cuiCliente, String nombreCliente, String apellidoCliente) {
        this.cuiCliente = cuiCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }
    
    //Constructor con todos los atributos de la clase
    public ClienteVO(String cuiCliente, String nombreCliente, String apellidoCliente, CuentaVO[] cuentasAsociadas) {
        this.cuiCliente = cuiCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.cuentasAsociadas = new CuentaVO[5];
    }
    
    //Método para agregar una cuenta
    public void agregarCuentaAsociada(CuentaVO cuenta){
        for(int i = 0; i < cuentasAsociadas.length; i++){
            if(cuentasAsociadas[i] == null){
                cuentasAsociadas[i] = cuenta;
                break;
            }
        }
    }
    
    //Métodos Getter & Setter
    public String getCuiCliente() {
        return cuiCliente;
    }

    public void setCuiCliente(String cuiCliente) {
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

    public CuentaVO[] getCuentasAsociadas() {
        return cuentasAsociadas;
    }

    public void setCuentasAsociadas(CuentaVO[] cuentasAsociadas) {
        this.cuentasAsociadas = cuentasAsociadas;
    }
}