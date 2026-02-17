package U5.R2.Ejercicio3;

import java.util.ArrayList;

public class Supermercado {

    ArrayList<Producto> productos;

    public Supermercado() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void venderProducto(Producto producto, int cantidadComprar) {
        if (productos.contains(producto)) {
            if (producto.getCantidadEnStock() - cantidadComprar >= 0) {
                producto.setCantidadEnStock(producto.getCantidadEnStock() - cantidadComprar);
            }
        }
    }

    public String mostrarInventario() {
        String stringInventario = "";
        for (Producto producto : productos) {
            stringInventario += "--" + producto + "\n";
        }
        return stringInventario;
    }

    @Override
    public String toString() {
        String resultado = "Productos en el supermercado:\n";

        for (Producto p : productos) {
            resultado += p + "\n";
        }

        return resultado;
    }

}
