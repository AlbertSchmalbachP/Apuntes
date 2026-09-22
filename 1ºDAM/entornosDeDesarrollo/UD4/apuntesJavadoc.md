# Etiquetas de Bloque (Block Tags)

Se colocan al final del comentario Javadoc, después de la descripción general.

    @param: Describe un parámetro de un método o constructor.
    @return: Describe el valor que devuelve un método.
    @throws (o @exception): Indica las excepciones que el método puede lanzar.
    @see: Añade un enlace de "Ver también" a otra parte de la documentación.
    @author: Identifica al autor del código (usado en clases e interfaces).
    @version: Especifica la versión actual del software.
    @since: Indica desde qué versión del proyecto está disponible este elemento.
    @deprecated: Señala que el código ya no debe usarse y sugiere una alternativa. 

# Etiquetas Inline (Inline Tags)

Se usan dentro de las frases para dar formato o crear enlaces dinámicos.

    {@link}: Inserta un enlace clickable a otro símbolo de la API.
    {@code}: Formatea el texto como código fuente sin interpretar etiquetas HTML.
    {@literal}: Muestra el texto tal cual, útil para caracteres como < o >.
    {@inheritDoc}: Hereda la documentación de la clase padre o interfaz.
    {@docRoot}: Representa la ruta relativa al directorio raíz de la documentación generada.
    {@snippet}: (Introducida en Java 18) Para incluir ejemplos de código modernos con resaltado.
    {@value}: Muestra el valor de una constante estática. 

## Orden Recomendado

Oracle sugiere seguir este orden específico al escribir tus comentarios para mantener la consistencia:

    @author
    @version
    @param
    @return
    @throws
    @see
    @since
    @serial
    @deprecated

## Ejemplo

/**

* Calcula el precio final de un producto aplicando un descuento porcentual.
* * <p>Esta función es útil para procesos de <b>facturación</b> y <i>e-commerce</i>.
* El cálculo se basa en la siguiente lógica:</p>
* * <ul>
* <li>Verifica que el descuento sea un valor entre 0 y 100.</li>
* <li>Aplica la fórmula: <code>precio * (1 - descuento / 100)</code>.</li>
* </ul>
* * @param precio El costo base del producto (debe ser mayor a 0).
* @param porcentajeDescuento El valor del descuento (ej: 15 para un 15%).
* @return El precio final tras aplicar el descuento.
* @throws IllegalArgumentException Si el precio es negativo o el descuento es inválido.
* * @see <a href="https://www.google.com">Documentación de Contabilidad</a>
 */
public double calcularPrecioFinal(double precio, double porcentajeDescuento) {
    if (precio < 0 || porcentajeDescuento < 0 || porcentajeDescuento > 100) {
        throw new IllegalArgumentException("Valores de entrada fuera de rango.");
    }
    return precio - (precio* (porcentajeDescuento / 100));
}
