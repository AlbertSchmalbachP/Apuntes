# R10E1 | Clase Producto
# Constructor, atributos y método mostrar.
# Consulta el PDF de la Relación 10 para el enunciado completo y la comprobación.

class Producto:
    def __init__(self, nombre, precio, stock):
        self.nombre = nombre
        self.precio = precio
        self.stock = stock

    def mostrar(self):
        print(f"{self.nombre}: {self.precio:.2f} EUR | Stock: {self.stock}")

producto1 = Producto("Teclado", 25.0, 3)
producto2 = Producto("Monitor", 97.95, 7)
producto1.mostrar()
producto2.mostrar()