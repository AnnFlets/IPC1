package edu.usac.ipc1.tarea1;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        //Declaración de objeto tipo Scanner y variables
        Scanner lector = new Scanner(System.in);
        int sumaPar = 0;
        int sumaImpar = 0;
        System.out.println("Ingrese una cadena con números enteros separados por comas:");
        //Llena un arreglo tipo String, ingresando en cada posición cada uno de los
        //valores de la cadena separados por coma
        String[] cadena = lector.nextLine().split(",");
        //Captura de excepciones
        try {
            //Se va a recorrer cada una de las posiciones del arreglo
            for (int i = 0; i < cadena.length; i++) {
                if ((Integer.parseInt(cadena[i]) % 2) == 0) {
                    System.out.println("El número " + cadena[i] + " es par");
                    sumaPar += Integer.parseInt(cadena[i]);
                } else {
                    System.out.println("El número " + cadena[i] + " es impar");
                    sumaImpar += Integer.parseInt(cadena[i]);
                }
            }
            System.out.println("\nLa suma de los números pares es: " + sumaPar);
            System.out.println("La suma de los números impares es: " + sumaImpar);
            if (sumaPar > sumaImpar) {
                System.out.println("\nLa suma de los números pares es mayor a la de los impares");
            } else if (sumaPar < sumaImpar) {
                System.out.println("\nLa suma de los números impares es mayor a la de los pares");
            } else {
                System.out.println("\nLa suma de los números pares y de los impares es igual");
            }
        } catch (Exception e) {
            System.err.println("[Error]: Tipo de dato inválido. " + e);
        }
    }
}