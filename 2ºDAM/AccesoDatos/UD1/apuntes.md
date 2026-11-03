# Apuntes UD1 · Acceso a ficheros en Java

Funciones para copiar en el examen. Cada bloque indica cuándo usarlo.
Formato de registro en TXT/CSV: `id;campo2;campo3`, un registro por línea.

---

## 0. Plantilla inicial menú

```java
Path archivo = Path.of("datos", "archivo.csv");
try (Scanner escaner = new Scanner(System.in)) {
    String opcion = "-1";
    while (!(opcion.equals("0"))) {
        System.out.println("\nMENÚ");
        System.out.println("1. Listar");
        System.out.println("2. Buscar");
        System.out.println("3. Alta");
        System.out.println("4. Modificar");
        System.out.println("5. Eliminar");
        System.out.println("6. Crear copia");
        System.out.println("7. Restaurar copia");
        System.out.println("\n0. Salir");
        System.out.print("\nIntroduce una opción: ");
        opcion = escaner.nextLine().trim();
        if (opcion.equals("1")) {
            // Listar
        } else if (opcion.equals("2")) {
            // Buscar
        } else if (opcion.equals("3")) {
            // Alta
        } else if (opcion.equals("4")) {
            // Modificar
        } else if (opcion.equals("5")) {
            // Eliminar
        } else if (opcion.equals("6")) {
            // Crear copia
        } else if (opcion.equals("7")) {
            // Restaurar copia
        } else if (opcion.equals("0")) {
            System.out.println("Programa finalizado.");
        } else {
            System.out.println("Opción no válida");
        }
    }
} catch (Exception e) {
    System.out.println("Error inesperado: " + e.getMessage());
}
```

---

## 1. Rutas, carpetas y archivos

### Crear carpeta y archivo si no existen
**Cuándo:** al arrancar el programa, antes de leer o escribir.

```java
Path carpeta = Path.of("datos");
Path archivo = carpeta.resolve("clubes.txt");
try {
    Files.createDirectories(carpeta);
    if (Files.notExists(archivo)) {
        Files.createFile(archivo);
    }
} catch (IOException e) {
    System.out.println("No se pudo acceder al archivo: " + e.getMessage());
}
```

### Crear la carpeta padre de un archivo
**Cuándo:** antes de escribir en una ruta que puede no existir.

```java
Files.createDirectories(ruta.getParent());
```

### Consultar existencia, tamaño y ruta absoluta
**Cuándo:** para comprobar el estado de un archivo.

```java
Files.exists(archivo);                 // true si existe
Files.notExists(archivo);              // true si se confirma que no existe
Files.size(archivo);                   // tamaño en bytes
archivo.toAbsolutePath();              // ruta completa, no comprueba que exista
```

### Listar archivos de una carpeta
**Cuándo:** para ver qué hay dentro de un directorio.

```java
try (DirectoryStream<Path> elementos = Files.newDirectoryStream(carpeta)) {
    for (Path elemento : elementos) {
        if (Files.isRegularFile(elemento)) {
            System.out.println(elemento.getFileName());
        }
    }
} catch (IOException e) {
    System.out.println(e.getMessage());
}
```

---

## 2. Leer y escribir texto

### Escribir (sustituye el contenido)
**Cuándo:** crear un archivo nuevo o reemplazar todo su contenido.

```java
try (BufferedWriter salida = Files.newBufferedWriter(ruta, StandardCharsets.UTF_8)) {
    salida.write("1;Granada CF;Granada");
    salida.newLine();
} catch (IOException e) {
    System.out.println("No se pudo guardar: " + e.getMessage());
}
```

### Añadir al final (conserva lo anterior)
**Cuándo:** altas. Java no evita duplicados, se validan antes.

```java
try (BufferedWriter salida = Files.newBufferedWriter(ruta, StandardCharsets.UTF_8,
        StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
    salida.write(id + ";" + nombre + ";" + ciudad);
    salida.newLine();
} catch (IOException e) {
    System.out.println("No se pudo añadir: " + e.getMessage());
}
```

### Leer línea a línea
**Cuándo:** recorrer el archivo una sola vez sin guardarlo en memoria.

```java
if (Files.notExists(ruta)) {
    System.out.println("Todavía no hay archivo.");
    return;
}
try (BufferedReader entrada = Files.newBufferedReader(ruta, StandardCharsets.UTF_8)) {
    String linea;
    while ((linea = entrada.readLine()) != null) {
        System.out.println(linea);
    }
} catch (IOException e) {
    System.out.println("No se pudo leer: " + e.getMessage());
}
```

### Leer todas las líneas en una lista
**Cuándo:** buscar, modificar o borrar. Es el paso previo a reescribir el fichero.

```java
List<String> lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);
```

### Escribir una lista de líneas (sustituye el contenido)
**Cuándo:** al terminar una modificación o una baja. La lista debe contener todas las líneas que se quieren conservar.

```java
Files.write(ruta, nuevas, StandardCharsets.UTF_8);
```

---

## 3. Interpretar un registro

### Separar campos y convertir el ID
**Cuándo:** siempre que se procesa una línea.

```java
String[] campos = linea.split(";", -1);    // -1 conserva campos vacíos al final
if (campos.length == 3) {
    try {
        int id = Integer.parseInt(campos[0].trim());
        String nombre = campos[1].trim();
        String ciudad = campos[2].trim();
        System.out.println("[" + id + "] " + nombre + " - " + ciudad);
    } catch (NumberFormatException e) {
        System.out.println("El ID no es un número válido.");
    }
}
```

### Saltar la cabecera de un CSV
**Cuándo:** el archivo tiene una primera línea con los nombres de las columnas.

```java
for (int i = 1; i < lineas.size(); i++) {      // empieza en 1, la línea 0 es la cabecera
    String[] campos = lineas.get(i).split(";", -1);
    // ...
}
```

### Leer un número por teclado distinguiendo errores
**Cuándo:** pedir un ID y diferenciar "no es número" de "no existe".

```java
Scanner teclado = new Scanner(System.in);
System.out.print("ID: ");
String texto = teclado.nextLine().trim();
int id = 0;
boolean idValido = false;
try {
    id = Integer.parseInt(texto);
    idValido = id > 0;
} catch (NumberFormatException e) {
    idValido = false;
}
if (!idValido) {
    System.out.println("El ID debe ser un número entero mayor que cero.");
}
```

---

## 4. CRUD en fichero de texto

Patrón: **leer todo → cambiar en memoria → escribir todo**. Solo se escribe si el registro existe.

### Consulta por ID
**Cuándo:** buscar un registro sin modificar el archivo.

```java
List<String> lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);
boolean encontrado = false;
for (String linea : lineas) {
    String[] campos = linea.split(";", -1);
    if (campos.length == 3 && campos[0].trim().equals(String.valueOf(id))) {
        System.out.println("Nombre: " + campos[1] + " | Ciudad: " + campos[2]);
        encontrado = true;
    }
}
if (!encontrado) {
    System.out.println("No existe el ID " + id + ".");
}
```

### Modificación
**Cuándo:** cambiar un campo de un registro. El resto de líneas pasan sin cambios.

```java
List<String> originales = Files.readAllLines(ruta, StandardCharsets.UTF_8);
List<String> nuevas = new ArrayList<>();
boolean encontrado = false;
for (String linea : originales) {
    String[] campos = linea.split(";", -1);
    if (campos.length == 3 && campos[0].trim().equals(String.valueOf(id))) {
        nuevas.add(campos[0] + ";" + campos[1] + ";" + nuevaCiudad);
        encontrado = true;
    } else {
        nuevas.add(linea);
    }
}
if (encontrado) {
    Files.write(ruta, nuevas, StandardCharsets.UTF_8);
    System.out.println("Registro actualizado.");
} else {
    System.out.println("No existe el ID " + id + ".");
}
```

### Baja
**Cuándo:** eliminar un registro. Se construye una lista sin esa línea.

```java
List<String> originales = Files.readAllLines(ruta, StandardCharsets.UTF_8);
List<String> nuevas = new ArrayList<>();
boolean encontrado = false;
for (String linea : originales) {
    String[] campos = linea.split(";", -1);
    if (campos.length == 3 && campos[0].trim().equals(String.valueOf(id))) {
        encontrado = true;
    } else {
        nuevas.add(linea);
    }
}
if (encontrado) {
    Files.write(ruta, nuevas, StandardCharsets.UTF_8);
    System.out.println("Registro eliminado.");
} else {
    System.out.println("No existe el ID " + id + ".");
}
```

### Baja conservando la cabecera
**Cuándo:** el CSV tiene cabecera. La línea 0 siempre se añade.

```java
for (int i = 0; i < originales.size(); i++) {
    String linea = originales.get(i);
    String[] campos = linea.split(";", -1);
    if (i > 0 && campos.length == 3 && campos[0].trim().equals(String.valueOf(id))) {
        encontrado = true;
    } else {
        nuevas.add(linea);
    }
}
```

### Alta sin duplicados
**Cuándo:** antes de añadir. Comprueba ID repetido y título repetido sin importar mayúsculas ni espacios.

```java
List<String> lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);
boolean repetido = false;
for (String linea : lineas) {
    String[] campos = linea.split(";", -1);
    if (campos.length == 3) {
        if (campos[0].trim().equals(String.valueOf(id))
                || campos[1].trim().equalsIgnoreCase(titulo.trim())) {
            repetido = true;
        }
    }
}
if (repetido) {
    System.out.println("El ID o el título ya existen.");
} else {
    try (BufferedWriter salida = Files.newBufferedWriter(ruta, StandardCharsets.UTF_8,
            StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
        salida.write(id + ";" + titulo.trim() + ";" + autor.trim());
        salida.newLine();
    }
}
```

### Validaciones de entrada
**Cuándo:** antes de aceptar un alta o una modificación.

```java
if (id <= 0) {
    System.out.println("El ID debe ser mayor que cero.");
} else if (titulo.trim().isEmpty() || autor.trim().isEmpty()) {
    System.out.println("El título y el autor no pueden estar vacíos.");
} else if (titulo.split(";", -1).length != 1) {
    System.out.println("El texto no puede contener ';'.");   // rompería el formato
}
```

---

## 5. Importación con validación

### Filtrar filas válidas y guardarlas en otro archivo
**Cuándo:** el archivo de entrada tiene filas erróneas. Nunca se sobrescribe la entrada.

```java
List<String> lineas = Files.readAllLines(entrada, StandardCharsets.UTF_8);
List<String> validas = new ArrayList<>();
Set<Integer> ids = new HashSet<>();
for (int i = 1; i < lineas.size(); i++) {          // se salta la cabecera
    String[] campos = lineas.get(i).split(";", -1);
    if (campos.length != 3) {
        System.out.println("Línea " + (i + 1) + ": número de campos incorrecto.");
        continue;
    }
    try {
        int id = Integer.parseInt(campos[0].trim());
        String nombre = campos[1].trim();
        int stock = Integer.parseInt(campos[2].trim());
        if (id <= 0) {
            System.out.println("Línea " + (i + 1) + ": ID no positivo.");
        } else if (nombre.isEmpty()) {
            System.out.println("Línea " + (i + 1) + ": nombre vacío.");
        } else if (stock < 0) {
            System.out.println("Línea " + (i + 1) + ": stock negativo.");
        } else if (!ids.add(id)) {                  // add devuelve false si ya estaba
            System.out.println("Línea " + (i + 1) + ": ID duplicado.");
        } else {
            validas.add(id + ";" + nombre + ";" + stock);
        }
    } catch (NumberFormatException e) {
        System.out.println("Línea " + (i + 1) + ": ID o stock no numérico.");
    }
}
Files.write(salida, validas, StandardCharsets.UTF_8);
```

---

## 6. Copias de seguridad

### Crear copia
**Cuándo:** antes de cualquier operación que reescriba el fichero.

```java
Path copia = Path.of("datos", "copias", "inventario.bak");
Files.createDirectories(copia.getParent());
Files.copy(origen, copia, StandardCopyOption.REPLACE_EXISTING);
```

### Restaurar con confirmación
**Cuándo:** recuperar datos. Comprueba que existe, pide confirmación y guarda la versión que se sustituye.

```java
if (Files.notExists(copia)) {
    System.out.println("No existe ninguna copia.");
} else {
    System.out.print("Se sustituirán los datos actuales. ¿Continuar? (s/n): ");
    String respuesta = teclado.nextLine().trim();
    if (respuesta.equalsIgnoreCase("s")) {
        Files.copy(origen, copia.getParent().resolve("anterior.bak"),
                StandardCopyOption.REPLACE_EXISTING);
        Files.copy(copia, origen, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Copia restaurada.");
    } else {
        System.out.println("Restauración cancelada.");
    }
}
```

### Comprobar que una copia es válida
**Cuándo:** antes de restaurar, para no reemplazar datos por un archivo que no se puede interpretar.

```java
List<String> lineasCopia = Files.readAllLines(copia, StandardCharsets.UTF_8);
boolean copiaValida = true;
for (String linea : lineasCopia) {
    String[] campos = linea.split(";", -1);
    if (campos.length != 3) {
        copiaValida = false;
    } else {
        try {
            Integer.parseInt(campos[0].trim());
        } catch (NumberFormatException e) {
            copiaValida = false;
        }
    }
}
```

---

## 7. Ficheros binarios (serialización)

### Clase serializable
**Cuándo:** guardar objetos completos. Los campos se guardan juntos, sin separadores.
Los constructor vacío y los setters los necesita Jackson (apartado 10); en binario no hacen falta.

```java
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto() {}

    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return id + " | " + nombre + " | " + precio + " | " + stock;
    }
}
```

### Guardar la lista completa
**Cuándo:** siempre se guarda la lista entera como un único objeto, no objeto a objeto.

```java
try (ObjectOutputStream salida = new ObjectOutputStream(Files.newOutputStream(archivo))) {
    salida.writeObject(productos);
} catch (IOException e) {
    System.out.println("Error al guardar: " + e.getMessage());
}
```

### Cargar la lista
**Cuándo:** leer el binario. Comprueba el tipo de la lista y de cada elemento.

```java
private static List<Producto> cargar(Path archivo) throws IOException, ClassNotFoundException {
    try (ObjectInputStream entrada = new ObjectInputStream(Files.newInputStream(archivo))) {
        Object objeto = entrada.readObject();
        if (!(objeto instanceof List<?> lista)) {
            throw new IOException("El fichero no contiene una lista.");
        }
        List<Producto> productos = new ArrayList<>();
        for (Object elemento : lista) {
            if (!(elemento instanceof Producto producto)) {
                throw new IOException("La lista contiene un elemento que no es Producto.");
            }
            productos.add(producto);
        }
        return productos;
    }
}
```

### Modificar un objeto y volver a guardar
**Cuándo:** cambiar un dato. Se carga todo, se cambia el objeto y se guarda la lista completa.

```java
List<Producto> productos = cargar(archivo);
Producto encontrado = null;
for (Producto producto : productos) {
    if (producto.getId() == id) {
        encontrado = producto;
    }
}
if (encontrado == null) {
    System.out.println("ID no encontrado. El fichero no se modifica.");
    return;
}
encontrado.setStock(stock);
try (ObjectOutputStream salida = new ObjectOutputStream(Files.newOutputStream(archivo))) {
    salida.writeObject(productos);
}
```

### Capturar los errores de una operación binaria
**Cuándo:** envolver la carga y el guardado.

```java
try {
    // cargar, modificar y guardar
} catch (NumberFormatException e) {
    System.out.println("Introduce números enteros válidos. No se guardan cambios.");
} catch (IOException | ClassNotFoundException e) {
    System.out.println("No se pudo leer o guardar el fichero: " + e.getMessage());
}
```

---

## 9. XML (DOM)

### Exportar una lista a XML
**Cuándo:** generar un XML. Se usa la API, nunca concatenar etiquetas.

```java
Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
Element raiz = documento.createElement("productos");
documento.appendChild(raiz);

for (Producto p : productos) {
    Element producto = documento.createElement("producto");
    producto.setAttribute("id", String.valueOf(p.getId()));

    Element nombre = documento.createElement("nombre");
    nombre.setTextContent(p.getNombre());
    Element precio = documento.createElement("precio");
    precio.setTextContent(String.valueOf(p.getPrecio()));
    Element stock = documento.createElement("stock");
    stock.setTextContent(String.valueOf(p.getStock()));

    producto.appendChild(nombre);
    producto.appendChild(precio);
    producto.appendChild(stock);
    raiz.appendChild(producto);
}

Files.createDirectories(ruta.getParent());
Transformer transformador = TransformerFactory.newInstance().newTransformer();
transformador.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
transformador.setOutputProperty(OutputKeys.INDENT, "yes");
transformador.transform(new DOMSource(documento), new StreamResult(ruta.toFile()));
```

Imports extra:

```java
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
```

### Importar XML de forma segura
**Cuándo:** leer un XML externo. Se valida todo en una lista temporal y solo después se sustituyen los datos.

```java
private static List<Producto> importar(Path archivo) throws Exception {
    if (!Files.exists(archivo)) {
        throw new IllegalArgumentException("No existe el archivo: " + archivo);
    }
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    // Se desactivan DTD y entidades externas
    factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
    factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
    factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
    factory.setXIncludeAware(false);
    factory.setExpandEntityReferences(false);

    Document documento = factory.newDocumentBuilder().parse(archivo.toFile());
    Element raiz = documento.getDocumentElement();
    if (!"productos".equals(raiz.getTagName())) {
        throw new IllegalArgumentException("La raíz debe ser <productos>.");
    }

    List<Producto> temporales = new ArrayList<>();
    Set<Integer> ids = new HashSet<>();
    NodeList nodos = raiz.getChildNodes();
    for (int i = 0; i < nodos.getLength(); i++) {
        if (!(nodos.item(i) instanceof Element elemento)) {
            continue;                                   // se ignoran espacios y saltos de línea
        }
        if (!"producto".equals(elemento.getTagName())) {
            throw new IllegalArgumentException("Etiqueta inesperada en productos.");
        }
        int id = Integer.parseInt(elemento.getAttribute("id"));
        String nombre = texto(elemento, "nombre").trim();
        double precio = Double.parseDouble(texto(elemento, "precio"));
        int stock = Integer.parseInt(texto(elemento, "stock"));
        if (id <= 0 || nombre.isEmpty() || precio < 0 || stock < 0 || !ids.add(id)) {
            throw new IllegalArgumentException("Datos inválidos o ID repetido: " + id);
        }
        temporales.add(new Producto(id, nombre, precio, stock));
    }
    return temporales;
}

private static String texto(Element padre, String etiqueta) {
    NodeList nodos = padre.getElementsByTagName(etiqueta);
    if (nodos.getLength() != 1) {
        throw new IllegalArgumentException("Debe existir un único <" + etiqueta + ">.");
    }
    return nodos.item(0).getTextContent();
}
```

### Uso: la lista actual solo cambia si la importación termina bien

```java
try {
    List<Producto> temporales = importar(archivo);
    productosActuales = temporales;
    System.out.println("Importación correcta.");
} catch (Exception e) {
    System.out.println("Importación rechazada: " + e.getMessage());
}
```

---

## 10. JSON (Jackson)

### Dependencia Maven (`pom.xml`)

```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.18.3</version>
</dependency>
```

### Exportar una lista

```java
ObjectMapper mapper = new ObjectMapper();
Files.createDirectories(ruta.getParent());
mapper.writerWithDefaultPrettyPrinter().writeValue(ruta.toFile(), productos);
```

### Importar con validación
**Cuándo:** leer un JSON externo. Si el JSON está mal formado, `readValue` lanza una excepción y la lista actual no se toca.
Para `readValue`, la clase necesita constructor vacío y setters (o ser un `record`).

```java
List<Producto> temporales = mapper.readValue(
        ruta.toFile(), new TypeReference<List<Producto>>() {});
validar(temporales);
productosActuales = temporales;
```

### Validar la lista importada

```java
private static void validar(List<Producto> productos) {
    if (productos == null) {
        throw new IllegalArgumentException("El JSON no contiene una lista.");
    }
    Set<Integer> ids = new HashSet<>();
    for (Producto p : productos) {
        if (p == null || p.getId() <= 0 || p.getNombre() == null
                || p.getNombre().isBlank() || p.getPrecio() < 0
                || p.getStock() < 0 || !ids.add(p.getId())) {
            throw new IllegalArgumentException("Producto inválido o ID duplicado.");
        }
    }
}
```

### Capturar los errores

```java
try {
    if (!Files.exists(archivo)) {
        throw new IOException("No existe el archivo");
    }
    // importar y validar
} catch (IOException | IllegalArgumentException e) {
    System.out.println("Importación rechazada: " + e.getMessage());
}
```

Imports extra:

```java
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
```

---

## 11. Separar menú y acceso a datos

### Interfaz de repositorio
**Cuándo:** el enunciado pide que el menú no use `Files` directamente.

```java
public interface RepositorioProductos {
    void guardarTodos(List<Producto> productos) throws IOException;
    List<Producto> cargarTodos() throws IOException;
}
```

### Implementación en TXT

```java
public class RepositorioTexto implements RepositorioProductos {
    private final Path ruta = Path.of("datos", "productos.txt");

    @Override
    public void guardarTodos(List<Producto> productos) throws IOException {
        List<String> lineas = new ArrayList<>();
        for (Producto p : productos) {
            lineas.add(p.getId() + ";" + p.getNombre() + ";" + p.getPrecio() + ";" + p.getStock());
        }
        Files.createDirectories(ruta.getParent());
        Files.write(ruta, lineas, StandardCharsets.UTF_8);
    }

    @Override
    public List<Producto> cargarTodos() throws IOException {
        List<Producto> productos = new ArrayList<>();
        if (Files.notExists(ruta)) {
            return productos;
        }
        for (String linea : Files.readAllLines(ruta, StandardCharsets.UTF_8)) {
            String[] campos = linea.split(";", -1);
            if (campos.length == 4) {
                try {
                    productos.add(new Producto(Integer.parseInt(campos[0]), campos[1],
                            Double.parseDouble(campos[2]), Integer.parseInt(campos[3])));
                } catch (NumberFormatException e) {
                    System.out.println("Línea ignorada: " + linea);
                }
            }
        }
        return productos;
    }
}
```

---

## 12. Qué uso en cada caso

| Necesito... | Uso |
|---|---|
| Crear carpeta si falta | `Files.createDirectories(ruta.getParent())` |
| Crear archivo vacío si falta | `Files.notExists` + `Files.createFile` |
| Añadir una línea al final | `newBufferedWriter` + `CREATE` + `APPEND` |
| Reemplazar todo el contenido | `Files.write(ruta, lista, UTF_8)` |
| Modificar o borrar en TXT | `readAllLines` → lista nueva → `Files.write` |
| Leer sin cargar todo | `BufferedReader` + `readLine()` |
| Separar campos | `linea.split(";", -1)` + comprobar `length` |
| Convertir texto a número | `Integer.parseInt` + `catch NumberFormatException` |
| Evitar títulos repetidos | `trim()` + `equalsIgnoreCase(...)` |
| Evitar IDs repetidos en una importación | `Set<Integer>` y `ids.add(id)` |
| Copia de seguridad | `Files.copy(..., REPLACE_EXISTING)` |
| Guardar objetos tal cual | `Serializable` + `ObjectOutputStream` |
| Modificar un registro sin reescribir todo | `RandomAccessFile` + `seek` |
| Intercambiar con otras aplicaciones (etiquetas) | XML con DOM |
| Intercambiar con otras aplicaciones (objetos/listas) | JSON con `ObjectMapper` |
| Cambiar de TXT a binario sin tocar el menú | Interfaz de repositorio |

---

## 13. Recordatorios

- `newBufferedWriter` sin opciones **sustituye** el contenido. Para añadir hace falta `CREATE` + `APPEND`.
- `Files.write` con una lista **sustituye** el contenido: la lista debe llevar todas las líneas que se conservan.
- Solo se reescribe el fichero si el registro existe y los datos nuevos son válidos.
- Antes de reescribir: copia de seguridad. Antes de restaurar: confirmación.
- En una importación: leer y validar todo en una lista temporal, y solo después sustituir los datos.
- `Integer.parseInt` siempre dentro de `try/catch (NumberFormatException)`.
- En binario se guarda la **lista completa**, no objeto a objeto.
- En `RandomAccessFile`: posición = `numeroRegistro * TAM_REGISTRO`; el ID es un dato dentro del registro.
- Tamaños: `int` 4, `boolean` 1, `char` 2 bytes. Registro de ejemplo: 53 bytes.
- `length() % TAM_REGISTRO != 0` indica un registro incompleto.
- No deserializar archivos de origen desconocido.
- En XML, desactivar DTD y entidades externas antes de leer.
- Cambiar la estructura de la clase serializada puede impedir leer binarios antiguos.