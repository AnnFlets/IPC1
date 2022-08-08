package edu.usac.ipc1.practica1;

import java.util.Scanner;
import operaciones.Aritmetica;
import operaciones.Calculo;
import operaciones.Estadistica;
import operaciones.Trigonometria;

public class Main {

    public static void main(String[] args) {
        //Declaración de objeto tipo scanner y variables
        Scanner lector;
        int opcion = 0;
        boolean banderaPrincipal = true;
        
        //Menú principal
        do {
            System.out.println("=== MENÚ ==="
                    + "\n1- Aritmética"
                    + "\n2- Trigonometría"
                    + "\n3- Estadística"
                    + "\n4- Cálculo"
                    + "\n5- Salir"
                    + "\n\nIngrese la opción a realizar:");
            try {
                lector = new Scanner(System.in);
                opcion = lector.nextInt();
                boolean banderaSubMenus = true;
                switch (opcion) {
                    case 1:
                        while (banderaSubMenus) {
                            Aritmetica aritmetica = new Aritmetica();
                            aritmetica.mostrarMenuAritmetica();
                            try {
                                lector = new Scanner(System.in);
                                opcion = lector.nextInt();
                                switch (opcion) {
                                    case 1:
                                        aritmetica.sumar();
                                        break;
                                    case 2:
                                        aritmetica.restar();
                                        break;
                                    case 3:
                                        aritmetica.multiplicar();
                                        break;
                                    case 4:
                                        aritmetica.dividir();
                                        break;
                                    case 5:
                                        banderaSubMenus = false;
                                        break;
                                    default:
                                        System.out.println("No ha ingresado una opción válida. Intente de nuevo");
                                }
                            } catch (Exception e) {
                                System.out.println("[Error-Menú-Aritmética]: Tipo de dato incorrecto. " + e);
                            }
                        }
                        break;
                    case 2:
                        while (banderaSubMenus) {
                            Trigonometria trigonometria = new Trigonometria();
                            trigonometria.mostrarMenuTrigonometria();
                            try {
                                lector = new Scanner(System.in);
                                opcion = lector.nextInt();
                                switch (opcion) {
                                    case 1:
                                        trigonometria.obtenerSeno();
                                        break;
                                    case 2:
                                        trigonometria.obtenerCoseno();
                                        break;
                                    case 3:
                                        trigonometria.obtenerTangente();
                                        break;
                                    case 4:
                                        banderaSubMenus = false;
                                        break;
                                    default:
                                        System.out.println("No ha ingresado una opción válida. Intente de nuevo");
                                }
                            } catch (Exception e) {
                                System.out.println("[Error-Menú-Trigonometría]: Tipo de dato incorrecto. " + e);
                            }
                        }
                        break;
                    case 3:
                        while (banderaSubMenus) {
                            Estadistica estadistica = new Estadistica();
                            estadistica.mostrarMenuEstadistica();
                            try {
                                lector = new Scanner(System.in);
                                opcion = lector.nextInt();
                                switch (opcion) {
                                    case 1:
                                        estadistica.obtenerMedia();
                                        break;
                                    case 2:
                                        estadistica.obtenerVarianza();
                                        break;
                                    case 3:
                                        estadistica.obtenerDesviacionEstandar();
                                        break;
                                    case 4:
                                        banderaSubMenus = false;
                                        break;
                                    default:
                                        System.out.println("No ha ingresado una opción válida. Intente de nuevo");
                                }
                            } catch (Exception e) {
                                System.out.println("[Error-Menú-Estadística]: Tipo de dato incorrecto. " + e);
                            }
                        }
                        break;
                    case 4:
                        while (banderaSubMenus) {
                            Calculo calculo = new Calculo();
                            calculo.mostrarMenuCalculo();
                            try {
                                lector = new Scanner(System.in);
                                opcion = lector.nextInt();
                                switch (opcion) {
                                    case 1:
                                        calculo.resolverSistemaEcuaciones();
                                        break;
                                    case 2:
                                        banderaSubMenus = false;
                                        break;
                                    default:
                                        System.out.println("No ha ingresado una opción válida. Intente de nuevo");
                                }
                            } catch (Exception e) {
                                System.out.println("[Error-Menú-Cálculo]: Tipo de dato incorrecto. " + e);
                            }
                        }
                        break;
                    case 5:
                        banderaPrincipal = false;
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("No ha ingresado una opción válida. Intente de nuevo");
                }
            } catch (Exception e) {
                System.out.println("[Error-Menú-Principal]: Tipo de dato incorrecto. " + e);
            }
        } while (banderaPrincipal);
    }
}