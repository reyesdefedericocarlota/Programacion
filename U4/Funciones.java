package U4;

import java.util.ArrayList;

public class Funciones {

    // Convertir números a String
    public static String unirNumeros(ArrayList<Integer> numeros) {
        ArrayList<String> numerosTexto = new ArrayList<>();

        for (Integer n : numeros) {
            numerosTexto.add(n.toString());
        }

        return String.join("-", numerosTexto);
    }

    // Buscar máximo y mínimo de un array
    public static int indiceTemp(ArrayList<Double> listado, boolean buscarMax) {
        int indice = 0;

        for (int i = 1; i < listado.size(); i++) {
            if (buscarMax && listado.get(i) > listado.get(indice)) {
                indice = i;
            } else if (!buscarMax && listado.get(i) < listado.get(indice)) {
                indice = i;
            }
        }
        return indice;
    }

    // Calcular promedio
    public static double promedio(ArrayList<Double> listado) {
        double sumatorio = 0;
        double promedio = 0;

        if (listado.isEmpty()) {
            promedio = 0;
        } else {
            for (Double numero : listado) {
                sumatorio += numero;
            }
            promedio = sumatorio / listado.size();
        }
        return promedio;
    }
}
