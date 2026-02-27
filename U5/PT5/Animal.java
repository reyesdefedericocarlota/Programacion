package U5.PT5;

public class Animal {
    private String nombre;
    private String codigo;
    private int cantidad;
    private double precio;

    public Animal(String nombre, String codigo, int cantidad, double precio) {
        setNombre(nombre);
        setCodigo(codigo);
        setCantidad(cantidad);
        setPrecio(precio);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser null ni estar vacío.");
        }
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código no puede ser null ni estar vacío.");
        }
        this.codigo = codigo;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que 0.");
        }
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Nombre: " + nombre + "  | Cantidad: " + cantidad + " | Precio: " + precio
                + "€";
    }

}
