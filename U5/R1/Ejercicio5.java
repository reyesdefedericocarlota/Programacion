package U5.R1;

public class Ejercicio5 {

    public static void main(String[] args) {

        Termometro termometro1 = new Termometro(0);

        System.out.println("La temperatura en Farenheit es: " + termometro1.convertirAFahrenheit() + "F");
    }
}

class Termometro {
    double temperatura;

    // Constructor
    Termometro(double temperatura) {
        this.temperatura = temperatura;
    }

    // Método
    double convertirAFahrenheit() {
        return (temperatura * 9 / 5) + 32;
    }

}