//Crea una función llamada `areaTriangulo` que reciba la base y la altura de un triángulo y devuelva su área calculada con la fórmula `(base * altura) / 2`.

package U4.U3.Relacion0;

public class Ejercicio10 {
    public static double areaTriangulo(double base, double altura) {

        return (base * altura) / 2;
    }

    public static void main(String[] args) {
        System.out.printf("El area del triángulo es:  %.2f", areaTriangulo(7.21, 5.0));
    }
}
