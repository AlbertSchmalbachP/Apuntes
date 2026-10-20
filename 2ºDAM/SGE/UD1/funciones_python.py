import csv

# Librería de funciones Python básicas para examen

#* VALIDACION

# Valida el numero segun tipo maximo y minimo (opcional)
def validar_numero(texto, tipo, minimo=None, maximo=None):
    valor = None
    error = ""
    try:
        valor = tipo(texto.strip())
        if minimo != None and valor < minimo:
            error = f"El valor no puede ser menor que {minimo}."
        elif maximo is not None and valor > maximo:
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


def validar_texto(texto):
    valor = texto.strip()
    error = ""
    if valor == "":
        error = "El texto no puede estar vacío."
        valor = None
    return valor, error
#? ejemplo uso:
#   nombre = None
#   while nombre is None:
#       nombre, error = validar_texto(input("Introduce un nombre: "))
#       if error != "":
#           print(error)


def pedir_si_no(mensaje):
    respuesta = ""
    while respuesta != "s" and respuesta != "n":
        respuesta = input(mensaje + " (s/n): ").strip().lower()
    return respuesta == "s"



#* CONVERSION

def convertir_entero(texto, minimo=0):
    resultado = None
    try:
        numero = int(texto)
        if numero >= minimo:
            resultado = numero
    except ValueError:
        resultado = None
    return resultado


def convertir_precio(texto):
    resultado = None
    try:
        precio = float(texto)
        if precio >= 0:
            resultado = precio
    except ValueError:
        resultado = None
    return resultado

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

# Encuentra el primer diccionario cuyo campo coincida
def encontrar_por_campo(items, campo, valor):
    encontrado = None
    for item in items:
        if encontrado is None and str(item[campo]).casefold() == str(valor).casefold():
            encontrado = item
    return encontrado


# Lista elementos cuyo campo contiene el texto
def buscar_texto(items, campo, texto):
    busqueda = texto.casefold()
    return [item for item in items if busqueda in str(item[campo]).casefold()]


# Agrega el objecto si no esa ya en el diccionario
def agregar_objeto(items, item, campo_clave):
    resultado = "duplicado"
    if encontrar_por_campo(items, campo_clave, item[campo_clave]) is None:
        items.append(item)
        resultado = "agregado"
    return resultado


def modificar_campo(items, campo_clave, valor_clave, campo, nuevo_valor):
    item = encontrar_por_campo(items, campo_clave, valor_clave)
    modificado = False
    if item is not None:
        item[campo] = nuevo_valor
        modificado = True
    return modificado


def eliminar_item(items, campo_clave, valor_clave):
    item = encontrar_por_campo(items, campo_clave, valor_clave)
    eliminado = False
    if item is not None:
        items.remove(item)
        eliminado = True
    return eliminado


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

def guardar_csv(nombre_archivo, items, campos):
    with open(nombre_archivo, "w", newline="", encoding="utf-8") as archivo:
        escritor = csv.DictWriter(archivo, fieldnames=campos)
        escritor.writeheader()
        escritor.writerows(items)
    return len(items)


def cargar_csv(nombre_archivo):
    items = []
    try:
        with open(nombre_archivo, "r", newline="", encoding="utf-8") as archivo:
            for fila in csv.DictReader(archivo):
                items.append(dict(fila))
    except FileNotFoundError:
        items = []
    return items   # números se deveulven como texto (conv. usando int()/float() fuera si necesario)


def guardar_txt(nombre_archivo, lineas):
    with open(nombre_archivo, "w", encoding="utf-8") as archivo:
        for linea in lineas:
            archivo.write(linea + "\n")
    return len(lineas)


def leer_txt(nombre_archivo):
    lineas = []
    try:
        with open(nombre_archivo, "r", encoding="utf-8") as archivo:
            for linea in archivo:
                lineas.append(linea.strip())
    except FileNotFoundError:
        lineas = []
    return lineas



#* PROGRAMA CON MENU PLANTILLA

def main():
    datos = []
    opcion = ""
    while opcion != "0":
        print("\n1) Listar\n2)Añadir\n3)Eliminar\n0) Salir")
        opcion = input("Opción: ").strip()
        if opcion == "1":
            for linea in listar_items(datos):
                print(linea)
        elif opcion == "2":
            pass
        elif opcion == "3":
            pass
        elif opcion != "0":
            print("Opción no válida.")


if __name__ == "__main__":
    main()