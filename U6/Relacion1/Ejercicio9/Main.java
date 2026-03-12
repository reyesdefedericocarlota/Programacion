package U6.Relacion1.Ejercicio9;

public class Main {
    public static void main(String[] args) {
        Guitarra guitarra = new Guitarra("Yamaha", "nylon");
        Piano piano = new Piano("Yamaha", "ligeras");

        System.out.println(guitarra.afinar());
        System.out.println(guitarra.tocar());

        System.out.println(piano.afinar());
        System.out.println(piano.tocar());
    }
}
