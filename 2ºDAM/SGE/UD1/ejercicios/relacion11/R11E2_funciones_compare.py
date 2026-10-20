# R11E2 | Mini CRM local
# Alta/listado/búsqueda/desactivación + persistencia CSV.

from pathlib import Path
from funciones_python import (
    validar_texto,
    agregar_objeto,
    modificar_campo,
    guardar_csv,
    cargar_csv,
)

RUTA_CSV = Path(__file__).with_name("clientes_crm.csv")
CAMPOS = ["nombre", "email", "ciudad", "activo"]


# cargar_csv devuelve todo como texto: aquí "activo" vuelve a ser True/False
def convertir_clientes(filas):
    clientes = []
    for fila in filas:
        clientes.append({
            "nombre": fila["nombre"],
            "email": fila["email"],
            "ciudad": fila["ciudad"],
            "activo": fila["activo"].strip().lower() == "true",
        })
    return clientes


# Devuelve el cliente como texto: "Lucía | lucia@x.com | Granada | Activo"
def formatear_cliente(cliente):
    estado = "Inactivo"
    if cliente["activo"] == True:
        estado = "Activo"
    return f"{cliente['nombre']} | {cliente['email']} | {cliente['ciudad']} | {estado}"


# Devuelve la lista de clientes como líneas de texto, la impresión se hace en main()
def listar_clientes(clientes):
    return [formatear_cliente(cliente) for cliente in clientes]


# Busca el texto en nombre, email o ciudad (buscar_texto de la librería solo mira un campo)
def buscar_clientes(clientes, texto):
    busqueda = texto.casefold()
    return [
        cliente for cliente in clientes
        if (busqueda in cliente["nombre"].casefold()
            or busqueda in cliente["email"].casefold()
            or busqueda in cliente["ciudad"].casefold())
    ]


def main():
    clientes = convertir_clientes(cargar_csv(RUTA_CSV))  # Recupera lo guardado antes
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
            nombre = None
            while nombre == None:
                nombre, error = validar_texto(input("Nombre: "))
                if error != "":
                    print(error)

            email = None
            while email == None:
                email, error = validar_texto(input("Email: "))
                if error != "":
                    print(error)

            ciudad = None
            while ciudad == None:
                ciudad, error = validar_texto(input("Ciudad: "))
                if error != "":
                    print(error)

            nuevo = {"nombre": nombre, "email": email, "ciudad": ciudad, "activo": True}
            if agregar_objeto(clientes, nuevo, "email") == "agregado":
                print("Cliente añadido.")
            else:
                print("Ya existe un cliente con ese email.")

        elif opcion == "2":
            if len(clientes) == 0:
                print("No hay clientes.")
            for linea in listar_clientes(clientes):
                print(linea)

        elif opcion == "3":
            texto = input("Texto de búsqueda: ").strip()
            encontrados = buscar_clientes(clientes, texto)
            if len(encontrados) == 0:
                print("No hay clientes.")
            for linea in listar_clientes(encontrados):
                print(linea)

        elif opcion == "4":
            email = input("Email del cliente que quieres desactivar: ").strip()
            if modificar_campo(clientes, "email", email, "activo", False) == True:
                print("Cliente desactivado.")
            else:
                print("Cliente no encontrado.")

        elif opcion == "5":
            cantidad = guardar_csv(RUTA_CSV, clientes, CAMPOS)
            print(f"Guardados {cantidad} clientes.")

        elif opcion == "6":
            clientes = convertir_clientes(cargar_csv(RUTA_CSV))
            print(f"Cargados {len(clientes)} clientes.")

        elif opcion != "0":
            print("Opción no válida.")


if __name__ == "__main__":
    main()
