# R10E3 | Clase Cliente
# cambiar_ciudad() y ficha() que devuelve texto.
# Consulta el PDF de la Relación 10 para el enunciado completo y la comprobación.

class Cliente:
    def __init__(self, nombre, email, ciudad):
        self.nombre = nombre
        self.email = email
        self.ciudad = ciudad

    def ciudad_nueva(self, nueva_ciudad):
        self.ciudad = nueva_ciudad

    def ficha(self):
        return f"\n--- Datos del cliente ---\nNombre: {self.nombre}\nEmail: {self.email}\nCiudad: {self.ciudad}"

cliente = Cliente("Migue", "migue@escuelaartegranada.com", "Granada")
print(cliente.ficha())
cliente.ciudad_nueva("Armilla")
print(cliente.ficha())