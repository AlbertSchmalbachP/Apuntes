package programacion.ud4.ud2tojava;
import java.util.ArrayList;

public class rel1_ej9 {
    public static void main(String[] args) {
        ArrayList<String> cola = new ArrayList<String>();
        // añade valores al array
        cola.add("cliente1");
        cola.add("cliente2");
        cola.add("cliente3");
        System.out.println(cola);
        System.out.println(cola.remove(0));
        System.out.println(cola);
        System.out.println(cola.remove(0));
        System.out.println(cola);
        System.out.println(cola.remove(0));
        System.out.println(cola);
    }
}