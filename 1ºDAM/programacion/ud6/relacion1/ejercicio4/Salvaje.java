package programacion.ud6.ejercicio4;

public class Salvaje extends Animal {
    String habitat;

    Salvaje(String nombre, String tipoAlimentacion, String habitat) {
        super(nombre, tipoAlimentacion);
        this.habitat = habitat;
    }

    public String cazar () {
        return "El animal salvaje " + nombre + " caza en su hábitat " + habitat + " y se alimenta de " + tipoAlimentacion + ".";
    }
}