# R8E2 | clasificar_stock
# Función que devuelve una categoría de stock.
# Consulta el PDF de la Relación 08 para el enunciado completo y la comprobación.

def clasificar_stock(stock):
    if stock == 0:
        estado = "Agotado"
    elif stock <= 5:
        estado = "Stock bajo"
    else:
        estado = "Stock suficiente"
    return estado

stockInput = int(input("Introduce el stock del producto: "))
while stockInput < 0:
    stockInput = int(input("El stock no puede ser negativo.\nIntroduce el stock del producto: "))
print(clasificar_stock(stockInput))