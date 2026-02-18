package U5.R2.Ejercicio3;

import java.util.Scanner;

import U5.R2.Faker;

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Supermercado mercadona = new Supermercado();

        final int CANTIDAD_PRODUCTOS = 100;
        Producto aleatorio = new Producto(null, null, 0, 0);

        for (int i = 0; i < CANTIDAD_PRODUCTOS; i++) {
            aleatorio = new Producto(Faker.producto(), Faker.loremLargo(), Faker.precio(1.0, 30.0),
                    Faker.entero(1, 200));
            mercadona.agregarProducto(aleatorio);
        }

        final String MENU = "Elige una de las siguientes opciones:\n" +
                "0 = Salir\n" +
                "1 = Reponer producto\n" +
                "2 = Vender producto\n" +
                "3 = Mostrar inventario";
        int elegirOpcion;
        Producto productoRepuesto;

        do {
            elegirOpcion = opcionMenu(scanner, MENU, 0, 3, -1);

            if (elegirOpcion == 1) {

                System.out.println("Ingrese ID del producto:");
                String id = scanner.nextLine();

                System.out.println("Cantidad a reponer:");
                int cantidad = Integer.parseInt(scanner.nextLine());

                productoRepuesto = mercadona.reponerProducto(id, cantidad);
                if (productoRepuesto != null) {
                    System.out.println("Producto repuesto con éxito:");
                    System.out.println(productoRepuesto);
                } else {
                    System.out.println("No se encontró el producto.");
                }

            } else if (elegirOpcion == 2) {

                System.out.println("Ingrese ID del producto:");
                String id = scanner.nextLine();

                System.out.println("Cantidad a vender:");
                int cantidad = Integer.parseInt(scanner.nextLine());

                boolean vendido = mercadona.venderProducto(id, cantidad);

                if (vendido) {
                    System.out.println("Venta realizada correctamente.");
                } else {
                    System.out.println("No se pudo realizar la venta.");
                }

            } else {
                System.out.println(mercadona.mostrarInventario());
            }

        } while (elegirOpcion != 0);

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

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
