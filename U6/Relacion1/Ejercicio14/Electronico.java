public class Electronico extends Producto {
    int garantia;

    public Electronico(int garantia, String nombre, double precio) {
        super(nombre, precio); 
        this.garantia = garantia;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "|| Precio: " + precio + "€ || Garantía: " + garantia + " días";
    }

}
