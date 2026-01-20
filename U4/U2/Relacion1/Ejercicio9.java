// Crea un array vacío llamado `cola`.
// Añade los elementos `"cliente1"`, `"cliente2"` y `"cliente3"` al final del array.
// Simula el proceso de atender a los clientes eliminando el primero e imprime el cliente atendido y el estado de la cola.

package U4.U2.Relacion1;

import java.util.ArrayList;

public class Ejercicio9 {

    public static void main(String[] args) {
        ArrayList<String> cola = new ArrayList<String>();
        cola.add("cliente1");
        cola.add("cliente2");
        cola.add("cliente3");

        System.out.println(cola.remove(0));
        System.out.println(cola);
    }

}
