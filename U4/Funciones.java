package U4;

import java.util.ArrayList;
import java.util.Scanner;

public class Funciones {

    // Convertir números a String
    public static String unirNumeros(ArrayList<Integer> numeros) {
        ArrayList<String> numerosTexto = new ArrayList<>();

        for (Integer n : numeros) {
            numerosTexto.add(n.toString());
        }

        return String.join("-", numerosTexto);
    }

    // Buscar máximo y mínimo de un array
    public static int indiceTemp(ArrayList<Double> listado, boolean buscarMax) {
        int indice = 0;

        for (int i = 1; i < listado.size(); i++) {
            if (buscarMax && listado.get(i) > listado.get(indice)) {
                indice = i;
            } else if (!buscarMax && listado.get(i) < listado.get(indice)) {
                indice = i;
            }
        }
        return indice;
    }

    // Calcular promedio
    public static double promedio(ArrayList<Double> listado) {
        double sumatorio = 0;
        double promedio = 0;

        if (listado.isEmpty()) {
            promedio = 0;
        } else {
            for (Double numero : listado) {
                sumatorio += numero;
            }
            promedio = sumatorio / listado.size();
        }
        return promedio;
    }

    // Mostrar mensaje
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

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

    // Solicitar cantidad
    public static int solicitarCantidad(Scanner scanner, int min, int parametroDefecto) {
        int cantidad;
        do {
            try {
                mostrarMensaje("Introduce la cantidad deseada:");
                cantidad = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                mostrarMensaje("Error, debes introducir un número.");
                cantidad = parametroDefecto;
            }

        } while (cantidad <= min);

        return cantidad;
    }
}
