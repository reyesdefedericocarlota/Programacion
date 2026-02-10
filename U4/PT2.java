package U4;

import java.util.ArrayList;
import java.util.Scanner;

public class PT2 {
    /**
     * Construye los tableros
     * 
     * @param arrayIntroducida array del tablero
     * @param tamanio          tamaño del tablero
     * @param simbolo          con que se va a rellenar el tablero
     */
    public static void construyeTablero(ArrayList<String> arrayIntroducida, int tamanio, String simbolo) {
        for (int i = 0; i < tamanio; i++) {
            arrayIntroducida.add(simbolo);
        }
    }

    /**
     * Coloca las bombas aleatoriamente
     * 
     * @param arrayOcultaIntroducida Tablero oculto
     * @param minimoDeBombas         Mínimo de bombas posibles
     * @param maximoDeBombas         Máximo de bombas posibles
     */
    public static void randomizaTablero(ArrayList<String> arrayOcultaIntroducida, int minimoDeBombas,
            int maximoDeBombas) {
        final int NUMEROBOMBAS = (int) (Math.floor(Math.random() * (maximoDeBombas - minimoDeBombas + 1))
                + minimoDeBombas);
        int contadorBombas = 0;
        int posicionTablero;
        while (contadorBombas != NUMEROBOMBAS) {
            posicionTablero = (int) (Math.floor(Math.random() * (arrayOcultaIntroducida.size())));

            // Si la posicion randomizada no tiene bomba, añado bomba
            if (arrayOcultaIntroducida.get(posicionTablero).equals("0")) {
                arrayOcultaIntroducida.set(posicionTablero, "1");
                contadorBombas++;
            }
        }
    }

    /**
     * Cuenta las tuberias existentes del tablero
     * 
     * @param tableroIntroducido El tablero del que se van a contar las tuberias
     * @return Devuelve el número de tuberias que hay en el tablero
     */
    public static int tuberiasSeguras(ArrayList<String> tableroIntroducido) {
        int tuberiasExistentes = 0;
        for (int i = 0; i < tableroIntroducido.size(); i++) {
            if (tableroIntroducido.get(i).equals("0")) {
                tuberiasExistentes++;
            }
        }
        return tuberiasExistentes;
    }

    // ======================== MAIN ==============================
    public static void main(String[] args) {

        // JUGADORES
        final String MARIO = "Mario";
        final String LUIGI = "Luigi";
        String jugadorActual = MARIO;
        int turno = 1;
        final int PAR = 2;
        int contadorTuberiasDestapadas = 0;

        // EMOJIS
        final String TUBERIA = "\uD83D\uDFE9";
        final String CIRCULOBLANCO = "\u26AA";
        final String BOMBA = "\uD83D\uDCA3";
        final String ESTALLIDO = "\uD83D\uDCA5";

        // BOMBAS
        final int MINIMOBOMBAS = 1;
        final int MAXIMOBOMBAS = 5;

        // TABLERO JUEGO
        final int TAMANIOTABLERO = 10;
        ArrayList<String> tableroOculto = new ArrayList<String>();
        construyeTablero(tableroOculto, TAMANIOTABLERO, "0");
        randomizaTablero(tableroOculto, MINIMOBOMBAS, MAXIMOBOMBAS); // Randomiza el tablero oculto
        int contadorTuberiasTablero = tuberiasSeguras(tableroOculto); // Tuberias que hay en el tablero oculto
        ArrayList<String> tableroVisual = new ArrayList<String>();
        construyeTablero(tableroVisual, TAMANIOTABLERO, TUBERIA);

        // MENSAJE FIN JUEGO
        String mensajeFinal = "";

        // CONTROL ERRORES y FIN JUEGO
        boolean sigueJugando = true;
        boolean eleccionNoPosible = true;
        String mensajeError = "Debes introducir un número entero de 0 a 9.";

        // POSICION USUARIO
        int posicionElegida = 0;

        // =========================================== JUEGO
        // ================================= //
        Scanner input = new Scanner(System.in);

        while (sigueJugando) {
            // Jugador que juega
            if (turno % PAR == 0) {
                jugadorActual = LUIGI;
            } else {
                jugadorActual = MARIO;
            }
            // Elección posición
            do {
                try {
                    System.out.println(String.join(" ", tableroVisual));
                    eleccionNoPosible = false;
                    System.out.print(jugadorActual + " elige: ");
                    posicionElegida = Integer.parseInt(input.nextLine());

                    if (posicionElegida < 0 || posicionElegida > (TAMANIOTABLERO - 1)) {
                        System.out.println(mensajeError);
                        eleccionNoPosible = true;
                    } else if (!tableroVisual.get(posicionElegida).equals(TUBERIA)) {
                        System.out.println("¡Esa posición ya fue elegida! Elige otra.");
                        eleccionNoPosible = true;
                    }
                } catch (Exception e) {
                    System.out.println(mensajeError);
                    eleccionNoPosible = true;
                }
            } while (eleccionNoPosible);

            // TOCA BOMBA - PIERDE
            if (tableroOculto.get(posicionElegida).equals("1")) {
                System.out.println("Topo-bomba");
                tableroVisual.set(posicionElegida, BOMBA);
                mensajeFinal = ESTALLIDO + "¡TOPO-BOMBA!" + ESTALLIDO + " " + jugadorActual + " pierde.";
                sigueJugando = false;

                // NO TOCA BOMBA
            } else {
                tableroVisual.set(posicionElegida, CIRCULOBLANCO);
                contadorTuberiasDestapadas++;
                if (contadorTuberiasDestapadas == contadorTuberiasTablero) {
                    mensajeFinal = "¡ENHORABUENA! " + MARIO + " y " + LUIGI + " han ganado";
                    sigueJugando = false;
                }
            }

            turno++;
        }

        input.close();

        // =================== MENSAJE FINAL DEL JUEGO ===================
        System.out.println(mensajeFinal);
        System.out.println(String.join(" ", tableroVisual));

    }
}
