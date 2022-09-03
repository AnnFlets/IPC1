package modelo;

public class ProductoVO {
    private String nombreProducto;
    private OperacionVO[] operaciones;
    
    public ProductoVO() {
    }

    public ProductoVO(String nombreProducto) {
        this.nombreProducto = nombreProducto;
        this.operaciones = new OperacionVO[5];
    }
    
    public void agregarOperaoion(OperacionVO operacion){
        for(int i = 0; i < operaciones.length; i++){
            if(operaciones[i] == null){
                operaciones[i] = operacion;
                break;
            }
        }
    }
    
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}