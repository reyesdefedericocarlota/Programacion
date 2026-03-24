public abstract class Empleado {
    String nombre;
    double sueldoBase;

    public Empleado(String nombre, double sueldoBase) {
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
    }

    abstract double calcularSueldo();
}
