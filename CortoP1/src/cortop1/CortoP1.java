package cortop1;

import controlador.ControladorInventario;
import modelo.OperacionVO;
import modelo.ProductoVO;
import vista.FrmInventario;

public class CortoP1 {
    
static int tablero[][] = {{1,2,3}, {4,5,6}, {7,8,9}};

    public static void main(String[] args) {
        //Vista
        FrmInventario vInventario = new FrmInventario();
        //Modelos
        ProductoVO pvo = new ProductoVO();
        OperacionVO ovo = new OperacionVO();
        //Controlador
        ControladorInventario cInventario = new ControladorInventario(vInventario, pvo, ovo);
        //Configuraciones pantalla inicial
        vInventario.setVisible(true);
        vInventario.setLocationRelativeTo(null);
        vInventario.setResizable(false);
    }
}