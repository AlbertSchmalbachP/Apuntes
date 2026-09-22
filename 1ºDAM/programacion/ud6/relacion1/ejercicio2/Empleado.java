package programacion.ud6.ejercicio2;

public class Empleado {
    String nombre;
    int sueldoBase;

    Empleado(String nombre, int sueldoBase) {
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
    }

    public String toString() {
        return nombre + " es un/a emplado/a, y tiene un sueldo de " + sueldoBase + "€ al mes.";
    }
}
