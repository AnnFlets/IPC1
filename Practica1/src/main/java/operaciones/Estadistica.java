package operaciones;

import java.util.Scanner;

public class Estadistica {
    //Declaración de variables y objeto Scanner
    private Scanner lector;
    private String cadena = "";
    private double media = 0;
    private double varianza = 0;
    private String[] valores;

    //Constructor vacío
    public Estadistica() {
    }

    //Métodos
    public void mostrarMenuEstadistica() {
        System.out.println("--- ESTADÍSTICA ---"
                + "\n1- Media"
                + "\n2- Varianza"
                + "\n3- Desviación estándar"
                + "\n4- Regresar"
                + "\n\nIngrese la opción a realizar:");
    }

    public void obtenerMedia() {
        System.out.println("- MEDIA -");
        try {
            calcularMedia();
            System.out.println("La media de: " + cadena + " es = " + media);
        } catch (Exception e) {
            System.err.println("[Error-Media]: Tipo de dato inválido. " + e);
        }

    }

    public void obtenerVarianza() {
        System.out.println("- VARIANZA -");
        try {
            calcularVarianza();
            System.out.println("La varianza de: " + cadena + " es = " + varianza);
        } catch (Exception e) {
            System.err.println("[Error-Varianza]: Tipo de dato inválido. " + e);
        }
    }

    public void obtenerDesviacionEstandar() {
        System.out.println("- DESVIACIÓN ESTÁNDAR -");
        try {
            calcularVarianza();
            System.out.println("La desviación estándar de: " + cadena + " es = " + Math.sqrt(varianza));
        } catch (Exception e) {
            System.err.println("[Error-Desviación]: Tipo de dato inválido. " + e);
        }
    }

    private void calcularMedia() {
        lector = new Scanner(System.in);
        System.out.println("Ingrese una cadena de números separada por comas:");
        cadena = lector.nextLine();
        valores = cadena.split(",");
        for (int i = 0; i < valores.length; i++) {
            media = media + (1/Double.parseDouble(valores[i]));
        }
        media = (valores.length)/media;
    }

    private void calcularVarianza() {
        calcularMedia();
        for (int i = 0; i < valores.length; i++) {
            varianza = varianza + Math.pow((Double.parseDouble(valores[i]) - media), 2);
        }
        varianza = varianza / (valores.length);
    }
}