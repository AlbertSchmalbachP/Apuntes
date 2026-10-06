destino = input("Introduce el destino del envío:\nPENINSULA (P)\nBALEARES (B)\nCANARIAS (C)\n").upper().strip()
while destino != "CANARIAS" and destino != "C" and destino != "BALEARES" and destino != "B" and destino != "PENINSULA" and destino != "P":
    destino = input("Se ha introducido un destino no válido.\n\nIntroduce el destino del envío:\nPENINSULA (P)\nBALEARES (B)\nCANARIAS (C)\n").upper()
subtotal = float(input("Introduce el total del pedido: "))
while subtotal < 0:
    subtotal = float(input("Se ha introducido un precio no válido. Introduce el total del pedido: "))
if destino == "CANARIAS" or destino == "C":
    gastos_envio = 18
elif destino == "BALEARES" or destino == "B":
    gastos_envio = 12
else:
    if subtotal >= 100:
        gastos_envio = 0
    else:
        gastos_envio = 6
total = subtotal + gastos_envio
print(f"Precio total del envío es {total:.2f} EUR.")