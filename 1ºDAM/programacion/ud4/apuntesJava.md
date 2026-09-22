# Apuntes Java

## ArrayList

Para utilizar un Array en Java, de momento, usamos ArrayList.

```java
ArrayList<String> titulos = new ArrayList<String>(Arrays.asList("1983", "La casa de Bernarda Alba", "Poeta en Nueva York", "Fahrenheit 451", "Nada"));
```

**Arrays.asList** es otra función que nos permite añadir valores al array directamente al crear este.
Antes de usar ArrayList y la función .aslist, deberemos **importarlos**:

```java
import java.util.ArrayList;
import java.util.Arrays;
```

### Métodos de ArrayList

#### Añadir un item (add)

```java
secuencia.add(2); // añade el numero 2 al array secuencia
```

#### Obtener un item (get)

```java
temp = numero.get(0); // obtiene el item de posición 0 y lo guarda en una variable temporal. El item ha sido copaido, es decir, el original sigue en el array
```

#### Colocar un item (set)

```java
numero.set(2, temp); // copia el elemento del array temporal a la posición 2 del array
```

#### Eliminar un item (remove)

```java
numero.remove(4); // elimina el elemento del array en la posición 4
```

## Escáneres (Scanner)

En Java, para poder leer el imput del usuario, necesitaremos usar los escáneres.

```java
Scanner scanner1 = new Scanner(System.in); // crear escáner (debe ser dentro del main)
variableAsignar = scanner1.nextLine(); // leer un System.out, en este caso un String
variableAsignar = scanner1.nextInt(); // otro ejemplo para un entero (int)
Scanner1.close(); // cerrar el escáner
```

Antes de crear un escaner, debermos importar el util de Java usando:

```java
import java.util.Scanner;
```

### Limpiar el buffer

Limpiamos el buffer cuando **pasamos de escanear un tipo primitivo (como int) a escanear un String**, además de cuando el usuario introduce un valor no válido.
Esto lo hacemos ya que el buffer almacena la acción de presionar intro (\n).

```java
System.out.print("Introduce una opción:");
opcion = scanner1.nextInt();
scanner1.nextLine();
```

En este ejemplo debemos limpiar el buffer, ya que si no el programa se saltaría el siguiente *scanner1.nextLine()*.

## length, length(), size()

En JavaScript, utilizabamos **length** para determinar la longitud de una variable. En java, dependiendo del tipo de dato, utilizamos una de estas:

```java
length -- arrays (int[], double[], String[]) -- to know the length of the arrays

length() -- String related Object (String, StringBuilder, etc) -- to know the length of the String

size() -- Collection Object (ArrayList, Set, etc) -- to know the size of the Collection 
// recuerda que de momento solo usamos ArrayList, por lo que para un Array deberemos usar size()
```

## Función .equals()

```java
Integer a = 128;
Integer b = 128;

System.out.println(a == b);       // false
System.out.println(a.equals(b));  // true
```

En el ejemplo de arriba, "a" y "b" son iguales debido al Integer Canche del tipo Integer ([echale un vistazo a esto](https://medium.com/tuanhdotnet/integer-caching-in-java-how-it-works-and-why-it-matters-cd6f09c53728))

Equals se usa solo para tipos **NO PRIMITIVOS**, como **Strings**, en los demás casos de usa == o ===
