package programacion.ud4.ud1tojava;
import java.util.Scanner;

public class rel2_ej5 {
    public static void main(String[] args) {
        // declara variables
        double relacionPeso = 0.165;
        double peso;
        double pesoLuna;
        // crea un nuevo escaner
        Scanner escaner = new Scanner(System.in);
        // pide el peso al usuario
        System.out.print("Ingrese su peso actual:");
        peso = escaner.nextDouble();
        // cierra el escaner
        escaner.close();
        // calcula el peso en la luna segun los dos datos Double
        pesoLuna = peso * relacionPeso;
        // se muestra el resultado
        System.out.printf("Su peso en la Luna sería de %.2f kilos!\n", pesoLuna);
    }
}