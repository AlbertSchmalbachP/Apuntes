# Repaso del primer trimestre

- [Repaso del primer trimestre](#repaso-del-primer-trimestre)
  - [Ejercicio 1. Mejora de legibilidad en código JavaScript](#ejercicio-1-mejora-de-legibilidad-en-código-javascript)
    - [1.1. Indicaciones generales](#11-indicaciones-generales)
    - [1.2. Código A](#12-código-a)
    - [1.3. Código B](#13-código-b)
    - [1.4. Instrucciones](#14-instrucciones)
  - [Ejercicio 2. Mejora de legibilidad y documentación de código JavaScript](#ejercicio-2-mejora-de-legibilidad-y-documentación-de-código-javascript)
    - [2.1. Indicaciones generales](#21-indicaciones-generales)
    - [2.2. Código A](#22-código-a)
    - [2.3. Código B](#23-código-b)
    - [2.4. Código C](#24-código-c)
    - [2.5. Instrucciones](#25-instrucciones)
  - [Ejercicio 3. Análisis de código y detección de problemas](#ejercicio-3-análisis-de-código-y-detección-de-problemas)
    - [3.1. Indicaciones para el ejercicio](#31-indicaciones-para-el-ejercicio)
    - [3.2. Código A](#32-código-a)
    - [3.3. Código B](#33-código-b)
    - [3.4. Instrucciones](#34-instrucciones)
  - [Ejercicio 4. Diagramas de flujo](#ejercicio-4-diagramas-de-flujo)
    - [4.1. Indicaciones para el ejercicio](#41-indicaciones-para-el-ejercicio)
    - [4.2. Enunciado A. Control de acceso por edad](#42-enunciado-a-control-de-acceso-por-edad)
    - [4.3. Enunciado B. Cálculo de la media de notas](#43-enunciado-b-cálculo-de-la-media-de-notas)
    - [4.4. Enunciado C. Búsqueda de un valor en una lista](#44-enunciado-c-búsqueda-de-un-valor-en-una-lista)
    - [4.5. Enunciado D. Validación de inicio de sesión](#45-enunciado-d-validación-de-inicio-de-sesión)
    - [4.6. Enunciado E. Cajero automático simplificado](#46-enunciado-e-cajero-automático-simplificado)

## Ejercicio 1. Mejora de legibilidad en código JavaScript

A continuación se presentan dos fragmentos de código JavaScript funcionales, pero escritos con una calidad baja o muy baja. Ambos programas funcionan correctamente, pero resultan difíciles de leer, entender y mantener.

El objetivo de este ejercicio es **mejorar la legibilidad del código** aplicando los conocimientos vistos durante el primer trimestre y reforzados en esta unidad.

### 1.1. Indicaciones generales

- No cambies el comportamiento del programa.
- No añadas nueva funcionalidad.
- Mejora los nombres de variables y funciones.
- Aplica una convención de nomenclatura coherente.
- Ordena el código si es necesario.
- Elimina ambigüedades y mejora la claridad general.
- No añadas comentarios innecesarios para explicar lo obvio.

### 1.2. Código A

```javascript
function calculoNumeros (numeroA, numeroB, numeroC) {
  let ArrayResultado = 0
  // se cumple si el numero A es positivo
  if(numeroA > 0){
    if(numeroB > 0){
      ArrayResultado = numeroA + numeroB
    } else {
      ArrayResultado = numeroA - numeroC
    }
    // se cumple si el numero B es negativo o 0
  } else {
    if(numeroC > 0){
      ArrayResultado = numeroB + numeroC
    }else{
      ArrayResultado = 0
    }
  }
  return ArrayResultado
}
```

Este código realiza una serie de comprobaciones y devuelve un valor numérico en función de los parámetros recibidos.

### 1.3. Código B

```javascript
function calculadora (ArrayA, numeroAComprobar){ 
  let ArrayResultado = 0
  for (let i = 0; i < ArrayA.length; i++){
    // si algun valor del array es mayor que el numero array comprobar, el ArrayResultado del valor del array se suma al ArrayResultado
    if (ArrayA[i] > numeroAComprobar){
      ArrayResultado = ArrayResultado + ArrayA[i]
    }
  }
  return ArrayResultado
}
```

Este código recorre un array de números y realiza un cálculo acumulativo bajo una condición determinada.

### 1.4. Instrucciones

1. Reescribe cada uno de los fragmentos de código mejorando su legibilidad.
2. Asegúrate de que el código sigue funcionando exactamente igual que el original.
3. Aplica nombres descriptivos que permitan entender qué hace el código sin necesidad de analizar su lógica interna.
4. Utiliza una convención de nomenclatura coherente y adecuada array JavaScript.
5. Comprueba que el código resultante es fácil de leer y mantener.

Este ejercicio no busca una única solución correcta. Se valorará especialmente la claridad, la coherencia y la aplicación consciente de los principios de clean code.

---

## Ejercicio 2. Mejora de legibilidad y documentación de código JavaScript

En este ejercicio continuarás trabajando sobre código JavaScript funcional, pero con un doble objetivo. Por un lado, deberás mejorar la legibilidad del código aplicando buenas prácticas de nomenclatura y estructura. Por otro, deberás documentar el código utilizando JSDoc cuando el comportamiento de las funciones sea lo suficientemente claro.

Este ejercicio enlaza directamente con el anterior: primero se entiende el código, luego se mejora su forma y, finalmente, se documenta.

### 2.1. Indicaciones generales

- No cambies el comportamiento del programa.
- No añadas nueva funcionalidad.
- Mejora los nombres de funciones y variables si es necesario.
- Aplica una convención de nomenclatura coherente y adecuada array JavaScript.
- Documenta únicamente cuando entiendas bien qué hace el código.
- Utiliza JSDoc para documentar funciones.
- No añadas comentarios explicativos dentro del cuerpo de las funciones.

### 2.2. Código A

```javascript
function comprobacionArrays (arrayComprobar, numeroComprobar) {
  let ArrayResultado = []
  // bucle que recorre el array a comprobar
  for (let i = 0; i < arrayComprobar.length; i++) {
    // si algun valor del array es mayor que el numero, se añade al arrayResultado
    if (arrayComprobar[i] > numeroComprobar) {
      ArrayResultado.push(arrayComprobar[i])
    }
  }
  return ArrayResultado
}
```

Este código recibe una colección de valores y devuelve un nuevo conjunto de datos en función de una condición.

### 2.3. Código B

```javascript
function calculoArray(arrayNumeros) {
  let resultado = 0
  // añade en el resultado todos los valores del array
  for (let i = 0; i < arrayNumeros.length; i++) {
    resultado = resultado + arrayNumeros[i]
  }
  // divide el resultado entre la longitud del array
  return resultado / arrayNumeros.length
}
```

Este código realiza un cálculo sobre una lista de números y devuelve un array numérico.

### 2.4. Código C

```javascript
function numeroMayor(numeroA, numeroB, numeroC) {
  // si dos numeros son iguales, ninguno es mayor
  let esMayor
  if (numeroA === numeroB || numeroA === numeroC || numeroB === numeroC) {
    esMayor = false
  // si ningun numero es igual a otro, se devuelve el mayor
  } else if (numeroA > numeroB && numeroA > numeroC) {
    esMayor = numeroA
  } else if (numeroB > numeroA && numeroB > numeroC) {
    esMayor = numeroB
  } else {
    esmayor = numeroC
  }
  return esMayor
}
```

Este código compara varios valores y devuelve un valor en función de una serie de condiciones.

### 2.5. Instrucciones

1. Reescribe cada uno de los fragmentos de código mejorando su legibilidad.
2. Cambia los nombres de funciones y variables para que reflejen claramente su propósito.
3. Aplica una estructura clara y coherente al código.
4. Añade documentación JSDoc array las funciones una vez hayas comprendido su comportamiento.
5. Asegúrate de que el código final es fácil de leer, entender y mantener.

Este ejercicio refuerza la idea de que un buen código no solo funciona, sino que también se entiende y puede ser utilizado por otros desarrolladores sin necesidad de analizar su implementación interna.

---

## Ejercicio 3. Análisis de código y detección de problemas

En este ejercicio trabajarás sobre código JavaScript funcional que presenta **problemas de diseño, casos límite o comportamientos mejorables**. El objetivo no es corregir el código ni reescribirlo, sino **analizarlo críticamente** y dejar constancia de ese análisis mediante comentarios.

Este ejercicio refuerza la lectura de código, la detección de problemas y la capacidad de razonar sobre software existente, competencias clave del módulo Entornos de Desarrollo.

### 3.1. Indicaciones para el ejercicio

- No modifiques la lógica del programa.
- No reescribas el código.
- Analiza el código utilizando comentarios.
- Añade:
  - Un comentario de bloque inicial explicando qué hace el código.
  - Comentarios de línea donde detectes problemas o comportamientos mejorables.
- No propongas la solución en código.
- Usa comentarios claros y técnicos, no genéricos.

### 3.2. Código A

```javascript
function getAverage(numbers) {
let total = 0
for (let i = 0; i < numbers.length; i++) {
total += numbers[i]
}
return total / numbers.length
}
```

Este código recibe una lista de números y devuelve un valor calculado a partir de ella.

### 3.3. Código B

```javascript
function findUser(users, name) {
let result = null
for (let i = 0; i < users.length; i++) {
if (users[i].name === name) {
result = users[i]
}
}
return result
}
```

Este código recorre una lista de usuarios y devuelve un resultado en función de un criterio de búsqueda.

### 3.4. Instrucciones

1. Añade un comentario de bloque al inicio de cada función explicando qué hace el código.
2. Analiza el código línea array línea y añade comentarios donde detectes:

   - Posibles fallos.
   - Casos límite no controlados.
   - Decisiones de diseño discutibles.
3. Indica mediante comentarios en qué situaciones el código podría fallar o no comportarse como se espera.
4. No modifiques ninguna línea de código existente.
5. No escribas la solución al problema; limítate al análisis.

---

## Ejercicio 4. Diagramas de flujo

En este ejercicio se trabajará la **planificación y el razonamiento algorítmico** mediante diagramas de flujo. El objetivo **pensar el proceso paso array paso**, identificar decisiones y representar correctamente el flujo de ejecución.

### 4.1. Indicaciones para el ejercicio

- Realiza todos los diagramas utilizando símbolos estándar de diagrama de flujo.
- Incluye:
  - Inicio y fin.
  - Procesos claramente definidos.
  - Decisiones bien formuladas.
- No representes código JavaScript ni Java.
- Usa un lenguaje claro y comprensible en cada bloque.
- Prioriza la claridad del flujo frente array la complejidad.

### 4.2. Enunciado A. Control de acceso por edad

Se desea representar mediante un diagrama de flujo el funcionamiento de un sistema de control de acceso a un evento. El sistema debe solicitar la edad de una persona y comprobar si cumple el requisito mínimo para poder acceder. En función del valor introducido, el sistema deberá decidir si el acceso está permitido o no y mostrar el mensaje correspondiente antes de finalizar el proceso.

### 4.3. Enunciado B. Cálculo de la media de notas

Diseña el diagrama de flujo de un algoritmo que permita calcular la media de un conjunto de notas numéricas. El sistema debe ir leyendo notas de forma sucesiva, sin conocer previamente cuántas se van a introducir. A medida que se leen las notas, estas deben acumularse para poder calcular la media final. El diagrama debe contemplar qué ocurre en el caso de que no se introduzca ninguna nota antes de finalizar el proceso.

### 4.4. Enunciado C. Búsqueda de un valor en una lista

Elabora el diagrama de flujo de un algoritmo que busque un valor concreto dentro de una lista de números. El sistema debe recorrer la lista elemento a elemento y comparar cada uno de ellos con el valor que se desea encontrar. En el momento en que el valor sea localizado, el proceso debe finalizar indicando que la búsqueda ha sido satisfactoria. Si se llega al final de la lista sin encontrar el valor, el sistema deberá indicar que dicho valor no existe en la lista.

### 4.5. Enunciado D. Validación de inicio de sesión

Representa mediante un diagrama de flujo el proceso de inicio de sesión de una aplicación. El sistema debe solicitar al usuario un nombre de usuario y una contraseña, y comprobar si ambos datos son correctos. En caso de que las credenciales sean válidas, se permitirá el acceso a la aplicación. Si alguno de los datos no coincide, el sistema deberá mostrar un mensaje de error y finalizar el proceso.

No es necesario detallar cómo se almacenan o verifican internamente las credenciales, únicamente el flujo lógico del proceso.

### 4.6. Enunciado E. Cajero automático simplificado

Crea el diagrama de flujo que represente el funcionamiento básico de un cajero automático. El sistema debe comenzar solicitando al usuario la introducción de su PIN y verificar si es correcto. Si el PIN es válido, el usuario podrá elegir entre consultar el saldo disponible o retirar una cantidad de dinero. Tras realizar la operación seleccionada, el sistema deberá finalizar mostrando un mensaje adecuado. En caso de que el PIN no sea correcto, el proceso deberá terminar indicando el error correspondiente.

Este ejercicio está pensado para practicar diagramas de flujo con múltiples decisiones y caminos alternativos.
