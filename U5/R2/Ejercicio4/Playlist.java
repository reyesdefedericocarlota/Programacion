package U5.R2.Ejercicio4;

import java.util.ArrayList;

public class Playlist {

    ArrayList<Cancion> canciones;

    public Playlist() {
        this.canciones = new ArrayList<>();
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    public String mostrarCanciones() {
        String mensaje = "Canciones:\n ";

        for (Cancion cancion : canciones) {
            mensaje += cancion + "\n";
        }
        return mensaje;
    }

    public int calcularDuracion() {
        int duracionTotal = 0;
        for (Cancion cancion : canciones) {
            duracionTotal += cancion.getDuracion();
        }
        return duracionTotal;
    }

    public String calcularDuracionFormateada() {
        int totalSegundos = calcularDuracion();

        int horas = totalSegundos / 3600;
        int minutos = (totalSegundos % 3600) / 60;
        int segundos = totalSegundos % 60;

        return "Duración de la playlist -> " + String.format("%02d", horas) + ":" +
                String.format("%02d", minutos) + ":" +
                String.format("%02d", segundos);
    }

}
