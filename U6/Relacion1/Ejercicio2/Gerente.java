package U6.Relacion1.Ejercicio2;

class Gerente extends Empleado {
    private final double BONIFICADOR = 2.5;

    public Gerente(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
    }

    public double calcularSueldo() {
        return getSueldoBase() * BONIFICADOR;
    }

}
