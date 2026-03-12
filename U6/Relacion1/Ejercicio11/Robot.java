package U6.Relacion1.Ejercicio11;

class Robot implements Movil, Trabajador {
    private String modelo;
    private int capacidadBateria;

    public Robot(String modelo, int capacidadBateria) {
        this.modelo = modelo;
        this.capacidadBateria = capacidadBateria;
    }

    @Override
    public String moverse() {
        return "El Robot modelo " + modelo + " con batería " + capacidadBateria
                + "% se desplaza hacia el destino programado.";
    }

    @Override
    public String realizarTarea() {
        return "El Robot modelo " + modelo + " con batería " + capacidadBateria
                + "% realiza la tarea asignada eficientemente.";
    }

}
