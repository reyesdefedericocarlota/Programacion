package U6.Relacion1.Ejercicio6;
// Define una interfaz DispositivoInteligente con los métodos encender(), apagar() y conectarWiFi(). 
// Cada método debe devolver una cadena indicando la acción realizada.
// Luego, crea dos clases concretas: Smartphone y SmartTV. 
// Cada clase debe implementar la interfaz y proporcionar una implementación específica para cada método.
// Implementa una clase Main para probar la creación de objetos y la llamada a los métodos de la interfaz.
public class Main {

    public static void main(String[] args) {

        Smartphone movil = new Smartphone();
        SmartTV tele = new SmartTV();

        System.out.println(movil);
        System.out.println(tele);
    }

}
