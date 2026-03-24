package Proyecto2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String MENU = "Elige una de las siguientes opciones:\n" +
                "1 = Añadir película\n" +
                "2 = Mostrar películas\n" +
                "3 = Crear sala\n" +
                "4 = Mostrar salas\n" +
                "5 = Programar proyección\n" +
                "6 = Mostrar proyecciones de una sala\n" +
                "7 = Cancelar proyección\n" +
                "8 = Comprobar si una sala está disponible ahora\n" +
                "9 = Salir";
        int elegirOpcion;
        String tituloPeli, codigo;
        int duracionPeli, asientosSala;
        String clasificacionEdad;
        String generoPeli;
        Sala salaEncontrada;
        Pelicula peliEncontrada;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime inicioProyeccion = null;
        LocalDateTime finProyeccion = null;

        Cine cine = new Cine("StemCine", "Granada", "España");

        do {
            elegirOpcion = opcionMenu(scanner, MENU, 1, 9, -1);

            if (elegirOpcion == 1) {
                System.out.print("Introduce el título de la película: ");
                tituloPeli = scanner.nextLine();
                System.out.print("Introduce la duración (en minutos): ");
                duracionPeli = Integer.parseInt(scanner.nextLine());
                System.out.print("Introduce la clasificación por edad: ");
                clasificacionEdad = scanner.nextLine();
                System.out.print("Introduce el género: ");
                generoPeli = scanner.nextLine();
                try {
                    Pelicula pelicula = new Pelicula(tituloPeli, duracionPeli, clasificacionEdad, generoPeli);
                    cine.agregarPelicula(pelicula);
                    System.out.println("Película añadida correctamente.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            } else if (elegirOpcion == 2) {
                System.out.println(cine.mostrarPeliculas());

            } else if (elegirOpcion == 3) {
                System.out.print("Introduce el número de asientos de la sala: ");
                asientosSala = Integer.parseInt(scanner.nextLine());
                try {
                    Sala sala = new Sala(asientosSala);
                    cine.agregarSala(sala);
                    System.out.println("Sala añadida correctamente.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            } else if (elegirOpcion == 4) {
                System.out.println(cine.mostrarSalas());

            } else if (elegirOpcion == 5) {
                System.out.print("Introduce el código de la sala: ");
                codigo = scanner.nextLine();
                salaEncontrada = cine.buscarSala(codigo);

                if (salaEncontrada == null) {
                    System.out.println("El código introducido no corresponde a ninguna sala.");
                } else {
                    System.out.print("Introduce el código de la pelicula que quieres proyectar: ");
                    codigo = scanner.nextLine();
                    peliEncontrada = cine.buscarPelicula(codigo);

                    if (peliEncontrada == null) {
                        System.out.println("El código introducido no corresponde a ninguna pelicula.");
                    } else {
                        inicioProyeccion = pedirFecha(scanner, formatter,
                                "Introduce la fecha y hora de inicio de la proyección (yyyy-MM-dd HH:mm): ");

                        finProyeccion = pedirFecha(scanner, formatter,
                                "Introduce la fecha y hora de fin de la proyección (yyyy-MM-dd HH:mm): ");
                        if (!finProyeccion.isAfter(inicioProyeccion)) {
                            System.out.println("La fecha de fin debe ser posterior a la de inicio.");
                        } else {
                            Proyeccion proyeccionNueva = new Proyeccion(peliEncontrada, inicioProyeccion,
                                    finProyeccion);
                            if (salaEncontrada.agregarProyeccion(proyeccionNueva)) {
                                System.out.println("Proyección agregada con éxito");
                            } else {
                                System.out.println("No se pudo agregar la proyección en esa fecha y hora.");
                            }
                        }
                    }
                }

            } else if (elegirOpcion == 6) {
                System.out.print("Introduce el código de la sala: ");
                codigo = scanner.nextLine();
                salaEncontrada = cine.buscarSala(codigo);

                if (salaEncontrada == null) {
                    System.out.println("El código introducido no corresponde a ninguna sala.");
                } else {
                    System.out.println(salaEncontrada.mostrarProyecciones());
                }

            } else if (elegirOpcion == 7) {
                System.out.print("Introduce el código de la sala: ");
                codigo = scanner.nextLine();
                salaEncontrada = cine.buscarSala(codigo);

                if (salaEncontrada == null) {
                    System.out.println("El código introducido no corresponde a ninguna sala.");
                } else {
                    System.out.print("Introduce el código de la proyección que quieres cancelar: ");
                    codigo = scanner.nextLine();
                    if (salaEncontrada.cancelarProyeccion(codigo)) {
                        System.out.println("Proyección cancelada con éxito");
                    } else {
                        System.out.println("No se pudo cancelar porque no existe ninguna proyección con ese código.");
                    }
                }

            } else if (elegirOpcion == 8) {
                System.out.print("Introduce el código de la sala: ");
                codigo = scanner.nextLine();
                salaEncontrada = cine.buscarSala(codigo);

                if (salaEncontrada == null) {
                    System.out.println("El código introducido no corresponde a ninguna sala.");
                } else {
                    if (salaEncontrada.salaDisponible()) {
                        System.out.println("La sala está disponible ahora mismo.");
                    } else {
                        System.out.println("La sala no está disponible.");
                    }
                }
            }

        } while (elegirOpcion != 9);

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
     * @return Opción seleccionada por el usuario (entero dentro del rango
     *         [min,max]).
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

    public static LocalDateTime pedirFecha(Scanner scanner, DateTimeFormatter formatter, String mensaje) {
        LocalDateTime fecha = null;
        boolean fechaCorrecta = false;

        while (!fechaCorrecta) {
            try {
                mostrarMensaje(mensaje);
                String entrada = scanner.nextLine();
                fecha = LocalDateTime.parse(entrada, formatter);
                fechaCorrecta = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato incorrecto. Debe ser yyyy-MM-dd HH:mm");
            }
        }

        return fecha;
    }
}

