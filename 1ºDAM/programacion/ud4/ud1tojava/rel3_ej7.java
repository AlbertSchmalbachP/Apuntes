package programacion.ud4.ud1tojava;
import java.util.Scanner;

public class rel3_ej7 {
    public static void main(String[] args) {
        // inicializa variables
        double numero1;
        double numero2;
        String operante;
        double resultado = 0;
        Scanner scanner1 = new Scanner(System.in);
        // pide los numeros y el operante al usuario
        System.out.print("Introduzca un número:");
        numero1 = scanner1.nextDouble();
        System.out.print("Introduzca otro número:");
        numero2 = scanner1.nextDouble();
        System.out.print("Introduce un operante:");
        operante = scanner1.next();
        scanner1.close();
        // condiciones que comprueban que operante se ha introducido
        if (operante.equals("+")) {
            resultado = numero1 + numero2;
        } else if (operante.equals("-")) {
            resultado = numero1 - numero2;
        } else if (operante.equals("*") || operante.equals("x")) {
            resultado = numero1 * numero2;
        } else if (operante.equals("/")) {
            resultado = numero1 / numero2;
        } else if (operante.equals("%")) {
            resultado = numero1 % numero2;
        } else {
            System.out.print("No se ha introducido un operante válido.");
        }
        // presenta el resultado al usuario
        System.out.println("El resultado de la operación es " + resultado + ".");
    }
}