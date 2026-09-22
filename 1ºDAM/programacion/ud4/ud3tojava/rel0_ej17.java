package programacion.ud4.ud3tojava;

public class rel0_ej17 {
    static Object revertirCadena(String cadena) {
        String cadenaInvertida = "";
        for (int i = cadena.length() - 1; i >= 0; i--) {
            cadenaInvertida += cadena.charAt(i);
        }
        return cadenaInvertida;
    }
    public static void main(String[] args) {
        String cadenaARevertir = "Hello World";
        System.out.print(revertirCadena(cadenaARevertir));
    }
}