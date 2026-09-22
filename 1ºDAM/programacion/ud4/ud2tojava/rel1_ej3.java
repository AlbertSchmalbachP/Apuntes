package programacion.ud4.ud2tojava;
import java.util.ArrayList;

public class rel1_ej3 {
    public static void main(String[] args) {
        ArrayList<String> colores = new ArrayList<String>();
        colores.add("rojo");
        colores.add("verde");
        colores.add("azul");
        ArrayList<String> eliminado = new ArrayList<String>();
        eliminado.add(colores.remove(0));
        System.out.println(colores);
        System.out.println(eliminado);
    }
}