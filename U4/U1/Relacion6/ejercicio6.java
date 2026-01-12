package U4.U1.Relacion6;

import java.util.Scanner;

public class ejercicio6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numero1 = "a";
        String numero2 = "a";
        String operacionUsuario = "a";
        int resultadoOperacion = 0;

        while (numero1 != "SALIR" && numero2 != "SALIR" && operacionUsuario != "SALIR") {
            System.out.println("Introduzca el primer número");
            numero1 = scanner.nextLine();

            if (numero1 != "SALIR") {
                int convertirNumero1 = Integer.parseInt(numero1);

                System.out.println("Introduzca el segundo número");
                numero2 = scanner.nextLine();

                if (numero2 != "SALIR") {
                    int convertirNumero2 = Integer.parseInt(numero2);

                    if (operacionUsuario != "SALIR") {

                        System.out.println("Introduce la operación:");
                        operacionUsuario = scanner.nextLine();

                        if (numero1 != "SALIR" && numero2 != "SALIR" && operacionUsuario != "SALIR") {
                            if (operacionUsuario.equals("+")) {
                                resultadoOperacion = (convertirNumero1 + convertirNumero2);
                            } else if (operacionUsuario.equals("-")) {
                                resultadoOperacion = (convertirNumero1 - convertirNumero2);
                            } else if (operacionUsuario.equals("*")) {
                                resultadoOperacion = (convertirNumero1 * convertirNumero2);
                            } else if (operacionUsuario.equals("/")) {
                                resultadoOperacion = (convertirNumero1 / convertirNumero2);
                            }
                            System.out.println("El resultado de " + convertirNumero1 + operacionUsuario
                                    + convertirNumero2 + " es " + resultadoOperacion);
                        }
                    }
                }
            }

        }
        scanner.close();
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