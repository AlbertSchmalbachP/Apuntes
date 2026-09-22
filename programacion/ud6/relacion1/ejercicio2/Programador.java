package programacion.ud6.ejercicio2;

public class Programador extends Empleado {
    final double bonificadorProgramador = 1.1;

    Programador(String nombre, int sueldoBase) {
        super(nombre, sueldoBase);
    }

    public double calcularSueldo() {
        return sueldoBase * bonificadorProgramador;
    }

    public String toString() {
        return nombre + " ocupa el rol de Programador/a, y tiene un sueldo de " + sueldoBase + "€.";
    }
}
