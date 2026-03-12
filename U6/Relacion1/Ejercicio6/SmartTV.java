package U6.Relacion1.Ejercicio6;

class SmartTV implements DispositivoInteligente {
    public String encender() {
        return "La tele se ha encendido";
    }

    public String apagar() {
        return "La tele se ha apagado";
    }

    public String conectarWifi() {
        return "La tele se ha conectado";
    }

    @Override
    public String toString() {
        return encender() + "\n" + apagar() + "\n" + conectarWifi();
    }
}
