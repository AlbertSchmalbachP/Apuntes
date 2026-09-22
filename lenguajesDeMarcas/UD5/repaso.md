# Chuleta Definitiva — UD5 JavaScript (DOM) + UD4 CSS (lo justo)

## Índice

- [1) Seleccionar elementos del HTML](#1-seleccionar-elementos-del-html)
- [2) Leer y escribir contenido y atributos](#2-leer-y-escribir-contenido-y-atributos)
- [3) Clases y estilos](#3-clases-y-estilos)
- [4) Crear, insertar y borrar elementos (DOM)](#4-crear-insertar-y-borrar-elementos-dom)
- [5) Propiedades útiles de nodos](#5-propiedades-útiles-de-nodos)
- [6) Eventos (interacción)](#6-eventos-interacción)
- [7) Delegación de eventos (event.target)](#7-delegación-de-eventos-eventtarget)
- [8) Conversión y validación rápida](#8-conversión-y-validación-rápida)
- [9) Recetas de examen (patrones típicos)](#9-recetas-de-examen-patrones-típicos)
- [10) Checklist de errores típicos](#10-checklist-de-errores-típicos)

---

## 1) Seleccionar elementos del HTML

**Para qué sirve:** "cazar" cosas del HTML para poder leerlas o cambiarlas desde JavaScript.

### `document.getElementById("id")`

- Devuelve **1 elemento** por `id`.
- Es el más directo para botones, spans, contenedores…

```js
const zona = document.getElementById("zonaProductos");
const boton = document.getElementById("btnAnadirUnidad");
```

### `document.querySelector("selectorCSS")`

- Devuelve **el primero** que coincida con un selector CSS (`#id`, `.clase`, `tag`).

```js
const primerProducto = document.querySelector(".producto");
const resumenNombre = document.querySelector("#resumenNombre");
// También acepta selectores complejos:
const enlaceActivo = document.querySelector("nav a.activo");
```

### `document.querySelectorAll("selectorCSS")`

- Devuelve **todos** los que coincidan (NodeList).
- Se recorre con `forEach`.

```js
const productos = document.querySelectorAll(".producto");
productos.forEach(function(p) {
  // ...
});
```

### `getElementsByClassName / getElementsByTagName`

- Devuelven una **HTMLCollection** (no un array, no tiene `forEach` directamente).
- Se recorren con `for...of`.

```js
const botones = document.getElementsByClassName("boton");
for (const boton of botones) {
  boton.style.backgroundColor = "red";
}

const parrafos = document.getElementsByTagName("p");
for (const parrafo of parrafos) {
  parrafo.style.color = "blue";
}
```

> ⚠️ Diferencia clave: `querySelectorAll` devuelve NodeList (tiene `forEach`), `getElementsByClassName/TagName` devuelven HTMLCollection (usa `for...of`).

---

## 2) Leer y escribir contenido y atributos

**Para qué sirve:** cambiar texto, leer inputs, tocar atributos y guardar info en `data-*`.

### `textContent`

- Lee o escribe texto **sin interpretar HTML** (lo más seguro, evita XSS).

```js
titulo.textContent = "Ultramarinos San Antón";
```

### `innerHTML`

- Lee/escribe **interpretando HTML**.
- Úsalo solo si necesitas meter etiquetas. ⚠️ **Cuidado con XSS** si metes datos del usuario.

```js
caja.innerHTML = "<strong>Hola</strong>";
```

### `value`

- Lo que hay en un `input` o lo seleccionado en un `select`.

```js
const nombre = inputNombre.value;
const seccion = selectSeccion.value;
```

### `dataset` (data-*)

- Acceso a atributos `data-*` desde JS.
- Ojo: normalmente son **texto**, aunque "parezcan números".

```html
<div class="producto" data-seccion="Despensa" data-unidades="3"></div>
```

```js
const seccion = producto.dataset.seccion;             // "Despensa"
const unidades = parseInt(producto.dataset.unidades); // 3 (número)
producto.dataset.unidades = unidades + 1;             // guarda "4"
```

### Atributos genéricos

- `getAttribute`, `setAttribute`, `removeAttribute`

```js
producto.setAttribute("tabindex", "0");
const tab = producto.getAttribute("tabindex");
producto.removeAttribute("alt");
```

---

## 3) Clases y estilos

**Para qué sirve:** marcar un elemento "activo", ocultar/mostrar, dar feedback visual.

### `classList.add / remove / contains`

```js
producto.classList.add("activo");
producto.classList.remove("activo");
const activo = producto.classList.contains("activo"); // true / false
```

### `style`

- Cambia estilo en línea (rápido para filtros).

```js
producto.style.display = "none";              // ocultar
producto.style.display = "block";             // mostrar
producto.style.backgroundColor = "blue";
producto.style.fontSize = "18px";
```

> Tip: mejor añadir/quitar una clase CSS con `classList` que tocar `style` directamente → el CSS queda organizado en el archivo `.css`.

---

## 4) Crear, insertar y borrar elementos (DOM)

**Para qué sirve:** crear elementos nuevos desde JS (li del pedido, productos, mensajes…).

### Crear + meter al final (`appendChild`)

```js
const li = document.createElement("li");
li.textContent = "Arroz - Despensa - 2 unidades";
listaPedido.appendChild(li);
```

### Insertar en una posición concreta (`insertBefore`)

```js
contenedor.insertBefore(nuevo, referencia); // inserta 'nuevo' ANTES de 'referencia'
```

### Borrar

```js
nodo.remove();                  // borra el nodo directamente
padre.removeChild(hijo);        // borra 'hijo' desde su padre
```

### Reemplazar

```js
padre.replaceChild(nuevoNodo, nodoViejo);
```

| Método | Necesita padre | Uso típico |
|---|---|---|
| `remove()` | No | Borrar directamente |
| `removeChild()` | Sí | Borrar un hijo concreto |
| `replaceChild()` | Sí | Sustituir un hijo |

---

## 5) Propiedades útiles de nodos

**Para qué sirve:** navegar y consultar la estructura del DOM sin buscar por ID o clase.

### `childElementCount`

- Devuelve el **número de hijos directos** (solo elementos, no texto).

```js
const lista = document.getElementById("lista");
console.log(lista.childElementCount); // ej: 3
```

### `lastElementChild`

- Devuelve el **último hijo** de un elemento. Si no hay hijos, devuelve `null`.

```js
const ultimo = lista.lastElementChild;
console.log(ultimo.textContent);
```

> ⚠️ Comprueba que no sea `null` antes de usarlo:

```js
if (lista.lastElementChild) {
  lista.lastElementChild.remove();
}
```

### `firstElementChild`

- Igual que `lastElementChild` pero devuelve el **primer hijo**.

```js
contenedor.insertBefore(nuevo, contenedor.firstElementChild);
```

---

## 6) Eventos (interacción)

**Para qué sirve:** reaccionar cuando el usuario hace cosas.

### `addEventListener("evento", funcion)`

```js
boton.addEventListener("click", function() {
  // lo que pasa al hacer click
});
```

### Función externa (más limpio y reutilizable)

```js
function mostrarMensaje() {
  alert("¡Evento activado!");
}
boton.addEventListener("click", mostrarMensaje);
```

### Eventos típicos

| Evento | Cuándo se dispara |
|---|---|
| `click` | Al hacer clic |
| `submit` | Al enviar un formulario |
| `change` | Al cambiar valor de input/select |
| `keydown` | Al pulsar una tecla |
| `keyup` | Al soltar una tecla |
| `mouseover` | Al pasar el ratón por encima |
| `mouseout` | Al sacar el ratón |
| `focus` | Al hacer foco en un campo |
| `blur` | Al perder el foco de un campo |

### `event.key` (teclado)

- Dentro de `keydown` / `keyup`, `event.key` da la tecla pulsada.

```js
const campo = document.querySelector("#campo");
campo.addEventListener("keydown", function(event) {
  console.log("Tecla presionada: " + event.key);
});
```

### `event.preventDefault()`

- En formularios evita que se recargue la página al enviar.

```js
form.addEventListener("submit", function(event) {
  event.preventDefault();
  // aquí haces lo tuyo
});
```

### `this`

- Dentro del handler suele ser el elemento al que le pusiste el listener.

```js
filtroSeccion.addEventListener("change", function() {
  filtrarProductos(this.value);
});
```

### `removeEventListener` (quitar un listener)

- Elimina un listener previamente añadido.
- ⚠️ **Solo funciona con funciones con nombre** (no anónimas).

```js
function mostrarMensaje() {
  alert("Hola");
}
boton.addEventListener("click", mostrarMensaje);
// ... más tarde:
boton.removeEventListener("click", mostrarMensaje);
```

---

## 7) Delegación de eventos (event.target)

**Para qué sirve:** poner **un solo listener** a un contenedor y detectar qué hijo se pulsó.
Ideal si:

- hay muchos elementos
- o creas elementos dinámicamente (y no quieres enganchar listeners uno por uno)

### Con `closest()` (recomendado para bloques complejos)

```js
zonaProductos.addEventListener("click", function(event) {
  const producto = event.target.closest(".producto");
  if (producto) {
    seleccionarProducto(producto);
  }
});
```

- `event.target` = lo que se clicó exactamente.
- `closest(".producto")` sube hasta encontrar el bloque completo `.producto`.

### Con `tagName` (cuando los hijos son simples, ej: `<li>`)

```js
lista.addEventListener("click", function(event) {
  if (event.target.tagName === "LI") {
    alert("Clicaste: " + event.target.textContent);
  }
});
```

> `tagName` devuelve el nombre de la etiqueta **en mayúsculas**: `"LI"`, `"BUTTON"`, `"DIV"`…

---

## 8) Conversión y validación rápida

**Para qué sirve:** no sumar textos como si fueran números, y validar inputs.

### Convertir a número

```js
const n1 = parseInt(texto);     // entero
const n2 = parseFloat(texto);   // decimal
const n3 = Number(texto);       // general
```

### `isNaN` (no es número)

```js
const n = parseInt(valor);
if (isNaN(n)) {
  // valor inválido
}
```

### `trim()` (quitar espacios)

```js
const nombre = input.value.trim();
```

---

## 9) Recetas de examen (patrones típicos)

### Receta A — Seleccionar activo + resumen

1. Click en un producto
2. Quitar `.activo` a todos
3. Poner `.activo` al clicado
4. Guardarlo como `productoActivo`
5. Pintar resumen (nombre / sección / unidades)

```js
function seleccionarProducto(producto) {
  quitarActivoATodos();
  producto.classList.add("activo");
  productoActivo = producto;
  actualizarResumen(productoActivo);
}
```

### Receta B — Sumar 1 en dataset + refrescar pantalla

1. Leer `productoActivo.dataset.unidades`
2. Convertir a número
3. Sumar 1
4. Guardar en `dataset`
5. Cambiar el número visible (`.unidades`)
6. Actualizar resumen

```js
let u = parseInt(productoActivo.dataset.unidades);
u = u + 1;
productoActivo.dataset.unidades = u;
productoActivo.querySelector(".unidades").textContent = u;
actualizarResumen(productoActivo);
```

### Receta C — Pasar a pedido (crear `li`)

1. Crear `li`
2. Construir texto con nombre + sección + unidades
3. `appendChild` a `#listaPedido`

```js
const li = document.createElement("li");
li.textContent = nombre + " - " + seccion + " - " + unidades + " unidades";
listaPedido.appendChild(li);
```

### Receta D — Crear producto desde formulario

1. Leer inputs (`value`)
2. `trim()` al nombre
3. Validar: nombre no vacío, unidades número y >= 0
4. Crear `div.producto` con `dataset`
5. Crear hijos (`h3`, `p`, `strong`)
6. `appendChild` al contenedor
7. Reset del form y mensaje

### Receta E — Reemplazar último elemento de una lista

1. Comprobar que existe `lastElementChild`
2. Crear nuevo `li`
3. Eliminar el último (`remove()` o `removeChild`)
4. Añadir el nuevo (`appendChild`)

```js
if (lista.lastElementChild) {
  const nuevoElemento = document.createElement("li");
  nuevoElemento.textContent = "Elemento editado";
  lista.lastElementChild.remove();
  lista.appendChild(nuevoElemento);
}
```

---

## 10) Checklist de errores típicos

- ❌ Rutas mal puestas: deben existir `css/style.css` y `js/script.js` con esa estructura.
- ❌ IDs o clases que no coinciden entre HTML y JS → el JS "no encuentra" elementos.
- ❌ `dataset` y `value` suelen ser texto → si vas a sumar, convierte con `parseInt`.
- ❌ En `submit` sin `preventDefault()` → se recarga y parece que no funciona.
- ❌ Guardar activo como una cosa y compararlo con otra (ej: guardas `null` y comparas con `""`).
- ❌ Cambias `dataset` pero no actualizas el texto visible (`textContent`) → "no se ve" el cambio.
- ❌ `removeEventListener` con función anónima → no funciona, necesita función con nombre.
- ❌ `lastElementChild` sin comprobar `null` → error si el contenedor está vacío.
- ❌ `tagName` en minúsculas → siempre está en MAYÚSCULAS (`"LI"` no `"li"`).
- ❌ Usar `forEach` en una `HTMLCollection` → usa `for...of` o conviértela con `Array.from()`.

---

## Mini resumen (para memorizar en 10s)

| Qué quieres hacer | Cómo |
|---|---|
| Seleccionar 1 por ID | `getElementById` |
| Seleccionar por CSS | `querySelector` / `querySelectorAll` |
| Cambiar texto | `textContent` |
| Meter HTML | `innerHTML` (ojo XSS) |
| Guardar datos en el elemento | `dataset` |
| Añadir/quitar clase | `classList.add/remove` |
| Crear elemento | `createElement` + `appendChild` |
| Escuchar eventos | `addEventListener` |
| Evitar recarga en form | `event.preventDefault()` |
| Saber qué tecla | `event.key` |
| Saber qué se clicó | `event.target` |
| Convertir a número | `parseInt` / `parseFloat` |
| Validar número | `isNaN` |

````
