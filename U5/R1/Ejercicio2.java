package U5.R1;

public class Ejercicio2 {
    public static void main(String[] args) {
        CuentaBancaria saldo1 = new CuentaBancaria("Carlota", 300);
        CuentaBancaria saldo2 = new CuentaBancaria("Teresa", 1000);

        saldo1.depositar(200);
        System.out.println("Carlota tiene: " + saldo1.saldo);
        if (saldo1.retirar(300)) {
            System.out.println("Ahora tiene: " + saldo1.saldo);
        } else {
            System.out.println("No tiene suficiente dinero para retirar esa cantidad.");
        }

        saldo2.depositar(200);
        System.out.println("Teresa tiene: " + saldo2.saldo);
        if (saldo1.retirar(2000)) {
            System.out.println("Ahora tiene: " + saldo2.saldo);
        } else {
            System.out.println("No tiene suficiente dinero para retirar esa cantidad.");
        }

    }
}

class CuentaBancaria {
    String titular;
    double saldo;

    CuentaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    void depositar(double cantidad) {
        this.saldo += cantidad;
    }

    boolean retirar(double cantidad) {
        boolean puedesRetirar = true;
        if (cantidad > this.saldo) {
            puedesRetirar = false;
        } else {
            this.saldo -= cantidad;
        }

        return puedesRetirar;
    }
}

// Crea una clase `CuentaBancaria` con atributos `titular` y `saldo`. Agrega
// métodos `depositar(cantidad)` y `retirar(cantidad)`, asegurando que el saldo
// no sea negativo después de un retiro.
