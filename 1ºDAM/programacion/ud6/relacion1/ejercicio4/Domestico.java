package programacion.ud6.ejercicio4;

public class Domestico extends Animal {
    String dueño;

    Domestico(String nombre, String tipoAlimentacion, String dueño) {
        super(nombre, tipoAlimentacion);
        this.dueño = dueño;
    }

    public String convivirConHumanos () {
        return "El animal doméstico " + nombre + " convive con su dueño " + dueño + " y se alimenta de " + tipoAlimentacion + ".";
    }
}
