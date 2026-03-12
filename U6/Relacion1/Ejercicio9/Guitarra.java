// - `Guitarra`:
//     - Atributos: `marca`, `tipoCuerdas`
//     - Método `tocar()`: devuelve "La guitarra de marca [marca] está tocando una melodía."
//     - Método `afinar()`: devuelve "La guitarra de marca [marca] con cuerdas [tipoCuerdas] está siendo afinada."

package U6.Relacion1.Ejercicio9;

class Guitarra implements InstrumentoMusical {
    private String marca;
    private String tipoCuerdas;

    public Guitarra(String marca, String tipoCuerdas) {
        this.marca = marca;
        this.tipoCuerdas = tipoCuerdas;
    }

    @Override
    public String tocar() {
        return "La guitarra de marca " + marca + " está tocando una melodía.";
    }

    @Override
    public String afinar() {
        return "La guitarra de marca " + marca + " con cuerdas " + tipoCuerdas + " está siendo afinada.";
    }

}