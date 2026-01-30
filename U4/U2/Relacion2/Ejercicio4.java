package U4.U2.Relacion2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio4 {

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

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

 

    public static void mostrarIventario(ArrayList<String> listaLibros, ArrayList<Integer> listaCantidadLibros) {
        for (int i = 0; i < listaLibros.size(); i++) {
            mostrarMensaje("Título: " + listaLibros.get(i) + " - Número de ejemplares: " + listaCantidadLibros.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creo arrays
        ArrayList<String> libros = new ArrayList<String>();
        ArrayList<Integer> cantidadLibros = new ArrayList<Integer>();

        // Creo variables
        final String textoMenu = "Elige una de las siguientes opciones:\n1.Añadir un nuevo libro al inventario (con su título y cantidad). \n2.Actualizar la cantidad de un libro existente. \n3.Ver el inventario completo (título y cantidad de cada libro). \n4.Salir del programa.";
        int elegirOpcion;
        String tituloLibro;
        int cantidadLibro;

        do {
            elegirOpcion = opcionMenu(scanner, textoMenu, 1, 4, -1);

            if (elegirOpcion == 1) {
                System.out.println("Introduce el título del libro:");
                tituloLibro = scanner.nextLine();
                libros.add(tituloLibro);

                System.out.println("Introduce la cantidad de ejemplares del libro:");
                cantidadLibro = scanner.nextInt();
                scanner.nextLine();
                cantidadLibros.add(cantidadLibro);

            } else if (elegirOpcion == 2) {
                System.out.println("Introduce el título del libro del que desea actualizar la cantidad:");
                tituloLibro = scanner.nextLine();
                for (int i = 0; i < libros.size(); i++) {
                    if (libros.get(i).equals(tituloLibro)) {
                        System.out.println("Introduce la nueva cantidad:");
                        cantidadLibro = scanner.nextInt();
                        cantidadLibros.set(i, cantidadLibro);
                    }
                }

            } else {
                mostrarIventario(libros, cantidadLibros);
            }

        } while (elegirOpcion != 4);

    }

}

// 4. Gestión de Inventario de una Librería
// Escribe un programa que permita al usuario gestionar el inventario de una
// librería. El programa debe usar dos arrays: uno para almacenar los títulos de
// los libros y otro para almacenar las cantidades disponibles de cada libro. El
// usuario debe poder realizar las siguientes acciones a través de un menú:

// 1.Añadir un nuevo libro al inventario (con su título y cantidad).
// 2.Actualizar la cantidad de un libro existente.
// 3.Ver el inventario completo (título y cantidad de cada libro).
// 4.Salir del programa.
// El programa debe actualizar el inventario según las acciones del usuario y
// seguir ejecutándose hasta que se elija la opción de salir.
