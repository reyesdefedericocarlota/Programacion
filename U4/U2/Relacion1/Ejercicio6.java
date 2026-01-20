// Crea un array llamado `frutas` que contenga los elementos `"manzana"`, `"banana"`, `"naranja"`.
// Elimina el primer elemento y añade `"fresa"` al final.
// Imprime el array resultante.

package U4.U2.Relacion1;

import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio6 {

    public static void main(String[] args) {
        ArrayList<String> frutas = new ArrayList<String>(Arrays.asList("manzana", "banana", "naranja"));
        frutas.remove(0);
        frutas.add("fresa");

        System.out.println(frutas);
    }
}
