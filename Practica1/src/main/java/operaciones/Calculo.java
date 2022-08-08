package operaciones;

import java.util.Scanner;

public class Calculo {
    //Declaración de variables y objeto Scanner
    private Scanner lector;
    private int numeroEcuaciones;
    private double[][] matriz;
    private double pivote = 0;
    private int indicadorOperacion = 0;

    //Constructor vacío
    public Calculo() {
    }

    //Métodos
    public void mostrarMenuCalculo() {
        System.out.println("--- CÁLCULO ---"
                + "\n1- Resolver sistema de ecuaciones lineales de NxN con Gauss-Jordan"
                + "\n2- Regresar"
                + "\n\nIngrese la opción a realizar:");
    }

    /*Perdón por la cantidad inmensa de comentarios en los siguientes métodos, pero es que
    estaba muy complicado lo de Gauss-Jordan y me ayudan a entender lo que hice :)*/
    public void resolverSistemaEcuaciones() {
        try {
            lector = new Scanner(System.in);
            System.out.println("Indique el tamaño del sistema de ecuaciones lineales:");
            numeroEcuaciones = lector.nextInt();
            if (numeroEcuaciones > 0) {
                /*El número de filas es igual al número de ecuaciones que se indiquen y
                el número de columnas es igual al número de incógnitas 
                (variables como x, y, z...) más un coeficiente*/
                matriz = new double[numeroEcuaciones][numeroEcuaciones + 1];
                System.out.println("Indique los coeficientes de cada ecuación utilizando una cadena de valores separados por comas:");
                //Se ejecuta el ciclo hasta ingresar todas las ecuaciones indicadas
                for (int i = 0; i < numeroEcuaciones; i++) {
                    System.out.println("f" + i + " = ");
                    lector = new Scanner(System.in);
                    /*Se divide, por comas, la cadena ingresada y se guardan
                    los coeficientes en el vector 'ecuacion', colocando cada
                    valor en una posición del arreglo*/
                    String[] ecuacion = lector.nextLine().split(",");
                    for (int j = 0; j < ecuacion.length; j++) {
                        /*Se guardan en la matriz cada uno de los coeficientes,
                        como valores reales, de todas las ecuaciones ingresadas*/
                        matriz[i][j] = Double.parseDouble(ecuacion[j]);
                    }
                }
                if (numeroEcuaciones == 1) {
                    //Mostrar la ecuación
                    System.out.println("\nEcuación lineal");
                    imprimirMatriz(matriz);
                    int contador = 0;
                    double numeroDivisor = matriz[0][0];
                    //Resolver la ecuación
                    while (contador < matriz[0].length) {
                        if (contador == 0) {
                            System.out.println("L" + 0 + "/" + numeroDivisor);
                        }
                        matriz[0][contador] = matriz[0][contador] / numeroDivisor;
                        contador++;
                    }
                    imprimirMatriz(matriz);
                    System.out.println("--- El resultado de la ecuación es: " + matriz[0][1] + "\n");
                } else {
                    //Mostrar la matriz aumentada
                    System.out.println("\nMatriz aumentada");
                    imprimirMatriz(matriz);
                    System.out.print("----------------------------------------\n\n");
                    //Procedimiento de Gauss-Jordan
                    resolverDiagonalPrincipal(matriz);
                    resolverEscaleraIzquierda(matriz);
                    resolverEscaleraDerecha(matriz);
                    mostrarResultado(matriz);
                }
            } else {
                System.out.println("El sistema no posee ecuaciones");
            }
        } catch (Exception e) {
            System.err.println("[Error-Cálculo]: " + e);
        }
    }

    //Imprime la matriz con los valores actuales
    private void imprimirMatriz(double matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print((matriz[i][j]) + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    /*Resuelve la diagonal principal de la matriz, haciendo que los valores
    que se encuentren en esta sean 1.0*/
    private void resolverDiagonalPrincipal(double matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            //El pivote va a tomar los valores de la diagonal principal
            pivote = matriz[i][i];
            indicadorOperacion = 0;
            for (int j = 0; j < matriz[0].length; j++) {
                if (pivote != 1) {
                    if (j == 0) {
                        System.out.println("L" + i + "/" + pivote);
                    }
                    /*Se dividen todos los elementos de la fila dentro del pivote
                    para hacer que los números de la diagonal principal sean 1.0*/
                    matriz[i][j] = matriz[i][j] / pivote;
                    indicadorOperacion = 1;
                }
            }
            //Solo imprimirá la matriz si se realizó una operación en la fila de la matriz
            if (indicadorOperacion == 1) {
                imprimirMatriz(matriz);
            }
        }
    }

    //Resuelve el sistema a través de Gauss
    private void resolverEscaleraIzquierda(double matriz[][]) {
        for (int j = 0; j < (matriz[0].length - 2); j++) {
            for (int i = j + 1; i < matriz.length; i++) {
                //El pivote tomará el valor del número que queremos hacer 0.
                pivote = matriz[i][j];
                for (int k = 0; k < matriz[0].length; k++) {
                    if (k == 0) {
                        System.out.println("L" + i + " - L" + j + " * " + pivote);
                    }
                    matriz[i][k] = (matriz[j][k] * pivote) - matriz[i][k];
                }
                imprimirMatriz(matriz);
            }
            resolverDiagonalPrincipal(matriz);
        }
        resolverDiagonalPrincipal(matriz);
    }

    //Termina de resolver el sistema por Gauss-Jordan
    private void resolverEscaleraDerecha(double matriz[][]) {
        for (int j = (matriz[0].length - 2); j > 0; j--) {
            for (int i = j - 1; i >= 0; i--) {
                //El pivote tomará el valor del número que queremos hacer 0.
                pivote = matriz[i][j];
                for (int k = 0; k < matriz[0].length; k++) {
                    if (k == 0) {
                        System.out.println("L" + i + " - L" + j + " * " + pivote);
                    }
                    matriz[i][k] = (matriz[j][k] * pivote) - matriz[i][k];
                }
                imprimirMatriz(matriz);
            }
            resolverDiagonalPrincipal(matriz);
        }
        resolverDiagonalPrincipal(matriz);
    }

    //Imprime el resultado del sistema de ecuaciones
    private void mostrarResultado(double matriz[][]) {
        System.out.println("--- El resultado del sistema de ecuaciones es: ");
        for (int contador = 0; contador < matriz.length; contador++) {
            System.out.println(matriz[contador][(matriz[0].length - 1)]);
        }
        System.out.println("");
    }
}