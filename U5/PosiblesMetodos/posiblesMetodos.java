package U5.PosiblesMetodos;

import java.util.ArrayList;
import java.util.Arrays;

import U5.PT5.Animal;

public class posiblesMetodos {

    /**
     * Agrega un nuevo animal al zoológico si el código no existe ya.
     *
     * @param animal Objeto Animal a agregar.
     * @return ArrayList<Boolean> con el control de errores:
     *         [0] -> true si se agregó correctamente
     *         [1] -> true si ya existe un animal con ese código
     */
    public ArrayList<Boolean> agregarAnimal(Animal animal) {
        ArrayList<Boolean> controlErrores = new ArrayList<>(Arrays.asList(false, false));
        if (buscarAnimal(animal.getCodigo()) != null) {
            controlErrores.set(1, true); // Ya existe el código
        } else {
            animales.add(animal);
            controlErrores.set(0, true); // Agregado correctamente
        }
        return controlErrores;
    }

    /**
     * Devuelve una lista de todos los animales que actualmente no tienen
     * ejemplares.
     *
     * @return ArrayList<Animal> con los animales cuya cantidad es 0.
     */
    public ArrayList<Animal> animalesConCantidadCero() {
        ArrayList<Animal> sinEjemplares = new ArrayList<>();
        for (Animal animal : animales) {
            if (animal.getCantidad() == 0) {
                sinEjemplares.add(animal);
            }
        }
        return sinEjemplares;
    }

    /**
     * Devuelve el total de ejemplares de todos los animales en el zoológico.
     *
     * @return int Total de ejemplares sumando la cantidad de cada animal.
     */
    public int totalEjemplares() {
        int total = 0;
        for (Animal animal : animales) {
            total += animal.getCantidad();
        }
        return total;
    }

    /**
     * Calcula el precio promedio de todos los animales en el zoológico.
     *
     * @return double Precio promedio, o 0 si no hay animales.
     */
    public double precioPromedio() {
        double promedio = 0;
        if (!animales.isEmpty()) {
            double suma = 0;
            for (Animal animal : animales) {
                suma += animal.getPrecio();
            }
            promedio = suma / animales.size();
        }
        return promedio;
    }

    /**
     * Devuelve el animal más caro del zoológico.
     *
     * @return Animal más caro, o null si no hay animales.
     */
    public Animal animalMasCaro() {
        Animal caro = null;
        if (!animales.isEmpty()) {
            caro = animales.get(0);
            for (Animal animal : animales) {
                if (animal.getPrecio() > caro.getPrecio()) {
                    caro = animal;
                }
            }
        }
        return caro;
    }

    /**
     * Devuelve el animal más barato del zoológico.
     *
     * @return Animal más barato, o null si no hay animales.
     */
    public Animal animalMasBarato() {
        Animal barato = null;
        if (!animales.isEmpty()) {
            barato = animales.get(0);
            for (Animal animal : animales) {
                if (animal.getPrecio() < barato.getPrecio()) {
                    barato = animal;
                }
            }
        }
        return barato;
    }

    /**
     * Permite comprar ejemplares de un animal si hay suficiente dinero y ejemplares
     * disponibles.
     *
     * @param codigo   Código del animal a comprar.
     * @param dinero   Dinero que el usuario paga.
     * @param cantidad Número de ejemplares que desea comprar.
     * @return ArrayList<Boolean> con el control de errores:
     *         [0] → Compra realizada con éxito
     *         [1] → Animal no existe
     *         [2] → Dinero insuficiente
     *         [3] → Cantidad inválida (≤0)
     *         [4] → Cantidad solicitada superior a ejemplares disponibles
     */
    public ArrayList<Boolean> comprarAnimal(String codigo, double dinero, int cantidad) {
        ArrayList<Boolean> controlErrores = new ArrayList<>(Arrays.asList(false, false, false, false, false));

        Animal animalEncontrado = buscarAnimal(codigo);

        if (animalEncontrado == null) {
            controlErrores.set(1, true); // Animal no existe
        } else if (cantidad <= 0) {
            controlErrores.set(3, true); // Cantidad inválida
        } else if (cantidad > animalEncontrado.getCantidad()) {
            controlErrores.set(4, true); // No hay suficientes ejemplares
        } else {
            double precioTotal = animalEncontrado.getPrecio() * cantidad;
            if (dinero < precioTotal) {
                controlErrores.set(2, true); // Dinero insuficiente
            } else {
                // Compra válida: restamos ejemplares del zoológico
                animalEncontrado.setCantidad(animalEncontrado.getCantidad() - cantidad);
                controlErrores.set(0, true); // Compra realizada con éxito
            }
        }

        return controlErrores;
    }

    /**
     * Agrega un nuevo animal al zoológico si el código no existe ya.
     *
     * Control de errores:
     * [0] -> true si se agregó correctamente
     * [1] -> true si ya existe un animal con ese código
     * [2] -> true si la cantidad es negativa o 0
     * [3] -> true si el precio es inválido (<=0)
     *
     * @param animal Objeto Animal que se quiere agregar al zoológico.
     * @return ArrayList<Boolean> indicando los posibles errores o éxito.
     */
    public ArrayList<Boolean> comprarAnimal(Animal animal) {
        ArrayList<Boolean> controlErrores = new ArrayList<>(Arrays.asList(false, false, false, false));

        // Validar cantidad y precio antes de intentar agregar
        if (animal.getCantidad() <= 0) {
            controlErrores.set(2, true);
        } else if (animal.getPrecio() <= 0) {
            controlErrores.set(3, true);
        } else if (buscarAnimal(animal.getCodigo()) != null) {
            controlErrores.set(1, true); // Ya existe un animal con ese código
        } else {
            animales.add(animal);
            controlErrores.set(0, true); // Agregado correctamente
        }

        return controlErrores;
    }

    /**
     * Permite actualizar el precio de un animal existente.
     *
     * @param codigo      Código del animal a actualizar.
     * @param nuevoPrecio Nuevo precio que se quiere asignar.
     * @return ArrayList<Boolean> con el control de errores:
     *         [0] → Precio actualizado correctamente
     *         [1] → Animal no existe
     *         [2] → Precio inválido (≤0)
     */
    public ArrayList<Boolean> actualizarPrecio(String codigo, double nuevoPrecio) {
        ArrayList<Boolean> controlErrores = new ArrayList<>(Arrays.asList(false, false, false));

        Animal animalEncontrado = buscarAnimal(codigo);

        if (animalEncontrado == null) {
            controlErrores.set(1, true); // Animal no existe
        } else if (nuevoPrecio <= 0) {
            controlErrores.set(2, true); // Precio inválido
        } else {
            animalEncontrado.setPrecio(nuevoPrecio);
            controlErrores.set(0, true); // Precio actualizado correctamente
        }

        return controlErrores;
    }
}
