package U4;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class PT2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String DIENTE = "diente", DIENTESANO = "check", DIENTEDANIADO = "x";
        final int NUMDIENTES = 10, MAXDIENTESPICADOS = 5;
        final int DIENTESPICADOS = new Random().nextInt(MAXDIENTESPICADOS) + 1;

        final int DIENTESNOPICADOS = NUMDIENTES - DIENTESPICADOS;
        final String JUGADOR1 = "Jugador 1", JUGADOR2 = "Jugador 2";

        boolean juegoPerdido = false;
        ArrayList<Integer> tableroInterno = new ArrayList<Integer>();
        ArrayList<String> tableroVisible = new ArrayList<String>();

        String jugadorActual = JUGADOR1;
        String mensajeFinPrograma = "Enhorabuena, ambos ganan";
        int posicionSeleccionada = 0, dientesPicdadosIntroducidos = 0, posicionDienteIntroducir = 0;

        for (int i = 0; i < NUMDIENTES; i++) {
            tableroInterno.add(0);
        }

        while (dientesPicdadosIntroducidos < DIENTESPICADOS) {
            posicionDienteIntroducir = new Random().nextInt(NUMDIENTES);
            if (tableroInterno.get(posicionDienteIntroducir) == 0) {
                tableroInterno.set(posicionDienteIntroducir, 1);
                dientesPicdadosIntroducidos++;
            }

        }

        for (int i = 0; i < NUMDIENTES; i++) {
            tableroVisible.add(DIENTE);
        }

        for (int i = 0; i < DIENTESNOPICADOS && !juegoPerdido; i++) {
            do {
                System.out.println(jugadorActual + " elige: ");
                try {
                    posicionSeleccionada = scanner.nextInt();

                } catch (Exception e) {
                    System.out.println("Error, debes introducir un número entero");
                }
            } while (tableroVisible.get(posicionSeleccionada) != DIENTE
                    || (posicionSeleccionada < 0 || posicionSeleccionada > NUMDIENTES));

            if (tableroInterno.get(posicionSeleccionada) == 0) {
                tableroVisible.set(posicionSeleccionada, DIENTESANO);
            } else {
                tableroVisible.set(posicionSeleccionada, DIENTEDANIADO);
                mensajeFinPrograma = "¡El cocodrilo mordió! " + jugadorActual + " pierde.";
                juegoPerdido = true;
            }
            System.out.print(tableroVisible);

            if (jugadorActual == JUGADOR1) {
                jugadorActual = JUGADOR2;
            } else {
                jugadorActual = JUGADOR1;
            }

        }
        scanner.close();
        System.out.print(mensajeFinPrograma);
    }

}
