package es.stemgranada.ed.pruebasunitarias.texto;

public class ProcesadorTexto {

    public int contarPalabras(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return 0;
        }
        return texto.trim().split("\\s+").length;
    }

    public boolean esPalindromo(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("El texto no puede ser null");
        }
        String limpio = texto.replaceAll("\\s+", "").toLowerCase();
        String invertido = new StringBuilder(limpio).reverse().toString();
        return limpio.equals(invertido);
    }

    public String invertir(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("El texto no puede ser null");
        }
        return new StringBuilder(texto).reverse().toString();
    }
}
