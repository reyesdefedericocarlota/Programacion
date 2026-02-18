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

    public boolean venderProducto(String id, int cantidadComprar) {
        boolean vendido = false;
        Producto producto = null;

        // Buscar producto
        for (Producto p : productos) {
            if (p.getId().equalsIgnoreCase(id)) {
                producto = p;
            }
        }

        // Si existe y hay stock suficiente
        if (producto != null) {
            if (producto.getCantidadEnStock() >= cantidadComprar) {
                producto.setCantidadEnStock(
                        producto.getCantidadEnStock() - cantidadComprar);
                vendido = true;
            }
        }
        return vendido;
    }

    public Producto reponerProducto(String id, int cantidadReponer) {
        Producto producto = null;

        // Buscar producto
        for (Producto p : productos) {
            if (p.getId().equalsIgnoreCase(id)) {
                producto = p;
            }
        }
        if (producto != null && cantidadReponer > 0) {
            producto.setCantidadEnStock(
                    producto.getCantidadEnStock() + cantidadReponer);
        }
        return producto;

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
