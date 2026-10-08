producto = input("Nombre del producto: ")
precio = float(input("Precio: "))
cantidad = int(input("Cantidad: "))
porcentaje_descuento = float(input("Porcentaje de descuento: "))

subtotal = precio * cantidad
descuento = subtotal * porcentaje_descuento / 100
total = subtotal - descuento

print(f"Producto: {producto}")
print(f"Subtotal: {subtotal:.2f} EUR")
print(f"Descuento: {descuento:.2f} EUR")
print(f"Total: {total:.2f} EUR")
