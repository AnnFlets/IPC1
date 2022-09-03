package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ProductoVO;
import vista.FrmEntradasSalidas;
import vista.FrmHistorialProducto;
import vista.FrmMenu;
import vista.FrmRegistroProducto;

public class ControladorMenu implements ActionListener{
    FrmMenu vMenu = new FrmMenu();
    FrmRegistroProducto vRegistro = new FrmRegistroProducto();
    FrmEntradasSalidas vOperacion = new FrmEntradasSalidas();
    FrmHistorialProducto vHistorial = new FrmHistorialProducto();
    ProductoVO[] informacionProducto = new ProductoVO[100];

    public ControladorMenu() {
    }

    public ControladorMenu(FrmMenu vMenu, FrmRegistroProducto vRegistro, FrmEntradasSalidas vOperacion, FrmHistorialProducto vHistorial) {
        this.vMenu = vMenu;
        this.vRegistro = vRegistro;
        this.vOperacion = vOperacion;
        this.vHistorial = vHistorial;
        this.vMenu.menuItemCrearProducto.addActionListener(this);
        this.vMenu.menuItemEntradasSalidas.addActionListener(this);
        this.vMenu.menuItemHistorialProductos.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vMenu.menuItemCrearProducto){
            this.vRegistro.setVisible(true);
            this.vRegistro.setLocationRelativeTo(null);
            this.vRegistro.setResizable(false);
        }
        if(e.getSource() == vMenu.menuItemEntradasSalidas){
            this.vOperacion.setVisible(true);
            this.vOperacion.setLocationRelativeTo(null);
            this.vOperacion.setResizable(false);
        }
        if(e.getSource() == vMenu.menuItemHistorialProductos){
            this.vHistorial.setVisible(true);
            this.vHistorial.setLocationRelativeTo(null);
            this.vHistorial.setResizable(false);
        }
    }
}