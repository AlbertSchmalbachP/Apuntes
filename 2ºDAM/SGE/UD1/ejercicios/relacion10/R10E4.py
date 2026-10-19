# R10E4 | Herencia
# Empleado y Comercial con super() y bonus.
# Consulta el PDF de la Relación 10 para el enunciado completo y la comprobación.

class Empleado:
    def __init__(self, nombre, salario):
        self.nombre = nombre
        self.salario = salario

class Comercial(Empleado):
    def __init__(self, nombre, salario, ventas):
        super().__init__(nombre, salario)
        self.ventas = ventas

    def calcular_bonus(self):
        return self.ventas * 0.05
    
    def resumen(self):
        bonus = self.calcular_bonus()
        salario_completo = self.salario + bonus
        return f"\n--- Resumen empleado ---\nNombre: {self.nombre}\nSalario: {self.salario:.2f}€\nBonus: {bonus:.2f}€\nSalario completo: {salario_completo:.2f}€"

comercial = Comercial("Attila", 1800, 871)
print(comercial.resumen())