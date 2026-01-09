package U4.U1.Relacion3;

import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double numero1, numero2;
        String operador;
        double resultado;

        System.out.println("Introduzca el primer número");
        numero1 = scanner.nextInt();
        System.out.println("Introduzca el segundo número");
        numero2 = scanner.nextInt();
        System.out.println("Introduzca el operador (+, -, *, /)");
        operador = scanner.next();
        scanner.close();

        if (operador.equals("+")) {
            resultado = numero1 + numero2;
        } else if (operador.equals("-")) {
            resultado = numero1 - numero2;
        } else if (operador.equals("*")) {
            resultado = numero1 * numero2;
        } else if (operador.equals("/")) {
            if (numero2 != 0) {
                resultado = numero1 / numero2;
            } else {
                System.out.println(("No es posible dividir entre 0"));
            }
        } else {
            System.out.println("Operador incorrecto");
        }

    }
}

// <script>
// let resultado

// let numero1 = prompt("Introduzca un número")
// numero1 = Number(numero1)

// let numero2 = prompt("Introduzca otro número")
// numero2 = Number(numero2)

// let operador = prompt("Introduzca el operador (+, -, *, /)")
// let division0

// if (operador == "+") {
// resultado = numero1 + numero2
// } else if (operador == "-") {
// resultado = numero1 - numero2
// } else if (operador == "*") {
// resultado = numero1 * numero2
// } else if (operador == "/") {
// if (numero2 != 0) {
// resultado = numero1 / numero2
// } else {
// console.log("No es posible dividir entre 0");
// division0 = true
// }
// } else {
// console.log("Operador incorrecto")
// }

// if (!division0){
// console.log("El resultado de " + numero1 + operador + numero2 + " es " +
// resultado)
// }else{
// console.log("Vuelva a probar con valores correctos");

// }
// </script>