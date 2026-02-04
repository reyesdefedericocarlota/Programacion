//Crea una función llamada `capitalizarPrimeraLetra` que reciba una palabra y devuelva la misma palabra con la primera letra en mayúscula. Investiga el uso de `toUpperCase()`.

package U4.U3.Relacion0;

public class Ejercicio19 {
    public static String capitalizarPrimeraLetra(String cadena) {
        return Character.toUpperCase(cadena.charAt(0)) + cadena.substring(1);
    }

    public static void main(String[] args) {

        System.out.println(capitalizarPrimeraLetra("hola"));
    }
}



