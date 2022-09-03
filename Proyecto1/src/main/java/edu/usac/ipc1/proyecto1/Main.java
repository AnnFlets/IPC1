package edu.usac.ipc1.proyecto1;

import controlador.ControladorBanco;
import modelo.ClienteVO;
import modelo.CuentaVO;
import vista.FrmBanco;

public class Main {

    public static void main(String[] args) {
        //Vista
        FrmBanco vBanco = new FrmBanco();
        //Modelos
        ClienteVO clienteVO = new ClienteVO();
        CuentaVO cuentaVO = new CuentaVO();
        //Controlador
        ControladorBanco cBanco = new ControladorBanco(vBanco, clienteVO, cuentaVO);
        //Configuraciones pantalla inicial
        vBanco.setVisible(true);
        vBanco.setLocationRelativeTo(null);
        vBanco.setResizable(false);
    }
}