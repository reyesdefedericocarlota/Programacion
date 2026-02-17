package U5.R2.Ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Libro libro1 = new Libro("01", "El Señor de los Anillos", "J.R.R Tolkien",
                "La novela narra el viaje de Frodo Bolsón, para destruir el Anillo Único y la consiguiente guerra que provocará el enemigo para recuperarlo, ya que es la principal fuente de poder de su creador, el señor oscuro Sauron. Tres Anillos para los Reyes Elfos bajo el cielo",
                true);
        Libro libro2 = new Libro("04", "1984", "George Orwell",
                "Es una novela distópica que narra la vida de Winston Smith en una sociedad totalitaria gobernada por el Gran Hermano. En Londres (Oceanía), el Partido controla cada aspecto de la vida mediante la vigilancia constante, la policía del pensamiento y la manipulación de la historia en el Ministerio de la Verdad. Winston, un funcionario que reescribe el pasado, busca rebelarse contra este sistema asfixiante, buscando libertad y verdad. ",
                false);
        Libro libro3 = new Libro("07", "Las Crónicas de Narnia", "C.S. Lewis",
                "La historia de cuatro niños (Peter, Susan, Edmund y Lucy Pevensie) que a través de un armario mágico, descubren el camino a la mágica, maravillosa, y alguna vez pacífica tierra de Narnia.",
                true);

        Biblioteca biblio = new Biblioteca();
        biblio.agregarLibro(libro1);
        biblio.agregarLibro(libro2);
        biblio.agregarLibro(libro3);
     

        int elegirOpcion;
        String idLibro;
        Libro buscado;
        final String MENU = "Elige una de las siguientes opciones:\n" +
                "0 = Salir\n" +
                "1 = Prestar un libro\n" +
                "2 = Devolver un libro\n";

        elegirOpcion = opcionMenu(scanner, MENU, 0, 2, -1);

        do {

            if (elegirOpcion == 1) {
                System.out.println("Introduce el id del libro");
                idLibro = scanner.nextLine();
                buscado = biblio.buscarLibro(idLibro);

            }
        } while (elegirOpcion != 0);
    }

    public static int opcionMenu(Scanner introScanner, String textoMenu, int min, int max, int parametroDefecto) {
        int opcion;
        do {
            try {
                mostrarMensaje(textoMenu);
                opcion = Integer.parseInt(introScanner.nextLine());
            } catch (NumberFormatException e) {
                mostrarMensaje("Error, debes introducir un número.");
                opcion = parametroDefecto;
            }
        } while (opcion < min || opcion > max);
        return opcion;
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

}
