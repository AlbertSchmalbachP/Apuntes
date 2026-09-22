# Actividades de pruebas unitarias con JUnit

## Convención de nombres en los tests

Se propone la siguiente nomenclatura para los métodos de test con el objetivo de mejorar la legibilidad y facilitar la comprensión del comportamiento que se está verificando.

El patrón utilizado es:

`accion_resultado_condicion`

Ejemplo:

`sumar_devuelve5_si2Mas3`

Cada parte del nombre indica:

- accion: método o comportamiento que se está probando
- resultado: qué se espera que ocurra
- condicion: en qué situación o con qué datos

Este enfoque permite que el nombre del test describa claramente qué se está comprobando sin necesidad de leer su implementación.

Reglas recomendadas:

- Mantener el patrón accion_resultado_condicion en todos los tests.
- Usar guion bajo (_) para separar partes y mejorar la lectura.
- Evitar nombres genéricos como deberiaFuncionar o deberiaCalcularCorrectamente.
- No usar prefijos o sufijos redundantes como testSuma o sumaTest, ya que JUnit 5 identifica el test mediante la anotación @Test.

Ventajas:

- Mejora la legibilidad del código de test
- Facilita la comprensión rápida del comportamiento probado
- Permite identificar errores con mayor facilidad cuando un test falla
- Convierte los tests en una forma de documentación del sistema

Se permite el uso de `_` para separar las distintas partes del nombre y mejorar la claridad.

---

## Actividad base - Ejemplo de referencia

Clase: `calculadora/CalculadoraTest.java`

En esta actividad se toma como referencia una batería de tests ya implementada. El objetivo es entender cómo están construidos antes de empezar a escribir los propios.

- Ejecutar los tests
- Analizar su estructura
- Identificar:
  - Arrange / Act / Assert
  - Uso de assertions
- No modificar código

## Tests nominales - CalculadoraDescuentos

Clase: `matematica/CalculadoraDescuentos.java`

En esta actividad se comprueba el comportamiento correcto del sistema cuando se utilizan datos válidos. Se trata de verificar que los métodos devuelven exactamente lo esperado en condiciones normales.

- Crear la clase `CalculadoraDescuentosTest.java`
- Testear:
  - calcularDescuento
  - aplicarDescuentoPorCliente
  - esDescuentoValido
- Comprobar resultados correctos
- Usar assertEquals y assertTrue

## Tests límite - ProcesadorTexto

Clase: `texto/ProcesadorTexto.java`

Aquí se trabajan situaciones especiales donde los valores pueden provocar comportamientos distintos, como entradas vacías o formatos poco habituales.

- Crear la clase `ProcesadorTextoTest.java`
- Testear:
  - contarPalabras
  - esPalindromo
  - invertir
- Probar:
  - String vacío
  - String con espacios
  - String con una sola palabra

## Tests erróneos - ValidadorEdad

Clase: `validacion/ValidadorEdad.java`

En esta actividad se validan entradas incorrectas para comprobar que el sistema responde de forma controlada ante errores. Además, se completa la comprobación del comportamiento del método `esMayorDeEdad` en condiciones normales para reforzar el uso de assertions booleanas.

- Crear la clase `ValidadorEdadTest.java`
- Testear:
  - esMayorDeEdad
  - clasificarEdad
- Comprobar:
  - edad negativa → excepción
- Usar try-catch.
- Opcional para ampliación: usar assertThrows (lambda).

- Añadir comprobaciones de comportamiento correcto en `esMayorDeEdad`:
  - edad ≥ 18 → `assertTrue`
  - edad < 18 → `assertFalse`

## Clases de equivalencia - ValidadorEdad

Clase: `validacion/ValidadorEdad.java`

En esta actividad se agrupan valores en categorías y se seleccionan casos representativos de cada grupo para evitar tests redundantes.

- Para `clasificarEdad`:
  - Definir grupos:
    - menor
    - adulto
    - mayor senior
- Crear tests representativos de cada grupo

## Tests parametrizados - CalculadoraDescuentos

Clase: `matematica/CalculadoraDescuentos.java`

En esta actividad se trabaja con múltiples datos de entrada en un mismo test para evitar duplicación y mejorar la mantenibilidad.

- Usar @ParameterizedTest
- Aplicarlo a:
  - esDescuentoValido
- Usar:
  - @ValueSource
  - @CsvSource

## Tests de excepciones - ProcesadorTexto

Clase: `texto/ProcesadorTexto.java`

En esta actividad se comprueba que ciertos métodos lanzan excepciones cuando reciben datos inválidos.

- Comprobar excepciones en:
  - esPalindromo
  - invertir
- Usar try-catch.
- Opcional para ampliación: usar assertThrows (lambda).

## Cobertura de código

En esta actividad se revisa qué partes del código no están siendo comprobadas por los tests y se completan.

- Ejecutar todos los tests
- Detectar métodos sin cubrir
- Añadir tests hasta cubrirlos
