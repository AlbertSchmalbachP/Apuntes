total = float(input("Introduce el precio total del pedido: "))
respuesta_premium = input("¿Eres premium? (S/N): ").upper()
esPremium = None
if respuesta_premium == "S" or respuesta_premium == "Y" or respuesta_premium == "SI":
    esPremium = True
elif respuesta_premium == "N" or respuesta_premium == "NO":
    esPremium = False
else:
    print("No se ha introducido una respuesta correcta.")
if esPremium == True or esPremium == False:
    if total >= 500 or (esPremium == True and total >= 250):
        esPrioritario = True
    else:
        esPrioritario = False
if esPrioritario:
    print("Es prioritario")
else:
    print("Es normal")