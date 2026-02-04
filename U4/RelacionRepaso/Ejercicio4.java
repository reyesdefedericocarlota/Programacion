package U4.RelacionRepaso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio4 {

    // Elegir opción menú
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

    // Solicitar cantidad
    public static double solicitarCantidad(Scanner scanner, int min, int parametroDefecto, String mensaje) {
        double cantidad;
        do {
            try {
                mostrarMensaje(mensaje);
                cantidad = Double.parseDouble(scanner.nextLine());

            } catch (NumberFormatException e) {
                mostrarMensaje("Error, debes introducir un número.");
                cantidad = parametroDefecto;
            }

        } while (cantidad <= min);

        return cantidad;
    }

    // Validar terreno
    public static String validarArray(Scanner scanner, ArrayList<String> listaTerrenos) {
        String terreno;
        boolean terrenoValido = false;

        do {
            mostrarMensaje("Introduce el terreno de la ruta:");
            terreno = scanner.nextLine();

            for (String t : listaTerrenos) {
                if (t.equals(terreno.toLowerCase())) {
                    terrenoValido = true;
                }
            }

            if (!terrenoValido) {
                mostrarMensaje("Error, debes introducir un terreno válido.");
            }
        } while (!terrenoValido);

        return terreno;
    }

    // Listar rutas
    public static void mostrarRuta(
            int indice,
            ArrayList<String> listaTractores,
            ArrayList<Double> listaKm,
            ArrayList<Double> listaLitros,
            ArrayList<String> listaTerrenos) {

        mostrarMensaje(indice + " -> " + listaTractores.get(indice)
                + " | " + listaKm.get(indice)
                + " | " + listaLitros.get(indice)
                + " | terreno: " + listaTerrenos.get(indice));
    }

    // Validar índice
    public static int validarIndice(Scanner scanner, int min, int parametroDefecto, String mensaje,
            ArrayList<String> listaTractores) {
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

    // Calcular ruta viable
    public static void calcularRuta(int indiceRuta, ArrayList<Double> litrosTractor, double litrosNecesariosRuta) {
        int aleatorio = (int) (Math.random() * 2);
        double litrosRestantes;

        if (litrosTractor.get(indiceRuta) >= litrosNecesariosRuta) {
            mostrarMensaje("Resultado: VIABLE");
            if (aleatorio == 1) {
                mostrarMensaje("Puede realizar la ruta sin problema.");
            } else {
                mostrarMensaje("El combustible disponible es suficiente");
            }
        } else {
            litrosRestantes = litrosNecesariosRuta - litrosTractor.get(indiceRuta);
            mostrarMensaje("Resultado: NO VIABLE | Faltan: " + litrosRestantes + " litros.");
            if (aleatorio == 1) {
                mostrarMensaje("El combustible disponible no es suficiente para completar el trayecto");
            } else {
                mostrarMensaje("Rellene el deposito con los litros que le faltan.");
            }
        }
    }

    // Eliminar ruta
    public static void eliminarRuta(
            int indiceEliminado,
            ArrayList<String> listaTractores,
            ArrayList<Double> listaKm,
            ArrayList<Double> listaLDisponibles, ArrayList<String> listaTerrenos) {

        listaTractores.remove(indiceEliminado);
        listaKm.remove(indiceEliminado);
        listaLDisponibles.remove(indiceEliminado);
        listaTerrenos.remove(indiceEliminado);

        mostrarMensaje("Ruta eliminada correctamente.");
    }

    // Mostrar mensaje
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creo arrays
        ArrayList<String> tractores = new ArrayList<String>();
        ArrayList<Double> kilometros = new ArrayList<Double>();
        ArrayList<Double> litrosDisponibles = new ArrayList<Double>();
        ArrayList<String> terrenos = new ArrayList<String>();
        ArrayList<String> tipoTerreno = new ArrayList<String>(Arrays.asList("llano", "mixto", "montaña"));

        // Creo variables
        final String MENU = "Elige una de las siguientes opciones:\n" +
                "0 = Salir\n" +
                "1 = Añadir ruta\n" +
                "2 = Listar rutas\n" +
                "3 = Calcular consumo\n" +
                "4 = Eliminar ruta";
        final String MENSAJEKM = "Introduce los km de la ruta:";
        final String MENSAJELITROS = "Introduce los litros disponibles:";
        final String MENSAJEINDICE = "Introduce el índice de la ruta";
        final double LITROSLLANO = 0.12;
        final double LITROSMIXTO = 0.18;
        final double LITROSMONTAÑA = 0.25;
        int elegirOpcion, indice;
        String modeloTractor, terreno;
        double kmRuta, litrosTractor, litrosNecesarios;

        do {
            elegirOpcion = opcionMenu(scanner, MENU, 0, 4, -1);

            if (elegirOpcion == 1) {
                System.out.println("Introduce el modelo del tractor:");
                modeloTractor = scanner.nextLine();
                tractores.add(modeloTractor);

                kmRuta = solicitarCantidad(scanner, 0, -1, MENSAJEKM);
                kilometros.add(kmRuta);

                litrosTractor = solicitarCantidad(scanner, 0, -1, MENSAJELITROS);
                litrosDisponibles.add(litrosTractor);

                terreno = validarArray(scanner, tipoTerreno);
                terrenos.add(terreno);

            } else if (elegirOpcion == 2) {
                for (int i = 0; i < tractores.size(); i++) {
                    mostrarRuta(i, tractores, kilometros, litrosDisponibles, terrenos);
                }

            } else if (elegirOpcion == 3) {
                indice = validarIndice(scanner, 0, -1, MENSAJEINDICE, tractores);
                litrosNecesarios = 0;

                if (terrenos.get(indice).equals("llano")) {
                    litrosNecesarios = kilometros.get(indice) * LITROSLLANO;

                } else if (terrenos.get(indice).equals("mixto")) {
                    litrosNecesarios = kilometros.get(indice) * LITROSMIXTO;

                } else {
                    litrosNecesarios = kilometros.get(indice) * LITROSMONTAÑA;
                }

                calcularRuta(indice, litrosDisponibles, litrosNecesarios);

            } else if (elegirOpcion == 4) {
                indice = validarIndice(scanner, 0, -1, MENSAJEINDICE, tractores);
                eliminarRuta(indice, tractores, kilometros, litrosDisponibles, terrenos);
            }

        } while (elegirOpcion != 0);
        scanner.close();
        System.out.println("Ha salido del programa");
    }
}
