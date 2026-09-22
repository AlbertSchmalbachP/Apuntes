package programacion.ud5.relacion2.ejercicio4;

import java.util.ArrayList;

public class Playlist {
    ArrayList<Cancion> canciones;
    Playlist() {
        this.canciones = new ArrayList<>();
    }

    public void agregarCanciones(Cancion cancion) {
        canciones.add(cancion);
    }
    public String mostrarCanciones() {
        String mensaje = "Canciones:\n";
        for (Cancion cancion : canciones) {
            mensaje += cancion.toString() + "\n";
        }
        return mensaje;
    }
    public String mostrarDuracion() {
        double duracionTotal = 0.0;
        for (Cancion cancion : canciones) {
            duracionTotal += cancion.getDuracion();
        }
        return "Duración total de la playlist: " + duracionTotal + " minutos.";
    }
}
