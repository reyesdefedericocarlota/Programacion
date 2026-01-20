//  Crea un array llamado `dias` que contenga los días de la semana de lunes a domingo.
//  Cambia el valor del día `"domingo"` por `"Domingo (fin de semana)"` accediendo directamente al índice.

package U4.U2.Relacion1;

import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio7 {

    public static void main(String[] args) {
        ArrayList<String> dias = new ArrayList<String>(
                Arrays.asList("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"));
        dias.set(dias.size() - 1, "Domingo (fin de semana)");

        System.out.println(dias);
    }
}
