public class Gerente extends Empleado {
    double bono;

    public Gerente(String nombre, double sueldoBase, double bono) {
        super(nombre, sueldoBase);
        this.bono = bono;
    }

    double calcularSueldo() {
        return sueldoBase + bono;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " || Sueldo calculado con el bono: " + calcularSueldo();
    }
}
