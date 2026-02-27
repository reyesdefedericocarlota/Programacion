package U5.PT5;

public class PT5 {

    public static void main(String[] args) {
        Animal animal = new Animal("Jirafa", "A1B2C3", 3, 25);
        // System.out.println(animal);

        Zoologico zoologico = new Zoologico();
        zoologico.agregarAnimales(animal);
        System.out.println(zoologico.mostrarAnimales());
    }
}
