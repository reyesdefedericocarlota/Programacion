class Moto extends Vehiculo {

    @Override
    String arrancar() {
        return "La moto arranca con un rugido ligero";
    }

    @Override
    String detener() {
        return "La moto se detiene usando el freno de mano y el delantero";
    }

}
