# modelos_talleres.py

class Participante:
    def __init__(self, email, nombre):
        self.email = email
        self.nombre = nombre


class Taller:
    def __init__(self, codigo, titulo, plazas):
        self.codigo = codigo
        self.titulo = titulo
        self.plazas = int(plazas)
        self.inscritos = [] # Guardará una lista de emails, no de objetos enteros

    # Devuelve True si aún no se ha llegado al límite de plazas
    def hay_hueco(self):
        return len(self.inscritos) < self.plazas

    def porcentaje_ocupacion(self):
        if self.plazas == 0: 
            return 0
        return (len(self.inscritos) / self.plazas) * 100


class CentroTalleres:
    # Esta clase gestora centraliza los diccionarios para buscarlos fácilmente
    def __init__(self):
        self.talleres = {}      # Diccionario: clave (codigo) -> valor (objeto Taller)
        self.participantes = {} # Diccionario: clave (email) -> valor (objeto Participante)

    # El método principal de la lógica de negocio. 
    # Devuelve un texto con el error o el éxito en lugar de imprimirlo.
    def inscribir(self, email, codigo_taller):
        # 1. Comprobamos que el participante existe en la base de datos
        if email not in self.participantes:
            return "Error: Participante no registrado en el centro."
            
        # 2. Comprobamos que el taller existe
        if codigo_taller not in self.talleres:
            return "Error: Ese código de taller no existe."
            
        # Extraemos el objeto taller del diccionario para trabajar con él
        taller = self.talleres[codigo_taller]
        
        # 3. Comprobamos duplicados (no se puede apuntar dos veces al mismo)
        if email in taller.inscritos:
            return "Error: El participante ya está inscrito en este taller."
            
        # 4. Comprobamos el aforo máximo
        if not taller.hay_hueco():
            return "Error: Taller completo. No quedan plazas."
            
        # 5. Si pasa todas las barreras de seguridad, lo inscribimos
        taller.inscritos.append(email)
        return f"Éxito: {email} inscrito correctamente en {taller.titulo}."