package U4.U2.Relacion2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {

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

    public static void mostrarJugadores(ArrayList<String> listaJugadores, ArrayList<Integer> listaPuntuaciones) {
        for (int i = 0; i < listaJugadores.size(); i++) {
            mostrarMensaje("La puntuación de " + listaJugadores.get(i) + " es " + listaPuntuaciones.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> jugadores = new ArrayList<String>(
                Arrays.asList("Jugador1", "Jugador2", "Jugador3", "Jugador4", "Jugador5"));
        ArrayList<Integer> puntuaciones = new ArrayList<Integer>(Arrays.asList(120, 200, 150, 180, 220));

        // Creo variables
        int elegirOpcion;
        final String MENU = "Elige una de las siguientes opciones:\n" +
                "1 = Añadir un nuevo jugador y su puntuación\n" +
                "2 = Mostrar los jugadores y sus puntuaciones actuales\n" +
                "3 = Salir del programa.";
        String jugador;
        int puntuacion;

        do {

            elegirOpcion = opcionMenu(scanner, MENU, 1, 3, -1);

            if (elegirOpcion == 1) {
                jugadores.remove(0);
                puntuaciones.remove(0);
                System.out.println("Introduce el nombre del jugador: ");
                jugador = scanner.nextLine();
                jugadores.add(jugador);

                do {
                    try {
                        System.out.println("Introduce su puntuación:");
                        puntuacion = Integer.parseInt(scanner.nextLine());

                    } catch (NumberFormatException e) {
                        System.out.println("Error, debes introducir un número.");
                        puntuacion = -1;
                    }

                } while (puntuacion < 1);

                puntuaciones.add(puntuacion);

            } else if (elegirOpcion == 2) {
                mostrarJugadores(jugadores, puntuaciones);
            }

        } while (elegirOpcion != 3);

        scanner.close();
    }
}

// 2. Sistema de Puntuación de un Videojuego
// Escribe un programa que gestione las puntuaciones de los jugadores en un
// videojuego utilizando dos arrays: uno para los nombres de los jugadores y
// otro para sus respectivas puntuaciones. El programa debe funcionar de la
// siguiente manera:
// 1. Crea dos arrays:
// - Uno para almacenar los nombres de los últimos 5 jugadores.
// - Otro para almacenar las puntuaciones correspondientes de esos jugadores.

// 2. El programa debe mostrar un menú con las siguientes opciones:

// - Añadir un nuevo jugador y su puntuación: El usuario debe poder ingresar el
// nombre del jugador y su puntuación. La información del jugador más antiguo
// (el primer elemento de ambos arrays) debe ser eliminada y los nuevos datos
// deben añadirse al final de ambos arrays.
// - Mostrar los jugadores y sus puntuaciones actuales: Se deben mostrar los
// nombres de los jugadores junto con sus respectivas puntuaciones.
// - Salir del programa: Terminar la ejecución del programa.

// 3.Ejecución continua: El programa debe seguir ejecutándose hasta que el
// usuario seleccione la opción de salir.
