package U4.U1.Relacion6;

import java.util.Scanner;

public class ejercicio4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double combustible, precioLitro, consumo, kmViaje, precioViaje;
        int numeroViaje = 0;

        System.out.println("Introduce el combustible inicial: ");
        combustible = scanner.nextDouble();

        System.out.println("Precio del litro de combustible: ");
        precioLitro = scanner.nextDouble();

        System.out.println("Consumo cada 100km: ");
        consumo = scanner.nextDouble();

        while (combustible > 0) {
            numeroViaje++;
            System.out.println("Introduce los kilómetros del viaje " + numeroViaje + ":");
            kmViaje = scanner.nextDouble();
            combustible = combustible - consumo * kmViaje / 100;
            precioViaje = (consumo * kmViaje / 100) * precioLitro;

            if (combustible > 0) {
                System.out.println("Precio del viaje: " + precioViaje + "€");
                System.out.println("Combustible restante: " + combustible + " litros");

            } else {
                System.out.println("¡Combustible insuficiente!");

            }
        }
        scanner.close();
    }
}

// Introduce el combustible inicial: 50
// Precio del litro de combustible: 1.45
// Consumo cada 100km: 5.6

// Introduce los kilómetros del viaje 1: 50
// Precio del viaje: 4.06€
// Combustible restante: 47.2 litros

// Introduce los kilómetros del viaje 2: 200
// Precio del viaje: 16.24€
// Combustible restante: 36 litros

// Introduce los kilómetros del viaje 3: 1000
// ¡Combustible insuficiente!