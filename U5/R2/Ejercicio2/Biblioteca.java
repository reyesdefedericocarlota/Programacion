package U5.R2.Ejercicio2;

import java.util.ArrayList;

public class Biblioteca {

    ArrayList<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void prestarLibro(Libro libroDisponible) {
        libroDisponible.setDisponible(false);
    }

    public void devolverLibro(Libro libroDisponible) {
        libroDisponible.setDisponible(true);
    }

    public Libro buscarLibro(String idLibro) {
        Libro libroEncontrado = null;
        boolean encontrado = false;
        for (int i = 0; i < libros.size() && !encontrado; i++) {
            if (libros.get(i).getId().equals(idLibro)) {
                libroEncontrado = libros.get(i);
                encontrado = true;
            }
        }
        return libroEncontrado;
    }

}
