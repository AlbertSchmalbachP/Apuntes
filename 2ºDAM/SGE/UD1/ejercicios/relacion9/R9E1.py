# R9E1 | Precio válido
# try/except ValueError y bucle con condición explícita.
# Consulta el PDF de la Relación 09 para el enunciado completo y la comprobación.

valido = False
precio = 0.0
while not valido:
    try:
        precio = float(input("Precio: "))
        if precio >= 0:
            valido = True
        if not valido:
            print("El precio no puede ser negativo")
    except ValueError:
        print("Introduce un número válido")