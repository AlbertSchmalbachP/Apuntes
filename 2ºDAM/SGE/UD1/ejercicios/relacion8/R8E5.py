# R8E5 | Programa modular
# Funciones pedir_datos, calcular_total, mostrar_resumen y main.
# Consulta el PDF de la Relación 08 para el enunciado completo y la comprobación.

def pedir_datos():
    cliente = input("Introduce el nombre del cliente: ")
    precio = int(input("Introduce el precio del producto: "))
    cantidad = int(input("Introduce la cantidad a comprar del producto: "))
    descuento = input("Introduce el procentaje de descunto del producto (déjalo en 0 si no se aplica ningun descuento): ")
    if descuento == "":
        descuento = 0
    else:
        descuento = float(descuento) / 100
    return cliente, precio, cantidad, descuento

def calcular_total(precio, cantidad, descuento):
    return precio * cantidad - (precio * cantidad * descuento)

def mostrar_resumen(cliente, precio, cantidad, descuento, total):
    return f"\nResumen del pedido\n\nCliente: {cliente}\nPrecio: {precio}\nCantidad: {cantidad}\nDescuento aplicado: {(descuento * 100)}%\n\nTotal: {total}€"

def main():
    cliente, precio, cantidad, descuento = pedir_datos()
    total = calcular_total(precio, cantidad, descuento)
    print(mostrar_resumen(cliente, precio, cantidad, descuento, total))

main()