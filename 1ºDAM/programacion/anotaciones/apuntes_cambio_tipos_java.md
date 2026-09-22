# 📘 Cambio de tipos en Java (Casting y conversiones)

En Java, el **cambio de tipos** permite convertir datos de un tipo a otro. Es fundamental para trabajar con operaciones matemáticas, entrada de datos y manipulación de valores.

---

## 1. Tipos de datos en Java

### 🔹 Tipos primitivos
- Enteros: `byte`, `short`, `int`, `long`
- Decimales: `float`, `double`
- Caracteres: `char`
- Booleanos: `boolean`

### 🔹 Tipos no primitivos (referencia)
- `String`
- Clases envoltorio: `Integer`, `Double`, `Float`, etc.
- Arrays, objetos, etc.

---

## 2. Conversión implícita (automática)

Ocurre cuando:
> Se convierte un tipo **más pequeño** en uno **más grande o más preciso**.

✔️ No requiere casting.

Ejemplo:
```java
int numero = 5;
double resultado = numero;  // 5 → 5.0
```

Otros ejemplos válidos:
```java
int → long
int → double
float → double
char → int
```

---

## 3. Conversión explícita (casting)

Se utiliza cuando:
> Se convierte un tipo **más grande** a uno **más pequeño**.

⚠️ Puede provocar pérdida de información.

Ejemplo:
```java
double numero = 10.70;
int entero = (int) numero;   // Resultado: 10 (no redondea, trunca)
```

Otro ejemplo:
```java
int resultado = (int) 5.9;   // resultado = 5
```

---

## 4. Conversión entre tipos primitivos

| De        | A        | ¿Necesita casting? |
|----------|----------|----------------------|
| int      | double   | ❌ No |
| double   | int      | ✔️ Sí |
| float    | double   | ❌ No |
| long     | int      | ✔️ Sí |
| char     | int      | ❌ No |
| int      | char     | ✔️ Sí |

Ejemplo:
```java
char letra = 'A';
int codigo = letra; // 65 (valor ASCII)
```

---

## 5. Conversión entre String y números

### 🔹 De String a número

Se usan los métodos de las clases envoltorio:

```java
String texto = "7";

int numero = Integer.parseInt(texto);
double decimal = Double.parseDouble(texto);
float flotante = Float.parseFloat(texto);
```

⚠️ Si el String no contiene un número válido → `NumberFormatException`.

Ejemplo incorrecto:
```java
Integer.parseInt("hola"); // ERROR
```

---

### 🔹 De número a String

Formas correctas:

```java
int numero = 7;

String texto = String.valueOf(numero);
```

También válido (pero menos recomendable):
```java
String texto = numero + "";
```

---

## 6. Ejemplo completo práctico

```java
public class TransformarTipos {
    public static void main(String[] args) {
        
        double numeroConDecimales = 10.70;
        int numeroSinDecimales = (int) numeroConDecimales; // Trunca → 10

        double division = 5.0 / 2; // Resultado: 2.5

        String numero = "7";

        division = Integer.parseInt(numero) / 2; // 7 / 2 = 3 (int)
        division = Double.parseDouble(numero) / 2; // 7.0 / 2 = 3.5

        numero = String.valueOf(7);
        numero = 7 + "";

        System.out.println(numero);
    }
}
```

---

## 7. Errores típicos a evitar

❌ Dividir enteros esperando decimales:
```java
double resultado = 5 / 2; // Resultado: 2.0 ❌
```

✔️ Solución:
```java
double resultado = 5.0 / 2;
```

---

❌ Olvidar el casting:
```java
int x = 3.5; // ERROR
```

✔️ Correcto:
```java
int x = (int) 3.5;
```

---

## 8. Resumen rápido

| Operación | Ejemplo |
|--------|--------|
| double → int | `(int) 10.7` → 10 |
| int → double | `double x = 5;` → 5.0 |
| String → int | `Integer.parseInt("7")` |
| String → double | `Double.parseDouble("7.5")` |
| int → String | `String.valueOf(7)` |
| Alternativa rápida | `7 + ""` |

