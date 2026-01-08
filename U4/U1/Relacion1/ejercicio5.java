package U4.U1.Relacion1;

import java.util.Scanner;

public class ejercicio5 {

    public static void main(String[] arg) {

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Introduzca su peso: ");
        double peso = scanner1.nextDouble();
        System.out.println("Peso en la Tierra: " + peso);
        scanner1.close();

        double pesoLuna = peso * 0.165;

    }
}
