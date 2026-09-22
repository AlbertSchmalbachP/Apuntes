package programacion.ud4.ud2tojava;
import java.util.ArrayList;

public class rel1_ej12 {
    public static void main(String[] args) {
        String eliminadoDelante;
        String eliminadoDetras;
        ArrayList<String> nombres = new ArrayList<String>();
        nombres.add("Carlos");
        nombres.add("Ana");
        nombres.add("Pedro");
        nombres.add("Laura");
        // elimino los valores primero y ultimo
        eliminadoDelante = nombres.remove(0);
        eliminadoDetras = nombres.remove(3);
        System.out.println(nombres);
        System.out.println(eliminadoDelante);
        System.out.println(eliminadoDetras);
    }
}