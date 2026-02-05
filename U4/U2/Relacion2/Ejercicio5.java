package U4.U2.Relacion2;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio5 {

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

    // Control de errores al introducir una calificación
    public static double solicitarCalificacion(Scanner scanner, int min, int max, int parametroDefecto) {
        double numero;
        do {
            try {
                mostrarMensaje("Introduce su calificación:");
                numero = Double.parseDouble(scanner.nextLine());

            } catch (NumberFormatException e) {
                mostrarMensaje("Error, debes introducir un número.");
                numero = parametroDefecto;
            }

        } while (numero < min || numero > max);

        return numero;
    }

    // Mostrar mensaje
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
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

    // Buscar calificación más alta y más baja
    public static int calificacionMaxMin(ArrayList<Double> listaCalificaciones, boolean buscarMax) {
        int indice = 0;

        for (int i = 1; i < listaCalificaciones.size(); i++) {
            if (buscarMax && listaCalificaciones.get(i) > listaCalificaciones.get(indice)) {
                indice = i;
            } else if (!buscarMax && listaCalificaciones.get(i) < listaCalificaciones.get(indice)) {
                indice = i;
            }
        }
        return indice;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creo arrays
        ArrayList<String> nombreEstudiantes = new ArrayList<String>();
        ArrayList<Double> calificaciones = new ArrayList<Double>();

        // Creo variables
        final String MENU = "Elige una de las siguientes opciones:\n" +
                "1 =  Añadir un estudiante y su calificación\n" +
                "2 = Mostrar la calificación promedio de la clase\n" +
                "3 =  Mostrar la calificación más alta y el nombre del estudiante correspondiente\n" +
                "4 =  Mostrar la calificación más baja y el nombre del estudiante correspondiente.\n" +
                "5 = Salir del programa";
        int elegirOpcion, indiceMaxMin;
        String nombre;
        double calificacion;

        do {
            elegirOpcion = opcionMenu(scanner, MENU, 1, 5, -1);

            if (elegirOpcion == 1) {
                System.out.println("Introduce el nombre del estudiante:");
                nombre = scanner.nextLine();
                nombreEstudiantes.add(nombre);

                calificacion = solicitarCalificacion(scanner, 0, 10, -1);
                calificaciones.add(calificacion);

            } else if (elegirOpcion == 2) {
                System.out.printf("La clasificación promedio de la clase es: %.2f%n", promedio(calificaciones));

            } else if (elegirOpcion == 3) {
                if (calificaciones.isEmpty()) {
                    System.out.println("No hay calificaciones registradas.");
                } else {
                    indiceMaxMin = calificacionMaxMin(calificaciones, true);
                    System.out.println("La calificación más alta es la de " + nombreEstudiantes.get(indiceMaxMin)
                            + " y es un " + calificaciones.get(indiceMaxMin));
                }
            } else if (elegirOpcion == 4) {
                if (calificaciones.isEmpty()) {
                    System.out.println("No hay calificaciones registradas.");
                } else {
                    indiceMaxMin = calificacionMaxMin(calificaciones, false);
                    System.out.println("La calificación más baja es la de " + nombreEstudiantes.get(indiceMaxMin)
                            + " y es un " + calificaciones.get(indiceMaxMin));
                }
            }

        } while (elegirOpcion != 5);
        scanner.close();
        System.out.println("Ha salido del programa");
    }
}

// 5. Sistema de Registro de Calificaciones
// Desarrolla un programa que permita registrar y gestionar las calificaciones
// de los estudiantes en una clase. Usa dos arrays: uno para los nombres de los
// estudiantes y otro para sus calificaciones. El programa debe ofrecer al
// usuario un menú con las siguientes opciones:

// 1. Añadir un estudiante y su calificación.
// 2. Mostrar la calificación promedio de la clase.
// 3. Mostrar la calificación más alta y el nombre del estudiante
// correspondiente.
// 4. Mostrar la calificación más baja y el nombre del estudiante
// correspondiente.
// 5. Salir del programa.