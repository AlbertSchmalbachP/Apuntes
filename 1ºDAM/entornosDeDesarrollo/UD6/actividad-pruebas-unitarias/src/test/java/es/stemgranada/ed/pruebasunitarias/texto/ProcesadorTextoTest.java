package es.stemgranada.ed.pruebasunitarias.texto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcesadorTextoTest {

    private ProcesadorTexto procesador;

    @BeforeEach
    void inicializar() {
        procesador = new ProcesadorTexto();
    }

    // TESTS LÍMITE

    @Test
    @DisplayName("contarPalabras: texto vacío devuelve 0")
    void contarPalabras_devuelve0_siTextoVacio() {

        int resultado = procesador.contarPalabras("");

        assertEquals(0, resultado);
    }

    @Test
    @DisplayName("contarPalabras: texto con espacios devuelve 0")
    void contarPalabras_devuelve0_siSoloEspacios() {

        int resultado = procesador.contarPalabras("   ");

        assertEquals(0, resultado);
    }

    @Test
    @DisplayName("contarPalabras: una palabra devuelve 1")
    void contarPalabras_devuelve1_siUnaPalabra() {

        int resultado = procesador.contarPalabras("hola");

        assertEquals(1, resultado);
    }

    @Test
    @DisplayName("contarPalabras: varias palabras se cuentan correctamente")
    void contarPalabras_devuelveNumeroCorrecto_siVariasPalabras() {

        int resultado = procesador.contarPalabras("hola mundo test");

        assertEquals(3, resultado);
    }

    @Test
    @DisplayName("esPalindromo: palabra válida devuelve true")
    void esPalindromo_devuelveTrue_siPalindromo() {

        boolean resultado = procesador.esPalindromo("oso");

        assertTrue(resultado);
    }

    @Test
    @DisplayName("esPalindromo: palabra normal devuelve false")
    void esPalindromo_devuelveFalse_siNoPalindromo() {

        boolean resultado = procesador.esPalindromo("java");

        assertFalse(resultado);
    }

    @Test
    @DisplayName("invertir: texto se invierte correctamente")
    void invertir_devuelveTextoInvertido() {

        String resultado = procesador.invertir("abc");

        assertEquals("cba", resultado);
    }

    // TESTS DE EXCEPCIONES

    @Test
    @DisplayName("esPalindromo: null lanza excepción")
    void esPalindromo_lanzaExcepcion_siTextoNull() {

        try {
            procesador.esPalindromo(null);
            fail("Debería lanzar IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    @DisplayName("invertir: null lanza excepción")
    void invertir_lanzaExcepcion_siTextoNull() {

        try {
            procesador.invertir(null);
            fail("Debería lanzar IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
