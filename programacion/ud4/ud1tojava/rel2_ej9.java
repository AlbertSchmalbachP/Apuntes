package programacion.ud4.ud1tojava;
import java.util.Scanner;
public class rel2_ej9 {

    public static void main(String[] args) {
        // declaracion de variables
        int caramelos;
        int ninos;
        int carameloPorNino;
        int resto;
        Scanner scanner1 = new Scanner(System.in);
        // pide al usuario el numero de caramelos y ninos
        System.out.print("Introduzca el número de caramelos:");
        caramelos = scanner1.nextInt();
        System.out.print("¿Cuántos niños/as hay?");
        ninos = scanner1.nextInt();
        // se cierra el escaner
        scanner1.close();
        // se calcula el numero de caramelos per capita y el resto
        carameloPorNino = caramelos / ninos;
        resto = caramelos % ninos;
        System.out.println("Cada niño/a recibirá " + carameloPorNino + " caramelos, y sobrarán " + resto + " caramelos.");
    }
}