package U5.PT5;

import java.util.ArrayList;
import java.util.Arrays;

public class Zoologico {
    private ArrayList<Animal> animales;

    public Zoologico() {
        this.animales = new ArrayList<>();
    }

    /**
     * Agrega un nuevo animal al zoológico.
     *
     * @param animal El objeto Animal a agregar.
     */
    public void agregarAnimal(Animal animal) {
        animales.add(animal);
    }

    /**
     * Devuelve un String con la información de todos los animales en el zoológico.
     *
     * @return String con todos los animales, cada uno en una línea.
     */
    public String mostrarAnimales() {
        String mensaje = "";

        for (Animal animal : animales) {
            mensaje += animal + "\n";
        }
        return mensaje;
    }

    /**
     * Busca un animal por su código.
     *
     * @param codigo Código del animal a buscar.
     * @return El objeto Animal si se encuentra, o null si no existe.
     */
    public Animal buscarAnimal(String codigo) {
        Animal animalBuscar = null;

        for (Animal animal : animales) {
            if (codigo.equals(animal.getCodigo())) {
                animalBuscar = animal;
            }
        }
        return animalBuscar;
    }

    /**
     * Agrega ejemplares a un animal existente.
     *
     * @param codigo   Código del animal al que se le agregarán ejemplares.
     * @param cantidad Cantidad de ejemplares a agregar (debe ser > 0).
     * @return ArrayList<Boolean> con el control de errores:
     *         [0] -> true si se agregó correctamente
     *         [1] -> true si el animal no existe
     *         [2] -> true si la cantidad es negativa o 0
     */
    public ArrayList<Boolean> agregarEjemplares(String codigo, int cantidad) {
        ArrayList<Boolean> controlErrores = new ArrayList<>(Arrays.asList(false, false, false));
        Animal animalEncontrado = buscarAnimal(codigo);

        if (animalEncontrado == null) {
            controlErrores.set(1, true);
        } else if (cantidad <= 0) {
            controlErrores.set(2, true);
        } else {
            animalEncontrado.setCantidad(animalEncontrado.getCantidad() + cantidad);
            controlErrores.set(0, true);
        }
        return controlErrores;
    }

    /**
     * Retira ejemplares de un animal existente.
     *
     * @param codigo   Código del animal del que se retirarán ejemplares.
     * @param cantidad Cantidad de ejemplares a retirar (debe ser > 0 y <= cantidad
     *                 disponible).
     * @return ArrayList<Boolean> con el control de errores:
     *         [0] -> true si se retiró correctamente
     *         [1] -> true si el animal no existe
     *         [2] -> true si la cantidad es negativa o 0
     *         [3] -> true si se intenta retirar más ejemplares de los disponibles
     */
    public ArrayList<Boolean> retirarEjemplares(String codigo, int cantidad) {
        ArrayList<Boolean> controlErrores = new ArrayList<>(Arrays.asList(false, false, false, false));
        Animal animalEncontrado = buscarAnimal(codigo);

        if (animalEncontrado == null) {
            controlErrores.set(1, true); 
        } else if (cantidad <= 0) {
            controlErrores.set(2, true); 
        } else {
            int cantidadRestante = animalEncontrado.getCantidad() - cantidad;
            if (cantidadRestante < 0) {
                controlErrores.set(3, true); 
            } else {
                animalEncontrado.setCantidad(cantidadRestante);
                controlErrores.set(0, true); 
            }
        }
        return controlErrores;
    }

    /**
     * Elimina un animal del zoológico si no tiene ejemplares disponibles.
     *
     * @param codigo Código del animal a eliminar.
     * @return ArrayList<Boolean> con el control de errores:
     *         [0] -> true si se eliminó correctamente
     *         [1] -> true si el animal no existe
     *         [2] -> true si el animal tiene ejemplares y no puede ser eliminado
     */
    public ArrayList<Boolean> eliminarAnimal(String codigo) {
        ArrayList<Boolean> controlErrores = new ArrayList<>(Arrays.asList(false, false, false));
        Animal animalEncontrado = buscarAnimal(codigo);

        if (animalEncontrado == null) {
            controlErrores.set(1, true); 
        } else if (animalEncontrado.getCantidad() > 0) {
            controlErrores.set(2, true); 
        } else {
            animales.remove(animalEncontrado);
            controlErrores.set(0, true); 
        }

        return controlErrores;
    }
}
