package U6.Relacion1.Ejercicio1;

class Televisor extends Electrodomestico {
    private int tamanioPantalla;

    public Televisor(String marca, String modelo, int tamanioPantalla) {
        super(marca, modelo);
        this.tamanioPantalla = tamanioPantalla;
    }

    @Override
    public String toString() {
        return super.toString() + " || Tamaño de la pantalla: " + tamanioPantalla + " cm.";
    }

}
