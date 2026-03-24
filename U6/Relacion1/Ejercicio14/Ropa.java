public class Ropa extends Producto {
    String talla;

    public Ropa(String nombre, double precio, String talla) {
        super(nombre, precio);
        this.talla = talla;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "|| Precio: " + precio + "€ || Talla: " + talla;
    }

}
