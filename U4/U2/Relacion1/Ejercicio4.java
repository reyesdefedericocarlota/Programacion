//  Crea un array llamado `animales` que contenga los elementos `"perro"`, `"gato"`.
//  Añade `"loro"` y `"tortuga"` al inicio del array y luego imprime el array.

package U4.U2.Relacion1;

import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio4 {

    public static void main(String[] args) {
        ArrayList<String> animales = new ArrayList<String>(Arrays.asList("perro", "gato"));
        animales.add(0, "loro");
        animales.add(0, "tortuga");

        System.out.println(String.join(",", animales));
    }
}
