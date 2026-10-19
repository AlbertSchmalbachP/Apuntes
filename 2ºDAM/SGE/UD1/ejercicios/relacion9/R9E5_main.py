# R9E5 | Programa principal

from R9E5_calculos import calcular_subtotal, aplicar_descuento
import sys
from pathlib import Path
sys.path.insert(0, str(Path(__file__).resolve().parents[2]))
from funciones_python import pedir_numero

precio = pedir_numero("Introduce el precio: ", float, minimo=0)
cantidad = pedir_numero("Introduce la cantidad a registrar: ", int, minimo=1)
porcentaje = pedir_numero("Introduce el porcentaje de descuento (%): ", float, minimo=0, maximo=100)

subtotal = calcular_subtotal(precio, cantidad)
total = aplicar_descuento(subtotal, porcentaje)

print(f"Precio total: {total:.2f}€")