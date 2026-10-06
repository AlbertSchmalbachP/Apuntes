producto = input("Introduce el nombre del producto: ")
stock = input("Introduce el stock del producto: ")
if stock < 0:
    print("No se aceptan cantidades negativas.")
elif stock == 0:
    print("Agotado.")
elif stock <= 5:
    print("Stock bajo.")
else:
    print("Stock suficiente.")