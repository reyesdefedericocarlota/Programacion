package U4.U2.Relacion2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio6 {
    public static void mostrarTarea(ArrayList<String> listaTareas, ArrayList<Boolean> tareasCompletadas,
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

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Arrays
        ArrayList<String> tareas = new ArrayList<>(Arrays.asList("tarea1", "tarea2", "tarea3"));
        ArrayList<Boolean> completadas = new ArrayList<>(Arrays.asList(false, true, false));

        int opcion = 0;
        // Opcion1
        String nuevaTarea;
        // Opcion2
        String tareaBuscar;
        Boolean tareaEncontrada;

        do {
            do {
                try {
                    System.out.println("1. Añadir tarea.\n" + //
                            "2. Marca completada.\n" + //
                            "3. Ver pendientes.\n" + //
                            "4. Ver completadas.\n" + //
                            "5. Salir.");
                    opcion = Integer.parseInt(scanner.nextLine());

                } catch (NumberFormatException e) {
                    System.out.println("Error introduce un numero: ");
                    opcion = -1;
                }

            } while (opcion < 1 || opcion > 5);

            if (opcion == 1) {
                System.out.println("Nueva tarea: ");
                nuevaTarea = scanner.nextLine();
                tareas.add(nuevaTarea);
                completadas.add(false);
            } else if (opcion == 2) {
                System.out.println("Nombre de la tarea: ");
                tareaBuscar = scanner.nextLine();
                tareaEncontrada = false;
                for (int i = 0; i < tareas.size() && !tareaEncontrada; i++) {
                    if (tareas.get(i).equalsIgnoreCase(tareaBuscar)) {
                        tareaEncontrada = true;
                        completadas.set(i, tareaEncontrada);
                    }
                }
                if (!tareaEncontrada) {
                    System.out.println("Tarea no encontrada");
                }
            } else if (opcion == 3) {
                mostrarTarea(tareas, completadas, false);
            } else if (opcion == 4) {
                mostrarTarea(tareas, completadas, true);
            }
        } while (opcion != 5);
        scanner.close();
    }
}