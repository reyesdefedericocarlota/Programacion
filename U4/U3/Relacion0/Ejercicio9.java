//Crea una función llamada `menorDeTres` que reciba tres números y devuelva el menor de los tres.

package U4.U3.Relacion0;

public class Ejercicio9 {
    public static int menorDeTres(int numero1, int numero2, int numero3) {
        int minimo = numero1;
        if (numero2 < minimo) {
            minimo = numero2;
        }
        if (numero3 < minimo) {
            minimo = numero3;
        }

        return minimo;
    }

    public static void main(String[] args) {
        int numeros = menorDeTres(6, 5, 7);
        System.out.println("El número más pequeño es: " + numeros);
    }
}
