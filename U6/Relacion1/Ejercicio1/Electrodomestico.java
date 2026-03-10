package U6.Relacion1.Ejercicio1;

public class Electrodomestico {
    protected String marca;
    protected String modelo;

    public Electrodomestico(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + " || Modelo: " + modelo;
    }

}
