package U6.RelacionRepaso.Examen;

import java.util.ArrayList;
import java.util.Scanner;

public class PT6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Presentador presentador1 = new Presentador("Paco Chascarrillos", 15, 1000, 2, 3);
        Presentador presentador2 = new Presentador("Lola Bromista", 12, 950, 1, 4);
        BateristaRobot baterista = new BateristaRobot("RX Golpazo", 18, 1400, 1, 2);
        RobotMusical robot = new RobotMusical("MegaShow 3000", 20, 1500, 1, 2, new ArrayList<>());

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n===== PT6 - MONSTRUOS CON MICROFONO =====");
            System.out.println("1. Probar IntegranteFestival");
            System.out.println("2. Probar Presentador");
            System.out.println("3. Probar BateristaRobot");
            System.out.println("4. Probar RobotMusical");
            System.out.println("5. Mostrar resultados");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.println("\n--- IntegranteFestival ---");

                presentador1.recargarEnergia(5);
                presentador2.recargarEnergia(3);
                baterista.recargarEnergia(4);
                robot.recargarEnergia(6);

            } else if (opcion == 2) {
                System.out.println("\n--- Presentador ---");

                presentador1.contarBroma();
                presentador1.mejorarCarisma(2);

                presentador2.contarBroma();
                presentador2.mejorarCarisma(1);

            } else if (opcion == 3) {
                System.out.println("\n--- BateristaRobot ---");

                baterista.afinar();
                baterista.golpeFuerte();

            } else if (opcion == 4) {
                System.out.println("\n--- RobotMusical ---");

                robot.afinar();
                robot.dispararLaser();

                robot.agregarIntegrante(presentador1);
                robot.agregarIntegrante(presentador2);

                robot.eliminarIntegrante("Lola Bromista");

            } else if (opcion == 5) {
                System.out.println("\n--- RESULTADOS ---");

                System.out.println("Rendimiento de " + presentador1.getNombre() + ": " +
                        presentador1.calcularRendimiento());
                System.out.println("Puede actuar " + presentador1.getNombre() + ": " +
                        presentador1.puedeActuar());

                System.out.println("Rendimiento de " + presentador2.getNombre() + ": " +
                        presentador2.calcularRendimiento());
                System.out.println("Puede actuar " + presentador2.getNombre() + ": " +
                        presentador2.puedeActuar());

                System.out.println("Rendimiento del baterista: " +
                        baterista.calcularRendimiento());
                System.out.println("Puede actuar el baterista: " + baterista.puedeActuar());

                System.out.println("Rendimiento del robot: " + robot.calcularRendimiento());
                System.out.println("Puede actuar el robot: " + robot.puedeActuar());
                System.out.println("Numero de presentadores a cargo: " +
                        robot.getPresentadoresACargo().size());

            } else if (opcion == 0) {
                System.out.println("Fin del programa.");
            } else {
                System.out.println("Opcion no valida.");
            }
        }

        sc.close();
    }
}