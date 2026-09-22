package programacion.ud6.ejercicio2;

public class Diseñador extends Empleado {
    final double bonificadorDiseñador = 1.25;
    
    Diseñador(String nombre, int sueldoBase) {
        super(nombre, sueldoBase);
    }

    public double calcularSueldo() {
        return sueldoBase * bonificadorDiseñador;
    }

    public String toString() {
        return nombre + " ocupa el rol de Diseñador/a, y tiene un sueldo de " + sueldoBase + "€.";
    }
}