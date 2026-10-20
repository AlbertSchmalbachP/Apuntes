# R11E1 | Mini inventario
# Menú, lista de diccionarios, funciones, validación y CSV.

from pathlib import Path
from funciones_python import (
    validar_numero,
    validar_texto,
    encontrar_por_campo,
    agregar_objeto,
    modificar_campo,
    buscar_texto,
    guardar_csv,
)

RUTA_CSV = Path(__file__).with_name("inventario.csv")
CAMPOS = ["nombre", "precio", "stock"]


# Devuelve el producto como texto: "1. Teclado | 25.50 EUR | Stock: 8"
def formatear_producto(numero, producto):
    return (
        f"{numero}. {producto['nombre']} | "
        f"{producto['precio']:.2f} EUR | Stock: {producto['stock']}"
    )


# Devuelve la lista de productos como líneas de texto, la impresión se hace en main()
def listar_productos(productos):
    return [
        formatear_producto(numero, producto)
        for numero, producto in enumerate(productos, start=1)
    ]


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
            if len(productos) == 0:
                print("No hay productos.")
            for linea in listar_productos(productos):
                print(linea)

        elif opcion == "2":
            nombre = None
            while nombre == None:
                nombre, error = validar_texto(input("Nombre del producto: "))
                if error != "":
                    print(error)

            if encontrar_por_campo(productos, "nombre", nombre) != None:
                print("Ya existe un producto con ese nombre.")
            else:
                precio = None
                while precio == None:
                    precio, error = validar_numero(input("Precio: "), float, 0)
                    if error != "":
                        print(error)

                stock = None
                while stock == None:
                    stock, error = validar_numero(input("Stock: "), int, 0)
                    if error != "":
                        print(error)

                nuevo = {"nombre": nombre, "precio": precio, "stock": stock}
                if agregar_objeto(productos, nuevo, "nombre") == "agregado":
                    print("Producto añadido.")

        elif opcion == "3":
            nombre = input("Nombre exacto del producto: ").strip()
            if encontrar_por_campo(productos, "nombre", nombre) == None:
                print("Producto no encontrado.")
            else:
                nuevo_stock = None
                while nuevo_stock == None:
                    nuevo_stock, error = validar_numero(input("Nuevo stock: "), int, 0)
                    if error != "":
                        print(error)
                if modificar_campo(productos, "nombre", nombre, "stock", nuevo_stock) == True:
                    print("Stock actualizado.")

        elif opcion == "4":
            texto = input("Texto que quieres buscar: ").strip()
            encontrados = buscar_texto(productos, "nombre", texto)
            if len(encontrados) == 0:
                print("No hay productos.")
            for linea in listar_productos(encontrados):
                print(linea)

        elif opcion == "5":
            cantidad = guardar_csv(RUTA_CSV, productos, CAMPOS)
            print(f"Guardados {cantidad} productos en {RUTA_CSV.name}.")

        elif opcion != "0":
            print("Opción no válida.")


if __name__ == "__main__":
    main()
