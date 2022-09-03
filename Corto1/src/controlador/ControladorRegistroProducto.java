package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.OperacionVO;
import modelo.ProductoVO;
import vista.FrmRegistroProducto;

public class ControladorRegistroProducto implements ActionListener{
    FrmRegistroProducto vRegistro = new FrmRegistroProducto();
    ProductoVO pvo = new ProductoVO();
    ProductoVO[] productos = new ProductoVO[5];
    OperacionVO[] operaciones = new OperacionVO[5];

    public ControladorRegistroProducto(FrmRegistroProducto vRegistro, ProductoVO pvo) {
        this.vRegistro = vRegistro;
        this.pvo = pvo;
        vRegistro.btnCrearProductoRP.addActionListener(this);
    }
    
    private void limpiarCampo(){
        vRegistro.txtNombreProductoRP.setText("");
    }
    
    private void registrarCampo(){
        if(!vRegistro.txtNombreProductoRP.getText().isBlank()){
            for(int i = 0; i < productos.length; i++){
                if(productos[i] == null){
                    productos[i] = new ProductoVO(vRegistro.txtNombreProductoRP.getText());
                    
                }
            }
            
            
            /*pvo.setNombreProducto(vRegistro.txtNombreProductoRP.getText());
            for(int i = 0; i < cMenu.informacionProducto.length; i++){
                String nombre = pvo.getNombreProducto();
                if(nombre.isBlank()){
                    break;
                }
            }*/
        }
    }
    
    private void imprimirProductos(){
        /*for(int i = 0; i < algo.length; i++){
            System.out.println(algo[i].getNombreProducto());
        }*/
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vRegistro.btnCrearProductoRP){
            registrarCampo();
            imprimirProductos();
            
        }
    }
    
}
