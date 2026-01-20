// Crea un array llamado `numeros` que contenga los números `[5, 10, 15, 20]`.
// Imprime en la consola el primer y el último elemento accediendo directamente por su índice.

package U4.U2.Relacion1;

import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio1 {

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<Integer>(Arrays.asList(5, 10, 15, 20));

        System.out.println(numeros.get(0));
        System.out.println(numeros.get(numeros.size() - 1));

        // Mostrar array
        String mensaje = "";
        for (int numero : numeros) {
            mensaje += numero + ",";
        }
        mensaje = mensaje.substring(0, mensaje.length() - 1);
        System.out.println(mensaje);
    }

}
