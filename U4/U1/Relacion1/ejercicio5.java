package U4.U1.Relacion1;

import java.util.Scanner;

public class ejercicio5 {

    public static void main(String[] args) {
        // Crear objeto Scanner
        Scanner scanner = new Scanner(System.in);
        double GRAVEDADLUNA = 0.165;
        double pesoTierra = 0;
        double pesoLuna = 0;

        // Leer datos del usuario
        System.out.println("Introduzca su peso: ");
        pesoTierra = scanner.nextDouble();

        // Calcular peso en la luna
        pesoLuna = pesoTierra * GRAVEDADLUNA;
        System.out.printf("Tu peso en la Luna es:  %.2f" + pesoLuna + " kg");

        scanner.close();

    }
}
