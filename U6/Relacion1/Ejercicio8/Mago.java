public class Mago implements Jugador {
    private String nombre;
    private String mana;
    private String hechizo;

    public Mago(String nombre, String mana, String hechizo) {
        this.nombre = nombre;
        this.mana = mana;
        this.hechizo = hechizo;
    }

    public String atacar() {
        return "El Mago " + nombre + " lanza un hechizo " + hechizo;
    }

    public String mover() {
        return "El Mago " + nombre + " se desplaza utilizando su mana: " + mana;
    }

    @Override
    public String toString() {
        return mover() + "\n" + atacar() + "\n";
    }
}
