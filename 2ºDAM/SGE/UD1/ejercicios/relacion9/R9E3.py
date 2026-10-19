# R9E3 | Guardar clientes
# Escribe y lee clientes.txt con with open y UTF-8.
# Consulta el PDF de la Relación 09 para el enunciado completo y la comprobación.

from pathlib import Path

ruta = Path(__file__).with_name("clientes.txt")
clientes = []

for numero in range(1, 4): # range(1, 4) da los números 1, 2 y 3, así que el bucle se repite 3 veces.
    nombre = input(f"Nombre del cliente {numero}: ").strip()
    ciudad = input(f"Ciudad del cliente {numero}: ").strip()
    clientes.append(f"{nombre};{ciudad}")

with open(ruta, "w", encoding="utf-8") as archivo:
    for cliente in clientes:
        archivo.write(cliente + "\n")

print("\nContenido de clientes.txt:")
with open(ruta, "r", encoding="utf-8") as archivo:
    for linea in archivo:
        print(linea.rstrip("\n")) # rstrip("\n") quita el salto de línea del final de cada línea, ya que for linea ya incluye un salto de linea