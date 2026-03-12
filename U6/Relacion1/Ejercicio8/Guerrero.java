public class Guerrero implements Jugador {
    private String nombre;
    private String fuerza;
    private String arma;

    public Guerrero(String nombre, String fuerza, String arma) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.arma = arma;
    }

    public String atacar() {
        return "El Guerrero " + nombre + " ataca con su " + arma;
    }

    public String mover() {
        return "El Guerrero " + nombre + " se mueve con fuerza " + fuerza;
    }

}
