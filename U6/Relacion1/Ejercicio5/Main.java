package U6.Relacion1.Ejercicio5;
// ### 5. Biblioteca con Diferentes Tipos de Materiales
// **Enunciado:**  
// Crea una clase `MaterialBibliografico` con los atributos `titulo` y `autor`. Luego, crea dos subclases: `Libro` y `Revista`.  
// Implementa el método `toString()` en ambas subclases para que devuelva una cadena con los detalles del material bibliográfico.  
// Todos los atributos deben ser privados.
// - `Libro`:
//     - Atributos: `numPaginas`, `genero`
//     - Método `toString()`: devuelve "Libro: [titulo] por [autor], Género: [genero], Páginas: [numPaginas]."

// - `Revista`:
//     - Atributos: `edicion`, `periodicidad`
//     - Método `toString()`: devuelve "Revista: [titulo] por [autor], Edición: [edicion], Periodicidad: [periodicidad]."

// Implementa una clase `Main` para probar la creación de objetos y la llamada al método `toString()`.

public class Main {
    public static void main(String[] args) {

        MaterialBibliografico periodico = new MaterialBibliografico("ABC", "ni idea");

        Libro libro = new Libro("Biblia", "El espíritu santo", 7000, "Religioso");

        Revista revista = new Revista("Hobby consolas", "no lo se tampoco", 278, "mensual");

        System.out.println(periodico);
        System.out.println(libro);
        System.out.println(revista);
        
    }
}