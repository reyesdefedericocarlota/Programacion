package U6.RelacionRepaso.Examen;

public class BateristaRobot extends IntegranteFestival implements Afinable {
    private int ritmosAfinados;
    private int golpesFuertes;

    public BateristaRobot(String nombre, int energia, int cacheBAse, int ritmosAfinados, int golpesFuertes) {
        super(nombre, energia, cacheBAse);
        this.ritmosAfinados = ritmosAfinados;
        this.golpesFuertes = golpesFuertes;
    }

    public int getRitmosAfinados() {
        return ritmosAfinados;
    }

    public int getGolpesFuertes() {
        return golpesFuertes;
    }

    public void setRitmosAfinados(int ritmosAfinados) {
        this.ritmosAfinados = ritmosAfinados;
    }

    public void setGolpesFuertes(int golpesFuertes) {
        this.golpesFuertes = golpesFuertes;
    }

    public int calcularRendimiento() {
        return getCacheBase() + (ritmosAfinados * 4) + (golpesFuertes * 2);
    }

    public boolean puedeActuar() {
        return getEnergia() >= 12 && ritmosAfinados >= 1;
    }

    public void afinar() {
        ritmosAfinados++;
    }

    public void golpeFuerte() {
        golpesFuertes++;
    }
}
