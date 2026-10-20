# main_floristeria.py
import csv
from modelos_floristeria import Producto, Venta

def main():
    catalogo = []
    ventas_historicas = []
    venta_actual = Venta() # Creamos un carrito vacío al arrancar

    # 1. CARGA DE DATOS (Persistencia)
    try:
        with open("productos.csv", "r", encoding="utf-8") as f:
            lector = csv.DictReader(f)
            for fila in lector:
                catalogo.append(Producto(fila["codigo"], fila["nombre"], fila["precio"], fila["stock"]))
    except FileNotFoundError:
        pass # Si no existe el archivo, empezamos con el catálogo vacío

    # 2. BUCLE DEL MENÚ SIN WHILE TRUE
    opcion = "-1"
    while opcion != "0":
        print("\n--- FLORISTERÍA LILA ---")
        print("1) Ver productos | 2) Alta | 3) Reponer | 4) Nueva venta / añadir líneas")
        print("5) Cerrar venta  | 6) Consultar ventas | 7) Guardar | 0) Salir")
        opcion = input("Elige una opción: ")

        if opcion == "1":
            print("\n--- CATÁLOGO ---")
            for p in catalogo:
                print(f"[{p.codigo}] {p.nombre} - {p.precio}€ (Stock: {p.stock})")

        elif opcion == "2":
            # Alta de nuevo producto con validación try/except[cite: 4]
            codigo = input("Código: ")
            nombre = input("Nombre: ")
            try:
                precio = float(input("Precio: "))
                stock = int(input("Stock inicial: "))
                catalogo.append(Producto(codigo, nombre, precio, stock))
                print("Producto añadido.")
            except ValueError:
                print("Error: El precio y el stock deben ser números.")

        elif opcion == "3":
            # Reponer stock
            codigo = input("Código del producto a reponer: ")
            for p in catalogo:
                if p.codigo == codigo:
                    try:
                        cantidad = int(input("Cantidad a sumar: "))
                        p.devolver(cantidad) # Usamos el método del modelo
                        print("Stock actualizado.")
                    except ValueError:
                        print("Error: Introduce un número.")
                    break

        elif opcion == "4":
            # Añadir línea a la venta actual
            codigo = input("Código del producto a vender: ")
            producto_encontrado = None
            for p in catalogo:
                if p.codigo == codigo:
                    producto_encontrado = p
                    break
            
            if producto_encontrado:
                try:
                    cantidad = int(input("Cantidad a vender: "))
                    # agregar_linea descuenta el stock automáticamente si hay suficiente[cite: 4]
                    if venta_actual.agregar_linea(producto_encontrado, cantidad):
                        print("Añadido a la venta actual.")
                    else:
                        print("Error: No hay stock suficiente.")
                except ValueError:
                    print("Error: La cantidad debe ser un número entero.")
            else:
                print("Producto no encontrado.")

        elif opcion == "5":
            # Cerrar la venta
            if len(venta_actual.lineas) > 0:
                print(f"Venta cerrada. Total cobrado: {venta_actual.total():.2f}€")
                ventas_historicas.append(venta_actual)
                venta_actual = Venta() # Abrimos una nueva venta vacía para el siguiente cliente
            else:
                print("No hay nada en la venta actual.")

        elif opcion == "6":
            # Consultar el histórico
            print("\n--- HISTÓRICO DE VENTAS ---")
            total_caja = 0
            for i, v in enumerate(ventas_historicas, 1):
                print(f"Venta {i} - Total: {v.total():.2f}€")
                total_caja += v.total()
            print(f"TOTAL RECAUDADO: {total_caja:.2f}€")

        elif opcion == "7" or opcion == "0":
            # Guardado antes de salir (Persistencia)[cite: 4]
            with open("productos.csv", "w", newline="", encoding="utf-8") as f:
                campos = ["codigo", "nombre", "precio", "stock"]
                escritor = csv.DictWriter(f, fieldnames=campos)
                escritor.writeheader()
                for p in catalogo:
                    escritor.writerow({"codigo": p.codigo, "nombre": p.nombre, "precio": p.precio, "stock": p.stock})
            print("Datos guardados correctamente.")

if __name__ == "__main__":
    main()