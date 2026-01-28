package U4.U2.Relacion2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1 {

    public static int indiceTemp(ArrayList<Double> listaTemperaturas, boolean buscarMax) {
        int indice = 0;

        for (int i = 1; i < listaTemperaturas.size(); i++) {
            if (buscarMax && listaTemperaturas.get(i) > listaTemperaturas.get(indice)) {
                indice = i;
            } else if (!buscarMax && listaTemperaturas.get(i) < listaTemperaturas.get(indice)) {
                indice = i;
            }
        }
        return indice;
    }

    public static double promedio(ArrayList<Double> listaTemperaturas) {
        double sumaTemp = 0;
        double promedio = 0;

        if (listaTemperaturas.isEmpty()) {
            promedio = 0;
        } else {
            for (Double temp : listaTemperaturas) {
                sumaTemp += temp;
            }
            promedio = sumaTemp / listaTemperaturas.size();
        }
        return promedio;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creo arrays
        ArrayList<String> diasSemana = new ArrayList<String>(
                Arrays.asList("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"));
        ArrayList<Double> temperaturas = new ArrayList<Double>();

        // Creo variables
        double temperatura;
        int opcion = 0;
        int indiceMax;
        int indiceMin;

        for (int i = 0; i < diasSemana.size(); i++) {
            do {
                try {
                    System.out.println("Introduce la temperatura del " + diasSemana.get(i) + ":");
                    temperatura = Double.parseDouble(scanner.nextLine());

                } catch (NumberFormatException e) {
                    System.out.println("Error, debes introducir un numero.");
                    temperatura = 101;
                }
            } while (temperatura < -270 || temperatura > 100);

            temperaturas.add(temperatura);
        }

        do {

            do {
                try {
                    System.out.println(
                            "Elige una de las siguientes opciones: \n1 = Mostrar la temperatura más alta registrada \n2 = Mostrar la temperatura más baja registrada \n3 = Calcular la temperatura promedio de la semana \n4 = Salir del programa.");
                    opcion = Integer.parseInt(scanner.nextLine());

                } catch (NumberFormatException e) {
                    System.out.println("Error, debes introducir un número.");
                    opcion = -1;
                }

            } while (opcion < 1 || opcion > 4);

            if (opcion == 1) {
                indiceMax = indiceTemp(temperaturas, true);
                System.out.println("La temperatura más alta registrada es la del " +
                        diasSemana.get(indiceMax) + ": " + temperaturas.get(indiceMax));

            } else if (opcion == 2) {
                indiceMin = indiceTemp(temperaturas, false);
                System.out.println("La temperatura más baja registrada es la del " +
                        diasSemana.get(indiceMin) + ": " + temperaturas.get(indiceMin));

            } else if (opcion == 3) {
                System.out.printf("El promedio de las temperaturas es: %.2f%n", promedio(temperaturas));
            }

        } while (opcion != 4);

        scanner.close();
    }
}

// Escribe un programa que permita al usuario ingresar las temperaturas
// registradas durante una semana (7 días). Una vez ingresadas las temperaturas,
// el programa debe mostrar al usuario un menú con las siguientes opciones:

// 1. Mostrar la temperatura más alta registrada.
// 2. Mostrar la temperatura más baja registrada.
// 3. Calcular la temperatura promedio de la semana.
// 4. Salir del programa.

// El programa debe ejecutarse hasta que el usuario elija la opción de salir.