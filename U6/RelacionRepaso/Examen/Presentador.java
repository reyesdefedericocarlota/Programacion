package U6.RelacionRepaso.Examen;

public class Presentador extends IntegranteFestival {
    private int numeroBromas;
    private int carisma;

    public Presentador(String nombre, int energia, int cacheBase, int numeroBromas, int carisma) {
        super(nombre, energia, cacheBase);
        this.numeroBromas = numeroBromas;
        this.carisma = carisma;
    }

    public int getNumeroBromas() {
        return numeroBromas;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setNumeroBromas(int numeroBromas) {
        this.numeroBromas = numeroBromas;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public int calcularRendimiento() {
        return getCacheBase() + (numeroBromas * 2) + (carisma * 3);
    }

    public boolean puedeActuar() {
        return getEnergia() >= 10;
    }

    public void contarBroma() {
        numeroBromas++;
    }

    public int mejorarCarisma(int cantidad) {
        if (cantidad > 0) {
            carisma += cantidad;
        }

        return carisma;
    }
}
