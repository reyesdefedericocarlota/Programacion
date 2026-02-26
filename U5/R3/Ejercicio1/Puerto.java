package U5.R3.Ejercicio1;

import java.util.ArrayList;

public class Puerto {
    private static int numeroPuertos;

    private String nombre;
    public String ubicacion;
    private int capacidadMaxima;
    public String telefonoContacto;
    private ArrayList<Amarre> amarres;
    private ArrayList<Embarcacion> embarcaciones;
    private ArrayList<String> matriculasAmarradas;

    public Puerto(String ubicacion, int capacidadMaxima, String telefonoContacto) {
        asignarNombre();
        this.ubicacion = ubicacion;
        this.capacidadMaxima = capacidadMaxima;
        this.telefonoContacto = telefonoContacto;

        this.amarres = new ArrayList<>();
        this.embarcaciones = new ArrayList<>();
        this.matriculasAmarradas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public ArrayList<Amarre> getAmarres() {
        return amarres;
    }

    public ArrayList<Embarcacion> getEmbarcaciones() {
        return embarcaciones;
    }

    public ArrayList<String> getMatriculasAmarradas() {
        return matriculasAmarradas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setAmarres(ArrayList<Amarre> amarres) {
        if (amarres.size() > capacidadMaxima) {
            throw new IllegalArgumentException(
                    "La cantidad de amarres no puede superar la capacidad máxima del puerto.");
        }
        this.amarres = amarres;
        for (int i = 0; i < amarres.size(); i++) {
            matriculasAmarradas.add("VACIO");
        }
    }

    public void setEmbarcaciones(ArrayList<Embarcacion> embarcaciones) {
        this.embarcaciones = embarcaciones;
    }

    public void setMatriculasAmarradas(ArrayList<String> matriculasAmarradas) {
        this.matriculasAmarradas = matriculasAmarradas;
    }

    public void asignarNombre() {
        setNombre("Puerto-" + numeroPuertos);
        numeroPuertos++;
    }

    @Override
    public String toString() {
        return getNombre()
                + ", Ubicación=" + ubicacion
                + ", Teléfono=" + telefonoContacto
                + ", CapacidadMáxima=" + capacidadMaxima
                + ", Amarres=" + amarres.size()
                + ", Embarcaciones=" + embarcaciones.size();
    }

    // Registra embarcacion y devuelve tue si la encuentra false en caso contrario
    public boolean registrarEmbarcacion(Embarcacion e) {
        boolean embarcacionRegistrada = false;

        for (Embarcacion emb : embarcaciones) {
            if (!emb.getMatricula().equalsIgnoreCase(emb.getMatricula())) {
                embarcaciones.add(emb);
                embarcacionRegistrada = true;
            }
        }
        return embarcacionRegistrada;
    }

    // Registra embarcacion y devuelve tue si la encuentra false en caso contrario
    public boolean altaAmarre(Amarre a) {
        boolean amarreRegistrado = false;

        if (!amarres.contains(a) && amarres.size() <= capacidadMaxima) {
            amarres.add(a);
            matriculasAmarradas.add("VACIO");
            amarreRegistrado = true;
        }

        return amarreRegistrado;
    }

    // Devuelve la embarcacion si la encuentra o null si no
    public Embarcacion buscarEmbarcacionEnPuerto(String matricula) {
        Embarcacion embarcacionBuscar = null;

        for (Embarcacion embarcacion : embarcaciones) {
            if (matricula.equals(embarcacion.getMatricula())) {
                embarcacionBuscar = embarcacion;
            }
        }
        return embarcacionBuscar;

    }

    public boolean asignarAmarre(String matricula, int numeroAmarre) {
        boolean amarreAsignado = false;
        Amarre amarreAsignar = amarres.get(numeroAmarre);
        Embarcacion embarcacionAsignar = buscarEmbarcacionEnPuerto(matricula);
        if (!matriculasAmarradas.contains(embarcacionAsignar.getMatricula())) {
            if (!amarreAsignar.isOcupado()) {
                if (embarcacionAsignar.getEslora() <= amarreAsignar.getLongitudMaxima()) {
                    matriculasAmarradas.set(numeroAmarre, matricula);
                    amarreAsignado = true;
                }
            }
        }
        return amarreAsignado;
    }

    public void liberarAmarre(int numeroAmarre) {
        boolean amarreLiberado = false;
        for (int i = 0; i < amarres.size() && !amarreLiberado; i++) {
            if (amarres.get(i).getNumero() == numeroAmarre) {
                amarres.get(i).setOcupado(false);
                matriculasAmarradas.set(numeroAmarre, "VACÍO");
                amarreLiberado = true;
            }
        }
    }

    public String mostrarAmarresLibres() {
        String mensaje = "Amarres libres:\n";

        for (Amarre a : amarres) {
            if (!a.isOcupado()) {
                mensaje += a + "\n";
            }
        }
        return mensaje;
    }

    public String mostrarAmarresOcupados() {
        String mensaje = "Amarres ocupados:\n";

        for (Amarre a : amarres) {
            if (a.isOcupado()) {
                mensaje += a + "\n";
            }
        }
        return mensaje;
    }

    public void buscarEmbarcacion(String matricula) {
        Embarcacion embarcacionAsignar = buscarEmbarcacionEnPuerto(matricula);
        if (embarcacionAsignar != null) {
            if (matriculasAmarradas.contains(embarcacionAsignar.getMatricula())) {
                for (int i = 0; i < matriculasAmarradas.size(); i++) {
                    if (matriculasAmarradas.get(i).equals(matricula)) {
                        mostrarMensaje("La embarcación está amarrada en el amarre nº " + amarres.get(i));
                    }
                }
            } else {
                mostrarMensaje("La embarcación está registrada pero no está amarrada.");
            }

        } else {
            mostrarMensaje("No existe ninguna embarcación con esa matrícula.");
        }
    }

    public boolean asignarAmarreAleatorio(Embarcacion embarcacion, Amarre amarre) {
        boolean amarreAsignado = false;
        if (!matriculasAmarradas.contains(embarcacion.getMatricula())
                && !amarre.isOcupado()
                && embarcacion.getEslora() <= amarre.getLongitudMaxima()) {

            matriculasAmarradas.set(amarres.indexOf(amarre), embarcacion.getMatricula());
            amarre.setOcupado(true);
            amarreAsignado = true;
        }
        return amarreAsignado;
    }

    // Suma `precioDia` de amarres ocupados.
    public double calcularIngresosDiariosActuales() {
        double sumaPrecios = 0;
        for (Amarre a : amarres) {
            if (a.isOcupado()) {
                sumaPrecios += a.getPrecioDia();
            }
        }
        return sumaPrecios;
    }

    // Suma `precioDia` de todos los amarres.
    public double calcularIngresosDiariosMaximos() {
        double sumaPrecios = 0;
        for (Amarre a : amarres) {
            sumaPrecios += a.getPrecioDia();

        }
        return sumaPrecios;
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

}
