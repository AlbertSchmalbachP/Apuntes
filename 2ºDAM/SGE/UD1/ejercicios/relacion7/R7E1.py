# R7E1 | Lista de productos
# append, remove, sort y enumerate.
# Consulta el PDF de la Relación 07 para el enunciado completo y la comprobación.

lista = ["Teclado", "Ratón", "Monitor"]
lista.append("Webcam")
lista.remove("Ratón")
for i, valor in enumerate(lista, start=1): 
    print(i, valor)