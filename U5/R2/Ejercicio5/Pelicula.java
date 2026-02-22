package U5.R2.Ejercicio5;

public class Pelicula {
    String titulo;
    String sinopsis;
    String director;
    int duracion;

    public Pelicula(String titulo, String sinopsis, String director, int duracion) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.director = director;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getDirector() {
        return director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

}
