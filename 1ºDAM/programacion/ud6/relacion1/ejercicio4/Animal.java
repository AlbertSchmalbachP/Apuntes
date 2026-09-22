package programacion.ud6.ejercicio4;

public class Animal {
    String nombre;
    String tipoAlimentacion;

    Animal(String nombre, String tipoAlimentacion) {
        this.nombre = nombre;
        this.tipoAlimentacion = tipoAlimentacion;
    }

    @Override
    public String toString() {
        return "El/la " + nombre + " tiene una alimentación de tipo " + tipoAlimentacion + ".";
    }
}
