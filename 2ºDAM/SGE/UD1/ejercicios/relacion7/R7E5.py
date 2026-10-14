# R7E5 | Categorías únicas y búsqueda
# set para únicos y búsqueda de texto ignorando mayúsculas.
# Consulta el PDF de la Relación 07 para el enunciado completo y la comprobación.

categorias = ["Xbox", "PlayStation", "Sega", "PlayStation", "XBOX", "Nintendo", "SNK", "SEGA"]
conjunto_categorias = set(categorias)
busqueda = input("Introduce un valor de búsqueda: ")

for valor in conjunto_categorias:
    if busqueda.lower() in valor.lower():
        print(valor)