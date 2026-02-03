package U5.R1;

public class Ejercicio3 {

    public static void main(String[] args) {

        Alumno alumno1 = new Alumno("Carlota", "Programación", 8);
        System.out.println("¿La calificación de " + alumno1.nombre + " es mayor o igual a 6? " + alumno1.aprobo(8));

        Alumno alumno2 = new Alumno("Carlos", "Programación", 5);
        System.out.println("¿La calificación de " + alumno2.nombre + " es mayor o igual a 6? " + alumno1.aprobo(5));
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

    boolean aprobo(double calificacion) {
        return calificacion >= 6;
    }
}

// Crea una clase `Alumno` con atributos `nombre`, `materia` y `calificacion`.
// Agrega un método `aprobo()` que devuelva `True` si la calificación es mayor o
// igual a 6, y `False` en caso contrario.
