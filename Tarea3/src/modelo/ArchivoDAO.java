package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ArchivoDAO {
    ArchivoVO archivoVO = new ArchivoVO();
    String cadena = "";

    /**
     * Constructor con parámetro
     * @param archivo -> recibe un objeto con la ruta y texto/contenido que tendrá el archivo
     */
    public ArchivoDAO(ArchivoVO archivo) {
        this.archivoVO = archivo;
    }
    
    /**
     * Método que abre el archivo y lee su contenido línea por línea
     */
    public void abrirArchivo(){
        File file;
        FileReader fileReader;
        BufferedReader buffer;
        try{
            file = new File(this.archivoVO.getRuta());
            fileReader = new FileReader(file);
            buffer = new BufferedReader(fileReader);
            String linea;
            while((linea = buffer.readLine())!= null){
                cadena += linea + "\n";
            }
            this.archivoVO.setCadena(cadena);
            fileReader.close();
        }catch(Exception e){
            System.err.println("[Error-Archivo]: No se pudo realizar la acción solicitada. " + e.getMessage());
        }        
    }
}