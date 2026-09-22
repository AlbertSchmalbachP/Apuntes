package programacion.ud4.ud3tojava;

import java.util.Scanner;
public class rel0_ej9 {
    static Object menorDeTres(double numero1, double numero2, double numero3) {
        Object numeroMenor = 0;
        if (numero1 < numero2 && numero1 < numero3) {
            numeroMenor = numero1;
        } else if (numero1 <= numero2 && numero1 > numero3) {
            numeroMenor = numero3;
        } else if (numero1 > numero2 && numero2 >= numero3) {
            numeroMenor = numero1;
        } else if (numero1 > numero2 && numero2 < numero3) {
            numeroMenor = numero2;
        } else {
            numeroMenor = null;
        }
        return numeroMenor;
    }
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        double numero1, numero2, numero3;
        System.out.print("Introduce un número:");
        numero1 = scanner1.nextDouble();
        System.out.print("Introduce otro número:");
        numero2 = scanner1.nextDouble();
        System.out.print("Introduce otro número:");
        numero3 = scanner1.nextDouble();
        scanner1.close();
        System.out.print(menorDeTres(numero1, numero2, numero3));
    }
}