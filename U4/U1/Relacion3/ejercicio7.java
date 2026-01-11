package U4.U1.Relacion3;

import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double numero1, numero2;
        String operador;
       
        System.out.println("Introduzca el primer número");
        numero1 = scanner.nextDouble();
        System.out.println("Introduzca el segundo número");
        numero2 = scanner.nextDouble();
        System.out.println("Introduzca el operador (+, -, *, /)");
        operador = scanner.next();
        scanner.close();

        if (operador.equals("+")) {
            System.out.println(numero1 + numero2);
        } else if (operador.equals("-")) {
            System.out.println(numero1 - numero2);
        } else if (operador.equals("*")) {
            System.out.println(numero1 * numero2);
        } else if (operador.equals("/")) {
            if (numero2 != 0) {
                System.out.println(numero1 / numero2);
            } else {
                System.out.println(("No es posible dividir entre 0"));
            }
        } else {
            System.out.println("Operador incorrecto");
        }

    }
}

