package programacion.ud4.ud2tojava;
import java.util.ArrayList;

public class rel1_ej8 {
    public static void main(String[] args) {
        int temp;
        ArrayList<Integer> numero = new ArrayList<Integer>();
        // añade valores al array
        numero.add(100);
        numero.add(200);
        numero.add(300);
        // añade el elemento en posición 0 al nuevo array
        temp = numero.get(0);
        // copia el elemento de la posicion 2 a la posicion 0
        numero.set(0, numero.get(2));
        // copia el elemento del array temporal a la posicion 2 del array principal
        numero.set(2, temp);
        System.out.println(numero);
    }
}