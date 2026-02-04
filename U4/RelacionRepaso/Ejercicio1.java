package U4.RelacionRepaso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1 {

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

        do {
            mostrarMensaje("Introduce el tipo de trabajo que realiza:");
            trabajo = scanner.nextLine();

            for (String t : ListaTrabajos) {
                if (t.equals(trabajo.toLowerCase())) {
                    trabajoValido = true;
                }
            }

            if (!trabajoValido) {
                mostrarMensaje("Error, debes introducir un trabajo válido.");
            }
        } while (!trabajoValido);

        return trabajo;
    }

    // Validar índice
    public static int validarIndice(Scanner scanner, int min, int parametroDefecto, String mensaje,
            ArrayList<Integer> listaTractores) {
        int indice;
        do {
            try {
                mostrarMensaje(mensaje);
                indice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                mostrarMensaje("Error, debes introducir un número.");
                indice = parametroDefecto;
            }
        } while (indice < min || indice >= listaTractores.size());

        return indice;
    }

    // Calcular tractor apto
    public static void calcularApto(ArrayList<Integer> listaPotencias, int indiceValido, int min) {
        int aleatorio = (int) (Math.random() * 2);

        if (listaPotencias.get(indiceValido) >= min) {
            mostrarMensaje("Resultado: APTO");
            if (aleatorio == 1) {
                mostrarMensaje("El tractor está listo para el trabajo 💪");
            } else {
                mostrarMensaje("Rendimiento adecuado, puede usarse sin problemas");
            }
        } else {
            mostrarMensaje("Resultado: NO APTO");
            if (aleatorio == 1) {
                mostrarMensaje("La potencia es insuficiente para este trabajo");
            } else {
                mostrarMensaje("No cumple los requisitos mínimos");
            }
        }
    }

    // Eliminar tractor
    public static String eliminarTractor(
            int indiceEliminado,
            ArrayList<String> listaMarcas,
            ArrayList<Integer> listaPotencias,
            ArrayList<String> listaTrabajos) {

        String marcaEliminada = listaMarcas.remove(indiceEliminado);
        listaPotencias.remove(indiceEliminado);
        listaTrabajos.remove(indiceEliminado);

        return marcaEliminada;
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
        final String MENSAJEOPCION3 = "Introduce el índice del tractor que desea evaluar:";
        final String MENSAJEOPCION4 = "Introduce el índice del tractor que desea eliminar:";
        int elegirOpcion;
        String marcaTractor;
        int potenciaTractor;
        String trabajoTractor;
        int indice;
        int potenciaMinima;
        String tractorEliminado;

        do {
            elegirOpcion = opcionMenu(scanner, MENU, 0, 4, -1);

            if ((elegirOpcion == 2 || elegirOpcion == 3 || elegirOpcion == 4) && marcas.isEmpty()) {
                System.out.println("No hay tractores registrados. Añade uno primero.");
            } else {

                if (elegirOpcion == 1) {
                    System.out.println("Introduce la marca del tractor:");
                    marcaTractor = scanner.nextLine();
                    marcas.add(marcaTractor);

                    potenciaTractor = solicitarPotencia(scanner, 0, -1);
                    potencias.add(potenciaTractor);

                    trabajoTractor = validarTrabajo(scanner, validarTrabajos);
                    trabajos.add(trabajoTractor);

                } else if (elegirOpcion == 2) {
                    for (int i = 0; i < marcas.size(); i++) {
                        System.out
                                .println(i + " -> Marca: " + marcas.get(i) + " | " + potencias.get(i) + "CV | trabajo: "
                                        + trabajos.get(i));
                    }

                } else if (elegirOpcion == 3) {
                    indice = validarIndice(scanner, 0, -1, MENSAJEOPCION3, potencias);

                    // Mostrar tractor evaluado
                    System.out.println("Tractor evaluado: " + marcas.get(indice) + " | "
                            + potencias.get(indice) + "CV | trabajo: " + trabajos.get(indice));

                    // Determinar la potencia mínima según el trabajo
                    if (trabajos.get(indice).equals("arado")) {
                        potenciaMinima = 120;
                    } else if (trabajos.get(indice).equals("transporte")) {
                        potenciaMinima = 90;
                    } else { // "siembra"
                        potenciaMinima = 70;
                    }

                    // Evaluar
                    calcularApto(potencias, indice, potenciaMinima);

                } else if (elegirOpcion == 4) {
                    indice = validarIndice(scanner, 0, -1, MENSAJEOPCION4, potencias);

                    tractorEliminado = eliminarTractor(indice, marcas, potencias, trabajos);
                    System.out.println("El tractor: " + tractorEliminado + " ha sido eliminado.");

                }
            }
        } while (elegirOpcion != 0);

        System.out.println("Ha salido del programa");
    }
}
