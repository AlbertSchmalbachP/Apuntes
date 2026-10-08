cliente = input("Cliente: ")

producto_1 = input("Nombre del producto 1: ")
precio_1 = float(input("Precio del producto 1: "))
cantidad_1 = int(input("Cantidad del producto 1: "))

producto_2 = input("Nombre del producto 2: ")
precio_2 = float(input("Precio del producto 2: "))
cantidad_2 = int(input("Cantidad del producto 2: "))

subtotal_1 = precio_1 * cantidad_1
subtotal_2 = precio_2 * cantidad_2
total = subtotal_1 + subtotal_2

print(f"Cliente: {cliente}")
print(f"{producto_1}: {cantidad_1} x {precio_1:.2f} EUR = {subtotal_1:.2f} EUR")
print(f"{producto_2}: {cantidad_2} x {precio_2:.2f} EUR = {subtotal_2:.2f} EUR")
print(f"Total: {total:.2f} EUR")
