package U6.Relacion1.Ejercicio4;

class Salvaje extends Animal {
    String habitat;

    public Salvaje(String nombre, String tipoAlimentacion, String habitat) {
        super(nombre, tipoAlimentacion);
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return super.toString() + " || Habitat: " + habitat;
    }

    public String cazar() {
        return "El animal salvaje " + getNombre() + " caza en su hábitat " + habitat + " y se alimenta de "
                + getTipoAlimentacion();
    }
}
