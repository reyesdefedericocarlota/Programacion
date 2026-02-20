package U5.R2.Ejercicio4;

public class Cancion {
    private String titulo;
    private String artista;
    private int duracion;

    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        setDuracion(duracion);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getDuracionFormateada() {
        int minutos = duracion / 60;
        int segundos = duracion % 60;

        return minutos + ":" + String.format("%02d", segundos);
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setDuracion(int duracion) {
        if (duracion >= 0) {
            this.duracion = duracion;
        } 
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + " || Artista: " + artista + " || Duracion: " + getDuracionFormateada();
    }

}
