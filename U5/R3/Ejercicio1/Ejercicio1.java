package U5.R3.Ejercicio1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import U5.R3.Faker;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int NUMERO_AMARRES = 50;
        final int NUMERO_EMBARCACIONES = 100;
        Puerto puerto1 = new Puerto("Barcelona", NUMERO_AMARRES, "640953583");

        for (int i = 0; i < NUMERO_AMARRES; i++) {
            Amarre aleatorio = new Amarre(Faker.longitudMaximaAmarre(), Faker.tipoAmarre(), false);
            puerto1.altaAmarre(aleatorio);
        }

        // for (Amarre a : puerto1.getAmarres()) {
        // System.out.println(a);
        // }

        for (int i = 0; i < NUMERO_EMBARCACIONES; i++) {
            Embarcacion aleatoria = new Embarcacion(Faker.matriculaEmbarcacion(), Faker.nombreEmbarcacion(),
                    Faker.eslora(), Faker.tipoEmbarcacion(), Faker.nombre(), Faker.anioFabricacionEmbarcacion(),
                    Faker.precio(2000, 5000));
            puerto1.registrarEmbarcacion(aleatoria);
        }

        // for (Embarcacion emb : puerto1.getEmbarcaciones()) {
        // System.out.println(emb);
        // }

        Random random = new Random();

        int asignadas = 0;

        while (asignadas < 20) {
            Embarcacion e = puerto1.getEmbarcaciones().get(random.nextInt(puerto1.getEmbarcaciones().size()));
            Amarre a = puerto1.getAmarres().get(random.nextInt(puerto1.getAmarres().size()));

            boolean exito = puerto1.asignarAmarreAleatorio(e, a);
            if (exito) {
                asignadas++; // solo contamos si realmente se asignó
            }
        }

        // for (String mat : puerto1.getMatriculasAmarradas()) {
        // System.out.println(mat);
        // }

        final String MENU = "Elige una de las siguientes opciones:\n" +
                "0 = Salir\n" +
                "1 = Mostrar información del puerto\n" +
                "2 = Mostrar amarres libres\n" +
                "3 = Mostrar amarres ocupados\n" +
                "4 = Registrar nueva embarcación\n" +
                "5 = Dar de alta un amarre\n" +
                "6 = Asignar amarre a embarcación\n" +
                "7 = Liberar un amarre\n" +
                "8 = Buscar embarcación\n" +
                "9 = Calcular ingresos diarios actuales\n" +
                "10 = Calcular ingresos diarios máximos";
        int elegirOpcion;

        do {
            elegirOpcion = opcionMenu(scanner, MENU, 0, 10, -1);

            if (elegirOpcion == 1) {
                System.out.println(puerto1);
            } else if (elegirOpcion == 2) {
                System.out.println(puerto1.mostrarAmarresLibres());
            } else if (elegirOpcion == 3) {
                System.out.println(puerto1.mostrarAmarresOcupados());
            } else if (elegirOpcion == 4) {
                System.out.print("Matrícula: ");
                String matricula = scanner.nextLine();

                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();

                System.out.print("Eslora (m): ");
                double eslora = Double.parseDouble(scanner.nextLine());

                System.out.print("Tipo (Velero, Lancha, Yate, Catamaran, Moto de agua): ");
                String tipo = scanner.nextLine();

                System.out.print("Propietario: ");
                String propietario = scanner.nextLine();

                System.out.print("Año de fabricación: ");
                int anio = Integer.parseInt(scanner.nextLine());

                System.out.print("Valor estimado (€): ");
                double valor = Double.parseDouble(scanner.nextLine());

                try {
                    Embarcacion nueva = new Embarcacion(matricula, nombre, eslora, tipo, propietario, anio, valor);
                    if (puerto1.registrarEmbarcacion(nueva)) {
                        System.out.println("Embarcación registrada correctamente.");
                    } else {
                        System.out.println("La embarcación ya estaba registrada.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Error al registrar la embarcación: " + e.getMessage());
                }
            } else if (elegirOpcion == 5) {
                System.out.print("Longitud máxima (>= 4.0 m): ");
                double longitud = Double.parseDouble(scanner.nextLine());

                System.out.print("Tipo de amarre (Normal, Premium, Megayate): ");
                String tipo = scanner.nextLine();

                System.out.print("¿Está ocupado? (true/false): ");
                boolean ocupado = Boolean.parseBoolean(scanner.nextLine());

                try {
                    Amarre nuevoAmarre = new Amarre(longitud, tipo, ocupado);
                    if (puerto1.altaAmarre(nuevoAmarre)) {
                        System.out.println("Amarre registrado correctamente.");
                    } else {
                        System.out.println("El amarre ya estaba registardo.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Error al dar de alta el amarre: " + e.getMessage());
                }
            } else if (elegirOpcion == 6) {
                System.out.print("Introduce matrícula de la embarcación: ");
                String matricula = scanner.nextLine();
                System.out.print("Introduce número del amarre: ");
                int numeroAmarre = Integer.parseInt(scanner.nextLine());

                Embarcacion emb = puerto1.buscarEmbarcacionEnPuerto(matricula);
                if (emb != null && numeroAmarre > 0 && numeroAmarre <= puerto1.getAmarres().size()) {
                    Amarre amarre = puerto1.getAmarres().get(numeroAmarre - 1); // índice = número - 1
                    if (puerto1.asignarAmarreAleatorio(emb, amarre)) {
                        System.out.println("Amarre asignado correctamente.");
                    } else {
                        System.out.println("No se pudo asignar el amarre.");
                    }
                } else {
                    System.out.println("Datos inválidos.");
                }
            } else if (elegirOpcion == 7) {
                System.out.print("Introduce número del amarre a liberar: ");
                int liberar = Integer.parseInt(scanner.nextLine());
                puerto1.liberarAmarre(liberar);
                System.out.println("Amarre liberado.");
            } else if (elegirOpcion == 8) {
                System.out.print("Introduce matrícula de la embarcación a buscar: ");
                String matriculaBuscar = scanner.nextLine();
                puerto1.buscarEmbarcacion(matriculaBuscar);
            } else if (elegirOpcion == 9) {
                System.out.println("Ingresos diarios actuales: " + puerto1.calcularIngresosDiariosActuales() + "€");
            } else if (elegirOpcion == 10) {
                System.out.println("Ingresos diarios máximos: " + puerto1.calcularIngresosDiariosMaximos() + "€");
            }
        } while (elegirOpcion != 0);
        System.out.println("Ha salido del programa");

    }

    public static int opcionMenu(Scanner introScanner, String textoMenu, int min, int max, int parametroDefecto) {
        int opcion;
        do {
            try {
                mostrarMensaje(textoMenu);
                opcion = Integer.parseInt(introScanner.nextLine());
            } catch (NumberFormatException e) {
                mostrarMensaje("Error, debes introducir un número.");
                opcion = parametroDefecto;
            }
        } while (opcion < min || opcion > max);
        return opcion;
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
