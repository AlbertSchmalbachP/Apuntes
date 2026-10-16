# R9E3 | Guardar clientes
# Escribe y lee clientes.txt con with open y UTF-8.
# Consulta el PDF de la Relación 09 para el enunciado completo y la comprobación.

with open("clientes.txt", "w", encoding="utf-8") as archivo:
    archivo.write("Lucía;Granada\n")
    archivo.write("Lucas;Palencia\n")
    archivo.write("Marta;Málaga\n")