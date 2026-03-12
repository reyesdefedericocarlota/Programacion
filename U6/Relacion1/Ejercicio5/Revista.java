package U6.Relacion1.Ejercicio5;

class Revista extends MaterialBibliografico {
    private int edicion;
    private String periocidad;

    public Revista(String titulo, String autor, int edicion, String periocidad) {
        super(titulo, autor);
        this.edicion = edicion;
        this.periocidad = periocidad;
    }

    @Override
    public String toString() {
        return super.toString() + ", Edición: " + edicion + ", Periocidad: " + periocidad;
    }

}
