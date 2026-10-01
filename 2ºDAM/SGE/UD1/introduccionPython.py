# VARIABLES Y TIPOS DE DATOS
empresa = "AulaTec" # str: cadena de texto
unidades = 3 # int: número entero
precio = 45.50 # float: número decimal
disponible = True # bool: verdadero o falso
print(empresa)
print(unidades)

# CALCULAR DATOS
subtotal = precio * unidades
print(subtotal)

# MOSTRAR VARIABLES EN UN MENSAJE
cliente = "Lucía Vega"
importe = 136.5
print(f"Cliente: {cliente}")
print(f"Importe: {importe:.2f} EUR")

# LEER INPUTS
cliente = input("Nombre del cliente: ")
producto = input("Producto solicitado: ")
print(f"{cliente} solicita {producto}.")

# CONVERTIR TEXTO A NUMEROS
cantidad_texto = input("Cantidad: ")
precio_texto = input("Precio unitario: ")
cantidad = int(cantidad_texto)
precio = float(precio_texto)
subtotal = cantidad * precio
print(f"Subtotal: {subtotal:.2f} EUR")