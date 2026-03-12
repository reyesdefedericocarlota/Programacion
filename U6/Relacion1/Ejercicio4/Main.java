package U6.Relacion1.Ejercicio4;
// ### 4. Animales Domésticos y Salvajes

// **Enunciado:**  
// Crea una clase `Animal` con los atributos `nombre` y `tipoAlimentacion`. Luego, crea dos subclases: `Domestico` con el método `convivirConHumanos()` y `Salvaje` con el método `cazar()`. Cada método debe devolver una cadena con una acción específica relacionada con el tipo de animal.  

// - `Domestico`:
//     - Atributos: `dueño`
//     - Método `convivirConHumanos()`: devuelve "El animal doméstico [nombre] convive con su dueño [dueño] y se alimenta de [tipoAlimentacion]."

// - `Salvaje`:
//     - Atributos: `habitat`
//     - Método `cazar()`: devuelve "El animal salvaje [nombre] caza en su hábitat [habitat] y se alimenta de [tipoAlimentacion]."

// Implementa una clase `Main` para probar la creación de objetos y la llamada a los métodos `convivirConHumanos()` y `cazar()`.

public class Main {
    public static void main(String[] args) {
        Animal animalico = new Animal("Musaraña", "basura");
        Salvaje celia = new Salvaje("Celia sapiens", "Alfalfa", "Mi casa");
        Domestico dobby = new Domestico("Dobby", "restos de sus amos", "si mismo");

        System.out.println(animalico);
        System.out.println(celia);
        System.out.println(dobby);

        System.out.println(celia.cazar());
        System.out.println(dobby.convivirConHumanos());

    }
}
