package U4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que contiene métodos auxiliares para la gestión de datos,
 * validación de entradas y operaciones sobre colecciones.
 *
 * <p>
 * Incluye funciones para mostrar información por pantalla, validar
 * datos introducidos por el usuario, operar con listas y realizar
 * cálculos básicos.
 * </p>
 *
 * @author Carlota Reyes
 *
 */
public class FuncionesJavaDoc {

    /**
     * Convierte una lista de números enteros en una cadena separada por guiones.
     *
     * @param numeros Lista de números enteros.
     * @return Una cadena con los números unidos mediante {@code "-"}.
     */
    public static String unirNumeros(ArrayList<Integer> numeros) {
        ArrayList<String> numerosTexto = new ArrayList<>();
        for (Integer n : numeros) {
            numerosTexto.add(n.toString());
        }
        return String.join("-", numerosTexto);
    }

    /**
     * Obtiene el índice del valor máximo o mínimo de una lista.
     *
     * @param listado   Lista de valores numéricos.
     * @param buscarMax {@code true} para buscar el máximo,
     *                  {@code false} para buscar el mínimo.
     * @return Índice del valor máximo o mínimo encontrado.
     */
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

    /**
     * Calcula el promedio de una lista de valores numéricos.
     *
     * @param listado Lista de valores tipo {@link Double}.
     * @return Promedio de los valores o {@code 0} si la lista está vacía.
     */
    public static double promedio(ArrayList<Double> listado) {
        double sumatorio = 0;
        if (listado.isEmpty()) {
            return 0;
        }
        for (Double numero : listado) {
            sumatorio += numero;
        }
        return sumatorio / listado.size();
    }

    /**
     * Muestra un mensaje por la salida estándar.
     *
     * @param mensaje Texto que se desea mostrar.
     */
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Solicita al usuario una opción válida dentro de un rango determinado.
     *
     * @param introScanner     Objeto {@link Scanner} para leer datos.
     * @param textoMenu        Texto del menú que se mostrará.
     * @param min              Valor mínimo permitido.
     * @param max              Valor máximo permitido.
     * @param parametroDefecto Valor asignado en caso de error de formato.
     * @return Opción válida dentro del rango especificado.
     */
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

    /**
     * Solicita una cantidad mayor que un valor mínimo.
     *
     * @param scanner          Objeto {@link Scanner} para leer datos.
     * @param min              Valor mínimo permitido.
     * @param parametroDefecto Valor asignado en caso de error.
     * @param mensaje          Mensaje mostrado al usuario.
     * @return Cantidad válida introducida.
     */
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

    /**
     * Comprueba que un elemento introducido exista en una lista.
     *
     * @param scanner        Objeto {@link Scanner} para la entrada de datos.
     * @param listaElementos Lista de elementos válidos.
     * @return Elemento válido introducido por el usuario.
     */
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

    /**
     * Solicita un producto válido o permite salir escribiendo {@code FIN}.
     *
     * @param scanner        Objeto {@link Scanner} para la entrada.
     * @param listaProductos Lista de productos disponibles.
     * @return Nombre del producto válido o {@code FIN}.
     */
    public static String solicitarProducto(Scanner scanner, ArrayList<String> listaProductos) {
        String nombreProducto;
        boolean encontrado;

        do {
            mostrarMensaje("Introduce el nombre del producto que desea comprar:");
            nombreProducto = scanner.nextLine();

            if (nombreProducto.equalsIgnoreCase("FIN")) {
                encontrado = true;
            } else {
                encontrado = false;
                for (String producto : listaProductos) {
                    if (producto.equalsIgnoreCase(nombreProducto)) {
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    mostrarMensaje("Producto no encontrado, intenta de nuevo.");
                }
            }

        } while (!encontrado);

        return nombreProducto;
    }

    /**
     * Solicita un número mayor que un valor mínimo.
     *
     * @param scanner          Objeto {@link Scanner}.
     * @param min              Valor mínimo permitido.
     * @param parametroDefecto Valor asignado en caso de error.
     * @return Número válido introducido.
     */
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

    /**
     * Valida que un elemento introducido pertenezca a una lista.
     *
     * @param scanner        Objeto {@link Scanner}.
     * @param listaElementos Lista de elementos válidos.
     * @return Elemento válido.
     */
    public static String validarArray(Scanner scanner, ArrayList<String> listaElementos) {
        String elemento;
        boolean elementoValido = false;

        do {
            mostrarMensaje("Introduce un elemento:");
            elemento = scanner.nextLine();

            for (String t : listaElementos) {
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

    /**
     * Valida que el índice introducido esté dentro de los límites de una lista.
     *
     * @param scanner          Objeto {@link Scanner}.
     * @param min              Valor mínimo permitido.
     * @param parametroDefecto Valor por defecto en caso de error.
     * @param mensaje          Mensaje mostrado al usuario.
     * @param listaElementos   Lista sobre la que se valida el índice.
     * @return Índice válido dentro del rango.
     */
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

    /**
     * Elimina un elemento en una posición determinada de varias listas
     * relacionadas.
     *
     * @param indiceEliminado Índice del elemento a eliminar.
     * @param listaMarcas     Lista de marcas.
     * @param listaPotencias  Lista de potencias.
     * @param listaTrabajos   Lista de trabajos.
     * @return Marca eliminada.
     */
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

    /**
     * Muestra un inventario de libros junto con su cantidad disponible.
     *
     * @param listaLibros         Lista de títulos.
     * @param listaCantidadLibros Lista de cantidades correspondientes.
     */
    public static void mostrarIventario(ArrayList<String> listaLibros, ArrayList<Integer> listaCantidadLibros) {
        for (int i = 0; i < listaLibros.size(); i++) {
            mostrarMensaje("Título: " + listaLibros.get(i)
                    + " - Número de ejemplares: " + listaCantidadLibros.get(i));
        }
    }

    /**
     * Determina si el último dígito numérico de una cadena es par.
     *
     * @param texto Cadena a analizar.
     * @return {@code true} si el último dígito encontrado es par,
     *         {@code false} en caso contrario.
     */
    public static boolean cumpleCondicion(String texto) {
        boolean resultado = false;
        boolean digitoEncontrado = false;

        for (int i = texto.length() - 1; i >= 0; i--) {
            char caracterActual = texto.charAt(i);
            if (!digitoEncontrado && Character.isDigit(caracterActual)) {
                int valorNumerico = Character.getNumericValue(caracterActual);
                resultado = valorNumerico % 2 == 0;
                digitoEncontrado = true;
            }
        }
        return resultado;
    }

    /**
     * Muestra por pantalla los datos de un elemento según su índice.
     *
     * @param indice          Índice del elemento a mostrar.
     * @param nombres         Lista de nombres.
     * @param valoresBase     Lista de valores base.
     * @param valoresActuales Lista de valores actuales.
     * @param responsables    Lista de responsables.
     */
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

    /**
     * Muestra las tareas completadas o pendientes.
     *
     * @param listaTareas        Lista de tareas.
     * @param tareasCompletadas  Lista que indica si cada tarea está completada.
     * @param mostrarCompletadas {@code true} para mostrar completadas,
     *                           {@code false} para mostrar pendientes.
     */
    public static void mostrarTarea(ArrayList<String> listaTareas,
            ArrayList<Boolean> tareasCompletadas,
            boolean mostrarCompletadas) {

        ArrayList<String> tareasMostrar = new ArrayList<>();

        for (int i = 0; i < tareasCompletadas.size(); i++) {
            if (tareasCompletadas.get(i) == mostrarCompletadas) {
                tareasMostrar.add(listaTareas.get(i));
            }
        }

        if (tareasMostrar.isEmpty()) {
            mostrarMensaje("No hay tareas a mostrar.");
        } else {
            mostrarMensaje(String.join("-", tareasMostrar));
        }
    }

}
