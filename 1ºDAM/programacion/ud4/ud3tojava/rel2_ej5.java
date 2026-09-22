package programacion.ud4.ud3tojava;

import java.util.ArrayList;
import java.util.Arrays;

public class rel2_ej5 {
    static int detectarPalabrasClave(String textoComprobar, ArrayList<String> claves) {
        int numeroPalabrasClave = 0;
        ArrayList<String> textoSeparado = new ArrayList<>(Arrays.asList(textoComprobar.split(" ")));
        for (int i = 0; i < textoSeparado.size(); i++) {
            for (int j = 0; j < claves.size(); j++) {
                if (textoSeparado.get(i).equalsIgnoreCase(claves.get(j))) {
                    numeroPalabrasClave++;
                }
            }
        }
        return numeroPalabrasClave;
    }

    public static void main(String[] args) {
        String texto = "Me gusta programar en Python y Java";
        ArrayList<String> palabrasClave = new ArrayList<String>(Arrays.asList("python", "java", "c++"));
        System.out.println(detectarPalabrasClave(texto, palabrasClave));
    }
}
