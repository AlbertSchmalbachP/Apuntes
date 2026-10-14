# R8E4 | resumir_importes
# Función que devuelve un diccionario o None si la lista está vacía.
# Consulta el PDF de la Relación 08 para el enunciado completo y la comprobación.

def resumir_importes(importes):
    if len(importes) == 0:
        diccionario = None
    else:
        diccionario = {
            "total": sum(importes),
            "media": sum(importes) / len(importes),
            "minimo": min(importes),
            "maximo": max(importes)
        }
    return diccionario

input_importes = []
importe = 0
while importe != -1:
    importe = float(input("Introduce un importe: "))
    if importe != -1:
        input_importes.append(importe)

resumen_importes = resumir_importes(input_importes)
if resumir_importes(input_importes) == None:
    print("No hay ningun resumen que mostrar, al no haberse introducido ningún importe.")
else:
    print(f"\nResumen de la lista\n\nTotal: {resumen_importes["total"]:.2f}€\nMedia: {resumen_importes["media"]:.2f}€\nMáximo: {resumen_importes["maximo"]:.2f}€\nMínimo: {resumen_importes["minimo"]:.2f}€\n")