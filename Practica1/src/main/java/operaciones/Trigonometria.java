package operaciones;

import java.util.Scanner;

public class Trigonometria {
    //Declaración de variables y objeto Scanner
    private Scanner lector;
    private int numeroI = 0;
    private double numeroX = 0;
    private double seno = 0;
    private double coseno = 0;
    private double tangente = 0;
    private double numerador = 0;
    private double base = 0;
    private double denominador;

    //Constructor vacío
    public Trigonometria() {
    }

    //Métodos
    public void mostrarMenuTrigonometria() {
        System.out.println("--- TRIGONOMETRÍA ---"
                + "\n1- Seno"
                + "\n2- Coseno"
                + "\n3- Tangente"
                + "\n4- Regresar"
                + "\n\nIngrese la opción a realizar:");
    }

    public void obtenerSeno() {
        System.out.println("- SENO -");
        try {
            lector = new Scanner(System.in);
            System.out.println("Ingrese el valor para x:");
            numeroX = lector.nextDouble();
            System.out.println("Ingrese el valor de i:");
            numeroI = lector.nextInt();
            calcularSeno();
            System.out.println("sen(" + numeroX + ") = " + seno);
        } catch (Exception e) {
            System.err.println("[Error-Seno]: Tipo de dato inválido. " + e);
        }
    }

    public void obtenerCoseno() {
        System.out.println("- COSENO -");
        try {
            lector = new Scanner(System.in);
            System.out.println("Ingrese el valor para x:");
            numeroX = lector.nextDouble();
            System.out.println("Ingrese el valor de i:");
            numeroI = lector.nextInt();
            calcularCoseno();
            System.out.println("cos(" + numeroX + ") = " + coseno);
        } catch (Exception e) {
            System.err.println("[Error-Coseno]: Tipo de dato inválido. " + e);
        }
    }

    public void obtenerTangente() {
        System.out.println("- TANGENTE -");
        try {
            lector = new Scanner(System.in);
            System.out.println("Ingrese el valor para x:");
            numeroX = lector.nextDouble();
            System.out.println("Ingrese el valor de i:");
            numeroI = lector.nextInt();
            calcularSeno();
            calcularCoseno();
            tangente = seno / coseno;
            System.out.println("tan(" + numeroX + ") = " + tangente);
        } catch (Exception e) {
            System.err.println("[Error-Tangente]: Tipo de dato inválido. " + e);
        }
    }

    private void calcularSeno() {
        for (int i = 0; i <= numeroI; i++) {
            numerador = (Math.pow(-1, i)) * (Math.pow(Math.toRadians(numeroX), (2 * i + 1)));
            base = (2 * i) + 1;
            calcularFactorial();
            seno += numerador / denominador;
        }
    }

    private void calcularCoseno() {
        for (int i = 0; i <= numeroI; i++) {
            numerador = (Math.pow(-1, i)) * (Math.pow(Math.toRadians(numeroX), (2 * i)));
            base = 2 * i;
            calcularFactorial();
            coseno += numerador / denominador;
        }
    }

    private void calcularFactorial() {
        denominador = 1;
        while (base > 0) {
            denominador *= base;
            base--;
        }
    }
}