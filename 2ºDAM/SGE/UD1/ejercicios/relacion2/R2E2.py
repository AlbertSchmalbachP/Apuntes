cliente = input("Nombre del cliente: ")
servicio = input("Nombre del servicio: ")
precio = float(input("Precio unitario: "))
cantidad = int(input("Cantidad: "))

subtotal = precio * cantidad

print(f"Cliente: {cliente}")
print(f"Servicio: {servicio}")
print(f"Precio unitario: {precio:.2f} EUR")
print(f"Cantidad: {cantidad}")
print(f"Subtotal: {subtotal:.2f} EUR")
