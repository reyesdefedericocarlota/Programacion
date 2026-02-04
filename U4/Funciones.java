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
    public static int solicitarCantidad(Scanner scanner, int min, int parametroDefecto, String mensaje) {
        int cantidad;
        do {
            try {
                mostrarMensaje(mensaje);
                cantidad = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                mostrarMensaje("Error, debes introducir un número.");
                cantidad = parametroDefecto;
            }

        } while (cantidad <= min);

        return cantidad;
    }

    // Control de errores comprobar que un elemento esté en su array correspondiente
    public static String comprobarElemento(Scanner scanner, ArrayList<String> listaElementos) {
        String elemento;
        boolean encontrado = false;

        do {
            mostrarMensaje("Introduce el elemento:");
            elemento = scanner.nextLine();

            for (String nombreElemento : listaElementos) {
                if (nombreElemento.equalsIgnoreCase(elemento)) {
                    encontrado = true;
                }
            }

            if (!encontrado) {
                mostrarMensaje("Elemento no encontrado, intenta de nuevo.");
            }

        } while (!encontrado);

        return elemento;
    }

    // Comprobar un elemento de un array y si el usuario escribe fin se sale
    public static String solicitarProducto(Scanner scanner, ArrayList<String> listaProductos) {
        String nombreProducto;
        boolean encontrado;

        do {
            mostrarMensaje("Introduce el nombre del producto que desea comprar:");
            nombreProducto = scanner.nextLine();

            if (nombreProducto.equalsIgnoreCase("FIN")) {
                encontrado = true; // Salimos del bucle si el usuario escribe FIN
            } else {
                encontrado = false;
                for (String producto : listaProductos) {
                    if (producto.equalsIgnoreCase(nombreProducto)) {
                        encontrado = true; // Producto válido
                    }
                }

                if (!encontrado) {
                    mostrarMensaje("Producto no encontrado, intenta de nuevo.");
                }
            }

        } while (!encontrado);

        return nombreProducto;
    }

    // Control de errores al introducir un número
    public static int solicitarNumero(Scanner scanner, int min, int parametroDefecto) {
        int numero;
        do {
            try {
                mostrarMensaje("Introduce un número:");
                numero = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                mostrarMensaje("Error, debes introducir un número.");
                numero = parametroDefecto;
            }

        } while (numero <= min);

        return numero;
    }

    // Control de errores al solicitar un elemento que pertenece a un array
    public static String validarArray(Scanner scanner, ArrayList<String> ListaElementos) {
        String elemento;
        boolean elementoValido = false;

        do {
            mostrarMensaje("Introduce un elemento:");
            elemento = scanner.nextLine();

            for (String t : ListaElementos) {
                if (t.equals(elemento.toLowerCase())) {
                    elementoValido = true;
                }
            }

            if (!elementoValido) {
                mostrarMensaje("Error, debes introducir un elemento válido.");
            }
        } while (!elementoValido);

        return elemento;
    }

    // Validar índice de un array
    public static int validarIndice(Scanner scanner, int min, int parametroDefecto, String mensaje,
            ArrayList<Integer> listaElementos) {
        int indice;
        do {
            try {
                mostrarMensaje(mensaje);
                indice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                mostrarMensaje("Error, debes introducir un número.");
                indice = parametroDefecto;
            }
        } while (indice < min || indice >= listaElementos.size());

        return indice;
    }

    // Eliminar elementos de varios arrays
    public static String eliminarElementos(
            int indiceEliminado,
            ArrayList<String> listaMarcas,
            ArrayList<Integer> listaPotencias,
            ArrayList<String> listaTrabajos) {

        String marcaEliminada = listaMarcas.remove(indiceEliminado);
        listaPotencias.remove(indiceEliminado);
        listaTrabajos.remove(indiceEliminado);

        return marcaEliminada;
    }

    // Mostrar elementos de varios arrays
    public static void mostrarIventario(ArrayList<String> listaLibros, ArrayList<Integer> listaCantidadLibros) {
        for (int i = 0; i < listaLibros.size(); i++) {
            mostrarMensaje("Título: " + listaLibros.get(i) + " - Número de ejemplares: " + listaCantidadLibros.get(i));
        }
    }

    // Determina si se cumple una condición basada en el último dígito de una cadena
    public static boolean cumpleCondicion(String texto) {
        boolean resultado = false;
        boolean digitoEncontrado = false;
        char caracterActual;
        int valorNumerico;

        for (int i = texto.length() - 1; i >= 0; i--) {
            caracterActual = texto.charAt(i);

            if (!digitoEncontrado && Character.isDigit(caracterActual)) {
                valorNumerico = Character.getNumericValue(caracterActual);
                if (valorNumerico % 2 == 0) {
                    resultado = true;
                }
                digitoEncontrado = true;
            }
        }

        return resultado;
    }

    // Listar varios arrays
    public static void mostrarElemento(
            int indice,
            ArrayList<String> nombres,
            ArrayList<Integer> valoresBase,
            ArrayList<Integer> valoresActuales,
            ArrayList<String> responsables) {

        mostrarMensaje(indice + " -> " + nombres.get(indice)
                + " | Base: " + valoresBase.get(indice)
                + " | Actual: " + valoresActuales.get(indice)
                + " | Responsable: " + responsables.get(indice));
    }

}
