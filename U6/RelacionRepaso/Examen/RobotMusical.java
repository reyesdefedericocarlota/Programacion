package U6.RelacionRepaso.Examen;

import java.util.ArrayList;

public class RobotMusical extends IntegranteFestival implements Afinable, Gestionable {
    private int ritmosAfinados;
    private int potenciaLaser;
    private ArrayList<Presentador> presentadoresACargo;

    public RobotMusical(String nombre, int energia, int cacheBAse, int ritmosAfinados, int potenciaLaser,
            ArrayList<Presentador> presentadoresAcargo) {
        super(nombre, energia, cacheBAse);
        this.ritmosAfinados = ritmosAfinados;
        this.potenciaLaser = potenciaLaser;
        this.presentadoresACargo = presentadoresAcargo;
    }

    public int getRitmosAfinados() {
        return ritmosAfinados;
    }

    public int getPotenciaLaser() {
        return potenciaLaser;
    }

    public ArrayList<Presentador> getPresentadoresACargo() {
        return presentadoresACargo;
    }

    public void setRitmosAfinados(int ritmosAfinados) {
        this.ritmosAfinados = ritmosAfinados;
    }

    public void setPotenciaLaser(int potenciaLaser) {
        this.potenciaLaser = potenciaLaser;
    }

    public void setPresentadoresACargo(ArrayList<Presentador> presentadoresAcargo) {
        this.presentadoresACargo = presentadoresAcargo;
    }

    public int calcularRendimiento() {
        return getCacheBase() + (ritmosAfinados * 3) + (potenciaLaser * 2) + (presentadoresACargo.size() * 5);
    }

    public boolean puedeActuar() {
        return getEnergia() >= 15;
    }

    public void afinar() {
        ritmosAfinados++;
    }

    public boolean agregarIntegrante(Presentador presentador) {
        boolean agregado = true;

        if (presentador == null) {
            agregado = false;
        }

        for (Presentador p : presentadoresACargo) {
            if (p.getNombre().equals(presentador.getNombre())) {
                agregado = false;
            }
        }

        if (agregado) {
            presentadoresACargo.add(presentador);
        }

        return agregado;
    }

    public boolean eliminarIntegrante(String nombre) {
        boolean eliminado = false;

        for (int i = 0; i < presentadoresACargo.size() && !eliminado; i++) {
            if (presentadoresACargo.get(i).getNombre().equals(nombre)) {
                presentadoresACargo.remove(presentadoresACargo.get(i));
                eliminado = true;
            }
        }

        return eliminado;
    }

    public void dispararLaser() {
        potenciaLaser++;
    }

}
