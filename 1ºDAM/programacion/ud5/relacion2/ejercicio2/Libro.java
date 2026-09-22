package programacion.ud5.relacion2.ejercicio2;

public class Libro {
    private String id;
    private String titulo;
    private String autor;
    private String sinopsis;
    private boolean disponible;
    Libro(String id, String titulo, String autor, String sinopsis, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.sinopsis = sinopsis;
        this.disponible = disponible;
    }
    // setter/getter para el atributo id
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    // setter/getter para el atributo titulo
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() {
        return titulo;
    }
    // setter/getter para el atributo autor
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getAutor() {
        return autor;
    }
    // setter/getter para el atributo sinopsis
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    // setter/getter para el atributo disponible
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public boolean getDisponible() {
        return disponible;
    }

    @Override
    public String toString() {
        String mensaje;
        if (disponible == true) {
            mensaje = "ID " + id + " | " + titulo + " | Autor: " + autor + " | Sinopsis: " + sinopsis + " | Disponibilidad: En stock";
        } else {
            mensaje = "ID " + id + " | " + titulo + " | Autor: " + autor + " | Sinopsis: " + sinopsis + " | Disponibilidad: Sin stock";
        }
        return mensaje;
    }
}
