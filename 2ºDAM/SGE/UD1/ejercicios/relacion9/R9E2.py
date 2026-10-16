# R9E2 | leer_entero
# Función reutilizable con mínimo y máximo.
# Consulta el PDF de la Relación 09 para el enunciado completo y la comprobación.

def leer_entero(entrada, minimo, maximo):
    valido = False
    while not valido:
        try:
            entero = int(input(entrada))
            if minimo <= entero <= maximo:
                valido = True
            else:
                print(f"El entero debe estar entre {minimo} y {maximo}.")
        except ValueError:
            print("Introduce un número válido.")
    return entero


def main():
    minimo = 1
    maximo = 100
    entrada = f"Introduce un número entero entre {minimo} y {maximo}: "
    numero = leer_entero(entrada, minimo, maximo)
    print(f"Has introducido el {numero}.")

main()