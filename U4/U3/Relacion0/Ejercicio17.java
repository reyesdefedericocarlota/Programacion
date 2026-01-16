//Crea una función llamada `revertirCadena` que reciba una cadena de texto y devuelva la misma cadena con los caracteres en orden inverso.

package U4.U3.Relacion0;

public class Ejercicio17 {
    public static String revertirCadena(String cadenaTexto) {
        String cadenaRevertida = "";
        for (int i = cadenaTexto.length() - 1; i >= 0; i--) {
            cadenaRevertida += cadenaTexto.charAt(i);
        }
        return cadenaRevertida;
    }

    public static void main(String[] args) {
        String saludo = "hola";
        System.out.println(saludo + " al revés es: " + revertirCadena(saludo));
    }
}
