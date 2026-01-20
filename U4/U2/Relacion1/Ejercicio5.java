// Usando el array `animales` del ejercicio anterior, elimina el primer elemento.
// Muestra el array después de la eliminación y el valor del elemento eliminado.

package U4.U2.Relacion1;

import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio5 {

    public static void main(String[] args) {
        ArrayList<String> animales = new ArrayList<String>(Arrays.asList("perro", "gato"));
        animales.add(0, "loro");
        animales.add(0, "tortuga");

        System.out.println(animales.remove(0));
        System.out.println(animales);
    }
}
