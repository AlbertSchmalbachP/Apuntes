# R6E1 | Serie de códigos de pedido
# Genera PED-001... con for y range().
# Consulta el PDF de la Relación 06 para el enunciado completo y la comprobación.

num_pedidos = int(input("Introduce el número de pedidos que se van a etiquetar: "))
while num_pedidos < 0:
    num_pedidos = int(input("No se puede introducir un número negativo. Introduce el número de pedidos que se van a etiquetar: "))
for pedido in range(num_pedidos):
    print(f"PED-${(pedido+1):03d}")
if num_pedidos == 0:
    print("No se han especificado pedidos.")
print("Programa finalizado.")
