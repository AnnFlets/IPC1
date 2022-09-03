package corto1;

import controlador.ControladorMenu;
import controlador.ControladorRegistroProducto;
import modelo.ProductoVO;
import vista.FrmEntradasSalidas;
import vista.FrmHistorialProducto;
import vista.FrmMenu;
import vista.FrmRegistroProducto;

public class Corto1 {

    public static void main(String[] args) {
        //Vistas
        FrmMenu vMenu = new FrmMenu();
        FrmRegistroProducto vRegistro = new FrmRegistroProducto();
        FrmEntradasSalidas vOperacion = new FrmEntradasSalidas();
        FrmHistorialProducto vHistorial = new FrmHistorialProducto();
        //Modelos
        ProductoVO pvo = new ProductoVO();
        //Controladores
        ControladorMenu cMenu = new ControladorMenu(vMenu, vRegistro, vOperacion, vHistorial);
        ControladorRegistroProducto cRegistro = new ControladorRegistroProducto(vRegistro, pvo);
        //Configuración inicial de la vista principal (Menu)
        vMenu.setVisible(true);
        vMenu.setLocationRelativeTo(null);
        vMenu.setResizable(false);
    }
}