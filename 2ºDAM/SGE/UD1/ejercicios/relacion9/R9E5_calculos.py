# R9E5 | Módulo calculos.py

def calcular_subtotal(precio, cantidad):
    return precio * cantidad

def aplicar_descuento(subtotal, porcentaje):
    descuento = subtotal * (porcentaje / 100)
    return subtotal - descuento