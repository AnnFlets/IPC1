package modelo;

public class ClienteDAO {
    ClienteVO clienteVO = new ClienteVO();
    ClienteVO[] usuarios = new ClienteVO[5];
    int i = 0;
    
    public ClienteVO[] almacenarUsuarios(){
        usuarios[i] = new ClienteVO(clienteVO.getCuiCliente(), clienteVO.getNombreCliente(), clienteVO.getApellidoCliente());
        return usuarios;
    }
}