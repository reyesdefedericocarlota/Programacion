// Usando el array `colores` del ejercicio anterior, elimina el último color.
// Muestra el array resultante y el valor del color eliminado.

package U4.U2.Relacion1;

import java.util.ArrayList;

public class Ejercicio3 {
    public static void main(String[] args) {
        ArrayList<String> colores = new ArrayList<String>();
        colores.add("rojo");
        colores.add("verde");
        colores.add("azul");

        String eliminado = colores.remove(colores.size() - 1);

        System.out.println(eliminado);
        System.out.println(colores);
    }

}
