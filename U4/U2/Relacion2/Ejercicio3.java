package U4.U2.Relacion2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3 {

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

        System.out.println("Introduce el nombre del producto que desea comprar:");
        producto = scanner.nextLine();

        while (!producto.equalsIgnoreCase("FIN")) {

            System.out.println("Introduce la cantidad deseada:");
            cantidad = scanner.nextInt();
            scanner.nextLine();

            precioCompra = 0;
            for (int i = 0; i < productos.size(); i++) {
                if (productos.get(i).equalsIgnoreCase(producto)) {
                    productosAdquiridos.add(productos.get(i));
                    cantidadProductos.add(cantidad);
                    precioCompra = precios.get(i) * cantidad;
                }
            }
            totalCompra += precioCompra;

            System.out.println("Introduce el nombre del producto que desea comprar:");
            producto = scanner.nextLine();
        }
        scanner.close();

        if (producto.equalsIgnoreCase("FIN")) {

            System.out.println("Resumen compra:" );

            for (int i = 0; i < productosAdquiridos.size(); i++) {
                System.out.println("\nProducto: " + productosAdquiridos.get(i) + " \nCantidad: "
                        + cantidadProductos.get(i));
            }
            System.out.println( " \nTotal a pagar: " + totalCompra + "€");
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