package U6.Relacion1.Ejercicio6;

class Smartphone implements DispositivoInteligente {
    public String encender() {
        return "El Smartphone se ha encendido";
    }

    public String apagar() {
        return "El Smartphone se ha apagado";
    }

    public String conectarWifi() {
        return "El Smartphone se ha conectado";
    }

    @Override
    public String toString() {
        return encender() + "\n" + apagar() + "\n" + conectarWifi();
    }

}
