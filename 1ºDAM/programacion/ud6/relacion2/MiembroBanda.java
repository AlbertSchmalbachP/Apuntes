package Tema6.Repaso.Repaso2;

abstract class MiembroBanda {
    private String nombreArtistico, localidad;
    private int anosEnLaAgrupacion;
    private double puntosBase;

    public MiembroBanda(String nombreArtistico, String localidad, int anosEnLaAgrupacion, double puntosBase) {
        this.nombreArtistico = nombreArtistico;
        setLocalidad(localidad);
        setAnosEnLaAgrupacion(anosEnLaAgrupacion);
        setPuntosBase(puntosBase);
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        if (localidad == null || localidad.isEmpty() || localidad.matches(".*[0-9].*")) {
            this.localidad = "[Nombre de la localidad inválido]";
        } else {
            this.localidad = localidad;
        }
    }

    public int getAnosEnLaAgrupacion() {
        return anosEnLaAgrupacion;
    }

    public void setAnosEnLaAgrupacion(int anosEnLaAgrupacion) {
        if (anosEnLaAgrupacion < 0) {
            this.anosEnLaAgrupacion = -1;
        } else {
            this.anosEnLaAgrupacion = anosEnLaAgrupacion;
        }
    }

    public double getPuntosBase() {
        return puntosBase;
    }

    public void setPuntosBase(double puntosBase) {
        if (puntosBase < 0) {
            this.puntosBase = -1;
        } else {
            this.puntosBase = puntosBase;
        }
    }

    public abstract double calcularRendimiento();

    public abstract boolean estaDisponible();

    public void sumarAnos() {
        anosEnLaAgrupacion++;
    }

    public void sumarPuntosBase(double puntos) {
        if (puntos > 0) {
            puntosBase += puntos;
        }
    }
}
