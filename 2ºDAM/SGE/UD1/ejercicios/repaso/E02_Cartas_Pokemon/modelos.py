# modelos_pokemon.py
class Carta:
    # Constructor que guarda los datos de una carta
    def __init__(self, codigo, nombre, tipo, rareza, valor):
        self.codigo = codigo
        self.nombre = nombre
        self.tipo = tipo
        self.rareza = rareza
        self.valor = float(valor)

class Coleccion:
    def __init__(self):
        # Usamos un diccionario usando el código de la carta como clave
        self.cartas = {}

    def agregar(self, carta):
        # Regla: No admitimos códigos repetidos
        if carta.codigo not in self.cartas:
            self.cartas[carta.codigo] = carta
            return True
        return False

    def extraer(self, codigo):
        # Saca una carta de la colección devolviéndola, o devuelve None si no existe
        if codigo in self.cartas:
            return self.cartas.pop(codigo)
        return None

    # LA OPERACIÓN ATÓMICA CLAVE
    def intercambiar(self, otra_coleccion, mi_codigo, su_codigo):
        # 1. Comprobamos que ambas cartas existen antes de tocar absolutamente nada
        if mi_codigo in self.cartas and su_codigo in otra_coleccion.cartas:
            
            # 2. Como ambas existen, las extraemos de las colecciones
            mi_carta = self.extraer(mi_codigo)
            su_carta = otra_coleccion.extraer(su_codigo)
            
            # 3. Las cruzamos usando el método agregar
            self.agregar(su_carta)
            otra_coleccion.agregar(mi_carta)
            
            # Devolvemos un texto para que el main.py lo imprima sin romper la regla del silencio
            return "Intercambio realizado con éxito."
        
        # Si alguna carta no existía, saltamos directamente aquí sin borrar nada
        return "Error: Alguna de las cartas no existe. Intercambio abortado."

    def valor_total(self):
        suma = 0
        for carta in self.cartas.values():
            suma += carta.valor
        return suma