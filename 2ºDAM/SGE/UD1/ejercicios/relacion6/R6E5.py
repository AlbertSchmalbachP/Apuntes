# R6E5 | Tabla de previsiones
# Usa dos for anidados para todas las combinaciones producto-mes.
# Consulta el PDF de la Relación 06 para el enunciado completo y la comprobación.

num_productos = int(input("Introduce un número de productos: "))
num_meses = int(input("Introduce un número de meses: "))
mensaje = ""
for producto in range(num_productos):
    for mes in range(num_meses):
        mensaje = mensaje + f"\nProducto {producto + 1} - Mes {mes + 1}"
print(mensaje)