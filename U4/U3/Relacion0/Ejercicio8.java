//Crea una función llamada `mayor` que reciba dos números y devuelva el mayor de los dos.

package U4.U3.Relacion0;

public class Ejercicio8 {
    public static int mayor(int numero1, int numero2) {
        int maximo = numero1;
        if (numero2 > numero1) {
            maximo = numero2;
        }
        return maximo;
    }

    public static void main(String[] args) {
        int primerResultado = mayor(6, 7);
        int segundoResultado = mayor(9, 5);
        System.out.println("El número mayor es: " + primerResultado);
        System.out.println("El número mayor es: " + segundoResultado);
    }
}
