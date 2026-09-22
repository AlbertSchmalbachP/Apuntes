package programacion.ud4.ud2tojava;
import java.util.ArrayList;

public class rel1_ej14 {
    public static void main(String[] args) {
        int temp;
        ArrayList<Integer> numero = new ArrayList<Integer>();
        numero.add(5);
        numero.add(10);
        numero.add(15);
        numero.add(20);
        temp = numero.remove(0);
        numero.add(temp);
        System.out.println(numero);
    }
}