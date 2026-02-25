package U5.R3.Ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Amarre {
    private static int numeroAmarre = 1;
    private int numero;
    private double longitudMaxima;
    private double precioDia;
    private boolean ocupado;
    private String tipoAmarre;

    private static final List<String> TIPOS_VALIDOS = new ArrayList<>(Arrays.asList("NORMAL", "PREMIUM", "MEGAYATE"));

    public Amarre(double longitudMaxima, String tipoAmarre, boolean ocupado) {
        asignarNumero();
        setTipoAmarre(tipoAmarre);
        setLongitudMaxima(longitudMaxima);
        this.ocupado = ocupado;
    }

    public int getNumero() {
        return numero;
    }

    public double getLongitudMaxima() {
        return longitudMaxima;
    }

    public double getPrecioDia() {
        return precioDia;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public String getTipoAmarre() {
        return tipoAmarre;
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
        calcularPrecio();
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public void setTipoAmarre(String tipoAmarre) {
        if (!TIPOS_VALIDOS.contains(tipoAmarre.toUpperCase())) {
            throw new IllegalArgumentException("Tipo de amarre no válido");
        }
        this.tipoAmarre = tipoAmarre.toUpperCase();
        calcularPrecio();
    }

    private void calcularPrecio() {
        if (tipoAmarre.equals(TIPOS_VALIDOS.get(0))) {
            precioDia = 25 + (1.5 * longitudMaxima);
        } else if (tipoAmarre.equals(TIPOS_VALIDOS.get(1))) {
            precioDia = 60 + (2.2 * longitudMaxima);
        } else {
            precioDia = 120 + (3.5 * longitudMaxima);
        }
    }

    public void asignarNumero() {
        setNumero(numeroAmarre);
        numeroAmarre++;
    }

    public String consultarDisponibilidad() {
        return ocupado ? "Está ocupado." : "Está libre.";
    }

    @Override
    public String toString() {
        return "Amarre " + getNumero() + " del tipo " + tipoAmarre + ". Longitud maxima de "
                + longitudMaxima + "m con precio diario de " + getPrecioDia() + "€/dia. "
                + consultarDisponibilidad();
    }
}
