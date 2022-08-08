package operaciones;

import java.util.Scanner;

public class Aritmetica {
    //Declaración de variables
    private Scanner lector;
    private double numero1 = 0;
    private double numero2 = 0;
    private double resultado;

    //Constructor vacío
    public Aritmetica() {
    }

    //Métodos
    public void mostrarMenuAritmetica() {
        System.out.println("--- ARITMÉTICA ---"
                + "\n1- Suma"
                + "\n2- Resta"
                + "\n3- Multiplicacion"
                + "\n4- División"
                + "\n5- Regresar"
                + "\n\nIngrese la opción a realizar:");
    }

    public void sumar() {
        System.out.println("- SUMA -");
        lector = new Scanner(System.in);
        try {
            System.out.println("Ingrese el primer sumando:");
            numero1 = lector.nextDouble();
            System.out.println("Ingrese el segundo sumando:");
            numero2 = lector.nextDouble();
            resultado = this.numero1 + this.numero2;
            System.out.println(numero1 + " + " + numero2 + " = " + resultado);
        } catch (Exception e) {
            System.err.println("[Error-Suma]: Tipo de dato incorrecto. " + e);
        }
    }

    public void restar() {
        System.out.println("- RESTA -");
        lector = new Scanner(System.in);
        try {
            System.out.println("Ingrese el minuendo:");
            numero1 = lector.nextDouble();
            System.out.println("Ingrese el sustraendo:");
            numero2 = lector.nextDouble();
            resultado = this.numero1 - this.numero2;
            System.out.println(numero1 + " - " + numero2 + " = " + resultado);
        } catch (Exception e) {
            System.err.println("[Error-Resta]: Tipo de dato incorrecto. " + e);
        }
    }

    public void multiplicar() {
        System.out.println("- MULTIPLICACIÓN -");
        lector = new Scanner(System.in);
        try {
            System.out.println("Ingrese el multiplicando:");
            numero1 = lector.nextDouble();
            System.out.println("Ingrese el multiplicador:");
            numero2 = lector.nextDouble();
            resultado = this.numero1 * this.numero2;
            System.out.println(numero1 + " * " + numero2 + " = " + resultado);
        } catch (Exception e) {
            System.err.println("[Error-Multiplicación]: Tipo de dato incorrecto. " + e);
        }
    }

    public void dividir() {
        System.out.println("- DIVISIÓN -");
        lector = new Scanner(System.in);
        System.out.println("Ingrese el dividendo:");
        try {
            numero1 = lector.nextDouble();
            System.out.println("Ingrese el divisor:");
            numero2 = lector.nextDouble();
            if (!(numero2 == 0)) {
                resultado = this.numero1 / this.numero2;
                System.out.println(numero1 + " / " + numero2 + " = " + resultado);
            }else{
                System.out.println("No se puede dividir dentro de cero.");   
            }
        } catch (Exception e) {
            System.err.println("[Error-División]: Tipo de dato incorrecto. " + e);
        }
    }
}