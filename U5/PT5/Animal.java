package U5.PT5;

public class Animal {
    private String nombre;
    private String codigo;
    private int cantidad;
    private double precio;

    private static final double PRECIO_MINIMO = 50.0;
    private static final double PRECIO_MAXIMO = 5000.0;

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
        if (codigo.length() != 6) {
            throw new IllegalArgumentException("El código debe tener exactamente 6 caracteres.");
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
        if (precio < PRECIO_MINIMO || precio > PRECIO_MAXIMO) {
            throw new IllegalArgumentException(
                    "El precio debe estar entre " + PRECIO_MINIMO + "€ y " + PRECIO_MAXIMO + "€.");
        }
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Nombre: " + nombre + "  | Cantidad: " + cantidad + " | Precio: " + precio
                + "€";
    }

}
