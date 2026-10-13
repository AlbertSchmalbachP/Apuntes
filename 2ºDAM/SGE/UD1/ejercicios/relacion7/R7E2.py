# R7E2 | Resumen de precios
# len, sum, min, max y media sobre una lista.
# Consulta el PDF de la Relación 07 para el enunciado completo y la comprobación.

precios = [2,5,4,6,9]
for valor in precios: 
    print(valor)
print(f"Cantidad de precios: {len(precios):.2f}")
print(f"Suma: {sum(precios):.2f}")
print(f"Mínimo: {min(precios):.2f}")
print(f"Máximo: {max(precios):.2f}")
print(f"Media: {sum(precios) / len(precios):.2f}")