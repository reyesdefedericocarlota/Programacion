package U4.U2.Relacion2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio6 {

    public static String elegirOpcion(Scanner scanner) {
        
        System.out.println(
                "Elige una de las siguientes opciones:\n" +
                        "1 = Añadir una nueva tarea.\n" +
                        "2 = Marcar una tarea como completada.\n" +
                        "3 = Ver tareas pendientes.\n" +
                        "4 = Ver tareas completadas.\n" +
                        "5 = Salir.");
        return scanner.next();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tareas = new ArrayList<String>(Arrays.asList("tarea1", "tarea2", "tarea3"));
        ArrayList<Boolean> completadas = new ArrayList<Boolean>(Arrays.asList(false, true, false));

        String opciones;

        do {
            opciones = elegirOpcion(scanner);

            if (opciones.equals("1")) {
                String nuevaTarea = "";
                System.out.println("Nueva tarea:");
                nuevaTarea = scanner.next();
                tareas.add(nuevaTarea);
                completadas.add(false);

            } else if (opciones.equals("2")) {
                String buscar = "";
                System.out.println("Nombre de la tarea:");
                buscar = scanner.next();
                Boolean encontrado = false;

                for (int i = 0; i < tareas.size() && !encontrado; i++) {
                    if (tareas.get(i).equals(buscar)) {
                        encontrado = true;
                        completadas.set(i, true);
                    }
                }

                if (!encontrado)
                    System.out.println("No encontrada");

            } else if (opciones.equals("3")) {
                ArrayList<String> pendientes = new ArrayList<String>();

                for (int i = 0; i < completadas.size(); i++) {
                    if (!completadas.get(i))
                        pendientes.add(tareas.get(i));
                }

                System.out.println("Pendientes: " + pendientes);

            } else if (opciones.equals("4")) {
                ArrayList<String> hechas = new ArrayList<String>();

                for (int i = 0; i < completadas.size(); i++) {
                    if (completadas.get(i))
                        hechas.add(tareas.get(i));
                }

                System.out.println("Completadas " + hechas);
            }

        } while (!opciones.equals("5"));

        scanner.close();

    }
}
