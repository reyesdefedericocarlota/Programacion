package U6.Relacion1.Ejercicio5;

public class MaterialBibliografico {
    private String titulo;
    private String autor;

    public MaterialBibliografico(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Libro: " + titulo + " por " + autor;
    }

}
