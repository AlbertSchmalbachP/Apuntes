package programacion.ud4.ud3tojava;

import java.util.Scanner;
public class rel0_ej10 {
    static Object areaTriangulo(double base, double altura) {
        double area = (base * altura) / 2;
        return area;
    }
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        double base, altura;
        System.out.print("Introduzca la longitud de la base:");
        base = scanner1.nextDouble();
        System.out.print("Introduzca la longitud de la altura:");
        altura = scanner1.nextDouble();
        scanner1.close();
        System.out.print(areaTriangulo(base, altura));
    }
}