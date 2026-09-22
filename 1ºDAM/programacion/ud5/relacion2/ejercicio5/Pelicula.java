package programacion.ud5.relacion2.ejercicio5;

public class Pelicula {
    private String titulo;
    private String sinopsis;
    private String director;
    private int duracion;

    Pelicula(String titulo, String sinopsis, String director, int duracion) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.director = director;
        this.duracion = duracion;
    }

    // getter/setter methods
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "\"" + titulo + "\"" + ", dirigida por " + director + ". Sinopsis: " + sinopsis + ". Duración: " + " minutos.";
    }
}
