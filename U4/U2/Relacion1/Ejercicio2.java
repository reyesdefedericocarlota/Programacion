// Crea un array vacío llamado `colores`.
// Añade los colores `"rojo"`, `"verde"` y `"azul"` al final del array y luego imprime el array.

package U4.U2.Relacion1;

import java.util.ArrayList;

public class Ejercicio2 {

    public static void main(String[] args) {
        ArrayList<String> colores = new ArrayList<String>();
        colores.add("rojo");
        colores.add("verde");
        colores.add("azul");

        String mensaje = "";
        for (String color : colores) {
            mensaje += color + ",";
        }

        mensaje = mensaje.substring(0, mensaje.length() - 1);

        System.out.println(mensaje);
    }
}
