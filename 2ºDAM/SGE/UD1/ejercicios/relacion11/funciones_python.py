import csv
from pathlib import Path

# Librería de funciones Python básicas para examen

#* VALIDACION

# Valida un número según tipo (int/float), mínimo y máximo (opcionales)
def validar_numero(texto, tipo, minimo=None, maximo=None):
    valor = None
    error = ""
    try:
        valor = tipo(texto.strip())
        if minimo != None and valor < minimo:
            error = f"El valor no puede ser menor que {minimo}."
        elif maximo != None and valor > maximo:
            error = f"El valor no puede ser mayor que {maximo}."
    except ValueError:
        error = "Introduce un valor válido."
    if error != "":
        valor = None
    return valor, error
#? ejemplo uso:
#   edad = None
#   while edad == None:
#       edad, error = validar_numero(input("Introduce una edad: "), int, 0, 120)
#       if error != "":
#           print(error)


# Valida que el texto no esté vacío
def validar_texto(texto):
    valor = texto.strip()
    error = ""
    if valor == "":
        error = "El texto no puede estar vacío."
        valor = None
    return valor, error
#? ejemplo uso:
#   nombre = None
#   while nombre == None:
#       nombre, error = validar_texto(input("Introduce un nombre: "))
#       if error != "":
#           print(error)


# Pide s o n. Devuelve True si es "s", False si es "n"
# No hace f
def pedir_si_no(mensaje):
    respuesta = ""
    while respuesta != "s" and respuesta != "n":
        respuesta = input(mensaje).strip().lower()
    return respuesta == "s"
#? ejemplo uso:
#   if pedir_si_no("¿Quieres guardar? (s/n): "):
#       print("Guardado")



#* CALCULOS

def calcular_subtotal(precio, cantidad):
    return precio * cantidad


def aplicar_descuento(importe, porcentaje=0):
    return importe - importe * porcentaje / 100


def calcular_iva(importe, porcentaje=21):
    return importe * porcentaje / 100


def calcular_total_con_iva(importe, porcentaje=21):
    return importe + calcular_iva(importe, porcentaje)


def calcular_media(numeros):
    media = 0
    if len(numeros) > 0:
        media = sum(numeros) / len(numeros)
    return media



#* DICCIONARIOS

# Encuentra el primer diccionario que coincida, o None
def encontrar_por_campo(items, campo, valor):
    encontrado = None
    for item in items:
        if encontrado is None and str(item[campo]).casefold() == str(valor).casefold():
            encontrado = item
    return encontrado


# Lista los diccionarios cuyo campo contiene el texto
def buscar_texto(items, campo, texto):
    busqueda = texto.casefold()
    return [item for item in items if busqueda in str(item[campo]).casefold()]


# Agrega el diccionario si no hay otro con la misma clave. Devuelve "agregado" o "duplicado"
def agregar_objeto(items, item, campo_clave):
    resultado = "duplicado"
    if encontrar_por_campo(items, campo_clave, item[campo_clave]) is None:
        items.append(item)
        resultado = "agregado"
    return resultado


# Cambia un campo del elemento encontrado por su clave. Devuelve True si lo encontró
def modificar_campo(items, campo_clave, valor_clave, campo, nuevo_valor):
    item = encontrar_por_campo(items, campo_clave, valor_clave)
    modificado = False
    if item is not None:
        item[campo] = nuevo_valor
        modificado = True
    return modificado


# Elimina el elemento encontrado por su clave. Devuelve True si lo encontró
def eliminar_item(items, campo_clave, valor_clave):
    item = encontrar_por_campo(items, campo_clave, valor_clave)
    eliminado = False
    if item is not None:
        items.remove(item)
        eliminado = True
    return eliminado


# Suma el valor de un campo numérico de todos los elementos
def sumar_campo(items, campo):
    return sum(item[campo] for item in items)


# Devuelve el elemtno de mayor valor, o None si el campo esta vacio
def maximo_por_campo(items, campo):
    mayor = None
    for item in items:
        if mayor is None or item[campo] > mayor[campo]:
            mayor = item
    return mayor



#* FICHEROS

# Guarda la lista de diccionarios en un CSV. Devuelve cuántos guardó
def guardar_csv(nombre_archivo, items, campos):
    with open(nombre_archivo, "w", newline="", encoding="utf-8") as archivo:
        escritor = csv.DictWriter(archivo, fieldnames=campos)
        escritor.writeheader()
        escritor.writerows(items)
    return len(items)


# Carga un CSV como lista de diccionarios (lista vacía si el archivo no existe)
def cargar_csv(nombre_archivo):
    items = []
    if Path(nombre_archivo).exists():
        with open(nombre_archivo, "r", newline="", encoding="utf-8") as archivo:
            for fila in csv.DictReader(archivo):
                items.append(dict(fila))
    return items # números son deveultos como texto (conv. usando int()/float() fuera si es necesario)


# Guarda una lista en un txt
def guardar_txt(nombre_archivo, lineas):
    with open(nombre_archivo, "w", encoding="utf-8") as archivo:
        for linea in lineas:
            archivo.write(linea + "\n")


# Lee un .txt como lista
def leer_txt(nombre_archivo):
    lineas = []
    if Path(nombre_archivo).exists():
        with open(nombre_archivo, "r", encoding="utf-8") as archivo:
            for linea in archivo:
                lineas.append(linea.strip())
    return lineas



#* PROGRAMA CON MENU PLANTILLA

def main():
    datos = []
    opcion = ""
    while opcion != "0":
        print("\n1) Listar\n2)Añadir\n3)Eliminar\n0) Salir")
        opcion = input("Opción: ").strip()
        if opcion == "1":
            for linea in datos:
                print(linea)
        elif opcion == "2":
            pass
        elif opcion == "3":
            pass
        elif opcion != "0":
            print("Opción no válida.")


if __name__ == "__main__":
    main()