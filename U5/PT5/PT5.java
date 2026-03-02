package U5.PT5;

import java.util.ArrayList;
import java.util.Scanner;

public class PT5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int NUMERO_ANIMALES = 1000;
        final String MENU = "Elige una de las siguientes opciones:\n" +
                "1 = Mostrar todos los animales\n" +
                "2 = Buscar un animal por código\n" +
                "3 = Agregar ejemplares a un animal\n" +
                "4 = Retirar ejemplares de un animal\n" +
                "5 = Eliminar un animal\n" +
                "6 = Salir";
        int elegirOpcion;
        String codigoAnimal;
        int cantidadAnimal;
        ArrayList<Boolean> resultadoOpciones;

        Zoologico zoologico = new Zoologico();

        for (int i = 0; i < NUMERO_ANIMALES; i++) {
            Animal animal = new Animal(Faker.nombreAnimal(), Faker.codigoAnimal(), Faker.cantidadAnimal(),
                    Faker.precio(50, 5000));
            zoologico.agregarAnimal(animal);
        }

        do {
            elegirOpcion = opcionMenu(scanner, MENU, 1, 6, -1);

            if (elegirOpcion == 1) {
                System.out.println(zoologico.mostrarAnimales());

            } else if (elegirOpcion == 2) {
                System.out.print("Introduce el código del animal: ");
                codigoAnimal = scanner.nextLine();
                Animal animalBuscado = zoologico.buscarAnimal(codigoAnimal);
                if (animalBuscado != null) {
                    System.out.println(animalBuscado);
                } else {
                    System.out.println("Animal no encontrado.");
                }

            } else if (elegirOpcion == 3) {
                System.out.print("Introduce el código del animal: ");
                codigoAnimal = scanner.nextLine();
                System.out.print("Cantidad a agregar: ");
                cantidadAnimal = Integer.parseInt(scanner.nextLine());

                resultadoOpciones = zoologico.agregarEjemplares(codigoAnimal, cantidadAnimal);

                if (resultadoOpciones.get(0)) {
                    System.out.println("Ejemplares agregados correctamente.");
                } else if (resultadoOpciones.get(1)) {
                    System.out.println("Animal no encontrado.");
                } else if (resultadoOpciones.get(2)) {
                    System.out.println("La cantidad debe ser mayor que 0.");
                }

            } else if (elegirOpcion == 4) {
                System.out.print("Introduce el código del animal: ");
                codigoAnimal = scanner.nextLine();
                System.out.print("Cantidad a retirar: ");
                cantidadAnimal = Integer.parseInt(scanner.nextLine());

                resultadoOpciones = zoologico.retirarEjemplares(codigoAnimal, cantidadAnimal);

                if (resultadoOpciones.get(0)) {
                    System.out.println("Ejemplares retirados correctamente.");
                } else if (resultadoOpciones.get(1)) {
                    System.out.println("Animal no encontrado.");
                } else if (resultadoOpciones.get(2)) {
                    System.out.println("Cantidad no válida.");
                } else if (resultadoOpciones.get(3)) {
                    System.out.println("No se puede retirar más ejemplares de los disponibles.");
                }

            } else if (elegirOpcion == 5) {
                System.out.print("Introduce el código del animal: ");
                codigoAnimal = scanner.nextLine();

                resultadoOpciones = zoologico.eliminarAnimal(codigoAnimal);

                if (resultadoOpciones.get(0)) {
                    System.out.println("Animal eliminado correctamente.");
                } else if (resultadoOpciones.get(1)) {
                    System.out.println("Animal no encontrado.");
                } else if (resultadoOpciones.get(2)) {
                    System.out.println("No se puede eliminar un animal con ejemplares disponibles.");
                }
            }
        } while (elegirOpcion != 6);
        System.out.println("Ha salido del programa");

    }

    /**
     * Muestra un menú y solicita al usuario que introduzca una opción válida.
     * Controla errores de formato (no numérico) y obliga a que la opción esté
     * dentro del rango [min, max].
     *
     * @param introScanner     Scanner para leer la entrada del usuario.
     * @param textoMenu        Texto del menú que se mostrará.
     * @param min              Valor mínimo válido de la opción.
     * @param max              Valor máximo válido de la opción.
     * @param parametroDefecto Valor que se asigna si la entrada no es un número
     *                         válido.
     * @return Opción seleccionada por el usuario (entero dentro del rango [min,max]).
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
     * Muestra un mensaje por consola.
     *
     * @param mensaje El texto que se mostrará en pantalla.
     */
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
