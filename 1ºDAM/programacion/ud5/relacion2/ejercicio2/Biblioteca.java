package programacion.ud5.relacion2.ejercicio2;

import java.util.ArrayList;

public class Biblioteca {
    ArrayList<Libro> libros;
    Biblioteca() {
        this.libros = new ArrayList<>();
    }
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }
    public void prestarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                libro.setDisponible(false);
            }
        }
    }
    public void devolverLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                libro.setDisponible(true);
            }
        }
    }
}
