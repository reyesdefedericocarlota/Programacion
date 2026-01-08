package U4.U1.Relacion1;

import java.util.Scanner;

public class ejercicio5 {

    public static void main(String[] args) {
        // Crear objeto Scanner
        Scanner scanner = new Scanner(System.in);

        // Leer datos del usuario
        System.out.println("Introduzca su peso: ");
        double peso = scanner.nextDouble();

        // Calcular peso en la luna
        double pesoLuna = peso * 0.165;
        System.out.println("Tu peso en la Luna es: " + pesoLuna + " kg");

        scanner.close();

    }
}
