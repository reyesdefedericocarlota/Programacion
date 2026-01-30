package U4.U2.Relacion2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3 {

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

    public static void resumenCompra(ArrayList<String> listaProductosAdquiridos,
            ArrayList<Integer> listaCantidadProductos, double precioCompra) {
        mostrarMensaje("Resumen compra:");

        for (int i = 0; i < listaProductosAdquiridos.size(); i++) {
            mostrarMensaje("\nProducto: " + listaProductosAdquiridos.get(i) + " \nCantidad: "
                    + listaCantidadProductos.get(i));
        }
        mostrarMensaje("\nTotal a pagar: " + precioCompra + "€");
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creo arrays
        ArrayList<String> productos = new ArrayList<String>(Arrays.asList("ACEITUNAS", "LECHE", "ARROZ", "MACARRONES",
                "GALLETAS", "LENTEJAS", "GARBANZOS", "MAÍZ", "NARANJAS", "ALUBIAS"));
        ArrayList<Double> precios = new ArrayList<Double>(
                Arrays.asList(2.0, 1.0, 2.0, 3.0, 4.0, 3.5, 4.0, 2.5, 4.0, 4.5));
        ArrayList<String> productosAdquiridos = new ArrayList<String>();
        ArrayList<Integer> cantidadProductos = new ArrayList<Integer>();

        // Creo variables
        String producto = "";
        int cantidad;
        double precioCompra;
        double totalCompra = 0;

        producto = solicitarProducto(scanner, productos);

        while (!producto.equalsIgnoreCase("FIN")) {

            cantidad = solicitarCantidad(scanner, 0, -1);

            precioCompra = 0;
            for (int i = 0; i < productos.size(); i++) {
                if (productos.get(i).equalsIgnoreCase(producto)) {
                    productosAdquiridos.add(productos.get(i));
                    cantidadProductos.add(cantidad);
                    precioCompra = precios.get(i) * cantidad;
                }
            }
            totalCompra += precioCompra;

            producto = solicitarProducto(scanner, productos);
        }
        scanner.close();

        if (producto.equalsIgnoreCase("FIN")) {
            resumenCompra(productosAdquiridos, cantidadProductos, totalCompra);
        }

    }
}

// Desarrolla un programa que gestione las compras en un almacén. Para esto:

// 1. Crea un array que contenga los nombres de 10 productos disponibles en el
// almacén.
// 2. Crea otro array que contenga los precios correspondientes a esos 10
// productos.
// 3. El programa debe permitir al usuario realizar una compra solicitando el
// nombre del producto y la cantidad deseada.
// 4. El programa debe buscar el precio del producto seleccionado, multiplicarlo
// por la cantidad y añadirlo al total de la compra.
// 5. Si el usuario escribe "FIN", el programa debe finalizar la compra,
// mostrando un resumen con todos los productos adquiridos, sus cantidades, y el
// costo total a pagar.