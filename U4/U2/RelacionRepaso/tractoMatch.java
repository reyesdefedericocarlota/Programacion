package U4.U2.RelacionRepaso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class tractoMatch {

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

    // Solicitar potencia
    public static int solicitarPotencia(Scanner scanner, int min, int parametroDefecto) {
        int potencia;
        do {
            try {
                mostrarMensaje("Introduce su potencia:");
                potencia = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                mostrarMensaje("Error, debes introducir un número.");
                potencia = parametroDefecto;
            }

        } while (potencia <= min);

        return potencia;
    }

    // Validar trabajo
    public static String validarTrabajo(Scanner scanner, ArrayList<String> ListaTrabajos) {
        String trabajo;
        boolean trabajoValido = false;

        mostrarMensaje("Introduce el tipo de trabajo que realiza");
        trabajo = scanner.nextLine();
        do {
            for (String t : ListaTrabajos) {
                if (t.equals(trabajo)) {
                    trabajoValido = true;
                }
            }

            if (!trabajoValido) {
                mostrarMensaje("Error, debes introducir un trabajo válido.");
            }
        } while (!trabajoValido);

        return trabajo;
    }

    // Mostrar mensaje
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creo arrays
        ArrayList<String> marcas = new ArrayList<String>();
        ArrayList<Integer> potencias = new ArrayList<Integer>();
        ArrayList<String> trabajos = new ArrayList<String>();
        ArrayList<String> validarTrabajos = new ArrayList<String>(Arrays.asList("arado", "transporte", "siembra"));

        // Creo variables
        final String MENU = "Elige una de las siguientes opciones:\n" +
                "0 = Salir\n" +
                "1 = Añadir tractor\n" +
                "2 = Listar tractores\n" +
                "3 = Evaluar tractor\n" +
                "4 = Eliminar tractor";
        int elegirOpcion;
        String marcaTractor;
        int potenciaTractor;
        String trabajoTractor;

        do {
            elegirOpcion = opcionMenu(scanner, MENU, 0, 4, -1);

            if (elegirOpcion == 1) {
                System.out.println("Introduce la marca del tractor:");
                marcaTractor = scanner.nextLine();
                marcas.add(marcaTractor);

                potenciaTractor = solicitarPotencia(scanner, 0, -1);
                potencias.add(potenciaTractor);

                trabajoTractor = validarTrabajo(scanner, validarTrabajos);
                trabajos.add(trabajoTractor);
            }
        } while (elegirOpcion != 0);
    }
}
