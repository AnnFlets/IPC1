package project1;

import controlador.ControladorMenu;
import controlador.ControladorRegistroCliente;
import modelo.ClienteDAO;
import modelo.ClienteVO;
import vista.FrmMenu;
import vista.FrmRegistroCliente;

public class Project1 {

    public static void main(String[] args) {
        //Vistas
        FrmMenu vMenu = new FrmMenu();
        FrmRegistroCliente vRegistroCliente = new FrmRegistroCliente();
        //Modelos
        ClienteVO clienteVO = new ClienteVO();
        ClienteDAO clienteDAO = new ClienteDAO();
        //Controladores
        ControladorMenu cMenu = new ControladorMenu(vMenu, vRegistroCliente);
        ControladorRegistroCliente cRegistroCliente = new ControladorRegistroCliente(vRegistroCliente, clienteVO, clienteDAO);
        //Configuraciones pantalla inicial
        vMenu.setVisible(true);
        vMenu.setLocationRelativeTo(null);
        vMenu.setResizable(false);
    }
}