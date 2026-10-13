# R7E3 | Ficha con diccionario
# Crear, leer, modificar y añadir claves a un dict.
# Consulta el PDF de la Relación 07 para el enunciado completo y la comprobación.

cliente = {
    "nombre": "Lamine",
    "ciudad": "Esplugas de Llobregat",
    "email": "lamineyamal304@bmail.com",
    "activo": True
}
print(cliente["nombre"])
print(cliente["ciudad"])
print(cliente["email"])
print(cliente["activo"])

cliente.update({"ciudad": "Barcelona"})
cliente["telefono"] = "666666666"
print("NUEVOS")
print(cliente["nombre"])
print(cliente["ciudad"])
print(cliente["email"])
print(cliente["activo"])
print(cliente["telefono"])