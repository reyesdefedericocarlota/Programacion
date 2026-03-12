package U6.Relacion1.Ejercicio4;

class Domestico extends Animal {
    String dueño;

    public Domestico(String nombre, String tipoAlimentacion, String dueño) {
        super(nombre, tipoAlimentacion);
        this.dueño = dueño;
    }

    public String convivirConHumanos() {
        return "El animal doméstico " + getNombre() + " convive con su dueño " + dueño + " y se alimenta de "
                + getTipoAlimentacion();
    }

    @Override
    public String toString() {
        return super.toString() + " || Dueño: " + dueño;
    }
}
