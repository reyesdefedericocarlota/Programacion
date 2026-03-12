public class Autobus implements Transporte {
    private String horaSalida;
    private String horaLLegada;

    public Autobus(String horaSalida, String horaLLegada) {
        this.horaSalida = horaSalida;
        this.horaLLegada = horaLLegada;
    }

    public String arrancar() {
        return "El autobús salió a las " + horaSalida;
    }

    public String detener() {
        return "El autobús llegó a las " + horaLLegada;
    }

}
