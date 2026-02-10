package U5.R1;

public class Ejercicio6 {

    public static void main(String[] args) {
        Reloj reloj1 = new Reloj(16, 10, 00);
        System.out.println(reloj1);

        reloj1.sumarMinutos(1000);
        System.out.println(reloj1);
    }

}

class Reloj {
    int hora;
    int minuto;
    int segundo;

    Reloj(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    void sumarMinutos(int minutos) {
        minuto += minutos;
        while (minuto >= 60) {
            minuto = minuto - 60;
            hora++;
        }
    }

    void restarMinutos(int minutos) {
        minuto -= minutos;
        if (minuto <= 0) {
            minuto = 0;
        }
    }

    @Override
    public String toString() {
        return hora + ":" + minuto + ":" + segundo;
    }

}