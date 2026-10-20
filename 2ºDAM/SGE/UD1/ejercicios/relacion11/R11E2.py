# R11E2 | Mini CRM local
# Alta/listado/búsqueda/desactivación + persistencia CSV.
# Consulta el PDF de la Relación 11 para el enunciado completo y la comprobación.

import csv
from pathlib import Path

RUTA_CSV = Path(__file__).with_name("clientes_crm.csv")
CAMPOS = ["nombre", "email", "ciudad", "activo"]


def guardar_clientes(clientes):
    with open(RUTA_CSV, "w", newline="", encoding="utf-8") as archivo:
        escritor = csv.DictWriter(archivo, fieldnames=CAMPOS)
        escritor.writeheader()
        escritor.writerows(clientes)
    return len(clientes)


def cargar_clientes():
    clientes = []
    if RUTA_CSV.exists():
        with open(RUTA_CSV, "r", newline="", encoding="utf-8") as archivo:
            lector = csv.DictReader(archivo)
            for fila in lector:
                clientes.append({
                    "nombre": fila["nombre"],
                    "email": fila["email"],
                    "ciudad": fila["ciudad"],
                    "activo": fila["activo"].strip().lower() == "true",
                })
    return clientes


def formatear_cliente(cliente):
    estado = "Activo" if cliente["activo"] else "Inactivo"
    return f"{cliente['nombre']} | {cliente['email']} | {cliente['ciudad']} | {estado}"


def listar_clientes(clientes):
    """Devuelve las líneas preparadas para mostrar en main()."""
    return [formatear_cliente(cliente) for cliente in clientes]


def alta_cliente(clientes, nombre, email, ciudad):
    """Devuelve 'faltan_datos', 'duplicado' o 'anadido'."""
    if not nombre or not email or not ciudad:
        return "faltan_datos"
    if any(cliente["email"].casefold() == email.casefold() for cliente in clientes):
        return "duplicado"
    clientes.append({"nombre": nombre, "email": email, "ciudad": ciudad, "activo": True})
    return "anadido"


def buscar_clientes(clientes, texto):
    busqueda = texto.casefold()
    return [
        cliente for cliente in clientes
        if (busqueda in cliente["nombre"].casefold()
            or busqueda in cliente["email"].casefold()
            or busqueda in cliente["ciudad"].casefold())
    ]


def desactivar_cliente(clientes, email):
    for cliente in clientes:
        if cliente["email"].casefold() == email.casefold():
            cliente["activo"] = False
            return True
    return False


def main():
    clientes = cargar_clientes()  # Recupera lo guardado en una ejecución anterior.
    opcion = ""
    while opcion != "0":
        print("\n1) Alta de cliente")
        print("2) Listar clientes")
        print("3) Buscar por texto")
        print("4) Desactivar cliente")
        print("5) Guardar en CSV")
        print("6) Cargar desde CSV")
        print("0) Salir")
        opcion = input("Opción: ").strip()

        if opcion == "1":
            nombre = input("Nombre: ").strip()
            email = input("Email: ").strip()
            ciudad = input("Ciudad: ").strip()
            resultado = alta_cliente(clientes, nombre, email, ciudad)
            if resultado == "faltan_datos":
                print("Todos los datos son obligatorios.")
            elif resultado == "duplicado":
                print("Ya existe un cliente con ese email.")
            else:
                print("Cliente añadido.")

        elif opcion == "2":
            if not clientes:
                print("No hay clientes.")
            for linea in listar_clientes(clientes):
                print(linea)

        elif opcion == "3":
            texto = input("Texto de búsqueda: ").strip()
            encontrados = buscar_clientes(clientes, texto)
            if not encontrados:
                print("No hay clientes.")
            for linea in listar_clientes(encontrados):
                print(linea)

        elif opcion == "4":
            email = input("Email del cliente que quieres desactivar: ").strip()
            if desactivar_cliente(clientes, email):
                print("Cliente desactivado.")
            else:
                print("Cliente no encontrado.")

        elif opcion == "5":
            cantidad = guardar_clientes(clientes)
            print(f"Guardados {cantidad} clientes.")

        elif opcion == "6":
            clientes = cargar_clientes()
            print(f"Cargados {len(clientes)} clientes.")

        elif opcion != "0":
            print("Opción no válida.")


if __name__ == "__main__":
    main()