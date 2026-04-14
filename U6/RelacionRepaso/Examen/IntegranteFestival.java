package U6.RelacionRepaso.Examen;

public abstract class IntegranteFestival {
    private String nombre;
    private int energia;
    private int cacheBase;

    public IntegranteFestival(String nombre, int energia, int cacheBAse) {
        this.nombre = nombre;
        this.energia = energia;
        this.cacheBase = cacheBAse;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEnergia() {
        return energia;
    }

    public int getCacheBase() {
        return cacheBase;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void setCacheBase(int cacheBAse) {
        this.cacheBase = cacheBAse;
    }

    abstract int calcularRendimiento();

    abstract boolean puedeActuar();

    public int recargarEnergia(int cantidad) {
        if (cantidad > 0) {
            energia += cantidad;
        }

        return energia;
    }

}
