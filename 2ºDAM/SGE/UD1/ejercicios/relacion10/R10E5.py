# R10E5 | Pedido y líneas
# LineaPedido + Pedido, composición y total().
# Consulta el PDF de la Relación 10 para el enunciado completo y la comprobación.

class LineaPedido:
    def __init__(self, producto, precio, cantidad):
        self.producto = producto
        self.precio = precio
        self.cantidad = cantidad
    
    def subtotal(self):
        return self.precio * self.cantidad

class Pedido:
    def __init__(self, cliente, lista_lineas):
        self.cliente = cliente
        self.lista_lineas = lista_lineas
    
    def agregar_linea(self, linea):
        self.lista_lineas.append(linea)
    
    def total(self):
        total = 0
        for linea in self.lista_lineas:
            total += linea.subtotal()
        return total

pedido = Pedido("Albert", [])
pedido.agregar_linea(LineaPedido("Ratón", 15, 2))
pedido.agregar_linea(LineaPedido("Teclado", 20.50, 1))
pedido.agregar_linea(LineaPedido("Monitor", 90, 1))
print(f"Total: {pedido.total():.2f}€")