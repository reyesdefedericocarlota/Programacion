package U6.Relacion1.Ejercicio2;

class Diseniador extends Empleado {
    private final double BONIFICADOR = 3;

    public Diseniador(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
    }

    public double calcularSueldo() {
        return getSueldoBase() * BONIFICADOR;
    }

}
