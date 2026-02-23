package U5.R3.Ejercicio1;

import java.util.Arrays;
import java.util.List;

public class Embarcacion {

    private String matricula;
    private String nombre;
    private double eslora;
    private String tipo;
    private String propietario;
    private int anioFabricacion;
    public double valorEstimado;

    private static final List<String> TIPOS_VALIDOS = Arrays.asList("Velero", "Lancha", "Yate", "Catamarán",
            "Moto de agua");

    public Embarcacion(String matricula, String nombre, double eslora,
            String tipo, String propietario,
            int anioFabricacion, double valorEstimado) {

        setMatricula(matricula);
        this.nombre = nombre;
        setEslora(eslora);
        setTipo(tipo);
        this.propietario = propietario;
        setAnioFabricacion(anioFabricacion);
        setValorEstimado(valorEstimado);
    }

    // Getters
    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public double getEslora() {
        return eslora;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPropietario() {
        return propietario;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    // Setters

    public void setMatricula(String matricula) {
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new IllegalArgumentException("La matrícula no puede ser null ni vacía.");
        }
        this.matricula = matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEslora(double eslora) {
        if (eslora < 0) {
            throw new IllegalArgumentException("La eslora debe ser mayor que 0.");
        }
       this.eslora = eslora;
    }

    public void setTipo(String tipo) {
        if (!TIPOS_VALIDOS.contains(tipo)) {
            throw new IllegalArgumentException("Tipo de embarcación no válido.");
        }
        this.tipo = tipo;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        if (anioFabricacion < 1950 || anioFabricacion > 2026) {
            throw new IllegalArgumentException("Año de fabricación fuera de rango.");
        }
        this.anioFabricacion = anioFabricacion;
    }

    public void setValorEstimado(double valorEstimado) {
        if (valorEstimado < 0) {
            this.valorEstimado = 0;
        } else {
            this.valorEstimado = valorEstimado;
        }
    }

    @Override
    public String toString() {
        return "Datos sobre la embarcacion:\n" +
                "matricula: " + matricula + " | " +
                " nombre: " + nombre + " | " +
                " eslora: " + eslora + " | " +
                " tipo: " + tipo + " | " +
                " propietario: " + propietario + " | " +
                " anioFabricacion: " + anioFabricacion + " | " +
                " valorEstimado: " + valorEstimado;
    }
}
