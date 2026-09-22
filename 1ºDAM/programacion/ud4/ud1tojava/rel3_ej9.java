package programacion.ud4.ud1tojava;
import java.util.Scanner;

public class rel3_ej9 {
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Introduzca un número de dos cifras:");
        int numero = scanner1.nextInt();
        int digito1 = 0;
        int digito2 = 0;
        int sumaDigitos = 0;
        if ((numero >= 10 && numero < 100) || (numero <= -10 && numero > -100)) {
            digito1 = numero / 10;
            digito2 = numero % 10;
            sumaDigitos = digito1 + digito2;
            System.out.print("La suma de los dos digitos es " + sumaDigitos + ".");
        } else {
            System.out.print("El número introducido no es de dos cifras!");
        }
        scanner1.close();
    }
}