# Unidad Didáctica 6: Pruebas unitarias y verificación automatizada con JUnit

## Índice

- [Unidad Didáctica 6: Pruebas unitarias y verificación automatizada con JUnit](#unidad-didáctica-6-pruebas-unitarias-y-verificación-automatizada-con-junit)
  - [Índice](#índice)
  - [Glosario](#glosario)
  - [1. Introducción y fundamentos](#1-introducción-y-fundamentos)
    - [1.1. Contexto técnico en el ciclo de desarrollo](#11-contexto-técnico-en-el-ciclo-de-desarrollo)
    - [1.2. Concepto general de prueba unitaria](#12-concepto-general-de-prueba-unitaria)
    - [1.3. Diferencias entre prueba manual, depuración y prueba automatizada](#13-diferencias-entre-prueba-manual-depuración-y-prueba-automatizada)
    - [1.4. Importancia profesional del testing automatizado](#14-importancia-profesional-del-testing-automatizado)
  - [2. Diseño de pruebas unitarias](#2-diseño-de-pruebas-unitarias)
    - [2.1. Identificación de unidades testeables](#21-identificación-de-unidades-testeables)
    - [2.2. Diseño de casos de prueba](#22-diseño-de-casos-de-prueba)
      - [2.2.1. Casos nominales](#221-casos-nominales)
      - [2.2.2. Casos límite](#222-casos-límite)
      - [2.2.3. Casos erróneos](#223-casos-erróneos)
      - [2.2.4. Partición en clases de equivalencia](#224-partición-en-clases-de-equivalencia)
    - [2.3. Estructura AAA (Arrange – Act – Assert)](#23-estructura-aaa-arrange--act--assert)
    - [2.4. Criterios de calidad de un test](#24-criterios-de-calidad-de-un-test)
  - [3. Fundamentos técnicos de JUnit 5](#3-fundamentos-técnicos-de-junit-5)
    - [3.1. Arquitectura de JUnit 5](#31-arquitectura-de-junit-5)
    - [3.2. Estructura de proyecto con Maven](#32-estructura-de-proyecto-con-maven)
    - [3.3. Anotaciones principales](#33-anotaciones-principales)
      - [`@Test`](#test)
      - [`@BeforeEach` y `@AfterEach`](#beforeeach-y-aftereach)
      - [`@BeforeAll` y `@AfterAll`](#beforeall-y-afterall)
      - [`@Disabled`](#disabled)
    - [3.4. Assertions más utilizadas](#34-assertions-más-utilizadas)
      - [`assertEquals`](#assertequals)
      - [`assertTrue` y `assertFalse`](#asserttrue-y-assertfalse)
      - [`assertNull` y `assertNotNull`](#assertnull-y-assertnotnull)
      - [`assertThrows`](#assertthrows)
    - [3.5. Organización y nomenclatura de clases de prueba](#35-organización-y-nomenclatura-de-clases-de-prueba)
  - [4. Elementos avanzados de testing](#4-elementos-avanzados-de-testing)
    - [4.1. Pruebas parametrizadas](#41-pruebas-parametrizadas)
      - [Ejemplo con `@ValueSource`](#ejemplo-con-valuesource)
      - [Ejemplo con `@CsvSource`](#ejemplo-con-csvsource)
    - [4.2. Validación de excepciones](#42-validación-de-excepciones)
    - [4.3. Aislamiento de dependencias y concepto de mock](#43-aislamiento-de-dependencias-y-concepto-de-mock)
    - [4.4. Cobertura de código](#44-cobertura-de-código)
  - [5. Testing y calidad del software](#5-testing-y-calidad-del-software)
    - [5.1. Relación entre testing y refactorización](#51-relación-entre-testing-y-refactorización)
    - [5.2. Desarrollo guiado por pruebas (TDD)](#52-desarrollo-guiado-por-pruebas-tdd)
    - [5.3. Errores frecuentes en la escritura de tests](#53-errores-frecuentes-en-la-escritura-de-tests)
    - [5.4. Nivel adecuado de cobertura y valor real de las pruebas](#54-nivel-adecuado-de-cobertura-y-valor-real-de-las-pruebas)
  - [6. Integración con el entorno de desarrollo](#6-integración-con-el-entorno-de-desarrollo)
    - [6.1. Ejecución desde el IDE](#61-ejecución-desde-el-ide)
    - [6.2. Integración con Maven](#62-integración-con-maven)
    - [6.3. Organización profesional del repositorio](#63-organización-profesional-del-repositorio)
    - [6.4. Limitaciones técnicas de las pruebas unitarias](#64-limitaciones-técnicas-de-las-pruebas-unitarias)
  - [7. Análisis crítico y madurez profesional](#7-análisis-crítico-y-madurez-profesional)
    - [7.1. Testing como cultura de calidad](#71-testing-como-cultura-de-calidad)
    - [7.2. Cuándo un test no aporta valor](#72-cuándo-un-test-no-aporta-valor)
    - [7.3. Balance entre velocidad y cobertura](#73-balance-entre-velocidad-y-cobertura)
    - [7.4. Testing en trabajo colaborativo](#74-testing-en-trabajo-colaborativo)
  - [8. Síntesis estructural de la unidad](#8-síntesis-estructural-de-la-unidad)

---

## Glosario

- **Assert**: Instrucción utilizada dentro de una prueba para verificar que el resultado obtenido coincide con el resultado esperado. Si la condición evaluada no se cumple, la prueba falla.
- **Caso de prueba**: Especificación concreta que define el estado inicial, los datos de entrada, la acción ejecutada y el resultado esperado para validar un comportamiento determinado del sistema.
- **Ciclo Red-Green-Refactor**: Secuencia de trabajo propia del desarrollo guiado por pruebas (TDD). Consiste en escribir primero una prueba que falla (Red), implementar el código mínimo para que pase (Green) y, posteriormente, mejorar el diseño manteniendo las pruebas correctas (Refactor).
- **Cobertura de código**: Métrica que indica qué porcentaje del código ha sido ejecutado durante la ejecución de las pruebas. Sirve como indicador orientativo, pero no garantiza por sí sola la calidad de los tests.
- **Mock**: Objeto simulado que sustituye a una dependencia real durante una prueba unitaria. Permite aislar la unidad bajo prueba y controlar el comportamiento de componentes externos.
- **Prueba unitaria**: Prueba automatizada que verifica el comportamiento de una unidad de software (método o clase) de forma aislada, sin depender de recursos externos.
- **Pruebas automatizadas**: Conjunto de pruebas que se ejecutan mediante herramientas de forma automática para verificar el comportamiento del sistema tras cada modificación del código.
- **Refactorización segura**: Modificación de la estructura interna del código sin alterar su comportamiento externo, apoyada en una batería de pruebas que garantiza que no se introducen regresiones.
- **TDD (Test Driven Development o Desarrollo guiado por pruebas)**: Estrategia de desarrollo en la que las pruebas se escriben antes que el código productivo, utilizando el ciclo Rojo-Verde-Refactorizar como guía de trabajo.

---

## 1. Introducción y fundamentos

### 1.1. Contexto técnico en el ciclo de desarrollo

El desarrollo profesional de software exige que un producto sea **correcto, mantenible, evolutivo y verificable**. Las pruebas no constituyen una fase final opcional, sino un componente estructural del ciclo de vida del desarrollo.

En un flujo de trabajo moderno, el proceso puede representarse de forma simplificada como una secuencia iterativa:

- Análisis del requisito.
- Diseño.
- Implementación.
- Verificación.
- Refactorización.
- Integración continua.

La verificación no aparece como un bloque aislado, sino como una actividad recurrente que acompaña cada iteración. Cada modificación del código puede introducir errores involuntarios, denominados *regresiones*. Detectarlos de forma sistemática requiere mecanismos automáticos que validen el comportamiento tras cada cambio.

En el ámbito profesional existen distintos niveles de pruebas:

- **Pruebas unitarias**, que validan unidades aisladas de código.
- **Pruebas de integración**, que verifican la interacción entre componentes.
- **Pruebas de sistema o aceptación**, que evalúan el comportamiento global desde la perspectiva funcional.

### 1.2. Concepto general de prueba unitaria

Una *prueba unitaria* es un fragmento de código cuyo objetivo es verificar el comportamiento de una unidad concreta del programa de forma aislada.

Una unidad suele ser:

- Un método.
- Una función.
- Una clase con responsabilidad claramente definida.

Para entenderlo con claridad, puede considerarse la siguiente clase sencilla:

```java
public class Calculadora {

    public int add(int a, int b) {
        return a + b;
    }
}
```

La unidad bajo prueba es el método `add`. Una prueba unitaria asociada podría escribirse de la siguiente manera:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraTest {

    @Test
    void sumar_devuelve5_si2Mas3() {
        Calculadora calculadora = new Calculadora();
        int result = calculadora.add(2, 3);
        assertEquals(5, result);
    }
}
```

En este ejemplo se verifica un comportamiento concreto: que la suma de 2 y 3 produce 5. Si el resultado real coincide con el esperado, la prueba pasa; si no, se detecta un fallo.

La característica esencial de una prueba unitaria es el **aislamiento**. La unidad bajo prueba debe evaluarse sin depender de factores externos como bases de datos reales, servicios de red o interfaces gráficas. En el ejemplo anterior, el método `add` no necesita ningún recurso externo, lo que facilita que la prueba sea:

- Rápida.
- Repetible.
- Determinista.
- Independiente del entorno.

Una prueba unitaria compara un resultado esperado con el resultado real obtenido al ejecutar la unidad. No pretende demostrar que el programa es perfecto, sino verificar que cumple un comportamiento definido bajo condiciones concretas y controladas.

### 1.3. Diferencias entre prueba manual, depuración y prueba automatizada

Es habitual confundir tres conceptos que, aunque relacionados, tienen objetivos distintos.

Una *prueba manual* consiste en ejecutar el programa e interactuar con él para comprobar si se comporta como se espera. Este enfoque depende completamente de la intervención humana y no es escalable en proyectos medianos o grandes.

La *depuración* o *debugging* es el proceso de localizar y corregir errores cuando ya se ha detectado un comportamiento incorrecto. Implica el uso de herramientas como puntos de ruptura, inspección de variables y ejecución paso a paso. La depuración reacciona ante el error.

La *prueba automatizada*, en cambio, es preventiva. Se define previamente qué comportamiento debe cumplir una unidad y se ejecuta automáticamente esa verificación cada vez que el código cambia. No requiere intervención humana constante y puede integrarse en procesos automáticos como compilaciones o integraciones continuas.

En resumen:

- La prueba manual valida visualmente.
- La depuración corrige errores detectados.
- La prueba automatizada verifica sistemáticamente comportamientos definidos.

En un entorno profesional, la combinación de pruebas automatizadas y depuración controlada es lo que permite mantener sistemas complejos bajo control.

### 1.4. Importancia profesional del testing automatizado

Las pruebas automatizadas son un **estándar consolidado** en el desarrollo profesional de software. No se incorporan como complemento final, sino como parte estructural del proceso de construcción del sistema.

Su relevancia se fundamenta en tres aspectos principales. En primer lugar, permite detectar errores en fases tempranas, reduciendo significativamente el coste de corrección. En segundo lugar, facilita la evolución del software, ya que una batería de pruebas sólida actúa como **red de seguridad** ante cambios y refactorizaciones. En tercer lugar, habilita procesos técnicos modernos como la *integración continua* y la validación automática en repositorios compartidos.

Las pruebas automatizadas transforman la calidad en un elemento **verificable**. En lugar de confiar en comprobaciones manuales o en la memoria del desarrollador, el sistema dispone de mecanismos objetivos que validan su comportamiento tras cada modificación.

Desde una perspectiva profesional, escribir pruebas unitarias forma parte del **desarrollo responsable y sostenible** del software.

---

## 2. Diseño de pruebas unitarias

La calidad de las pruebas no depende únicamente de la herramienta utilizada, sino del **diseño previo** que se realiza antes de escribir el código del test. Una prueba mal diseñada puede generar falsa seguridad o convertirse en un obstáculo para la evolución del sistema.

Diseñar pruebas unitarias implica decidir con precisión:

- Qué se va a probar.
- Bajo qué condiciones.
- Con qué datos.
- Qué comportamiento se considera correcto.

Una prueba bien diseñada no surge de manera improvisada; responde a un análisis estructurado del comportamiento esperado.

### 2.1. Identificación de unidades testeables

No todas las partes de un programa son igualmente adecuadas para pruebas unitarias. La unidad ideal es aquella que:

- Tiene una responsabilidad claramente definida.
- Recibe entradas bien delimitadas.
- Produce salidas verificables.
- No depende directamente de recursos externos.

Los métodos *puros*, es decir, aquellos que no modifican estado externo y cuyo resultado depende únicamente de sus parámetros, son especialmente adecuados para pruebas unitarias. En cambio, los métodos que interactúan con bases de datos, sistemas de archivos o servicios externos requieren mecanismos adicionales de aislamiento, como el uso de *mocks*.

Una clase con **alta cohesión** y **bajo acoplamiento** resulta más fácilmente testeable. Por tanto, el diseño orientado a objetos influye directamente en la facilidad de escribir pruebas unitarias.

Identificar unidades testeables no es solo una tarea técnica, sino también un indicador del **grado de calidad del diseño** del sistema.

### 2.2. Diseño de casos de prueba

Un caso de prueba define el estado inicial del sistema, los datos de entrada, la acción ejecutada y el resultado esperado. Para ilustrarlo, se utilizará el siguiente método como ejemplo:

```java
public class ValidadorEdad {

    public boolean isAdult(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Edad no válida");
        }
        return age >= 18;
    }
}
```

En este caso, la unidad bajo prueba es el método `isAdult`.

No basta con probar un único escenario correcto. Un diseño sólido contempla distintos tipos de situaciones que pueden afectar al comportamiento de la unidad.

#### 2.2.1. Casos nominales

El caso nominal representa el comportamiento esperado bajo condiciones normales. Es el escenario habitual y el primero que debe verificarse.

Para el método `isAdult`, un caso nominal sería:

```java
@Test
void esMayorDeEdad_devuelveTrue_siEdad18() {
    ValidadorEdad validator = new ValidadorEdad();
    boolean result = validator.isAdult(18);
    assertTrue(result);
}
```

Aquí se comprueba que una edad válida dentro del rango produce el resultado esperado.

Los casos nominales validan la funcionalidad principal, pero no garantizan que el sistema sea robusto ante situaciones especiales.

#### 2.2.2. Casos límite

Los casos límite analizan el comportamiento en los extremos del dominio de entrada. Muchos errores aparecen precisamente en estos puntos.

En el ejemplo anterior, los límites relevantes son:

- Edad mínima válida.
- Edad inmediatamente inferior al límite.
- Edad máxima válida.

Una prueba de límite podría ser:

```java
@Test
void esMayorDeEdad_devuelveFalse_siEdad17() {
    ValidadorEdad validator = new ValidadorEdad();
    assertFalse(validator.isAdult(17));
}
```

También podría verificarse el límite superior permitido:

```java
@Test
void esMayorDeEdad_devuelveTrue_siEdad120() {
    ValidadorEdad validator = new ValidadorEdad();
    assertTrue(validator.isAdult(120));
}
```

Probar únicamente valores intermedios podría ocultar errores en las comparaciones.

#### 2.2.3. Casos erróneos

Un sistema robusto debe reaccionar adecuadamente ante entradas inválidas. En este caso, edades negativas o superiores a 120 deben provocar una excepción.

```java
@Test
void esMayorDeEdad_lanzaExcepcion_siEdadNegativa() {
    ValidadorEdad validator = new ValidadorEdad();
    assertThrows(IllegalArgumentException.class, () -> validator.isAdult(-5));
}
```

Este tipo de prueba no valida un resultado correcto, sino el cumplimiento de un contrato: ante datos inválidos debe lanzarse una excepción específica.

Las pruebas de casos erróneos aseguran que el sistema no falle de manera imprevisible.

#### 2.2.4. Partición en clases de equivalencia

La partición en clases de equivalencia consiste en dividir el dominio de entrada en grupos donde se espera un comportamiento similar, seleccionando un valor representativo de cada grupo.

Para el método `isAdult` pueden definirse tres clases principales:

- Edades válidas menores de 18.
- Edades válidas mayores o iguales a 18.
- Edades inválidas.

No es necesario probar todas las edades posibles entre 0 y 120. Basta con elegir representantes adecuados, como:

- 10 para menores de edad.
- 25 para adultos.
- -1 para edad inválida.

De esta forma se reduce el número de pruebas sin perder cobertura funcional relevante.

La partición en clases de equivalencia permite diseñar pruebas eficientes y sistemáticas, evitando redundancia innecesaria mientras se mantiene rigor técnico.

### 2.3. Estructura AAA (Arrange – Act – Assert)

Una prueba bien estructurada suele seguir el patrón AAA:

- *Arrange*: preparación del entorno y datos.
- *Act*: ejecución de la acción bajo prueba.
- *Assert*: verificación del resultado.

Esta estructura mejora la claridad y legibilidad del test. Cada fase cumple una función concreta:

En la fase *Arrange* se crean objetos y se inicializan variables.
En la fase *Act* se ejecuta el método que se desea probar.
En la fase *Assert* se comparan los resultados obtenidos con los esperados.

Separar claramente estas fases evita pruebas confusas donde la preparación, la ejecución y la verificación se mezclan sin orden. La claridad en un test es tan importante como la claridad en el código productivo.

### 2.4. Criterios de calidad de un test

Un test de calidad debe cumplir ciertos principios que garantizan su utilidad real.

En primer lugar, debe ser **independiente**. No debe depender del resultado de otros tests ni del orden de ejecución.

En segundo lugar, debe ser **determinista**. Ejecutarlo varias veces en las mismas condiciones debe producir siempre el mismo resultado.

También debe ser **rápido**. Las pruebas unitarias forman parte del ciclo de desarrollo y deben ejecutarse con frecuencia. Si son lentas, se abandonan.

Otro criterio fundamental es la **claridad**. Un test debe comunicar qué comportamiento se espera. Si no se entiende qué verifica, pierde valor como documentación ejecutable.

Por último, un test debe **centrarse en una única responsabilidad**. Probar múltiples comportamientos en una sola prueba dificulta identificar la causa de un fallo.

Una batería de pruebas bien diseñada no solo detecta errores, sino que actúa como especificación viva del comportamiento del sistema.

---

## 3. Fundamentos técnicos de JUnit 5

JUnit 5 es la versión moderna del framework de pruebas más utilizado en el ecosistema Java. No se trata únicamente de una actualización sintáctica respecto a versiones anteriores, sino de una reorganización arquitectónica que separa claramente responsabilidades y permite mayor extensibilidad.

Comprender su estructura técnica permite utilizarlo de forma correcta dentro de proyectos profesionales gestionados con herramientas como Maven.

### 3.1. Arquitectura de JUnit 5

JUnit 5 se compone de tres módulos principales: *Platform*, *Jupiter* y *Vintage*.

La **JUnit Platform** actúa como base de ejecución. Es la capa que permite lanzar pruebas desde el IDE, desde Maven o desde otras herramientas de integración continua. No contiene tests en sí misma, sino la infraestructura que los ejecuta.

**JUnit Jupiter** es el módulo que implementa el nuevo modelo de programación y las anotaciones modernas como `@Test`, `@BeforeEach` o `@ParameterizedTest`. Es el componente que se utiliza en proyectos actuales.

**JUnit Vintage** permite ejecutar pruebas escritas con versiones anteriores de JUnit. Su uso está orientado a proyectos heredados y no es necesario en desarrollos nuevos.

Esta separación modular facilita la evolución del framework y permite integrar distintos motores de ejecución bajo una misma plataforma.

### 3.2. Estructura de proyecto con Maven

En proyectos gestionados con Maven, las pruebas unitarias se ubican en una estructura diferenciada del código principal. La convención estándar establece dos directorios:

- `src/main/java` para el código productivo.
- `src/test/java` para el código de pruebas.

Esta separación no es únicamente organizativa. Maven compila ambos conjuntos de código en fases distintas y ejecuta automáticamente las pruebas durante la fase `test`.

La dependencia habitual para trabajar con JUnit 5 se declara con alcance `test`, lo que indica que solo es necesaria durante la compilación y ejecución de pruebas, pero no forma parte del artefacto final generado.

Cuando se ejecuta el comando:

```bash
mvn test
```

Maven compila el código, compila las pruebas y ejecuta todas las clases que siguen la convención de test. Si alguna prueba falla, la construcción del proyecto se detiene, lo que convierte las pruebas en un mecanismo de control automático de calidad.

### 3.3. Anotaciones principales

Las anotaciones definen el comportamiento de los métodos dentro de una clase de prueba. Indican al motor de ejecución qué métodos deben considerarse tests y cómo debe gestionarse el ciclo de vida de cada uno.

Para ilustrar su uso, se utilizará la siguiente clase sencilla:

```java
public class Contador {

    private int value = 0;

    public void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }
}
```

#### `@Test`

Marca un método como prueba unitaria. Sin esta anotación, el método no será ejecutado por JUnit.

```java
@Test
void incrementar_devuelve1_siValorInicial0() {
    Contador contador = new Contador();
    contador.increment();
    assertEquals(1, contador.getValue());
}
```

Cada método anotado con `@Test` debe verificar un comportamiento concreto y ser independiente del resto.

#### `@BeforeEach` y `@AfterEach`

Permiten definir métodos que se ejecutan antes y después de cada prueba respectivamente. Son útiles cuando varias pruebas necesitan un estado inicial común.

```java
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ContadorTest {

    private Contador contador;

    @BeforeEach
    void inicializarContador() {
        contador = new Contador();
    }

    @AfterEach
    void liberarContador() {
        contador = null;
    }

    @Test
    void contador_devuelve0_siEstadoInicial() {
        assertEquals(0, contador.getValue());
    }

    @Test
    void contador_devuelve1_siSeIncrementaUnaVez() {
        contador.increment();
        assertEquals(1, contador.getValue());
    }
}
```

En este ejemplo, el contador se inicializa antes de cada test, garantizando independencia entre ejecuciones.

#### `@BeforeAll` y `@AfterAll`

Se ejecutan una única vez por clase de prueba. Resultan útiles cuando la inicialización es costosa.

```java
@BeforeAll
static void iniciarTodo() {
    System.out.println("Inicio de la batería de pruebas");
}

@AfterAll
static void finalizarTodo() {
    System.out.println("Fin de la batería de pruebas");
}
```

Estos métodos deben ser estáticos en el ciclo de vida por defecto de JUnit 5.

#### `@Disabled`

Permite desactivar temporalmente una prueba sin eliminarla.

```java
@Disabled("Pendiente de refactorización")
@Test
void reiniciarContador_devuelve0_siSeRestablece() {
    // Implementación futura
}
```

Esta anotación es útil cuando un comportamiento está en revisión pero no se desea perder la estructura del test.

El uso adecuado de estas anotaciones garantiza independencia entre pruebas y un control preciso del ciclo de ejecución.

### 3.4. Assertions más utilizadas

Las *assertions* constituyen el mecanismo de verificación dentro de una prueba. Permiten comparar el resultado obtenido con el resultado esperado y determinar si el comportamiento es correcto.

#### `assertEquals`

Se utiliza cuando se desea comparar valores esperados y reales.

```java
@Test
void sumar_devuelve5_si2Mas3() {
    Calculadora calculadora = new Calculadora();
    assertEquals(5, calculadora.add(2, 3));
}
```

#### `assertTrue` y `assertFalse`

Se emplean para validar condiciones booleanas.

```java
@Test
void esMayorDeEdad_devuelveValorCorrecto_siEdad20Y15() {
    ValidadorEdad validator = new ValidadorEdad();
    assertTrue(validator.isAdult(20));
    assertFalse(validator.isAdult(15));
}
```

#### `assertNull` y `assertNotNull`

Permiten verificar referencias que pueden estar inicializadas o no.

```java
@Test
void buscarPorId_devuelveNull_siUsuarioNoExiste() {
    RepositorioUsuario repository = new RepositorioUsuario();
    assertNull(repository.findById(999));
}
```

#### `assertThrows`

Se utiliza para comprobar que un método lanza una excepción específica.

```java
@Test
void esMayorDeEdad_lanzaExcepcion_siEdadInvalida() {
    ValidadorEdad validator = new ValidadorEdad();
    assertThrows(IllegalArgumentException.class, () -> validator.isAdult(-1));
}
```

Una comprobación (`assertion`) no solo detecta fallos; también documenta el comportamiento esperado. Cuando las verificaciones son claras y específicas, las pruebas actúan como especificación ejecutable del sistema.

### 3.5. Organización y nomenclatura de clases de prueba

La convención más extendida establece que la clase de prueba tenga el mismo nombre que la clase productiva seguida del sufijo `Test`. Por ejemplo, si existe una clase `Calculadora`, su prueba será `CalculadoraTest`.

Esta convención permite que herramientas como *Maven* y los IDE identifiquen automáticamente qué clases deben ejecutarse durante la fase de pruebas, integrándose sin configuración adicional en el ciclo de construcción del proyecto.

En **JUnit 5**, el reconocimiento de métodos de prueba se basa exclusivamente en la anotación `@Test`, no en el nombre del método. Por tanto, ya no es necesario utilizar el prefijo `test` ni mantener convenciones heredadas de versiones anteriores del framework.

En el ecosistema Java moderno se emplea nomenclatura en *camelCase* descriptivo. El objetivo no es reflejar el nombre técnico del método probado, sino expresar con claridad el comportamiento verificado.

Ejemplos habituales:

`total_devuelve0_siListaVacia`
`esMayorDeEdad_lanzaExcepcion_siEdadNegativa`
`calcularTotal_devuelve0_siListaVacia`

Los nombres deben describir el comportamiento esperado, no la implementación interna. Una buena práctica consiste en que el método de prueba pueda leerse casi como una frase.

El uso de nombres expresivos convierte las pruebas en **documentación ejecutable**. Un desarrollador debe poder comprender qué comportamiento se valida sin necesidad de analizar el cuerpo del test.

Mantener coherencia en la nomenclatura dentro del proyecto es más importante que la elección de un patrón concreto, siempre que este sea descriptivo y esté alineado con las convenciones generales del lenguaje Java.

---

## 4. Elementos avanzados de testing

Una vez dominados los fundamentos de las pruebas unitarias, es necesario incorporar técnicas que permitan ampliar la cobertura funcional sin aumentar innecesariamente la complejidad del código de pruebas.

Los elementos avanzados no implican escribir más tests, sino escribirlos de forma más eficiente, más expresiva y mejor alineada con escenarios reales.

### 4.1. Pruebas parametrizadas

En muchos casos, un mismo comportamiento debe validarse con múltiples conjuntos de datos. Escribir un método de prueba distinto para cada combinación genera duplicación innecesaria y dificulta el mantenimiento.

Las pruebas parametrizadas permiten ejecutar el mismo test con diferentes valores de entrada. En JUnit 5 se utilizan anotaciones como `@ParameterizedTest` junto con fuentes de datos como `@ValueSource` o `@CsvSource`.

Para ilustrarlo, considérese la siguiente clase:

```java
public class UtilidadesNumero {

    public boolean isPositive(int number) {
        return number > 0;
    }
}
```

Sin pruebas parametrizadas, podrían escribirse varios métodos casi idénticos para distintos valores. Con `@ParameterizedTest`, el mismo comportamiento puede verificarse de forma más estructurada.

#### Ejemplo con `@ValueSource`

```java
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UtilidadesNumeroTest {

    private UtilidadesNumero utils = new UtilidadesNumero();

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 100})
    void esPositivo_devuelveTrue_paraNumerosPositivos_parametrizado(int number) {
        assertTrue(utils.isPositive(number));
    }
}
```

En este caso, el mismo test se ejecuta tres veces, una por cada valor definido en la anotación.

#### Ejemplo con `@CsvSource`

Las pruebas parametrizadas también permiten verificar relaciones entre entradas y salidas esperadas.

```java
@ParameterizedTest
@CsvSource({
    "1, true",
    "0, false",
    "-5, false"
})
void esPositivo_devuelveResultadoEsperado_paraMultiplesEntradas_csv(int input, boolean expected) {
    UtilidadesNumero utils = new UtilidadesNumero();
    assertEquals(expected, utils.isPositive(input));
}
```

Aquí se definen pares entrada–resultado esperado. El test se ejecuta automáticamente para cada línea del `CsvSource`.

Las pruebas parametrizadas son especialmente útiles cuando se valida un mismo algoritmo con diferentes entradas, se prueban límites numéricos o se verifican reglas repetitivas. Su uso adecuado mejora la claridad del código de prueba y reduce duplicación innecesaria.

### 4.2. Validación de excepciones

Un diseño robusto no solo contempla resultados correctos, sino también el manejo adecuado de errores. En muchos métodos, lanzar una excepción forma parte del contrato del sistema.

JUnit 5 permite validar excepciones mediante `assertThrows`. Esta assertion verifica que un bloque de código produce una excepción concreta.

No basta con que el código falle; debe fallar de la manera esperada. Por ello, es habitual comprobar también el mensaje asociado a la excepción cuando forma parte del contrato funcional.

Validar excepciones permite garantizar que:

- Se aplican correctamente reglas de validación.
- No se aceptan estados inconsistentes.
- Los errores se comunican de forma controlada.

Las pruebas de excepciones fortalecen la fiabilidad del sistema frente a entradas inválidas o situaciones anómalas.

### 4.3. Aislamiento de dependencias y concepto de mock

Una prueba unitaria debe evaluar una unidad de manera aislada. Sin embargo, muchas clases dependen de otras clases o servicios externos.

Cuando una unidad depende directamente de una base de datos, un servicio web o un sistema externo, la prueba deja de ser puramente unitaria y pasa a depender de factores que no están bajo control del test.

Considérese el siguiente ejemplo:

```java
public interface PasarelaPago {
    boolean processPayment(double amount);
}
```

```java
public class ServicioPedido {

    private PasarelaPago pasarelaPago;

    public ServicioPedido(PasarelaPago pasarelaPago) {
        this.pasarelaPago = pasarelaPago;
    }

    public boolean placeOrder(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Importe inválido");
        }
        return pasarelaPago.processPayment(amount);
    }
}
```

La clase `ServicioPedido` depende de `PasarelaPago`. Si `PasarelaPago` se conectara a un sistema real de pagos, no sería adecuado usarlo directamente en una prueba unitaria.

Para mantener el aislamiento se utilizan *mocks*, que son objetos simulados que imitan el comportamiento de dependencias reales. Un mock permite definir qué debe devolver un método sin ejecutar la lógica real del componente externo.

Con Mockito, el test podría escribirse de la siguiente forma:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServicioPedidoTest {

    @Test
    void realizarPedido_devuelveTrue_siPagoCorrecto() {

        PasarelaPago mockGateway = mock(PasarelaPago.class);
        when(mockGateway.processPayment(100.0)).thenReturn(true);

        ServicioPedido service = new ServicioPedido(mockGateway);

        boolean result = service.placeOrder(100.0);

        assertTrue(result);
        verify(mockGateway).processPayment(100.0);
    }
}
```

En este ejemplo:

- Se crea un objeto simulado de `PasarelaPago`.
- Se define que, cuando se procese el pago de 100.0, debe devolver `true`.
- No se ejecuta ningún sistema real de pagos.
- Se verifica que el método ha sido invocado correctamente.

El uso de mocks permite aislar la unidad bajo prueba y controlar completamente el entorno de ejecución. De esta forma, el test valida únicamente la lógica de `ServicioPedido`, no el comportamiento del sistema de pagos.

El diseño orientado a interfaces y la inyección de dependencias facilitan enormemente el uso de mocks y mejoran la testabilidad del sistema.

### 4.4. Cobertura de código

La **cobertura de código** mide qué porcentaje del sistema ha sido ejecutado durante la ejecución de las pruebas. Herramientas como *JaCoCo* permiten generar informes automáticos que indican qué líneas, ramas o métodos han sido recorridos.

Es fundamental comprender que **cobertura no equivale a calidad**.

Un porcentaje alto de cobertura no garantiza que las pruebas sean significativas. Es posible ejecutar gran parte del código sin verificar realmente comportamientos relevantes o reglas de negocio críticas.

Existen distintos tipos de cobertura:

- Cobertura de líneas.
- Cobertura de ramas.
- Cobertura de métodos.

En un contexto profesional, la cobertura debe interpretarse como un **indicador orientativo**, no como un objetivo absoluto. Perseguir el 100 % puede conducir a escribir pruebas artificiales cuyo único propósito sea aumentar la métrica.

La meta adecuada consiste en proteger comportamientos críticos, decisiones condicionales relevantes y puntos sensibles del sistema, manteniendo un equilibrio entre rigor técnico y eficiencia del desarrollo.

---

## 5. Testing y calidad del software

Las pruebas no son un añadido posterior al desarrollo, sino un **mecanismo estructural de garantía de calidad**. Un sistema sin pruebas automatizadas depende de la memoria y disciplina individual. En cambio, un sistema con una batería sólida de pruebas convierte la calidad en una propiedad verificable y repetible.

### 5.1. Relación entre testing y refactorización

La *refactorización* consiste en modificar la estructura interna del código sin alterar su comportamiento externo. Para realizarla con seguridad es imprescindible disponer de pruebas automatizadas que actúen como **red de protección**.

Cuando se reorganizan responsabilidades, se simplifican métodos o se extraen nuevas clases, las pruebas existentes permiten comprobar que el comportamiento funcional permanece intacto. Si alguna prueba falla tras la modificación, indica que el comportamiento ha cambiado o que se ha introducido un error.

Sin pruebas, la refactorización es una actividad arriesgada. Con pruebas, se convierte en una práctica segura que mejora cohesión, reduce acoplamiento y favorece la mantenibilidad.

En este sentido, el testing no solo detecta errores: **habilita la mejora continua del diseño**.

### 5.2. Desarrollo guiado por pruebas (TDD)

El *Desarrollo guiado por pruebas* (TDD) es una estrategia en la que las pruebas se escriben antes que el código productivo.

El ciclo clásico se resume en tres fases:

- **Red**: se escribe una prueba que falla.
- **Green**: se implementa el código mínimo necesario para que la prueba pase.
- **Refactor**: se mejora el diseño manteniendo las pruebas en verde.

Este enfoque obliga a definir primero el comportamiento esperado. El desarrollador trabaja a partir de una especificación ejecutable y no únicamente desde la implementación.

TDD no implica escribir más pruebas, sino **cambiar el orden del proceso mental**. La prueba actúa como contrato funcional desde el inicio.

Aunque no todos los proyectos requieren TDD estricto, comprender su filosofía ayuda a desarrollar software con mayor claridad estructural y menor acoplamiento.

### 5.3. Errores frecuentes en la escritura de tests

Al comenzar a trabajar con pruebas unitarias es habitual cometer errores que reducen su eficacia.

Uno de los más frecuentes es escribir tests que verifican múltiples comportamientos en un único método. Cuando la prueba falla, resulta difícil identificar la causa exacta.

Otro problema común es compartir estado entre pruebas. Si un test depende del resultado de otro, la batería pierde independencia y confiabilidad.

También es problemático escribir pruebas excesivamente acopladas a la implementación interna. Si el diseño cambia pero el comportamiento externo se mantiene, las pruebas no deberían fallar.

Finalmente, se observan tests triviales que verifican *getters* o *setters* sin lógica asociada. Aunque incrementan la cobertura, no protegen comportamientos relevantes.

Un buen test debe centrarse en el **comportamiento observable**, no en detalles internos irrelevantes.

### 5.4. Nivel adecuado de cobertura y valor real de las pruebas

La cobertura de código indica qué partes del sistema han sido ejecutadas durante las pruebas, pero no garantiza por sí sola calidad.

Es posible alcanzar porcentajes elevados sin validar adecuadamente reglas de negocio críticas. Ejecutar una línea no implica verificar todos los escenarios relevantes asociados a ella.

El objetivo no debe ser alcanzar el 100 %, sino proteger:

- Comportamientos críticos.
- Decisiones condicionales relevantes.
- Escenarios con impacto funcional significativo.

Una cobertura razonable, combinada con pruebas significativas, aporta mayor valor que una cobertura perfecta basada en tests superficiales.

La calidad real de una batería de pruebas se mide por su **capacidad para detectar regresiones**, no por un porcentaje aislado.

---

## 6. Integración con el entorno de desarrollo

Las pruebas unitarias forman parte del **flujo habitual de trabajo**. No deben ejecutarse de manera esporádica, sino integrarse en el ciclo diario de desarrollo como mecanismo continuo de verificación.

El testing deja de ser una actividad puntual y pasa a convertirse en una práctica recurrente dentro del entorno de desarrollo.

### 6.1. Ejecución desde el IDE

Los entornos de desarrollo modernos permiten ejecutar pruebas directamente desde el editor, lo que facilita una retroalimentación inmediata.

Es posible:

- Ejecutar una prueba individual.
- Ejecutar todas las pruebas de una clase.
- Ejecutar la batería completa del proyecto.

El IDE muestra los resultados de forma visual, diferenciando claramente entre pruebas superadas y fallidas. Esta respuesta inmediata favorece un ciclo de desarrollo rápido basado en pequeñas modificaciones y validaciones constantes.

La ejecución frecuente desde el IDE permite detectar errores en fases tempranas y reduce la probabilidad de acumular fallos antes de integrar cambios.

### 6.2. Integración con Maven

En proyectos gestionados con Maven, las pruebas se ejecutan automáticamente durante la fase `test`.

El comando:

```bash
mvn test
```

compila el código principal, compila las pruebas y ejecuta todas las clases de test detectadas según las convenciones establecidas.

Si alguna prueba falla, el proceso se detiene y el proyecto no se considera correctamente construido. De este modo, las pruebas se convierten en un **mecanismo automático de control de calidad**.

En entornos profesionales, esta ejecución se integra habitualmente en sistemas de *integración continua*, donde cada envío al repositorio activa automáticamente la batería de pruebas. El resultado deja de depender de comprobaciones manuales y pasa a estar automatizado.

### 6.3. Organización profesional del repositorio

Una organización coherente del proyecto facilita su mantenibilidad y comprensión.

El código productivo debe ubicarse en `src/main/java`, mientras que las pruebas deben situarse en `src/test/java`, replicando la misma estructura de paquetes. Esta simetría permite localizar rápidamente la prueba asociada a cada clase.

Por ejemplo:

```text
src/main/java/com/example/service/ServicioPedido.java
```

Debe tener su equivalente en:

```text
src/test/java/com/example/service/ServicioPedidoTest.java
```

Mantener esta correspondencia estructural refuerza la relación entre código y pruebas. Además, los tests deben versionarse junto al código productivo, ya que forman parte integral del sistema y no constituyen documentación externa.

### 6.4. Limitaciones técnicas de las pruebas unitarias

Las pruebas unitarias no sustituyen todos los niveles de verificación existentes en un sistema.

No están diseñadas para validar:

- Interacciones complejas entre múltiples componentes.
- El comportamiento real de una base de datos.
- Integraciones completas con sistemas externos en producción.

Para estos escenarios existen otros niveles de prueba, como las *pruebas de integración*, las *pruebas de sistema* o las *pruebas de aceptación*.

Las pruebas unitarias deben centrarse en unidades aisladas y comportamientos específicos. Comprender sus límites evita utilizarlas de forma inapropiada y permite mantener una estrategia de testing equilibrada.

---

## 7. Análisis crítico y madurez profesional

El dominio técnico de JUnit no es suficiente para considerar que se trabaja con calidad profesional. La madurez en testing implica comprender su propósito dentro del desarrollo de software y aplicar criterios críticos en su uso.

Saber escribir tests es una competencia técnica. Saber **cuándo, cómo y por qué** escribirlos es una competencia profesional.

### 7.1. Testing como cultura de calidad

Más allá de su dimensión técnica, el testing representa una **cultura de trabajo**. En equipos profesionales, las pruebas no se consideran una tarea adicional, sino un componente habitual del desarrollo.

Integrar testing de forma sistemática implica asumir que todo cambio debe ser *verificable*. Las pruebas automatizadas permiten que el conocimiento sobre el comportamiento del sistema no dependa exclusivamente de las personas, sino que quede reflejado en **código ejecutable**.

Esta cultura:

- Reduce la incertidumbre ante modificaciones.
- Favorece la colaboración.
- Mejora la estabilidad del proyecto a medio y largo plazo.

El testing deja de ser una actividad puntual para convertirse en un hábito estructural del equipo.

### 7.2. Cuándo un test no aporta valor

No todas las pruebas son útiles. Un test puede existir y, sin embargo, no aportar valor real.

Un caso típico es el de pruebas que replican exactamente la implementación interna. Si el test verifica detalles privados en lugar del **comportamiento observable**, se vuelve frágil ante cambios de diseño.

También aportan poco valor las pruebas triviales que verifican *getters* y *setters* sin lógica asociada. Aunque incrementan el porcentaje de cobertura, no protegen reglas relevantes.

Otro problema frecuente son los tests excesivamente complejos que requieren gran cantidad de configuración para validar algo mínimo. Cuando el coste de mantenimiento de la prueba supera su utilidad, el diseño debe revisarse.

Un test aporta valor cuando:

- Detecta errores significativos.
- Protege comportamientos críticos.
- Facilita la evolución segura del código.

### 7.3. Balance entre velocidad y cobertura

Las pruebas unitarias deben ser **rápidas**. Una batería que tarda demasiado en ejecutarse tiende a utilizarse con menor frecuencia, lo que reduce su efectividad.

Al mismo tiempo, la cobertura debe ser suficiente para proteger las partes críticas del sistema.

Existe un equilibrio necesario:

- Demasiada cobertura con pruebas superficiales no garantiza calidad.
- Muy pocas pruebas reducen la seguridad ante cambios.

El objetivo razonable consiste en cubrir reglas de negocio, decisiones condicionales importantes y comportamientos con impacto funcional, manteniendo tiempos de ejecución reducidos.

La calidad no se mide únicamente en porcentaje de cobertura, sino en la **capacidad real de las pruebas para detectar regresiones**.

### 7.4. Testing en trabajo colaborativo

En proyectos colaborativos, el testing adquiere una dimensión adicional.

Cuando varios desarrolladores trabajan sobre el mismo repositorio, cada modificación puede afectar a código ajeno. Las pruebas automatizadas permiten verificar automáticamente que los cambios no rompen funcionalidades existentes.

En procesos basados en control de versiones y *pull requests*, la ejecución automática de pruebas actúa como filtro de calidad. Un cambio que provoca fallos en la batería de tests no debería integrarse hasta corregirse.

El testing también mejora la comunicación dentro del equipo. Las pruebas expresan de forma ejecutable qué comportamiento se espera de cada componente, reduciendo ambigüedades.

En este contexto, el testing no es solo una herramienta técnica, sino un **mecanismo de coordinación y confianza compartida**.

---

## 8. Síntesis estructural de la unidad

La verificación automatizada mediante pruebas unitarias constituye un pilar esencial en el desarrollo moderno de software.

A lo largo de la unidad se han abordado:

- El concepto y propósito de las pruebas unitarias.
- El diseño riguroso de casos de prueba.
- El uso técnico de JUnit 5.
- Elementos avanzados como pruebas parametrizadas y mocks.
- La relación entre testing, calidad y refactorización.
- La integración con herramientas de desarrollo.
- El análisis crítico del valor real de las pruebas.

Las pruebas unitarias no sustituyen otros niveles de testing, pero proporcionan la base sobre la que se construye un sistema robusto y evolutivo.

Comprender su fundamento técnico y su dimensión profesional permite utilizarlas no como un requisito formal, sino como una práctica habitual de desarrollo responsable.
