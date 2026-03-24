class Camion extends Vehiculo {

    @Override
    String arrancar() {
        return "El camión arranca lentamente con un motor potente";
    }

    @Override
    String detener() {
        return "El camión se detiene aplicando frenos de aire";
    }

}
