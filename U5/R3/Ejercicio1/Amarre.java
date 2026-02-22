package U5.R3.Ejercicio1;

import java.util.Arrays;
import java.util.List;

public class Amarre {
    private int numero;
    private double longitudMaxima;
    public double precioDia;
    private boolean ocupado;
    public String tipoAmarre;

    private static final List<String> TIPOS_VALIDOS = Arrays.asList("Normal", "Premium", "Megayate");

    public Amarre(int numero, double longitudMaxima, String tipoAmarre, boolean ocupado) {
        setNumero(numero);
        setLongitudMaxima(longitudMaxima);
        setTipoAmarre(tipoAmarre);
        calcularPrecio();
        this.ocupado = ocupado;
    }

    public int getNumero() {
        return numero;
    }

    public double getLongitudMaxima() {
        return longitudMaxima;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setNumero(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("El identificador debe ser mayor de 0");
        }
        this.numero = numero;
    }

    public void setLongitudMaxima(double longitudMaxima) {
        if (longitudMaxima < 4.0) {
            throw new IllegalArgumentException("La longitud máxima debe ser mayor o igual que 4.0");
        }
        this.longitudMaxima = longitudMaxima;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public void setTipoAmarre(String tipoAmarre) {
        if (!TIPOS_VALIDOS.contains(tipoAmarre)) {
            throw new IllegalArgumentException("Tipo de amarre no válido");
        }
        this.tipoAmarre = tipoAmarre;
    }

    private void calcularPrecio() {
        if (tipoAmarre.equals("Normal")) {
            precioDia = 25 + (1.5 * longitudMaxima);
        } else if (tipoAmarre.equals("Premium")) {
            precioDia = 60 + (2.2 * longitudMaxima);
        } else {
            precioDia = 120 + (3.5 * longitudMaxima);
        }
    }

    @Override
    public String toString() {
        return "Datos sobre el amarre:\n" +
                "numero: " + numero + " | " +
                " longitud máxima: " + longitudMaxima + " | " +
                " tipo: " + tipoAmarre + " | " +
                " precio: " + precioDia + " | " +
                " ocupado: " + ocupado;
    }
}
