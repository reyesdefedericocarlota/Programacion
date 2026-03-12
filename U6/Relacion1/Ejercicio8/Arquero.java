public class Arquero implements Jugador {
    private String nombre;
    private String agilidad;
    private String arco;

    public Arquero(String nombre, String agilidad, String arco) {
        this.nombre = nombre;
        this.agilidad = agilidad;
        this.arco = arco;
    }

    public String atacar() {
        return "El Arquero: " + nombre + " dispara una flecha con su " + arco;
    }

    public String mover() {
        return "El Arquero: " + nombre + " se mueve ágilmente con agilidad " + agilidad;
    }

    
    
}
