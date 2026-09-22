package programacion.ud4.ud2tojava;
import java.util.ArrayList;

public class rel1_ej15 {
    public static void main(String[] args) {
        ArrayList<Integer> numero = new ArrayList<Integer>();
        numero.add(1);
        numero.add(2);
        numero.add(3);
        numero.add(4);
        numero.add(5);
        for (int i = numero.size() - 1; i >= 0; i = i - 1) { // size() = length() para ArrayList
            numero.remove(i);
            System.out.println(numero);
        }
    }
}