// Define una interfaz Jugador con los métodos mover() y atacar(). Cada método debe devolver una cadena indicando la acción realizada.
// Luego, crea tres clases concretas: Guerrero, Mago y Arquero. Cada clase debe implementar la interfaz y proporcionar una implementación específica para cada método según el tipo de jugador.

// Guerrero:

// Atributos: nombre, fuerza, arma
// Método mover(): devuelve "El Guerrero [nombre] se mueve con fuerza [fuerza]."
// Método atacar(): devuelve "El Guerrero [nombre] ataca con su [arma]."
// Mago:

// Atributos: nombre, mana, hechizo
// Método mover(): devuelve "El Mago [nombre] se desplaza utilizando su mana [mana]."
// Método atacar(): devuelve "El Mago [nombre] lanza un hechizo [hechizo]."
// Arquero:

// Atributos: nombre, agilidad, arco
// Método mover(): devuelve "El Arquero [nombre] se mueve ágilmente con agilidad [agilidad]."
// Método atacar(): devuelve "El Arquero [nombre] dispara una flecha con su [arco]."
// Implementa una clase Main para probar la creación de objetos y la llamada a los métodos de la interfaz.

public class Main {

    public static void main(String[] args) {

        Guerrero guerrero1 = new Guerrero("Pablo", "poderosa", "espada");
        Mago mago1 = new Mago("Gandalf", "poder sobrenatural", "poderoso");
        Arquero arquero1 = new Arquero("Robin", "media", "arco");

        System.out.println(guerrero1.atacar());
        System.out.println(guerrero1.mover());

        System.out.println(mago1);

        System.out.println(arquero1.atacar());
        System.out.println(arquero1.mover());

    }

}
