# APUNTES DE CLASE - Diseño y Configuración en Android (XML)
Resumen de los elementos visuales, recursos y la conexión con Kotlin mediante View Binding.


---


## 1. Etiquetas y Atributos Generales (`activity_main.xml`)
El archivo `activity_main.xml` define QUÉ hay en la pantalla y CÓMO se coloca.


### Etiquetas de Contenedores (Layouts)
*   `<LinearLayout>`: Apila los elementos uno detrás de otro.
    *   Añade `android:orientation="vertical"` para que se apilen de arriba a abajo, o `"horizontal"` para que se coloquen de izquierda a derecha.
*   `<ScrollView>`: Permite hacer scroll en pantallas muy largas. **Regla de oro:** Solo puede tener UN hijo directo (normalmente metes un `LinearLayout` dentro del `ScrollView`).
*   `<RadioGroup>`: Contenedor específico para agrupar varios `<RadioButton>`. Asegura que solo se pueda marcar una opción a la vez.


### Etiquetas de Vistas (Widgets)
*   `<TextView>`: Etiqueta para mostrar texto que el usuario *no* puede editar.
*   `<EditText>`: Campo de entrada de texto.
*   `<Button>`: Botón interactivo.
*   `<CheckBox>`: Casilla de verificación (múltiples opciones).
*   `<RadioButton>`: Opción circular (única opción, usado dentro de un `RadioGroup`).


### Atributos Clave (Validos para casi cualquier vista)
*   `android:id="@+id/miElemento"`: Le da un nombre único a la vista para poder llamarla desde Kotlin.
*   `android:layout_width` / `android:layout_height`: Define el tamaño.
    *   `match_parent`: Ocupa todo el ancho/alto de su contenedor.
    *   `wrap_content`: Se ajusta al tamaño exacto de su contenido.
*   `android:text="Texto visible"`: El texto que muestra el botón o la etiqueta.
*   `android:hint="Escribe aquí..."`: (Solo `EditText`) El texto gris de ayuda que desaparece al escribir.
*   `android:inputType="numberDecimal"`: (Solo `EditText`) Filtra el teclado (números, texto, decimales).
*   `android:padding="16dp"`: Espacio interno entre el borde de la vista y su contenido.
*   `android:layout_marginTop="8dp"`: Margen exterior superior (empuja a los vecinos hacia abajo).
*   `style="@style/NombreEstilo"`: Aplica un conjunto de atributos guardados en `styles.xml`.


---


## 2. Los Recursos: Colores, Strings y Estilos
Android Studio guarda estos valores en archivos separados dentro de la carpeta `res/values/`. Esto permite reciclar código y facilita traducciones y cambios de tema.


### A. Colores (`colors.xml`)
Se definen colores mediante códigos Hexadecimales.
*   **Se escribe en XML:** `<color name="turquesa">#008E9B</color>`
*   **Se usa en `activity_main.xml`:** `android:textColor="@color/turquesa"`
*   **Se usa en Kotlin:** `binding.texto.setTextColor(getColor(R.color.turquesa))`


### B. Textos (`strings.xml`)
Centraliza los textos de la app. Ideal si algún día quieres traducir la app a otro idioma (Android cargará el archivo de strings correspondiente).
*   **Se escribe en XML:** `<string name="texto_saludo">¡Hola Mundo!</string>`
*   **Se usa en `activity_main.xml`:** `android:text="@string/texto_saludo"`
*   **Se usa en Kotlin:** `binding.texto.setText(R.string.texto_saludo)`


### C. Estilos (`styles.xml`)
Funciona de forma similar a una clase en CSS. Agrupa atributos visuales repetitivos (padding, text size, width) para no tener que copiarlos en cada `EditText` o `Button`.
*   **Se crea en XML:**
    ```xml
    <style name="CampoFormulario">
        <item name="android:layout_width">match_parent</item>
        <item name="android:layout_height">wrap_content</item>
        <item name="android:textSize">16sp</item>
    </style>
    ```
*   **Se aplica en `activity_main.xml`:** `style="@style/CampoFormulario"`


---


## 3. Cómo Sincronizar e Iniciar "View Binding"
View Binding es la herramienta que lee tus `android:id` en el XML y crea automáticamente una variable en Kotlin para que no tengas que usar `findViewById`.


### Paso 1: Activarlo en Gradle
Abre el archivo `build.gradle.kts` (el del **Módulo: app**) y añade dentro del bloque `android { ... }`:
```kotlin
buildFeatures {
    viewBinding = true
}
```


### Paso 2: Sincronizar el Proyecto
Haz clic en **"Sync Now"** (suele aparecer arriba a la derecha en una barra amarilla) o en el icono del elefante con la flecha en la barra superior de Android Studio. Esto hace que Android lea tus XML y genere las clases ocultas de Binding.


### Paso 3: Preparar la Activity (MainActivity.kt)
Android habrá creado una clase uniendo el nombre de tu XML con la palabra "Binding" (ej: `activity_main.xml` -> `ActivityMainBinding`). Conéctalo en tu `onCreate`:


```kotlin
class MainActivity : AppCompatActivity() {


    // 1. Declaramos la variable binding
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       
        // 2. Inicializamos la vista leyendo el XML
        binding = ActivityMainBinding.inflate(layoutInflater)
       
        // 3. Le decimos a la activity que muestre la vista de binding
        setContentView(binding.root)
       
        // ¡Listo! Ya puedes usar tus elementos por su ID directamente:
        // binding.btnRegistrar.setOnClickListener { ... }
    }
}
```
