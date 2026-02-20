package U5.R2.Ejercicio4;

import java.util.Scanner;

import U5.R2.Faker;

public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Playlist europaFm = new Playlist();

        final int CANTIDAD_CANCIONES = 100;
        Cancion aleatoria = new Cancion(null, null, 0);

        for (int i = 0; i < CANTIDAD_CANCIONES; i++) {
            aleatoria = new Cancion(Faker.palabrasLorem(), Faker.nombre(), Faker.entero(30, 420));
            europaFm.agregarCancion(aleatoria);
        }

        final String MENU = "Elige una de las siguientes opciones:\n" +
                "0 = Salir\n" +
                "1 = Agregar canción\n" +
                "2 = Mostrar canciones\n" +
                "3 = Calcular la duración de la playlist";
        int elegirOpcion;
        String nombreCancion;
        String autor;
        int duracion;

        do {
            elegirOpcion = opcionMenu(scanner, MENU, 0, 3, -1);

            if (elegirOpcion == 1) {
                System.out.println("Introduce el titulo de la canción: ");
                nombreCancion = scanner.nextLine();
                System.out.println("Introduce el nombre del autor: ");
                autor = scanner.nextLine();
                System.out.println("Introduce la duración (en segundos) de la canción: ");
                duracion = scanner.nextInt();
                scanner.nextLine();

                Cancion cancion = new Cancion(nombreCancion, autor, duracion);
                europaFm.agregarCancion(cancion);
                System.out.println("Canción agregada correctamente");

            } else if (elegirOpcion == 2) {
                System.out.println(europaFm.mostrarCanciones());

            } else if (elegirOpcion == 3) {
                System.out.println(europaFm.calcularDuracionFormateada());
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
