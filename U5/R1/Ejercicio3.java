package U5.R1;

public class Ejercicio3 {

    public static void main(String[] args) {

    }
}

class Alumno {
    String nombre;
    String materia;
    double calificacion;

    Alumno(String nombre, String materia, double calificacion) {
        this.nombre = nombre;
        this.materia = materia;
        this.calificacion = calificacion;
    }
}

// Crea una clase `Alumno` con atributos `nombre`, `materia` y `calificacion`.
// Agrega un método `aprobo()` que devuelva `True` si la calificación es mayor o
// igual a 6, y `False` en caso contrario.
