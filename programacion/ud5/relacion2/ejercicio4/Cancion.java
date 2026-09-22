package programacion.ud5.relacion2.ejercicio4;

public class Cancion {
    private String titulo;
    private String artista;
    private double duracion;
    Cancion(String titulo, String artista, double duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
    }

    // getter/setter methods
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }

    public double getDuracion() {
        return duracion;
    }
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "\"" + titulo + "\"" + " - " + artista + " (" + duracion + " minutos)";
    }
}
