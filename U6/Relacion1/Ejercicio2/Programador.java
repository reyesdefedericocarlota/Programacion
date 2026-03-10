package U6.Relacion1.Ejercicio2;

class Programador extends Empleado {
    private final double BONIFICADOR = 1.5;

    public Programador(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
    }

    public double calcularSueldo() {
        return sueldoBase * BONIFICADOR;
    }
}
