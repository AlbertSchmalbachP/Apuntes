package Tema6.Repaso.Repaso2;

import java.util.ArrayList;

public class ResponsableMusical extends MiembroBanda implements Coordinable, Revisable {
    private String repertorioSemana;
    private int numeroIntegrantesACargo, partiturasRevisadas, erroresDetectados;
    private ArrayList<MiembroBanda> integrantes;

    public ResponsableMusical(String nombreArtistico, String localidad, int anosEnLaAgrupacion, double puntosBase,
            String repertorioSemana, int numeroIntegrantesACargo, int partiturasRevisadas, int erroresDetectados,
            ArrayList<MiembroBanda> integrantes) {
        super(nombreArtistico, localidad, anosEnLaAgrupacion, puntosBase);
        setRepertorioSemana(repertorioSemana);
        setNumeroIntegrantesACargo(numeroIntegrantesACargo);
        setPartiturasRevisadas(partiturasRevisadas);
        setErroresDetectados(erroresDetectados);
        setIntegrantes(integrantes);
    }

    public String getRepertorioSemana() {
        return repertorioSemana;
    }

    public void setRepertorioSemana(String repertorioSemana) {
        if (repertorioSemana == null || repertorioSemana.isEmpty() || repertorioSemana.matches(".*[0-9].*")) {
            this.repertorioSemana = "[Repertorio inválido]";
        }
        this.repertorioSemana = repertorioSemana;
    }

    public int getNumeroIntegrantesACargo() {
        return numeroIntegrantesACargo;
    }

    public void setNumeroIntegrantesACargo(int numeroIntegrantesACargo) {
        if (numeroIntegrantesACargo < 0) {
            this.numeroIntegrantesACargo = -1;
        } else {
            this.numeroIntegrantesACargo = numeroIntegrantesACargo;
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

    public ArrayList<MiembroBanda> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(ArrayList<MiembroBanda> integrantes) {
        if (integrantes == null || integrantes.isEmpty()) {
            this.integrantes = new ArrayList<>();
        } else {
            this.integrantes = integrantes;
        }
    }

    @Override
    public double calcularRendimiento() {
        return getPuntosBase() + (getAnosEnLaAgrupacion() * 4) + (numeroIntegrantesACargo * 3)
                + (partiturasRevisadas * 2) - erroresDetectados;
    }

    @Override
    public boolean estaDisponible() {
        boolean disponible;

        if (erroresDetectados <= 5) {
            disponible = true;
        } else {
            disponible = false;
        }

        return disponible;
    }

    @Override
    public boolean asignarMiembro(MiembroBanda miembro) {
        boolean seHaAsignado;

        if (miembro == null) {
            seHaAsignado = false;
        }

        for (int i = 0; i < integrantes.size(); i++) {
            if (integrantes.get(i).getNombreArtistico().equals(miembro.getNombreArtistico())) {
                seHaAsignado = false;
            }
        }

        integrantes.add(miembro);
        numeroIntegrantesACargo = integrantes.size();
        seHaAsignado = true;
        return seHaAsignado;
    }

    @Override
    public boolean quitarMiembro(String nombreArtistico) {
        boolean seHaQuitado;

        for (int i = 0; i < integrantes.size(); i++) {
            if (integrantes.get(i).getNombreArtistico().equals(nombreArtistico)) {
                integrantes.remove(integrantes.get(i));
                numeroIntegrantesACargo = integrantes.size();
                seHaQuitado = true;
            }
        }

        seHaQuitado = false;
        return seHaQuitado;
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

    public double calcularRendimientoEquipo() {
        double total = 0;
        
        for (MiembroBanda miembro : integrantes) {
            total += miembro.calcularRendimiento();
        }
        return total;
    }
}