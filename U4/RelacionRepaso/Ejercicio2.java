package U4.RelacionRepaso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {

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

    // Validar revisión
    public static String validarRevisión(Scanner scanner, ArrayList<String> listaRevisiones) {
        String revisión;
        boolean revisionValida = false;

        do {
            mostrarMensaje("Introduce el tipo de revisión que desea que realizemos:");
            revisión = scanner.nextLine();

            for (String r : listaRevisiones) {
                if (r.equals(revisión.toLowerCase())) {
                    revisionValida = true;
                }
            }

            if (!revisionValida) {
                mostrarMensaje("Error, debes introducir una revisión válida.");
            }
        } while (!revisionValida);

        return revisión;
    }

    // Validar extras
    public static int solicitarExtra(Scanner scanner, int min, int parametroDefecto) {
        int extra;
        do {
            try {
                mostrarMensaje("Introduce el número de extras que quiere que realizemos:");
                extra = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                mostrarMensaje("Error, debes introducir un número.");
                extra = parametroDefecto;
            }

        } while (extra < min);

        return extra;
    }

    // Determinar si se aplica descuento
    public static boolean tieneDescuento(String matricula) {
        boolean descuento = false;
        boolean encontrado = false;
        char caracter;
        int numero;

        for (int i = matricula.length() - 1; i >= 0; i--) {
            caracter = matricula.charAt(i);

            if (!encontrado && Character.isDigit(caracter)) {
                numero = Character.getNumericValue(caracter);
                if (numero % 2 == 0) {
                    descuento = true;
                }
                encontrado = true;
            }
        }

        return descuento;
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

    // Eliminar revisión de todas las listas
    public static String eliminarRevision(
            int indiceEliminado,
            ArrayList<String> listaMatriculas,
            ArrayList<String> listaRevisiones,
            ArrayList<Integer> listaExtras, ArrayList<Double> listaCosteFinal) {

        String matriculaEliminada = listaMatriculas.remove(indiceEliminado);
        listaRevisiones.remove(indiceEliminado);
        listaExtras.remove(indiceEliminado);
        listaCosteFinal.remove(indiceEliminado);

        return matriculaEliminada;
    }

    // Mostrar mensaje
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creo arrays
        ArrayList<String> matriculas = new ArrayList<String>();
        ArrayList<String> revisiones = new ArrayList<String>();
        ArrayList<Integer> extras = new ArrayList<Integer>();
        ArrayList<Double> costeFinal = new ArrayList<Double>();
        ArrayList<String> validarRevisiones = new ArrayList<String>(Arrays.asList("básica", "completa"));

        // Creo variables
        final String MENU = "Elige una de las siguientes opciones:\n" +
                "0 = Salir\n" +
                "1 = Añadir revisión\n" +
                "2 = Listar revisiones\n" +
                "3 = Mostrar coste\n" +
                "4 = Eliminar revisión";
        final String MENSAJEOPCION3 = "Introduce el índice del tractor";
        final int PRECIOEXTRA = 15;
        final int PRECIOBASICA = 60;
        final int PRECIOCOMPLETA = 120;
        final double DESCUENTO = 0.10;
        int elegirOpcion;
        String matriculaTractor;
        String tipoRevision;
        int extraTractor;
        double costeTotal;
        String determinarDescuento;
        double calculoDesc;
        int indice;
        String revisionEliminada;

        do {
            elegirOpcion = opcionMenu(scanner, MENU, 0, 4, -1);

            if ((elegirOpcion == 2 || elegirOpcion == 3 || elegirOpcion == 4) && matriculas.isEmpty()) {
                System.out.println("No hay tractores registrados. Añade uno primero.");
            } else {

                if (elegirOpcion == 1) {
                    System.out.println("Introduce la matricula del tractor:");
                    matriculaTractor = scanner.nextLine();
                    matriculas.add(matriculaTractor);

                    tipoRevision = validarRevisión(scanner, validarRevisiones);
                    revisiones.add(tipoRevision);

                    extraTractor = solicitarExtra(scanner, 0, -1);
                    extras.add(extraTractor);

                    costeTotal = 0;
                    if (revisiones.get(revisiones.size() - 1).equals("básica")) {
                        costeTotal += PRECIOBASICA;
                    } else {
                        costeTotal += PRECIOCOMPLETA;
                    }
                    costeTotal += extras.get(extras.size() - 1) * PRECIOEXTRA;

                    determinarDescuento = matriculas.get(matriculas.size() - 1);

                    if (tieneDescuento(determinarDescuento)) {
                        calculoDesc = costeTotal * DESCUENTO;
                        costeTotal -= calculoDesc;
                    }
                    costeFinal.add(costeTotal);

                } else if (elegirOpcion == 2) {
                    for (int i = 0; i < matriculas.size(); i++) {
                        System.out
                                .println(i + " -> " + matriculas.get(i) + " | " + revisiones.get(i) + " | extras: "
                                        + extras.get(i) + " | coste: " + costeFinal.get(i));
                    }

                } else if (elegirOpcion == 3) {
                    indice = validarIndice(scanner, 0, -1, MENSAJEOPCION3, extras);

                    determinarDescuento = matriculas.get(indice);
                    if (tieneDescuento(determinarDescuento)) {
                        System.out.println(
                                "La matrícula de su tractor termina en número par, se le ha aplicado un 10% de descuento.");
                    } else {
                        System.out.println(
                                "La matrícula de su tractor termina en número impar así que no se le ha aplicado descuento.");
                    }
                    System.out.println("El coste final de la evaluación del tractor " + matriculas.get(indice) + " es "
                            + costeFinal.get(indice) + "€");

                } else if (elegirOpcion == 4) {
                    indice = validarIndice(scanner, 0, -1, MENSAJEOPCION3, extras);

                    revisionEliminada = eliminarRevision(indice, matriculas, revisiones, extras, costeFinal);
                    System.out.println("El tractor: " + revisionEliminada + " ha sido eliminado.");
                }
            }

        } while (elegirOpcion != 0);
        System.out.println("Ha salido del programa");
    }
}
