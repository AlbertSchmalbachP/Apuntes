# R8E3 | aplicar_descuento
# Función con parámetro porcentaje=0.
# Consulta el PDF de la Relación 08 para el enunciado completo y la comprobación.

def aplicar_descuento(importe, porcentaje=0):
    descuento = importe * (porcentaje / 100)
    return importe - descuento

importeInput = int(input("Introduce el importe del producto: "))
while importeInput < 0:
    importeInput = int(input("El importe no puede ser negativo.\nIntroduce el importe del producto: "))

descuentoInput = int(input("Introduce el descuento del producto (0 para no aplicarlo): "))
while descuentoInput < 0:
    descuentoInput = int(input("El descuento no puede ser negativo.\nIntroduce el descuento del producto: "))
if descuentoInput == 0:
    print(f"{aplicar_descuento(importeInput):.2f}€")
else:
    print(f"{aplicar_descuento(importeInput, descuentoInput):.2f}€")