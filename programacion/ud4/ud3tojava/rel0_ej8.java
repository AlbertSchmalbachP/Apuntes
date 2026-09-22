package programacion.ud4.ud3tojava;

import java.util.Scanner;
public class rel0_ej8 {
    static Object mayor(double numero1, double numero2) {
        Object numeroMayor = 0;
        if (numero1 < numero2) {
            numeroMayor = numero2;
        } else if (numero1 > numero2) {
            numeroMayor = numero1;
        } else {
            numeroMayor = null;
        }
        return numeroMayor;
    }
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        double numero1;
        double numero2;
        System.out.print("Introduce un número:");
        numero1 = scanner1.nextDouble();
        System.out.print("Introduce otro número:");
        numero2 = scanner1.nextDouble();
        System.out.println("El número mayor es: " + mayor(numero1, numero2));
        scanner1.close();
    }
}