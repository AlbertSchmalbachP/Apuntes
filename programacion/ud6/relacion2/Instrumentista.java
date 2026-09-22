package Tema6.Repaso.Repaso2;

public class Instrumentista extends MiembroBanda {
    private String instrumentoPrincipal;
    private int nivelTecnico, ensayosAsistidos, actuacionesDisponibles;

    public Instrumentista(String nombreArtistico, String localidad, int anosEnLaAgrupacion, double puntosBase,
            String instrumentoPrincipal, int nivelTecnico, int ensayosAsistidos, int actuacionesDisponibles) {
        super(nombreArtistico, localidad, anosEnLaAgrupacion, puntosBase);
        setInstrumentoPrincipal(instrumentoPrincipal);
        setNivelTecnico(nivelTecnico);
        setEnsayosAsistidos(ensayosAsistidos);
        setActuacionesDisponibles(actuacionesDisponibles);
    }

    public String getInstrumentoPrincipal() {
        return instrumentoPrincipal;
    }

    public void setInstrumentoPrincipal(String instrumentoPrincipal) {
        if (instrumentoPrincipal == null || instrumentoPrincipal.isEmpty()
                || instrumentoPrincipal.matches(".*[0-9].*")) {
            this.instrumentoPrincipal = "[Intrumento principal inválido]";
        } else {
            this.instrumentoPrincipal = instrumentoPrincipal;
        }
    }

    public int getNivelTecnico() {
        return nivelTecnico;
    }

    public void setNivelTecnico(int nivelTecnico) {
        if (nivelTecnico < 0) {
            this.nivelTecnico = -1;
        } else {
            this.nivelTecnico = nivelTecnico;
        }
    }

    public int getEnsayosAsistidos() {
        return ensayosAsistidos;
    }

    public void setEnsayosAsistidos(int ensayosAsistidos) {
        if (ensayosAsistidos < 0) {
            this.ensayosAsistidos = -1;
        } else {
            this.ensayosAsistidos = ensayosAsistidos;
        }
    }

    public int getActuacionesDisponibles() {
        return actuacionesDisponibles;
    }

    public void setActuacionesDisponibles(int actuacionesDisponibles) {
        if (actuacionesDisponibles < 0) {
            this.actuacionesDisponibles = -1;
        } else {
            this.actuacionesDisponibles = actuacionesDisponibles;
        }
    }

    @Override
    public double calcularRendimiento() {
        return getPuntosBase() + (nivelTecnico * 5) + (ensayosAsistidos * 2);
    }

    @Override
    public boolean estaDisponible() {
        boolean disponible;

        if (actuacionesDisponibles > 0) {
            disponible = true;
        } else {
            disponible = false;
        }

        return disponible;
    }

    public void registrarEnsayo() {
        ensayosAsistidos++;
    }

    public void consumirActuacion() {
        if (actuacionesDisponibles > 0) {
            actuacionesDisponibles--;
        }
    }
}