ventas_tienda_mes = int(input("Introduce el número de ventas realizadas en la tienda física este mes: "))
ventas_web_mes = int(input("Introduce el número de ventas realizadas en la página web este mes: "))
ventas_telefono_mes = int(input("Introduce el número de ventas realizadas por teléfono este mes: "))
maximas_ventas_empate = []

if ventas_telefono_mes < 0 or ventas_tienda_mes < 0 or ventas_web_mes < 0:
    print("No se pueden introducir valores negativos. Revisa los valores introducidos.") 
else:
    if ventas_tienda_mes < ventas_web_mes: # web gana tienda
        if ventas_web_mes < ventas_telefono_mes:
            maximas_ventas = ventas_telefono_mes
        elif ventas_web_mes > ventas_telefono_mes:
            maximas_ventas = ventas_web_mes
        else: # web y teléfono empatan
            maximas_ventas_empate = ["web", "teléfono"]
    elif ventas_tienda_mes > ventas_web_mes: # tienda gana web
        if ventas_tienda_mes < ventas_telefono_mes:
            maximas_ventas = ventas_telefono_mes
        elif ventas_tienda_mes > ventas_telefono_mes:
            maximas_ventas = ventas_tienda_mes
        else: # tienda y teléfono empatan
            maximas_ventas_empate = ["tienda física", "teléfono"]
    else: # tienda y web empatan
        if ventas_tienda_mes < ventas_telefono_mes:
            maximas_ventas = ventas_telefono_mes
        elif ventas_tienda_mes > ventas_telefono_mes:
            maximas_ventas_empate = ["tienda física", "web"]
        else: # empate triple
            maximas_ventas_empate = ["tienda física", "web", "teléfono"]

    if len(maximas_ventas_empate) == 0: # manejar resultados con un solo ganador
        if maximas_ventas == ventas_tienda_mes:
            canalMaximo = "tienda física"
        elif maximas_ventas == ventas_web_mes:
            canalMaximo = "web"
        else:
            canalMaximo = "teléfono"
        print(f"El canal de venta que mayores ventas ha alcanzado este mes es {canalMaximo}.")
    else: # manejar resultados con multiples ganadores
        canalMaximo = ""
        for i in range(len(maximas_ventas_empate)): # equivalente a un bucle for (i=0;i<maximas_ventas_empate.length;i++)
            if i == len(maximas_ventas_empate) - 1:
                canalMaximo += maximas_ventas_empate[i]
            elif i == len(maximas_ventas_empate) - 2:
                canalMaximo += maximas_ventas_empate[i] + " y "
            else:
                canalMaximo += maximas_ventas_empate[i] + ", "
        print(f"Los canales de venta que mayores ventas han alcanzado este mes son {canalMaximo}.")