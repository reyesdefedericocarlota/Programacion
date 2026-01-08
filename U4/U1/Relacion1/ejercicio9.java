package U4.U1.Relacion1;

import java.util.Scanner;

public class ejercicio9 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuántos caramelos tienes?");
        int numeroDeCaramelos = scanner.nextInt();

        System.out.println("¿Cuántos niños hay?");
        int numeroDeNinios = scanner.nextInt();

        int caramelosPorNinio = numeroDeCaramelos / numeroDeNinios;
        int restoDeCaramelos = numeroDeCaramelos % numeroDeNinios;

        System.out.println("A cada niño le tocan " + caramelosPorNinio + " caramelos y han sobrado " + restoDeCaramelos);

        scanner.close();
    }

}
