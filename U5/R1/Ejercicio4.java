package U5.R1;

public class Ejercicio4 {

    public static void main(String[] args) {

        Auto auto1 = new Auto("Toyota", "Corolla", 60.5);

        auto1.acelerar(20.0);
        System.out.println("Velocidad actual: " + auto1.velocidadActual);

        auto1.frenar(10.5);
        System.out.println("Velocidad actual: " + auto1.velocidadActual);

    }
}

class Auto {
    String marca;
    String modelo;
    double velocidadActual;

    Auto(String marca, String modelo, double velocidadActual) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadActual = velocidadActual;
    }

    void acelerar(double cantidad) {
        velocidadActual += cantidad;
    }

    void frenar(double cantidad) {
        velocidadActual -= cantidad;
        if (velocidadActual < 0) {
            velocidadActual = 0;
        }
    }

}