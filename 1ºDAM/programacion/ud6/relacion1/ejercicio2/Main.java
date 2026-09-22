package programacion.ud6.ejercicio2;

// Crea una clase Empleado con los atributos nombre y sueldoBase. 
// Luego, crea tres subclases: Programador, Diseñador y Gerente. 
// Cada subclase debe tener un método calcularSueldo() 
// que ajuste el sueldo base según un bonificador específico para cada tipo de empleado.
// private final double BONIFICADOR = 1.5

// Implementa una clase Main para probar la creación de objetos y la llamada al método calcularSueldo().

public class Main{
    public static void main(String[] args) {
        // añadir empleados
        Empleado empleado1 = new Empleado("María Gómez", 2400);
        Programador empleado2 = new Programador("Isabel Ramos", 2700);
        Diseñador empleado3 = new Diseñador("Luis Molina", 3100);
        Gerente empleado4 = new Gerente("José Miguel Rayas", 2500);
        // probar toString
        System.out.println(empleado1);
        System.out.println(empleado2);
        System.out.println(empleado3);
        System.out.println(empleado4);
        // probar metodo sueldos
        System.out.println(empleado2.calcularSueldo());
        System.out.println(empleado3.calcularSueldo());
        System.out.println(empleado4.calcularSueldo());
    }
}