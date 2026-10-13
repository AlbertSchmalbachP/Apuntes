# R6E4 | Menú de gestión
# Menú 1/2/3/0 con condición explícita; sin while True ni break.
# Consulta el PDF de la Relación 06 para el enunciado completo y la comprobación.
opcion = -1
while opcion != 0:
    opcion = int(input("1. Alta\n2. Consulta\n3. Informe\n0. Salir\n\nIntroduce una opción: "))
    if opcion == 1:
        print("Mensaje de la opción 1")
    elif opcion == 2:
        print("Mensaje de la opción 2")
    elif opcion == 3:
        print("Mensaje de la opción 3")
    elif opcion == 0:
        print("Saliendo...")
    else:
        print("Opción no válida.")
print("Programa finalizado.")