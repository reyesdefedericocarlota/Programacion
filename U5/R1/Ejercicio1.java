package U5.R1;

public class Ejercicio1 {

    public static void main(String[] args) {
        // Creación de un objeto usando el constructor
        Circulo circulo1 = new Circulo(4.5);
        Circulo circulo2 = new Circulo(7.2);

        System.out.println("Círculo de radio " + circulo1.radio + " Area: " + circulo1.calcularArea() + " Perímetro: "
                + circulo1.calcularPerimetro());
        System.out.println("Círculo de radio " + circulo2.radio + " Area: " + circulo2.calcularArea() + " Perímetro: "
                + circulo2.calcularPerimetro());
    }

}

class Circulo {
    double radio;
    final double PI = 3.14;

    // Constructor
    Circulo(double radio) {
        this.radio = radio;
    }

    // Métodos
    double calcularArea() {
        return (PI * radio * radio);
    }

    double calcularPerimetro() {
        return (2 * PI * radio);
    }

}

// Crea una clase `Círculo` con el atributo `radio`. Agrega un método
// `calcularArea()` que retorne el área del círculo (π * radio²) y otro método
// `calcularPerimetro()` que retorne su perímetro (2 * π * radio).