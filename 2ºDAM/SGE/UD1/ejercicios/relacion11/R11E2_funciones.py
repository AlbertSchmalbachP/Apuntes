# R11E2 | Mini CRM local
# Alta/listado/búsqueda/desactivación + persistencia CSV.
# Consulta el PDF de la Relación 11 para el enunciado completo y la comprobación.

from pathlib import Path
from funciones_python import (
    validar_texto,
    encontrar_por_campo,
    agregar_objeto,
    modificar_campo,
    buscar_texto,
    guardar_csv,
    validar_si_no,
    cargar_csv
)

RUTA_CSV = Path(__file__).with_name("clientes.csv")
CAMPOS = ["nombre", "email", "ciudad", "activo"]

def listar_clientes(clientes):
    return [
        formatear_cliente(numero, cliente)
        for numero, cliente in enumerate(clientes, start=1)
    ]

def formatear_cliente(numero, cliente):
    return (
        f"\n--- {numero}. {cliente['nombre']} ---\nEmail: {cliente['email']}\nCiudad: {cliente['ciudad']}\nActivo: {cliente['activo']}"
    )

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

def main():
    clientes = convertir_clientes(cargar_csv(RUTA_CSV))  # Recupera lo guardado
    opcion = ""
    while opcion != "0":
        print("\n1) Dar cliente de alta")
        print("2) Listar clientes")
        print("3) Buscar por nombre")
        print("4) Desactivar cliente")
        print("5) Guardar en CSV")
        print("6) Cargar en CSV")
        print("0) Salir")
        opcion = input("Introduce una opción: ").strip()
        if opcion == "1":
            nombre = None
            email = None
            while nombre == None:
                nombre, error = validar_texto(input("Introduce el nombre del cliente: "))
                if error != "":
                    print(error)
            if encontrar_por_campo(clientes, "nombre", nombre) != None:
                print("Ya existe un cliente con ese nombre.")
            else:
                while email == None:
                    email, error = validar_texto(input("Introduce el email del cliente: "))
                    if error != "":
                        print(error)
                    ciudad = None
                while ciudad == None:
                    ciudad, error = validar_texto(input("Introduce la ciudad del cliente: "))
                    if error != "":
                        print(error)
                guardar = None
                while guardar is None:
                    guardar, error = validar_si_no(input("¿Quieres guardar? (s/n): "))
                    if error != "":
                        print(error)
                if guardar:
                    print("Guardado")
                activo = validar_si_no("¿Quieres marcarlo como \"activo\"? (s/n): ")
                nuevo = {"nombre": nombre, "email": email, "ciudad": ciudad, "activo": activo}
                if agregar_objeto(clientes, nuevo, "nombre") == "agregado":
                    print("Cliente agregado con éxito.")

        elif opcion == "2":
            if len(clientes) == 0:
                print("No hay clientes.")
            for linea in listar_clientes(clientes):
                print(linea)
        
        elif opcion == "3":
            texto = input("Introduce el nombre a buscar: ").strip()
            encontrados = buscar_texto(clientes, "nombre", texto)
            if len(encontrados) == 0:
                print("No hay clientes que coincidan.")
            for linea in listar_clientes(encontrados):
                print(linea)
        
        elif opcion == "4":
            nombre = input("Introduce el nombre del cliente a desactivar: ").strip()
            if modificar_campo(clientes, "nombre", nombre, "activo", False):
                print("Cliente desactivado con éxito.")
            else:
                print("No se ha encontrado al cliente.")
        
        elif opcion == "5":
            cantidad = guardar_csv(RUTA_CSV, clientes, CAMPOS)
            print(f"{cantidad} clientes guardados con éxito en {RUTA_CSV.name}.")
        
        elif opcion == "6":
            clientes = convertir_clientes(cargar_csv(RUTA_CSV))
            print(f"{len(clientes)} clientes cargados con éxito desde {RUTA_CSV.name}.")
        
        elif opcion == "0":
            print("Programa finalizado.")
        else:
            print("Opción no válida.")


if __name__ == "__main__":
    main()