package U5.R3.Ejercicio1;

public class Ejercicio1 {

    public static void main(String[] args) {
        Embarcacion embarcacion1 = new Embarcacion("2343", null, 0, "Yate", null, 2026, 0);
        System.out.println(embarcacion1);

        Amarre amarre1 = new Amarre(1, 4, "Premium", false);
        System.out.println(amarre1);

        Embarcacion[] embarcaciones = new Embarcacion[5];
        Amarre[] amarres = new Amarre[5];
        Puerto puerto = new Puerto("Puerto Real", "Barcelona", 5, "123456789",
                amarres, embarcaciones, new String[5]);

        Embarcacion e1 = new Embarcacion("MAT001", "Velero Uno", 10, "Velero", "Ana", 2005, 5000);
        Embarcacion e2 = new Embarcacion("MAT002", "Lancha Dos", 8, "Lancha", "Luis", 2010, 3000);
        Embarcacion e3 = new Embarcacion("MAT001", "Velero Tres", 12, "Velero", "Marta", 2015, 7000);

        if (puerto.registrarEmbarcacion(e1)) {
            System.out.println("Embarcación registrada correctamente");
        } else {
            System.out.println("No se pudo registrar la embarcación");
        }

        System.out.println(puerto.registrarEmbarcacion(e2)); // true
        System.out.println(puerto.registrarEmbarcacion(e3)); // false (matrícula repetida)

        System.out.println("Estado del array embarcaciones:");
        for (Embarcacion e : embarcaciones) {
            if (e != null) {
                System.out.println(e.getMatricula() + " - " + e.getNombre());
            } else {
                System.out.println("Vacío");
            }
        }

        Amarre a1 = new Amarre(1, 26, "Normal", false);
        Amarre a2 = new Amarre(2, 26, "Premium", true);

        System.out.println(puerto.altaAmarre(a1));
        System.out.println(puerto.altaAmarre(a2));

        System.out.println("Estado del array amarres:");
        for (Amarre a : amarres) {
            if (a != null) {
                System.out.println(a);
            } else {
                System.out.println("Vacío");
            }
        }
    }

}
