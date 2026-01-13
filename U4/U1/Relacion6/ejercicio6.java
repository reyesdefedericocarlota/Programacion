package U4.U1.Relacion6;

import java.util.Scanner;

public class ejercicio6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numero1, numero2, operacion;
        int n1, n2, resultado = 0;
        boolean salir = false;

        while (!salir) {

            System.out.println("Introduzca el primer número (o SALIR):");
            numero1 = scanner.nextLine();

            if (numero1.equals("SALIR")) {
                salir = true;
            } else {

                System.out.println("Introduzca el segundo número (o SALIR):");
                numero2 = scanner.nextLine();

                if (numero2.equals("SALIR")) {
                    salir = true;
                } else {

                    System.out.println("Introduce la operación (+, -, *, /) o SALIR:");
                    operacion = scanner.nextLine();

                    if (operacion.equals("SALIR")) {
                        salir = true;
                    } else {

                        n1 = Integer.parseInt(numero1);
                        n2 = Integer.parseInt(numero2);

                        if (operacion.equals("+")) {
                            resultado = n1 + n2;
                        } else if (operacion.equals("-")) {
                            resultado = n1 - n2;
                        } else if (operacion.equals("*")) {
                            resultado = n1 * n2;
                        } else if (operacion.equals("/")) {
                            resultado = n1 / n2;
                        } else {
                            System.out.println("Operación no válida");
                        }

                        System.out.println("El resultado de " + n1 + operacion + n2 + " es " + resultado);
                    }
                }
            }
        }
        scanner.close();
        System.out.println("Programa finalizado.");
    }
}
// while (numero1 != "SALIR" && numero2 != "SALIR" && operacionUsuario !=
// "SALIR") {
// numero1 = prompt("Introduce el primer número:")

// if (numero1 != "SALIR") {
// numero1 = Number(numero1)

// numero2 = prompt("Introduce el segundo número:")
// if (numero2 != "SALIR") {
// numero2 = Number(numero2)

// operacionUsuario = prompt("Introduce la operación:")

// if (operacionUsuario != "SALIR") {

// if (operacionUsuario == "+") {
// resultadoOperacion = numero1 + numero2
// } else if (operacionUsuario == "-") {
// resultadoOperacion = numero1 - numero2
// } else if (operacionUsuario == "*") {
// resultadoOperacion = numero1 * numero2
// } else if (operacionUsuario == "/") {
// resultadoOperacion = numero1 / numero2
// }

// alert("El resultado de " + numero1 + operacionUsuario + numero2 + " es " +
// resultadoOperacion)
// }
// }
// }
// }