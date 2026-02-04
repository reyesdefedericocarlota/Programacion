package U4.RelacionRepaso;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {

    // Elegir opcion de un menú
    public static int opcionMenu(Scanner introScanner, String textoMenu, int min, int max, int parametroDefecto) {
        int opcion;
        do {
            try {
                mostrarMensaje(textoMenu);
                opcion = Integer.parseInt(introScanner.nextLine());
            } catch (NumberFormatException e) {
                mostrarMensaje("Error, debes introducir un número.");
                opcion = parametroDefecto;
            }
        } while (opcion < min || opcion > max);
        return opcion;
    }

    // Validar precio
    public static int solicitarCantidad(Scanner scanner, int min, int parametroDefecto, String mensaje) {
        int precio;
        do {
            try {
                mostrarMensaje(mensaje);
                precio = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                mostrarMensaje("Error, debes introducir un número.");
                precio = parametroDefecto;
            }

        } while (precio <= min);

        return precio;
    }

    // Listar lotes
    public static void mostrarLote(int i,
            ArrayList<String> modelos,
            ArrayList<Integer> preciosIniciales,
            ArrayList<Integer> mejorPuja,
            ArrayList<String> mejorPostor) {

        mostrarMensaje(i + " -> " + modelos.get(i)
                + " | Inicial: " + preciosIniciales.get(i)
                + " | Mejor puja: " + mejorPuja.get(i)
                + " | Postor: " + mejorPostor.get(i));
    }

    // Validar índice
    public static int validarIndice(Scanner scanner, int min, int parametroDefecto, String mensaje,
            ArrayList<Integer> listaPrecios) {
        int indice;
        do {
            try {
                mostrarMensaje(mensaje);
                indice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                mostrarMensaje("Error, debes introducir un número.");
                indice = parametroDefecto;
            }
        } while (indice < min || indice >= listaPrecios.size());

        return indice;
    }

    // Eliminar lote de todas las listas
    public static String eliminarLote(
            int indiceEliminado,
            ArrayList<String> listaModelos,
            ArrayList<Integer> listaPreciosIniciales,
            ArrayList<String> mejorPostor, ArrayList<Integer> listaMejorPuja) {

        String modeloEliminado = listaModelos.remove(indiceEliminado);
        listaPreciosIniciales.remove(indiceEliminado);
        mejorPostor.remove(indiceEliminado);
        listaMejorPuja.remove(indiceEliminado);

        return modeloEliminado;
    }

    // Mostrar mensaje
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creo arrays
        ArrayList<String> modelos = new ArrayList<String>();
        ArrayList<Integer> preciosIniciales = new ArrayList<Integer>();
        ArrayList<Integer> mejorPuja = new ArrayList<Integer>();
        ArrayList<String> mejorPostor = new ArrayList<String>();

        // Creo variables
        final String MENU = "Elige una de las siguientes opciones:\n" +
                "0 = Salir\n" +
                "1 = Añadir lote\n" +
                "2 = Listar lotes\n" +
                "3 = Hacer puja\n" +
                "4 = Ver ganador actual\n" +
                "5 = Eliminar lote\n";
        final String MENSAJETRACTOR = "Introduce el índice del tractor";
        final String MENSAJEOPCION1 = "Introduce el precio inicial del tractor:";
        final String MENSAJEOPCION3 = "Introduce la cantidad a pujar";
        int elegirOpcion, indice, puja;
        int precioInicial = 0;
        String modeloTractor, nombrePostor, loteEliminado;

        do {
            elegirOpcion = opcionMenu(scanner, MENU, 0, 5, -1);

            if ((elegirOpcion == 2 || elegirOpcion == 3 || elegirOpcion == 4 || elegirOpcion == 5)
                    && modelos.isEmpty()) {
                System.out.println("No hay lotes registrados. Añade uno primero.");

            } else {
                if (elegirOpcion == 1) {
                    System.out.println("Introduce el modelo del tractor:");
                    modeloTractor = scanner.nextLine();
                    modelos.add(modeloTractor);

                    precioInicial = solicitarCantidad(scanner, 0, -1, MENSAJEOPCION1);
                    preciosIniciales.add(precioInicial);

                    mejorPuja.add(0);
                    mejorPostor.add("NADIE");

                } else if (elegirOpcion == 2) {
                    for (int i = 0; i < modelos.size(); i++) {
                        mostrarLote(i, modelos, preciosIniciales, mejorPuja, mejorPostor);
                    }

                } else if (elegirOpcion == 3) {
                    indice = validarIndice(scanner, 0, -1, MENSAJETRACTOR, preciosIniciales);

                    System.out.println("Introduzca su nombre:");
                    nombrePostor = scanner.nextLine();
                    puja = solicitarCantidad(scanner, 0, -1, MENSAJEOPCION3);

                    if (puja >= preciosIniciales.get(indice) && puja > mejorPuja.get(indice)) {
                        mejorPuja.set(indice, puja);
                        mejorPostor.set(indice, nombrePostor);

                    } else if (puja < preciosIniciales.get(indice)) {
                        System.out.println("No llega al precio inicial");

                    } else {
                        System.out.println("No supera la mejor puja");
                    }

                } else if (elegirOpcion == 4) {
                    indice = validarIndice(scanner, 0, -1, MENSAJETRACTOR, preciosIniciales);

                    if (mejorPuja.get(indice) == 0) {
                        System.out.println("Sin pujas todavía");
                    } else {
                        System.out.println(
                                "Va ganando " + mejorPostor.get(indice) + " con una puja de " + mejorPuja.get(indice)
                                        + "€");
                    }

                } else if (elegirOpcion == 5) {
                    indice = validarIndice(scanner, 0, -1, MENSAJETRACTOR, preciosIniciales);

                    loteEliminado = eliminarLote(indice, modelos, preciosIniciales, mejorPostor, mejorPuja);
                    System.out.println("El tractor: " + loteEliminado + " ha sido eliminado.");
                }
            }
        } while (elegirOpcion != 0);
        System.out.println("Ha salido del programa");
    }
}
