# modelos_floristeria.py

class Producto:
    def __init__(self, codigo, nombre, precio, stock):
        self.codigo = codigo
        self.nombre = nombre
        self.precio = float(precio)
        self.stock = int(stock)

    # Método para comprobar si hay stock antes de vender
    def reservar(self, cantidad):
        if 0 < cantidad <= self.stock:
            self.stock -= cantidad
            return True
        return False

    # Método para devolver stock si se repone o se cancela una venta
    def devolver(self, cantidad):
        self.stock += cantidad


class LineaVenta:
    # La línea guarda el producto entero y congela el precio por si este cambia en el futuro
    def __init__(self, producto, cantidad):
        self.producto = producto
        self.cantidad = cantidad
        self.precio_unitario = producto.precio

    def subtotal(self):
        return self.precio_unitario * self.cantidad


class Venta:
    def __init__(self):
        self.lineas = []
        self.cerrada = False

    def agregar_linea(self, producto, cantidad):
        # Solo se añade si la venta está abierta y el producto tiene stock suficiente
        if not self.cerrada and producto.reservar(cantidad):
            nueva_linea = LineaVenta(producto, cantidad)
            self.lineas.append(nueva_linea)
            return True
        return False

    def total(self):
        suma = 0
        for linea in self.lineas:
            suma += linea.subtotal()
        return suma

    # OPERACIÓN ATÓMICA: Si se cancela, recorre las líneas y devuelve el stock al producto
    def cancelar(self):
        if not self.cerrada:
            for linea in self.lineas:
                # Llama al método devolver del producto original
                linea.producto.devolver(linea.cantidad)
            self.lineas = [] # Vacía el carrito
            self.cerrada = True
            return True
        return False