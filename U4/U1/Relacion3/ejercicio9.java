package U4.U1.Relacion3;

import java.util.Scanner;

public class ejercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        final int MIN_NUM = 10;
        final int MAX_NUM = 99;

        System.out.println("Introduzca un número de dos dígitos");
        numero = scanner.nextInt();
        scanner.close();

        if (numero >= MIN_NUM && numero <= MAX_NUM) {
            int digitoDecenas = numero / 10;
            int digitoUnidades = numero % 10;
            int suma = digitoDecenas + digitoUnidades;
            System.out.println("El número tiene dos cifras, la suma de sus cifras es: " + suma);
        } else {
            System.out.println("El número no tiene dos cifras");
        }

    }
}

