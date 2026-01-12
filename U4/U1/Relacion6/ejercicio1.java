package U4.U1.Relacion6;

import java.util.Scanner;

public class ejercicio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroAlumno = 1;
        int alumnosAprobados = 0, alumnosSuspensos = 0;
        double sumatorio = 0, nota;

        System.out.println("Introduce la calificacion del alumno " + numeroAlumno + ":");
        nota = scanner.nextDouble();

        while (nota != -1) {
            sumatorio += nota;
            numeroAlumno++;

            if (nota < 5) {
                alumnosSuspensos++;
            } else {
                alumnosAprobados++;
            }

            System.out.println("Introduce la calificacion del alumno " + numeroAlumno + ":");
            nota = scanner.nextDouble();
        }
        scanner.close();
        double media = sumatorio / (numeroAlumno - 1);

        System.out.println("Hay " + alumnosAprobados + " alumnos aprobados y " + alumnosSuspensos + " alumnos suspensos.");
        System.out.printf("La calificación media es (%.2f ", media);
    }
}
