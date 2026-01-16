//Crea una función llamada `contarVocalesEnCadena` que reciba una cadena de texto y devuelva la cantidad total de vocales que contiene.

package U4.U3.Relacion0;

public class Ejercicio18 {
    public static int contarVocalesEnCadena(String cadenaTexto) {
        int numeroTotalVocales = 0;
        char[] convertirArray = cadenaTexto.toCharArray();

        for (int i = 0; i < cadenaTexto.length(); i++) {
            if (convertirArray[i] == 'a' || convertirArray[i] == 'e' || convertirArray[i] == 'i'
                    || convertirArray[i] == 'o' || convertirArray[i] == 'u') {

                numeroTotalVocales++;
            }
        }

        return numeroTotalVocales;
    }

    public static void main(String[] args) {
        String animal = "murcielago";
        System.out.println("La palabra " + animal + " tiene " + contarVocalesEnCadena(animal) + " vocales.");
    }
}
