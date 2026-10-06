precio = float(input("Introduce el precio unitario: "))
cantidad = float(input("Introduce la cantidad: "))
subtotal = precio * cantidad
if cantidad < 0:
    print("No se aceptan cantidades negativas.")
else:
    if cantidad < 5:
        descuento = 0
    elif cantidad < 10:
        descuento = 0.05
    else:
        descuento = 0.1
descontado = subtotal * descuento
total = subtotal - descontado
print(f"Subtotal: {subtotal:.2f} EUR | Porcentaje aplicado: {descuento * 100:.0f}% | Total: {total:.2f} EUR")