package U5.PT5;

import java.util.ArrayList;
import java.util.Arrays;

public class Zoologico {
    private ArrayList<Animal> animales;

    public Zoologico() {
        this.animales = new ArrayList<>();
    }

    public void agregarAnimales(Animal animal) {
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

    public boolean agregarEjemplares(Animal animal, int cantidadAnimal) {
        boolean ejemplarAgregado = false;

        if (animales.contains(animal)) {
            animal.setCantidad(animal.getCantidad() + cantidadAnimal);
            ejemplarAgregado = true;
        }
        return ejemplarAgregado;
    }

    // Devuelve un array de Booleanos para gestionar si se han retirado ejemplares o
    // no

    // [0]->Si se ha retirado o no
    // [1]->En caso de no estar retirado, si no exite el animal
    // [2]->En caso de no estar retirado, si la cantidada retirar es un num negativo
    // [3]-> // // // // //, si ha sido se ha intentado retirar más de lo disponible
    public ArrayList<Boolean> retirarEjemplares(String nombre, int cantidadAnimal) {
        ArrayList<Boolean> controlErrores = new ArrayList<>(Arrays.asList(false, false, false, false));
        int cantidadEjemplar;

        for (int i = 0; i < animales.size() && !controlErrores.get(1); i++) {
            if (animales.get(i).getNombre().equals(nombre)) {
                controlErrores.set(1, true);
                if (cantidadAnimal > 0) {
                    controlErrores.set(2, true);
                    cantidadEjemplar = animales.get(i).getCantidad() - cantidadAnimal;
                    if (cantidadEjemplar >= 0) {
                        controlErrores.set(3, true);
                        controlErrores.set(0, true);
                        animales.get(i).setCantidad(cantidadEjemplar);
                    }
                }
            }
        }

        return controlErrores;
    }

    public ArrayList<Boolean> eliminarAnimal(Animal animal) {
    }
}
