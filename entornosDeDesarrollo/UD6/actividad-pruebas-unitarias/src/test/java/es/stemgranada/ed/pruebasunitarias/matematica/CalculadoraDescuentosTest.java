package es.stemgranada.ed.pruebasunitarias.matematica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDescuentosTest {

    private static final double MARGEN_ERROR = 0.0001;

    private CalculadoraDescuentos calculadora;

    @BeforeEach
    void inicializar() {
        calculadora = new CalculadoraDescuentos();
    }

    // TESTS NOMINALES

    @Test
    @DisplayName("calcularDescuento: 100 con 20% debe devolver 80")
    void calcularDescuento_devuelve80_siPrecio100_yPorcentaje20() {

        double resultado = calculadora.calcularDescuento(100, 20);

        assertEquals(80, resultado, MARGEN_ERROR);
    }

    @Test
    @DisplayName("aplicarDescuentoPorCliente: cliente VIP aplica 30%")
    void aplicarDescuentoPorCliente_devuelve70_siClienteVip() {

        double resultado = calculadora.aplicarDescuentoPorCliente(100, "vip");

        assertEquals(70, resultado, MARGEN_ERROR);
    }

    @Test
    @DisplayName("aplicarDescuentoPorCliente: cliente regular aplica 10%")
    void aplicarDescuentoPorCliente_devuelve90_siClienteRegular() {

        double resultado = calculadora.aplicarDescuentoPorCliente(100, "regular");

        assertEquals(90, resultado, MARGEN_ERROR);
    }

    @Test
    @DisplayName("aplicarDescuentoPorCliente: cliente nuevo aplica 5%")
    void aplicarDescuentoPorCliente_devuelve95_siClienteNuevo() {

        double resultado = calculadora.aplicarDescuentoPorCliente(100, "nuevo");

        assertEquals(95, resultado, MARGEN_ERROR);
    }

    @Test
    @DisplayName("esDescuentoValido: valores dentro del rango deben ser válidos")
    void esDescuentoValido_devuelveTrue_paraValoresValidos() {

        assertTrue(calculadora.esDescuentoValido(0));
        assertTrue(calculadora.esDescuentoValido(25));
        assertTrue(calculadora.esDescuentoValido(100));
    }

    // TESTS PARAMETRIZADOS

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 50, 100})
    @DisplayName("esDescuentoValido: valores válidos con ValueSource")
    void esDescuentoValido_devuelveTrue_paraValoresValidos_parametrizado(int porcentaje) {

        assertTrue(calculadora.esDescuentoValido(porcentaje));
    }

    @ParameterizedTest
    @CsvSource({
            "100,10,90",
            "200,25,150",
            "50,10,45"
    })
    @DisplayName("calcularDescuento: múltiples casos con CsvSource")
    void calcularDescuento_devuelveResultadoCorrecto_paraMultiplesCasos(double precio, int porcentaje,
            double esperado) {

        double resultado = calculadora.calcularDescuento(precio, porcentaje);

        assertEquals(esperado, resultado, MARGEN_ERROR);
    }

    @ParameterizedTest
    @CsvSource({
            "100,vip,70",
            "100,regular,90",
            "100,nuevo,95",
            "100,desconocido,100"
    })
    @DisplayName("aplicarDescuentoPorCliente: distintos tipos de cliente")
    void aplicarDescuentoPorCliente_devuelveResultadoCorrecto_paraTiposCliente(double precio, String tipo,
            double esperado) {

        double resultado = calculadora.aplicarDescuentoPorCliente(precio, tipo);

        assertEquals(esperado, resultado, MARGEN_ERROR);
    }
}
