# modelos_tecnico.py
class Trabajo:
    # Clase padre que define los datos comunes
    def __init__(self, codigo, cliente, horas, estado="Pendiente"):
        self.codigo = codigo
        self.cliente = cliente
        self.horas = float(horas)
        self.estado = estado

    def cambiar_estado(self, nuevo_estado):
        # Reglas: no puede retroceder y no puede saltar de pendiente a finalizado
        if self.estado == "Pendiente" and nuevo_estado == "Finalizado":
            return False
        self.estado = nuevo_estado
        return True

    # Método genérico que heredarán y pisarán las hijas
    def calcular_importe(self):
        return 0.0

# CLASE HIJA 1
class Reparacion(Trabajo):
    def __init__(self, codigo, cliente, horas, precio_pieza, estado="Pendiente"):
        # Llamamos al constructor de la clase padre
        super().__init__(codigo, cliente, horas, estado)
        self.precio_pieza = float(precio_pieza)

    def calcular_importe(self):
        # 25€/hora + pieza
        return (self.horas * 25.0) + self.precio_pieza

# CLASE HIJA 2
class AsistenciaRemota(Trabajo):
    def __init__(self, codigo, cliente, horas, estado="Pendiente"):
        super().__init__(codigo, cliente, horas, estado)

    def calcular_importe(self):
        # 20€/hora sin piezas
        return self.horas * 20.0