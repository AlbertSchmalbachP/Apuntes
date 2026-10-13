# R6E3 | Introducir importes hasta cero
# Acumula importes con while hasta introducir 0.
# Consulta el PDF de la Relación 06 para el enunciado completo y la comprobación.

importe = -1
contador = 0
total = 0
while importe != 0:
    importe = int(input("Introduce un importe: "))
    if importe != 0:
        total = total + importe
        contador = contador + 1
print(f"Contador: {contador}. Total: {total:.2f}€.")