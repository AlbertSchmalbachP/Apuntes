package Tema6.Repaso.Repaso2;

public class Guitarrista extends Instrumentista implements Tocable, Revisable {
    private int numeroInstrumentos, solosPreparados, partiturasRevisadas, erroresDetectados;
    private double valorInstrumentos;

    public Guitarrista(String nombreArtistico, String localidad, int anosEnLaAgrupacion, double puntosBase,
            String instrumentoPrincipal, int nivelTecnico, int ensayosAsistidos, int actuacionesDisponibles,
            int numeroInstrumentos, int solosPreparados, int partiturasRevisadas, int erroresDetectados,
            double valorInstrumentos) {
        super(nombreArtistico, localidad, anosEnLaAgrupacion, puntosBase, instrumentoPrincipal, nivelTecnico,
                ensayosAsistidos, actuacionesDisponibles);
        setNumeroInstrumentos(numeroInstrumentos);
        setSolosPreparados(solosPreparados);
        setPartiturasRevisadas(partiturasRevisadas);
        setErroresDetectados(erroresDetectados);
        setValorInstrumentos(valorInstrumentos);
    }

    public int getNumeroInstrumentos() {
        return numeroInstrumentos;
    }

    public void setNumeroInstrumentos(int numeroInstrumentos) {
        if (numeroInstrumentos < 0) {
            this.numeroInstrumentos = -1;
        } else {
            this.numeroInstrumentos = numeroInstrumentos;
        }
    }

    public int getSolosPreparados() {
        return solosPreparados;
    }

    public void setSolosPreparados(int solosPreparados) {
        if (solosPreparados < 0) {
            this.solosPreparados = -1;
        } else {
            this.solosPreparados = solosPreparados;
        }
    }

    public int getPartiturasRevisadas() {
        return partiturasRevisadas;
    }

    public void setPartiturasRevisadas(int partiturasRevisadas) {
        if (partiturasRevisadas < 0) {
            this.partiturasRevisadas = -1;
        } else {
            this.partiturasRevisadas = partiturasRevisadas;
        }
    }

    public int getErroresDetectados() {
        return erroresDetectados;
    }

    public void setErroresDetectados(int erroresDetectados) {
        if (erroresDetectados < 0) {
            this.erroresDetectados = -1;
        } else {
            this.erroresDetectados = erroresDetectados;
        }
    }

    public double getValorInstrumentos() {
        return valorInstrumentos;
    }

    public void setValorInstrumentos(double valorInstrumentos) {
        if (valorInstrumentos < 0) {
            this.valorInstrumentos = -1;
        } else {
            this.valorInstrumentos = valorInstrumentos;
        }
    }

    @Override
    public double calcularRendimiento() {
        return super.calcularRendimiento() + (solosPreparados * 4) + (partiturasRevisadas * 1.5) - erroresDetectados
                + (valorInstrumentos * 0.02);
    }

    @Override
    public boolean estaDisponible() {
        boolean disponible;

        if (super.estaDisponible() && solosPreparados >= 1) {
            disponible = true;
        } else {
            disponible = false;
        }

        return disponible;
    }

    @Override
    public boolean asignarInstrumento(String nombre, double valor) {
        boolean seHaAsignado;

        if (nombre == null || nombre.isEmpty() || valor <= 0) {
            seHaAsignado = false;
        } else {
            numeroInstrumentos++;
            valorInstrumentos += valor;
            seHaAsignado = true;
        }

        return seHaAsignado;
    }

    @Override
    public boolean retirarInstrumento(String nombre, double valor) {
        boolean seHaRetirado;

        if (numeroInstrumentos == 0 || valor <= 0) {
            seHaRetirado = false;
        } else {
            numeroInstrumentos--;
            valorInstrumentos -= valor;

            if (valorInstrumentos < 0) {
                valorInstrumentos = 0;
            }

            seHaRetirado = true;
        }

        return seHaRetirado;
    }

    @Override
    public void sumarPartiturasRevisadas() {
        partiturasRevisadas++;
    }

    @Override
    public void sumarErroresDetectados(int cantidad) {
        if (cantidad > 0) {
            erroresDetectados += cantidad;
        }
    }

    public void prepararSolo() {
        solosPreparados++;
    }

    public void corregirError() {
        if (erroresDetectados > 0) {
            erroresDetectados--;
        }
    }
}