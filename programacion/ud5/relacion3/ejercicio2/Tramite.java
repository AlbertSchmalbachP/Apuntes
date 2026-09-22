package programacion.ud5.relacion3.ejercicio2;

import java.net.Authenticator;

public class Tramite {
    static int numeroTramites;
    String codigo;
    String nombreTramite;
    double precioBase;
    boolean requiereCita;
    int duracionDias;

    Tramite(int numeroTramites, String codigo, String nombreTramite, double precioBase, boolean requiereCita, int duracionDias) {
        this.codigo = codigo; // TODO: autogenerar codigo
        this.nombreTramite = nombreTramite;
        this.precioBase = precioBase;
        this.requiereCita = requiereCita; // TODO: Calcular si necesita cita
        this.duracionDias = duracionDias;
    }

    calcularRequiereCita() {
        // todo
    }

    @Override
    public String toString() {
        if (requiereCita == true) {
            return "Número de clientes: " + numeroTramites + " | " + nombreTramite + "(código " + codigo + "). Precio base de " + precioBase + " euros, teniendo una duración de " + duracionDias + " días. Requiere cita.";
        } else {
            return "Número de clientes: " + numeroTramites + " | " + nombreTramite + "(código " + codigo + "). Precio base de " + precioBase + " euros, teniendo una duración de " + duracionDias + " días. No requiere cita.";
        }
    }
}
