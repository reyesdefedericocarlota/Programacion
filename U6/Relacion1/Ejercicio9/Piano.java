// - `Piano`:
//     - Atributos: `marca`, `tipoTeclas`
//     - Método `tocar()`: devuelve "El piano de marca [marca] está tocando una pieza clásica."
//     - Método `afinar()`: devuelve "El piano de marca [marca] con teclas [tipoTeclas] está siendo afinado."

package U6.Relacion1.Ejercicio9;

public class Piano implements InstrumentoMusical {
    private String marca;
    private String tipoTeclas;

    public Piano(String marca, String tipoTeclas) {
        this.marca = marca;
        this.tipoTeclas = tipoTeclas;
    }

    @Override
    public String tocar() {
        return "El piano de marca " + marca + " está tocando una pieza clásica.";
    }

    @Override
    public String afinar() {
        return "El piano de marca " + marca + " con teclas " + tipoTeclas + " está siendo afinado.";
    }

}