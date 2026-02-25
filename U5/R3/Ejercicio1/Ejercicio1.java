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

        for (String mat : puerto1.getMatriculasAmarradas()) {
            System.out.println(mat);
        }
    }

}
