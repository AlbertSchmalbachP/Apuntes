package es.stemgranada.ed.pruebasunitarias.calculadora;

/*
 * JUnit NO forma parte del lenguaje Java estándar.
 *
 * Para poder usar @Test, @BeforeEach, assertEquals, etc.,
 * es necesario que el proyecto incluya la librería JUnit 5.
 *
 * Esto puede hacerse de dos formas:
 *
 *   1) Añadiendo manualmente los JAR de JUnit al proyecto.
 *      (No recomendado en proyectos profesionales.)
 *
 *   2) (RECOMENDADO) Usando un proyecto gestionado con Maven
 *      que incluya la dependencia:
 *
 *      <dependency>
 *          <groupId>org.springframework.boot</groupId>
 *          <artifactId>spring-boot-starter-test</artifactId>
 *          <scope>test</scope>
 *      </dependency>
 *
 * En este ejemplo estamos trabajando dentro de un proyecto Maven,
 * por lo que JUnit 5 ya está disponible automáticamente en
 * src/test/java y podemos importar sus anotaciones sin problemas.
 */

/*
 * Importamos las anotaciones de JUnit 5 necesarias para definir
 * el ciclo de vida y los métodos de prueba.
 */

// Se ejecuta antes de cada test. Permite preparar el entorno.
import org.junit.jupiter.api.BeforeEach;

// Permite asignar un nombre más legible al test en el reporte.
import org.junit.jupiter.api.DisplayName;

// Marca un método como prueba unitaria.
import org.junit.jupiter.api.Test;

/*
 * Importaciones específicas para pruebas parametrizadas.
 */

// Indica que el método se ejecutará varias veces con distintos valores.
import org.junit.jupiter.params.ParameterizedTest;

// Fuente de datos simple basada en una lista de valores.
import org.junit.jupiter.params.provider.ValueSource;

// Fuente de datos basada en pares o múltiples valores (formato CSV).
import org.junit.jupiter.params.provider.CsvSource;

/*
 * Importación estática de las assertions.
 * Permite usar assertEquals, assertTrue, assertThrows, etc.
 * sin escribir Assertions.assertEquals(...)
 */
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void inicializar() {
        calculadora = new Calculadora();
    }

    // PRUEBAS DE SUMA

    @Test
    @DisplayName("La suma de 2 y 3 debe ser 5")
    void sumar_devuelve5_si2Mas3() {

        // Arrange: se preparan los datos de entrada que se van a usar en la prueba.
        // En este caso, los dos números que se van a sumar.
        int a = 2;
        int b = 3;

        // Act: se ejecuta el método que se quiere verificar.
        // Aquí se llama a sumar con los valores preparados.
        int resultado = calculadora.sumar(a, b);

        // Assert: se comprueba que el resultado obtenido coincide
        // con el valor esperado según el comportamiento definido.
        assertEquals(5, resultado);
    }

    // PRUEBAS DE DIVISIÓN

    @Test
    @DisplayName("La división 10 / 2 debe ser 5")
    void dividir_devuelve5_si10Entre2() {

        double resultado = calculadora.dividir(10, 2);

        // En operaciones con double se usa delta para evitar
        // pequeños errores de precisión.
        assertEquals(5.0, resultado, 0.0001);
    }

    @Test
    @DisplayName("Dividir entre cero debe lanzar excepción")
    void dividir_lanzaExcepcion_siDivisorEsCero() {

        // Se comprueba que al ejecutar este método
        // se lanza una IllegalArgumentException.
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.dividir(10, 0));
    }

    // PRUEBAS DE POTENCIA

    @Test
    @DisplayName("2 elevado a 3 debe ser 8")
    void potencia_devuelve8_siBase2_yExponente3() {

        double resultado = calculadora.potencia(2, 3);

        assertEquals(8.0, resultado, 0.0001);
    }

    @Test
    @DisplayName("Exponente negativo debe lanzar excepción")
    void potencia_lanzaExcepcion_siExponenteNegativo() {

        // Se verifica que el método no acepta exponentes negativos
        // y que responde lanzando la excepción esperada.
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.potencia(2, -1));
    }

    // PRUEBAS DE MEDIA

    @Test
    @DisplayName("La media de 2,4,6 debe ser 4")
    void media_devuelve4_siValores2_4_6() {

        double[] valores = { 2, 4, 6 };

        double resultado = calculadora.media(valores);

        assertEquals(4.0, resultado, 0.0001);
    }

    @Test
    @DisplayName("Array vacío debe lanzar excepción")
    void media_lanzaExcepcion_siArrayVacio() {

        double[] valores = {};

        // Se comprueba que no se permite calcular la media
        // de un array vacío.
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.media(valores));
    }

    @Test
    @DisplayName("Array null debe lanzar excepción")
    void media_lanzaExcepcion_siArrayNull() {

        // También se valida que null no es una entrada válida.
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.media(null));
    }

    // PRUEBAS BOOLEANAS

    @ParameterizedTest
    @ValueSource(ints = { 2, 4, 10, 100 })
    @DisplayName("Debe identificar números pares")
    void esPar_devuelveTrue_paraNumerosPares_parametrizado(int numero) {

        assertTrue(calculadora.esPar(numero));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 7, 99 })
    @DisplayName("Debe identificar números impares")
    void esPar_devuelveFalse_paraNumerosImpares_parametrizado(int numero) {

        assertFalse(calculadora.esPar(numero));
    }

    // PRUEBAS DE FACTORIAL

    @Test
    @DisplayName("El factorial de 5 debe ser 120")
    void factorial_devuelve120_siEntrada5() {

        long resultado = calculadora.factorial(5);

        assertEquals(120, resultado);
    }

    @Test
    @DisplayName("El factorial de 0 debe ser 1 (caso límite)")
    void factorial_devuelve1_siEntrada0() {

        assertEquals(1, calculadora.factorial(0));
    }

    @Test
    @DisplayName("Número negativo debe lanzar excepción")
    void factorial_lanzaExcepcion_siEntradaNegativa() {

        /*
         * Aquí aparece una expresión lambda:
         *
         * () -> calculadora.factorial(-3)
         *
         * Una lambda es una forma compacta de pasar un bloque de código
         * como si fuera un dato. En este caso, no se ejecuta inmediatamente.
         *
         * JUnit recibe ese bloque, lo ejecuta internamente y comprueba
         * si lanza la excepción indicada en el primer parámetro.
         *
         * Es equivalente a hacer un try-catch manual,
         * pero de forma más limpia y controlada.
         */
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.factorial(-3));
    }

    // PRUEBA PARAMETRIZADA CON CSV

    @ParameterizedTest
    @CsvSource({
            "1,1",
            "2,2",
            "3,6",
            "4,24"
    })
    @DisplayName("Prueba parametrizada de factorial con CSV")
    void factorial_devuelveResultadoCorrecto_paraMultiplesEntradas_csv(int entrada, long esperado) {

        long resultado = calculadora.factorial(entrada);

        assertEquals(esperado, resultado);
    }
}
