public class Asistente extends Empleado {
    double horasExtras;

    public Asistente(double horasExtras, String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
        this.horasExtras = horasExtras;
    }

    double calcularSueldo() {
        return sueldoBase + horasExtras;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " || Sueldo calculado con las horas extras: " + calcularSueldo();
    }
}
