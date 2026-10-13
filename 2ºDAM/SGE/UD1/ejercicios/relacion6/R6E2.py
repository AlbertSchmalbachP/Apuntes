# R6E2 | Ventas de una semana
# Pide 7 ventas con for; calcula total y media sin lista.
# Consulta el PDF de la Relación 06 para el enunciado completo y la comprobación.
num_dias = 7
total_ventas = 0
for dia in range(num_dias):
    ventas_dia = int(input(f"Introduce las ventas del día {(dia + 1)}: "))
    total_ventas = total_ventas + ventas_dia
media_ventas = total_ventas / num_dias
print(f"Ventas totales: {total_ventas:.2f}€. Media ventas: {media_ventas:.2f}€.")