package programacion.ud5.relacion3.ejercicio2;

public class Expediente {
    static int numeroExpedientes;
    int numeroExpediente;
    Cliente cliente;
    Tramite tramite;
    String estado;
    boolean pagado;
    String fechaApertura;

    Expediente(Cliente cliente, String estado, String fechaApertura, int numeroExpediente, boolean pagado, Tramite tramite) {
        this.numeroExpediente = numeroExpediente; // TODO: Generar numero automatico
        this.cliente = cliente;
        this.tramite = tramite;
        this.estado = estado;
        this.pagado = pagado;
        this.fechaApertura = fechaApertura;
    }

    public void cambiarEstado(String nuevoEstado) {
        estado = nuevoEstado;
    }

    public void marcarPagado() {
        pagado = true;
    }

    @Override
    public String toString() {
        if (pagado == true) {
            return "Número de expediente: " + numeroExpediente + " | Perteneciente a " + cliente + ", con tipo de trámite " + tramite + " (Estado: " + estado + "). Está pagado. Fecha de apertura: " + fechaApertura;
        } else {
            return "Número de expediente: " + numeroExpediente + " | Perteneciente a " + cliente + ", con tipo de trámite " + tramite + " (Estado: " + estado + "). No está pagado. Fecha de apertura: " + fechaApertura;
        }
    }
}
