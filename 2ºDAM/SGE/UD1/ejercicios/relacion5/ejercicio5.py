ventas_tienda_mes = int(input("Introduce el número de ventas realizadas en la tienda física este mes: "))
ventas_web_mes = int(input("Introduce el número de ventas realizadas en la página web este mes: "))
ventas_telefono_mes = int(input("Introduce el número de ventas realizadas por teléfono este mes: "))
maximas_ventas_empate = []

if ventas_tienda_mes < ventas_web_mes:
    if ventas_web_mes < ventas_telefono_mes:
        maximas_ventas = ventas_telefono_mes
    elif ventas_web_mes > ventas_telefono_mes:
        maximas_ventas = ventas_web_mes
    else: # empate
        maximas_ventas_empate = [ventas_web_mes, ventas_telefono_mes]
elif ventas_tienda_mes > ventas_web_mes:
    if ventas_tienda_mes < ventas_telefono_mes:
        maximas_ventas = ventas_telefono_mes
    elif ventas_tienda_mes > ventas_telefono_mes:
        maximas_ventas = ventas_tienda_mes
    else: # empate
        maximas_ventas_empate = [ventas_web_mes, ventas_telefono_mes]
elif ventas_web_mes <
else: # empate
    maximas_ventas_empate = [ventas_web_mes, ventas_telefono_mes, ventas_tienda_mes]

if len(maximas_ventas_empate) == 0:
    if maximas_ventas == ventas_tienda_mes:
        canalMaximo = "tienda física"
    elif maximas_ventas == ventas_web_mes:
        canalMaximo = "web"
    else:
        canalMaximo = "teléfono"
    print(f"El canal de venta que mayores ventas ha alcanzado este mes es {canalMaximo}.")
else:
    canalMaximo = ""
    for i in range(len(maximas_ventas_empate)): # equivalente a un bucle for (i=0;i<maximas_ventas_empate.length;i++)
        if i == len(maximas_ventas_empate) - 1:
            canalMaximo += str(maximas_ventas_empate[i])
        else:
            canalMaximo += str(maximas_ventas_empate[i]) + ", "
    print(f"Los canales de venta que mayores ventas han alcanzado este mes son {canalMaximo}.")