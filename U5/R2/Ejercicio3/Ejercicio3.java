package U5.R2.Ejercicio3;

import U5.R2.Faker;

public class Ejercicio3 {

    public static void main(String[] args) {

        Producto champuHS = new Producto("Champú HS",
                "Olor a limón",
                3.49,
                100);
        Producto champuPantene = new Producto("Champú Pantene",
                "Olor a hierbabuena",
                2.5,
                50);
        Producto champuHacendado = new Producto("Champú Hacendado",
                "Olor neutral",
                1.7,
                150);

        if (!champuHS.setPrecio(-8.01)) {
            System.err.println("Ha habido un error actualizando el precio");
        }
        if (!champuHS.setPrecio(8)) {
            System.err.println("Ha habido un error actualizando el precio");
        }

        System.out.println(champuHS.getPrecio());

        if (!champuHS.setCantidadEnStock(-8)) {
            System.err.println("Ha habido un error actualizando la cantidad");
        }

        if (!champuHS.setCantidadEnStock(50)) {
            System.err.println("Ha habido un error actualizando la cantidad");
        }

        System.out.println(champuHS.getCantidadEnStock());

        Supermercado mercadona = new Supermercado();
        mercadona.agregarProducto(champuHS);
        mercadona.agregarProducto(champuPantene);
        mercadona.agregarProducto(champuHacendado);
        System.out.println(mercadona);
        mercadona.venderProducto(champuHS, 20);
        System.out.println(mercadona);
        System.out.println(mercadona.mostrarInventario());

        final int CANTIDAD_PRODUCTOS = 100;
        Producto aleatorio = new Producto(null, null, 0, 0);

        for (int i = 0; i < CANTIDAD_PRODUCTOS; i++) {
            aleatorio = new Producto(Faker.producto(), Faker.loremLargo(), Faker.precio(1.0, 30.0),
                    Faker.entero(1, 200));
            mercadona.agregarProducto(aleatorio);
        }

        System.out.println(mercadona.mostrarInventario());

    }

}
