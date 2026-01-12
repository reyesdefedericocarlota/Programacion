package U4.U1.Relacion4;

import java.util.Scanner;

public class ejercicio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        System.out.println("Introduce un número");
        numero = scanner.nextInt();
        scanner.close();

        if (numero < 0) {
            System.out.println("El número introducido no es válido");
        } else {
            int multiplicacion;
            final int MAX_DIG = 10;
            for (int i = 1; i <= MAX_DIG; i++) {
                multiplicacion = i * numero;
                System.out.println(numero + " x " + i + " = " + multiplicacion);
            }
        }

    }
}

// Escribe un programa que pida al usuario un número entero positivo y muestre
// la tabla de multiplicar de ese número (del 1 al 10) usando un bucle for
