package es.stemgranada.ed.pruebasunitarias.validacion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorEdadTest {

    private ValidadorEdad validador;

    @BeforeEach
    void inicializar() {
        validador = new ValidadorEdad();
    }

    // TESTS ERRÓNEOS

    @Test
    @DisplayName("esMayorDeEdad: edad negativa lanza excepción")
    void esMayorDeEdad_lanzaExcepcion_siEdadNegativa() {

        try {
            validador.esMayorDeEdad(-1);
            fail("Debería lanzar IllegalArgumentException si la edad es negativa");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    @DisplayName("clasificarEdad: edad negativa lanza excepción")
    void clasificarEdad_lanzaExcepcion_siEdadNegativa() {
        try {
            validador.clasificarEdad(-5);
            fail("Debería lanzar IllegalArgumentException si la edad es negativa");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    // CLASES DE EQUIVALENCIA

    @Test
    @DisplayName("clasificarEdad: menor de edad")
    void clasificarEdad_devuelveMenor_siEdadMenor18() {

        String resultado = validador.clasificarEdad(10);

        assertEquals("menor", resultado);
    }

    @Test
    @DisplayName("clasificarEdad: adulto")
    void clasificarEdad_devuelveAdulto_siEdadEntre18y65() {

        String resultado = validador.clasificarEdad(30);

        assertEquals("adulto", resultado);
    }

    @Test
    @DisplayName("clasificarEdad: mayor senior")
    void clasificarEdad_devuelveMayorSenior_siEdadMayor65() {

        String resultado = validador.clasificarEdad(70);

        assertEquals("mayor senior", resultado);
    }

    // CASOS NOMINALES EXTRA (coherencia)

    @Test
    @DisplayName("esMayorDeEdad: 18 devuelve true")
    void esMayorDeEdad_devuelveTrue_siEdad18() {

        boolean resultado = validador.esMayorDeEdad(18);

        assertTrue(resultado);
    }

    @Test
    @DisplayName("esMayorDeEdad: menor de edad devuelve false")
    void esMayorDeEdad_devuelveFalse_siMenorDeEdad() {

        boolean resultado = validador.esMayorDeEdad(16);

        assertFalse(resultado);
    }
}
