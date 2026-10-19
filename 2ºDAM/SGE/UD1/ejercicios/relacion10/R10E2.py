# R10E2 | Métodos de inventario
# vender() y reponer() con actualización de stock.
# Consulta el PDF de la Relación 10 para el enunciado completo y la comprobación.

class Producto:
    def __init__(self, nombre, precio, stock):
        self.nombre = nombre
        self.precio = precio
        self.stock = stock

    def vender(self, cantidad):
        posible = False
        if cantidad <= self.stock or cantidad <= 0:
            self.stock -= cantidad
            posible = True
        return posible

    def reponer(self, cantidad):
        if cantidad > 0:
            self.stock += cantidad

    def mostrar(self):
        print(f"{self.nombre}: {self.precio:.2f} EUR | Stock: {self.stock}")

cantidad_vender = 3
cantidad_reponer = 8
producto1 = Producto("Teclado", 25.0, 3)
producto2 = Producto("Monitor", 97.95, 7)
producto1.mostrar()
producto2.mostrar()
producto1.vender(cantidad_vender)
producto2.reponer(cantidad_reponer)
producto1.mostrar()
producto2.mostrar()