// Crea un array con los números `[100, 200, 300]`.
// Usa una variable temporal para intercambiar los valores del primer y tercer elemento, e imprime el array después del cambio.

package U4.U2.Relacion1;

import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio8 {

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<Integer>(Arrays.asList(5, 100, 200, 300));
        int temporal = numeros.get(0);

        numeros.get(0) = numeros.get(3);
       
        System.out.println(numeros);
    }
}
