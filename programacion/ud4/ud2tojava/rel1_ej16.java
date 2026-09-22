package programacion.ud4.ud2tojava;
import java.util.ArrayList;

public class rel1_ej16 {
    public static void main(String[] args) {
        int numero = 1;
        ArrayList<Integer> secuencia = new ArrayList<Integer>();
        for (int i = 0 ; i < 5 ; i++) {
            secuencia.add(numero);
            System.out.println(secuencia);
            numero++;
        }
    }
}