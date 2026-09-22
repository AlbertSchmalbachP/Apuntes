package programacion.ud4.ud1tojava;
import java.util.Scanner;

public class rel3_ej5 {
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Introduzca un número:");
        int numero = scanner1.nextInt();
        scanner1.close();
        if (numero >= 10 && numero <= 20) {
            System.out.print("El número está entre 10 y 20");
        } else {
            System.out.print("El número NO está entre 10 y 20");
        }
    }
}