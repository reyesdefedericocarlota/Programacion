package U5.R2.Ejercicio1;

import java.util.ArrayList;

// Luego, crea una clase Universidad que tenga un array de estudiantes y métodos para:

//     Agregar estudiantes
//     Mostrar todos los estudiantes
//     Buscar un estudiante por su número de matrícula

public class Universidad {

    ArrayList<Estudiante> alumnado;

    public Universidad() {
        this.alumnado = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        alumnado.add(estudiante);
    }

    public String mostrarAlumnado() {
        String stringAlumnado = "";
        for (Estudiante estudiante : alumnado) {
            stringAlumnado += "--" + estudiante + "\n";
        }
        return stringAlumnado;
    }

    public Estudiante buscarEstudiante(String numeroDeMatricula) {
        Estudiante estudianteEncontrado = null ; // variable para guardar el resultado

        for (Estudiante estudiante : alumnado) {
            if (estudiante.getNumeroDeMatricula().equals(numeroDeMatricula)) {
                estudianteEncontrado = estudiante; // guardamos el estudiante
            }
        }

        // Si no se encontró ningún estudiante, mostrar mensaje
        if (estudianteEncontrado == null) {
            mostrarMensaje("La matrícula introducida no corresponde a ningún alumno");
        }

        return estudianteEncontrado; 
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

}
