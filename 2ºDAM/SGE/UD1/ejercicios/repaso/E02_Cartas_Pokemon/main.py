# main_pokemon.py
import csv
from modelos_pokemon import Carta, Coleccion

def main():
    mi_coleccion = Coleccion()
    tu_coleccion = Coleccion() # Colección ficticia para probar los intercambios

    # Metemos una carta de prueba en la colección rival para poder hacer intercambios
    tu_coleccion.agregar(Carta("PK03", "Bulbasaur", "Planta", "Común", 4.0))

    # Carga de CSV inicial
    try:
        with open("cartas.csv", "r", encoding="utf-8") as archivo:
            lector = csv.DictReader(archivo)
            for fila in lector:
                carta = Carta(fila["codigo"], fila["nombre"], fila["tipo"], fila["rareza"], fila["valor"])
                mi_coleccion.agregar(carta)
    except FileNotFoundError:
        pass

    opcion = "-1"
    # Menú sin while True
    while opcion != "0":
        print("\n--- COLECCIÓN POKÉMON ---")
        print("1) Listar  | 2) Añadir   | 3) Eliminar")
        print("4) Buscar  | 5) Cambiar  | 6) Estadísticas | 0) Salir y Guardar")
        opcion = input("Elige: ")

        if opcion == "1":
            for c in mi_coleccion.cartas.values():
                print(f"[{c.codigo}] {c.nombre} ({c.tipo} - {c.rareza}) - {c.valor}€")

        elif opcion == "2":
            codigo = input("Código (ej. PK04): ")
            if codigo == "":
                print("Error: El código no puede estar vacío.")
            else:
                nombre = input("Nombre: ")
                tipo = input("Tipo: ")
                rareza = input("Rareza: ")
                try:
                    valor = float(input("Valor en €: "))
                    if valor < 0:
                        print("Error: Valor negativo.")
                    elif mi_coleccion.agregar(Carta(codigo, nombre, tipo, rareza, valor)):
                        print("Carta añadida.")
                    else:
                        print("Error: Ya existe una carta con ese código.")
                except ValueError:
                    print("Error: El valor debe ser un número.")

        elif opcion == "3":
            codigo = input("Código de la carta a eliminar: ")
            # La extraemos al aire (se pierde)
            if mi_coleccion.extraer(codigo):
                print("Carta eliminada.")
            else:
                print("Error: Carta no encontrada.")

        elif opcion == "5":
            print("\n- Tu colección:")
            for c in mi_coleccion.cartas.values():
                print(f"[{c.codigo}] {c.nombre}")
            print("- Colección Rival:")
            for c in tu_coleccion.cartas.values():
                print(f"[{c.codigo}] {c.nombre}")
            
            mi_codigo = input("\nTu código a entregar: ")
            su_codigo = input("Código rival que quieres: ")
            
            # Llamamos a la operación atómica
            resultado = mi_coleccion.intercambiar(tu_coleccion, mi_codigo, su_codigo)
            print(resultado)

        elif opcion == "6":
            print(f"Valor total: {mi_coleccion.valor_total():.2f}€")
            print(f"Número de cartas: {len(mi_coleccion.cartas)}")

    # Volcado al CSV antes de salir
    with open("cartas.csv", "w", newline="", encoding="utf-8") as archivo:
        escritor = csv.DictWriter(archivo, fieldnames=["codigo", "nombre", "tipo", "rareza", "valor"])
        escritor.writeheader()
        for c in mi_coleccion.cartas.values():
            escritor.writerow({"codigo": c.codigo, "nombre": c.nombre, "tipo": c.tipo, "rareza": c.rareza, "valor": c.valor})
    print("Colección guardada. ¡Atrápalos a todos!")

if __name__ == "__main__":
    main()