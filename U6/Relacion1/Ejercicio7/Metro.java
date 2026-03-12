public class Metro implements Transporte {
    private int numeroVagones;

    public Metro(int numeroVagones) {
        this.numeroVagones = numeroVagones;
    }

    public String arrancar() {
        return "El metro con " + numeroVagones + " vagones ha arrancado.";
    }

    public String detener() {
        return "El metro se ha detenido.";
    }
}
