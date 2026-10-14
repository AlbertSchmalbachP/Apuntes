# R7E4 | Catálogo
# Lista de diccionarios; filtra por stock y cuenta disponibles.
# Consulta el PDF de la Relación 07 para el enunciado completo y la comprobación.

# Declarar lista ([]) con 5 diccionarios ({})
productos = [
    {
        "nombre": "PlayStation 3",
        "categoría": "7ª Generación",
        "precio": 74.99,
        "stock": 14
    },
    {
        "nombre": "Xbox One",
        "categoría": "8ª Generación",
        "precio": 119.99,
        "stock": 9
    },
    {
        "nombre": "GameCube",
        "categoría": "6ª Generación",
        "precio": 84.99,
        "stock": 0
    },
    {
        "nombre": "Dreamcast",
        "categoría": "6ª Generación",
        "precio": 99.99,
        "stock": 2
    },
    {
        "nombre": "Xbox 360",
        "categoría": "7ª Generación",
        "precio": 69.99,
        "stock": 7
    }
]

# Recorrer la lista
disponibles = 0
for producto in productos:
    if producto["stock"] > 0:
        print(f"{producto["nombre"]}\nCategoría: {producto["categoría"]} | Precio: {producto["precio"]:.2f}€ | Stock: {producto["stock"]}\n")
        disponibles = disponibles + 1
print(f"Productos disponibles: {disponibles}")