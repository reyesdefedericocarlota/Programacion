package U5.R3.Ejercicio1;

import java.util.Arrays;

public class Puerto {
    private String nombre;
    public String ubicacion;
    private int capacidadMaxima;
    public String telefonoContacto;
    private Amarre[] amarres;
    private Embarcacion[] embarcaciones;
    private String[] matriculasAmarradas;

    public Puerto(String nombre, String ubicacion, int capacidadMaxima, String telefonoContacto, Amarre[] amarres,
            Embarcacion[] embarcaciones, String[] matriculasAmarradas) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidadMaxima = capacidadMaxima;
        this.telefonoContacto = telefonoContacto;
        setAmarres(amarres);
        this.embarcaciones = embarcaciones;
        this.matriculasAmarradas = matriculasAmarradas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public Amarre[] getAmarres() {
        return amarres;
    }

    public Embarcacion[] getEmbarcaciones() {
        return embarcaciones;
    }

    public String[] getMatriculasAmarradas() {
        return matriculasAmarradas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public void setAmarres(Amarre[] amarres) {
        if (amarres.length > capacidadMaxima) {
            throw new IllegalArgumentException("La cantidad de amarres no puede superar la capacidad máxima.");
        }
        this.amarres = amarres;
    }

    public void setEmbarcaciones(Embarcacion[] embarcaciones) {
        this.embarcaciones = embarcaciones;
    }

    public void setMatriculasAmarradas(String[] matriculasAmarradas) {
        this.matriculasAmarradas = matriculasAmarradas;
    }

    public int numEmbarcaciones() {
        int count = 0;
        for (Embarcacion e : embarcaciones) {
            if (e != null) {
                count++;
            }
        }
        return count;
    }

    public int numAmarres() {
        int count = 0;
        for (Amarre a : amarres) {
            if (a != null)
                count++;
        }
        return count;
    }

    @Override
    public String toString() {
        return "Nombre del puerto: " + nombre + " || Ubicación: " + ubicacion + " || Teléfono: " + telefonoContacto
                + " || Número de amarres: " + numAmarres() + "|| Número de embarcaciones: "
                + numEmbarcaciones();
    }

    public boolean registrarEmbarcacion(Embarcacion e) {
        boolean embRegistrada = true;
        boolean agregada = false;

        // Comprobar si ya existe la matrícula
        for (Embarcacion emb : embarcaciones) {
            if (emb != null && emb.getMatricula().equals(e.getMatricula())) {
                embRegistrada = false;
            }
        }

        // Agregar en la primera posición libre solo si se puede registrar
        if (embRegistrada) {
            for (int i = 0; i < embarcaciones.length && !agregada; i++) {
                if (embarcaciones[i] == null) {
                    embarcaciones[i] = e;
                    agregada = true;
                }
            }
        }

        return embRegistrada && agregada;
    }

    public boolean altaAmarre(Amarre a) {
        boolean amarreRegistrado = true;
        boolean agregado = false;

        for (Amarre amarre : amarres) {
            if (amarre != null && amarre.getNumero() == a.getNumero()) {
                amarreRegistrado = false;
            }
        }

        if (amarreRegistrado) {
            for (int i = 0; i < amarres.length && !agregado; i++) {
                if (amarres[i] == null) {
                    amarres[i] = a;
                    agregado = true;
                }
            }
        }

        return amarreRegistrado && agregado;
    }

    public boolean asignarAmarre(String matricula, int numeroAmarre) {
        boolean asignado = false;
        boolean embarcacionExiste = false;
        boolean yaAmarrada = false;
        Embarcacion embarcacion = null;

        // Buscar la embarcación por matrícula
        for (Embarcacion e : embarcaciones) {
            if (e != null && e.getMatricula().equals(matricula)) {
                embarcacionExiste = true;
                embarcacion = e;
            }
        }

        // Comprobar si ya está amarrada
        for (String m : matriculasAmarradas) {
            if (m != null && m.equals(matricula)) {
                yaAmarrada = true;
            }
        }

        // Asignar al amarre correcto
        if (embarcacionExiste && !yaAmarrada) {
            for (int i = 0; i < amarres.length && !asignado; i++) {
                Amarre a = amarres[i];
                if (a != null && a.getNumero() == numeroAmarre && !a.isOcupado()) {
                    if (embarcacion.getEslora() <= a.getLongitudMaxima()) {
                        a.setOcupado(true);
                        matriculasAmarradas[i] = matricula;
                        asignado = true;
                    }
                }
            }
        }

        return asignado;
    }

    public void liberarAmarre(int numeroAmarre) {
        boolean amarreLiberado = false;
        for (int i = 0; i < amarres.length && !amarreLiberado; i++) {
            if (amarres[i].getNumero() == numeroAmarre) {
                amarres[i].setOcupado(false);
                matriculasAmarradas[i] = null;
                amarreLiberado = true;
            }
        }
    }

    public String mostrarAmarresLibres() {
        String mensaje = "Amarres libres:\n";

        for (Amarre a : amarres) {
            if (a != null && !a.isOcupado()) {
                mensaje += a + "\n";
            }
        }
        return mensaje;
    }

    public String mostrarAmarresOcupados() {
        String mensaje = "Amarres ocupados:\n";

        for (Amarre a : amarres) {
            if (a != null && a.isOcupado()) {
                mensaje += a + "\n";
            }
        }
        return mensaje;
    }

    public boolean buscarEmbarcacion(String matricula) {
        boolean amarreEncontrado = false;

            for (int i = 0; i < matriculasAmarradas.length && !amarreEncontrado; i++) {
                if (matriculasAmarradas[i] != null && matriculasAmarradas[i].equals(matricula)) {
                    mostrarMensaje("La embarcación se encuentra en el amarre " + amarres[i].getNumero());
                    amarreEncontrado = true;
                }
            }
        
        return amarreEncontrado;
    }

    public double calcularIngresosDiariosActuales() {
        double sumaPrecios = 0;
        for (Amarre a : amarres) {
            if (a != null && a.isOcupado()) {
                sumaPrecios += a.getPrecioDia();
            }
        }
        return sumaPrecios;
    }

    public double calcularIngresosDiariosMaximos() {
        double sumaPrecios = 0;
        for (Amarre a : amarres) {
            if (a != null) {
                sumaPrecios += a.getPrecioDia();
            }
        }
        return sumaPrecios;
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

}
