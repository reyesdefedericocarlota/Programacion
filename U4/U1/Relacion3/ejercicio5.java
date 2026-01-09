package U4.U1.Relacion3;

import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = 0;

        System.out.println("Introduzca el numero");
        numero = scanner.nextInt();

        scanner.close();
        boolean estaEntre10y20 = (numero >= 10 && numero <= 20);

        if (estaEntre10y20) {
            System.out.println("El número " + numero + " está entre 10 y 20");
        } else {
            System.out.println("El número " + numero + " no está entre 10 y 20");
        }
    }
}
