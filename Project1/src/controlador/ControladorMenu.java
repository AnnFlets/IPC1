package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ClienteVO;
import vista.FrmMenu;
import vista.FrmRegistroCliente;

public class ControladorMenu implements ActionListener {

    FrmMenu vMenu = new FrmMenu();
    FrmRegistroCliente vRegistroCliente = new FrmRegistroCliente();

    public ControladorMenu(FrmMenu vMenu, FrmRegistroCliente vRegistroCliente) {
        this.vMenu = vMenu;
        this.vRegistroCliente = vRegistroCliente;
        this.vMenu.mItemCrearCliente.addActionListener(this);
        this.vMenu.mItemCrearCuenta.addActionListener(this);
        this.vMenu.mItemInformacionCliente.addActionListener(this);
        this.vMenu.mItemDeposito.addActionListener(this);
        this.vMenu.mItemTransferencia.addActionListener(this);
        this.vMenu.mItemPagoServicios.addActionListener(this);
        this.vMenu.mItemHistorial.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vMenu.mItemCrearCliente) {
            vRegistroCliente.setVisible(true);
            vRegistroCliente.setLocationRelativeTo(null);
            vRegistroCliente.setResizable(false);
        }
    }

}
