# R11E1 | Mini inventario
# Menú, lista de diccionarios, funciones, validación y CSV.
# Consulta el PDF de la Relación 11 para el enunciado completo y la comprobación.

import csv
from pathlib import Path

RUTA_CSV = Path(__file__).with_name("inventario.csv")


def convertir_entero(texto, minimo=0):
    """Devuelve un entero válido o None si el dato no es correcto."""
    try:
        numero = int(texto)
    except ValueError:
        return None
    return numero if numero >= minimo else None


def convertir_precio(texto):
    """Devuelve un precio no negativo o None si no es válido."""
    try:
        precio = float(texto)
    except ValueError:
        return None
    return precio if precio >= 0 else None


def encontrar_producto(productos, nombre):
    for producto in productos:
        if producto["nombre"].casefold() == nombre.casefold():
            return producto
    return None


def anadir_producto(productos, nombre, precio, stock):
    """Añade un producto y devuelve el resultado de la operación."""
    if not nombre:
        return "nombre_vacio"
    if encontrar_producto(productos, nombre) is not None:
        return "duplicado"
    productos.append({"nombre": nombre, "precio": precio, "stock": stock})
    return "anadido"


def modificar_stock(productos, nombre, nuevo_stock):
    """Modifica el stock y devuelve si se ha encontrado el producto."""
    producto = encontrar_producto(productos, nombre)
    if producto is None:
        return False
    producto["stock"] = nuevo_stock
    return True


def buscar_productos(productos, texto):
    busqueda = texto.casefold()
    return [producto for producto in productos if busqueda in producto["nombre"].casefold()]


def formatear_producto(numero, producto):
    return (
        f"{numero}. {producto['nombre']} | "
        f"{producto['precio']:.2f} EUR | Stock: {producto['stock']}"
    )


def guardar_csv(productos):
    with open(RUTA_CSV, "w", newline="", encoding="utf-8") as archivo:
        escritor = csv.DictWriter(archivo, fieldnames=["nombre", "precio", "stock"])
        escritor.writeheader()
        escritor.writerows(productos)
    return len(productos)


def main():
    productos = [
        {"nombre": "Teclado", "precio": 25.50, "stock": 8},
        {"nombre": "Ratón", "precio": 12.75, "stock": 5},
    ]
    opcion = ""
    while opcion != "0":
        print("\n1) Listar productos")
        print("2) Añadir producto")
        print("3) Modificar stock")
        print("4) Buscar por nombre")
        print("5) Guardar en CSV")
        print("0) Salir")
        opcion = input("Opción: ").strip()

        if opcion == "1":
            if not productos:
                print("No hay productos.")
            for numero, producto in enumerate(productos, start=1):
                print(formatear_producto(numero, producto))

        elif opcion == "2":
            nombre = input("Nombre del producto: ").strip()
            if not nombre:
                print("El nombre no puede estar vacío.")
            elif encontrar_producto(productos, nombre) is not None:
                print("Ya existe un producto con ese nombre.")
            else:
                precio = None
                while precio is None:
                    precio = convertir_precio(input("Precio: "))
                    if precio is None:
                        print("Introduce un precio válido (no negativo).")

                stock = None
                while stock is None:
                    stock = convertir_entero(input("Stock: "))
                    if stock is None:
                        print("Introduce un stock entero no negativo.")

                resultado = anadir_producto(productos, nombre, precio, stock)
                if resultado == "anadido":
                    print("Producto añadido.")

        elif opcion == "3":
            nombre = input("Nombre exacto del producto: ").strip()
            if encontrar_producto(productos, nombre) is None:
                print("Producto no encontrado.")
            else:
                nuevo_stock = None
                while nuevo_stock is None:
                    nuevo_stock = convertir_entero(input("Nuevo stock: "))
                    if nuevo_stock is None:
                        print("Introduce un stock entero no negativo.")
                if modificar_stock(productos, nombre, nuevo_stock):
                    print("Stock actualizado.")

        elif opcion == "4":
            texto = input("Texto que quieres buscar: ").strip()
            encontrados = buscar_productos(productos, texto)
            if not encontrados:
                print("No hay productos.")
            for numero, producto in enumerate(encontrados, start=1):
                print(formatear_producto(numero, producto))

        elif opcion == "5":
            cantidad = guardar_csv(productos)
            print(f"Guardados {cantidad} productos en {RUTA_CSV.name}.")

        elif opcion != "0":
            print("Opción no válida.")


if __name__ == "__main__":
    main()