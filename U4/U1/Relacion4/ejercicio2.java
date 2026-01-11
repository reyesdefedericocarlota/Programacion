package U4.U1.Relacion4;

import java.util.Scanner;

public class ejercicio2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroSecreto;
        int intento;

        System.out.println("Introduce el número secreto");
        numeroSecreto = scanner.nextInt();

        System.out.println("Averigua el número");
        intento = scanner.nextInt();

        while (numeroSecreto != intento) {
            System.out.println("Número " + intento + " incorrecto");

            System.out.println("Averigua el número");
            intento = scanner.nextInt();
        }
        System.out.println("Has averiguado el numero");

        scanner.close();

    }
}

// let numeroSecreto = prompt("Introduce el numero secreto")
// let intento = prompt("Averigua el número")

// while (numeroSecreto != intento) {
// console.log("Número " + intento + " incorrecto");
// intento = prompt("Averigua el número")
// }
// console.log("Has averiguado el numero");
