package programacion.ud4.ud2tojava;
import java.util.ArrayList;

public class rel1_ej13 {
    public static void main(String[] args) {
        ArrayList<String> letras = new ArrayList<String>();
        ArrayList<String> letrasInverso = new ArrayList<String>();
        letras.add("a");
        letras.add("b");
        letras.add("c");
        letras.add("d");
        for (int i = letras.size() - 1; i >= 0; i = i - 1) { // size() = length() para ArrayList
            letrasInverso.add(letras.get(i));
        }
        System.out.println(letrasInverso);
    }
}