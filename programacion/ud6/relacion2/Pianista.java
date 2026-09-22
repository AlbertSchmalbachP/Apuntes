package Tema6.Repaso.Repaso2;

public class Pianista extends Instrumentista implements Tocable {
    private int numeroInstrumentos, acompanamientosPreparados, precision;
    private double valorInstrumentos;

    public Pianista(String nombreArtistico, String localidad, int anosEnLaAgrupacion, double puntosBase,
            String instrumentoPrincipal, int nivelTecnico, int ensayosAsistidos, int actuacionesDisponibles,
            int numeroInstrumentos, int acompanamientosPreparados, int precision, double valorInstrumentos) {
        super(nombreArtistico, localidad, anosEnLaAgrupacion, puntosBase, instrumentoPrincipal, nivelTecnico,
                ensayosAsistidos, actuacionesDisponibles);
        setNumeroInstrumentos(numeroInstrumentos);
        setAcompanamientosPreparados(acompanamientosPreparados);
        setPrecision(precision);
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

    public int getAcompanamientosPreparados() {
        return acompanamientosPreparados;
    }

    public void setAcompanamientosPreparados(int acompanamientosPreparados) {
        if (acompanamientosPreparados < 0) {
            this.acompanamientosPreparados = -1;
        } else {
            this.acompanamientosPreparados = acompanamientosPreparados;
        }
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        if (precision < 0) {
            this.precision = -1;
        } else {
            this.precision = precision;
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
        return super.calcularRendimiento() + (acompanamientosPreparados * 3) + precision + (valorInstrumentos * 0.015);
    }

    @Override
    public boolean estaDisponible() {
        boolean disponible;

        if (super.estaDisponible() && precision >= 5) {
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

    public void prepararAcompanamiento() {
        acompanamientosPreparados++;
    }

    public void aumentarPrecision(int cantidad) {
        if (cantidad > 0) {
            precision += cantidad;
        }
    }
}