package U5.PT5;

import java.util.ArrayList;
import java.util.Arrays;

public class Zoologico {
    private ArrayList<Animal> animales;

    public Zoologico() {
        this.animales = new ArrayList<>();
    }

    public void agregarAnimal(Animal animal) {
        animales.add(animal);
    }

    public String mostrarAnimales() {
        String mensaje = "";

        for (Animal animal : animales) {
            mensaje += animal + "\n";
        }
        return mensaje;
    }

    public Animal buscarAnimal(String codigo) {
        Animal animalBuscar = null;

        for (Animal animal : animales) {
            if (codigo.equals(animal.getCodigo())) {
                animalBuscar = animal;
            }
        }
        return animalBuscar;
    }

    // [0] -> Agregado correctamente
    // [1] -> No existe el animal
    // [2] -> Cantidad negativa o 0
    public ArrayList<Boolean> agregarEjemplares(String codigo, int cantidad) {
        ArrayList<Boolean> controlErrores = new ArrayList<>(Arrays.asList(false, false, false));
        Animal animalEncontrado = buscarAnimal(codigo);

        if (animalEncontrado == null) {
            controlErrores.set(1, true); // Animal no encontrado
        } else if (cantidad <= 0) {
            controlErrores.set(2, true); // Cantidad inválida
        } else {
            animalEncontrado.setCantidad(animalEncontrado.getCantidad() + cantidad);
            controlErrores.set(0, true); // Agregado correctamente
        }
        return controlErrores;
    }

    // Devuelve un array de Booleanos para gestionar si se han retirado ejemplares o
    // no

    // [0] -> Si se ha retirado o no
    // [1] -> Si no existe el animal
    // [2] -> Si la cantidad es negativa o 0
    // [3] -> Si se intenta retirar más de lo disponible
    public ArrayList<Boolean> retirarEjemplares(String codigo, int cantidad) {
        ArrayList<Boolean> controlErrores = new ArrayList<>(Arrays.asList(false, false, false, false));
        Animal animalEncontrado = buscarAnimal(codigo);

        if (animalEncontrado == null) {
            controlErrores.set(1, true); // No existe
        } else if (cantidad <= 0) {
            controlErrores.set(2, true); // Cantidad inválida
        } else {
            int cantidadRestante = animalEncontrado.getCantidad() - cantidad;
            if (cantidadRestante < 0) {
                controlErrores.set(3, true); // Intento de retirar más de lo disponible
            } else {
                animalEncontrado.setCantidad(cantidadRestante);
                controlErrores.set(0, true); // Retirado correctamente
            }
        }
        return controlErrores;
    }

    // [0]->Si se ha retirado o no
    // [1]->En caso de no estar retirado, si no exite el animal
    // [2]->En caso de no estar retirado, si el animal tiene ejemplares
    public ArrayList<Boolean> eliminarAnimal(String codigo) {
        ArrayList<Boolean> controlErrores = new ArrayList<>(Arrays.asList(false, false, false));
        Animal animalEncontrado = buscarAnimal(codigo);

        if (animalEncontrado == null) {
            controlErrores.set(1, true); // No existe
        } else if (animalEncontrado.getCantidad() > 0) {
            controlErrores.set(2, true); // Tiene ejemplares
        } else {
            animales.remove(animalEncontrado);
            controlErrores.set(0, true); // Eliminado correctamente
        }

        return controlErrores;
    }
}
