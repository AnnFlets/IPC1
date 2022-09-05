package edu.usac.ipc1.proyecto1;

import controlador.ControladorBanco;
import modelo.ClienteVO;
import modelo.CuentaVO;
import modelo.TransaccionVO;
import vista.FrmBanco;

public class Main {

    public static void main(String[] args) {
        //Vista
        FrmBanco vBanco = new FrmBanco();
        //Modelos
        ClienteVO clienteVO = new ClienteVO();
        CuentaVO cuentaVO = new CuentaVO();
        TransaccionVO transaccionVO = new TransaccionVO();
        //Controlador
        ControladorBanco cBanco = new ControladorBanco(vBanco, clienteVO, cuentaVO, transaccionVO);
        //Configuraciones pantalla inicial
        vBanco.setVisible(true);
        vBanco.setLocationRelativeTo(null);
        vBanco.setResizable(false);
    }
}