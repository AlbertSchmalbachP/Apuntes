package programacion.ud5.relacion2.ejercicio5;

import java.util.ArrayList;

public class Cine {
    ArrayList<Pelicula> peliculas;
    Cine() {
        this.peliculas = new ArrayList<>();
    }

    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public String mostrarPeliculas() {
        String mensaje = "Peliculas:\n";
        for (Pelicula pelicula : peliculas) {
            mensaje += pelicula.toString() + "\n";
        }
        return mensaje;
    }

    public Pelicula buscarPelicula(String peliculaBuscar) {
        //! falta control de errores
        Pelicula peliculaDevolver = null;
        for (Pelicula pelicula : peliculas) {
            if (peliculaBuscar.equals(pelicula.getTitulo())) {
                peliculaDevolver = pelicula;
            }
        }
        return peliculaDevolver;
    }

    public String mostrarDuracionMedia() {
        double duracionTotal = 0.0;
        double duracionMedia;
        for (Pelicula pelicula : peliculas) {
            duracionTotal += pelicula.getDuracion();
        }
        duracionMedia = duracionTotal / peliculas.size();
        return "Duración media de las películas: " + duracionMedia + " minutos.";
    }
}
