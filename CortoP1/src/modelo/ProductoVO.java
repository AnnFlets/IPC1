package modelo;

public class ProductoVO {
    //Atributos
    int idProducto;
    String nombreProducto;

    //Constructor vacío
    public ProductoVO() {
    }
    
    //Constructor con parámetros
    public ProductoVO(int idProducto, String nombreProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
    }

    //Getters & Setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}