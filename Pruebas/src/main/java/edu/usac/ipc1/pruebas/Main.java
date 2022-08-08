package edu.usac.ipc1.pruebas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner lector;
        int numeroEcuaciones;
        double[][] matriz;

        try {
            lector = new Scanner(System.in);
            System.out.println("Indique el tamaño del sistema de ecuaciones lineales:");
            numeroEcuaciones = lector.nextInt();
            if (numeroEcuaciones > 0) {
                System.out.println("Indique los coeficientes de cada ecuación utilizando una cadena de valores separados por comas:");
                matriz = new double[numeroEcuaciones][numeroEcuaciones + 1];
                for (int i = 0; i < numeroEcuaciones; i++) {
                    System.out.println("f" + i + " = ");
                    lector = new Scanner(System.in);
                    String[] cadena = lector.nextLine().split(",");
                    for (int j = 0; j < cadena.length; j++) {
                        matriz[i][j] = Double.parseDouble(cadena[j]);
                    }
                }
                imprimirMatriz(matriz);
                resolverSistema(matriz);
            } else {
                System.out.println("El sistema no tiene ecuaciones");
            }
        } catch (Exception e) {
            System.err.println("[Error-Cálculo]: " + e);
        }
    }

    private static void imprimirMatriz(double matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print((matriz[i][j]) + "\t");
            }
            System.out.println("");
        }
        System.out.println("matriz.length " + matriz.length);
        System.out.println("matriz[0].length " + matriz[0].length);
    }

    private static void resolverSistema(double matriz[][]) {
        double pivote;
        //Se recorre la matriz
        for (int i = 0; i < matriz.length; i++) {
            //El pivote va a tomar los valores de la diagonal principal
            pivote = matriz[i][i];
            for (int j = 0; j < matriz[0].length; j++) {
                if (j == 0) {
                    System.out.print("L" + i + "/" + pivote);
                }
                //Se dividen todos los elementos de la matriz dentro del pivote
                //para hacer que los números de la diagonal principal sean 1.0
                matriz[i][j] = matriz[i][j] / pivote;
            }
            System.out.println("");
            imprimirMatriz(matriz);
        }
        for (int i = 0; i < matriz.length; i++) {
            pivote = matriz[i][i];
            if (i < matriz.length - 1) {
                for (int j = i + 1; j < matriz.length; j++) {
                    pivote = matriz[i][i];
                    for (int k = 0; k < matriz[0].length; k++) {
                        matriz[j][k] = matriz[j][k] - (pivote * matriz[i][k]);
                    }
                }
            }
        }
        for(int i = (matriz.length - 1); i >=1 ; i--){
            for(int j = i-1; j>=0 ; j--){
                pivote = matriz[j][i];
                for(int k = matriz[0].length - 1; k >=0 ;k--){
                    matriz[j][k] = matriz[j][k] - (pivote * matriz[i][k]);
                }
            }
        }
        imprimirMatriz(matriz);
    }
}
