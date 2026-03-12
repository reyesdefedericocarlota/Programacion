package U6.Relacion1.Ejercicio5;

class Libro extends MaterialBibliografico {
    private int numPaginas;
    private String genero;

    public Libro(String titulo, String autor, int numPaginas, String genero) {
        super(titulo, autor);
        this.numPaginas = numPaginas;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return super.toString() + ", Género: " + genero + ", Páginas: " + numPaginas;
    }
}
