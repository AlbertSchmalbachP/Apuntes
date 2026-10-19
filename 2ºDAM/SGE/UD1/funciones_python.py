# Librería de funciones Python básicas para examen

# Pide un número por teclado hasta que sea válido
def pedir_numero(mensaje, tipo, minimo=None, maximo=None):
    while True:
        try:
            valor = tipo(input(mensaje).strip())
        except ValueError:
            print("Introduce un valor válido.")
            continue # siguiente iteración

        if minimo is not None and valor < minimo:
            print(f"El valor no puede ser menor que {minimo}.")
        elif maximo is not None and valor > maximo:
            print(f"El valor no puede ser mayor que {maximo}.")
        else:
            return valor