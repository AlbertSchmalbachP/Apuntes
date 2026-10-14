# R8E1 | calcular_subtotal
# Función con parámetros y return.
# Consulta el PDF de la Relación 08 para el enunciado completo y la comprobación.

def calcular_subtotal(precio, cantidad):
    return precio * cantidad

# Pedir valores
precioInput = int(input("Introduce el precio del producto: "))
while precioInput < 0:
    precioInput = int(input("El precio no puede ser negativo.\nIntroduce el precio del producto: "))

cantidadInput = int(input("Introduce la cantidad del producto: "))
while cantidadInput < 0:
    cantidadInput = int(input("La cantidad a comprar no puede ser negativa.\nIntroduce el precio del producto: "))

# LLamar a la función
resultado = calcular_subtotal(precioInput, cantidadInput)
print(f"{resultado:.2f}€")