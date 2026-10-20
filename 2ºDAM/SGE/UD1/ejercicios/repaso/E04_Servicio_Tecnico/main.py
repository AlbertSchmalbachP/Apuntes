# main_tecnico.py
import csv
from modelos_tecnico import Reparacion, AsistenciaRemota

def main():
    trabajos = []

    # Carga de CSV y reconstrucción inteligente
    try:
        with open("trabajos.csv", "r", encoding="utf-8") as archivo:
            lector = csv.DictReader(archivo)
            for fila in lector:
                if fila["tipo"] == "Reparacion":
                    # Reconstruimos como objeto Reparacion
                    trabajos.append(Reparacion(fila["codigo"], fila["cliente"], fila["horas"], fila["precio_pieza"], fila["estado"]))
                elif fila["tipo"] == "Remoto":
                    # Reconstruimos como objeto AsistenciaRemota
                    trabajos.append(AsistenciaRemota(fila["codigo"], fila["cliente"], fila["horas"], fila["estado"]))
    except FileNotFoundError:
        pass

    opcion = "-1"
    while opcion != "0":
        print("\n--- SERVICIO TÉCNICO ---")
        print("1) Listar | 2) Alta Reparación | 3) Alta Remota")
        print("4) Cambiar Estado | 5) Resumen | 0) Guardar y Salir")
        opcion = input("Elige: ")

        if opcion == "1":
            for t in trabajos:
                # Fíjate cómo imprimimos el importe sin preguntar qué clase es
                print(f"[{t.codigo}] {t.cliente} - Estado: {t.estado} - Importe: {t.calcular_importe():.2f}€")

        elif opcion == "2" or opcion == "3":
            codigo = input("Código del trabajo: ")
            # Comprobación simple de duplicados
            existe = False
            for t in trabajos:
                if t.codigo == codigo: existe = True
                
            if existe:
                print("Error: El código ya existe.")
            else:
                cliente = input("Cliente: ")
                if cliente == "":
                    print("Error: El cliente no puede estar vacío.")
                else:
                    try:
                        horas = float(input("Horas empleadas: "))
                        if horas <= 0:
                            print("Error: Las horas deben ser positivas.")
                        else:
                            if opcion == "2":
                                precio_pieza = float(input("Precio de la pieza: "))
                                if precio_pieza < 0:
                                    print("Error: Precio negativo.")
                                else:
                                    trabajos.append(Reparacion(codigo, cliente, horas, precio_pieza))
                                    print("Reparación guardada.")
                            else:
                                trabajos.append(AsistenciaRemota(codigo, cliente, horas))
                                print("Asistencia remota guardada.")
                    except ValueError:
                        print("Error: Debes introducir un número.")

        elif opcion == "4":
            codigo = input("Código: ")
            nuevo_estado = input("Nuevo estado (Pendiente, En curso, Finalizado): ")
            encontrado = False
            for t in trabajos:
                if t.codigo == codigo:
                    encontrado = True
                    if t.cambiar_estado(nuevo_estado):
                        print("Estado actualizado.")
                    else:
                        print("Error: Transición de estado no permitida.")
                    break
            if not encontrado:
                print("Código no encontrado.")

        elif opcion == "5":
            finalizados = 0
            total_dinero = 0
            for t in trabajos:
                if t.estado == "Finalizado":
                    finalizados += 1
                    total_dinero += t.calcular_importe()
            print(f"Trabajos finalizados: {finalizados}")
            print(f"Dinero total a facturar: {total_dinero:.2f}€")

    # Guardado con el campo "tipo" adicional para poder reconstruir
    with open("trabajos.csv", "w", newline="", encoding="utf-8") as archivo:
        campos = ["tipo", "codigo", "cliente", "horas", "estado", "precio_pieza"]
        escritor = csv.DictWriter(archivo, fieldnames=campos)
        escritor.writeheader()
        for t in trabajos:
            if isinstance(t, Reparacion):
                escritor.writerow({"tipo": "Reparacion", "codigo": t.codigo, "cliente": t.cliente, "horas": t.horas, "estado": t.estado, "precio_pieza": t.precio_pieza})
            else:
                escritor.writerow({"tipo": "Remoto", "codigo": t.codigo, "cliente": t.cliente, "horas": t.horas, "estado": t.estado, "precio_pieza": 0})
    print("Datos guardados.")

if __name__ == "__main__":
    main()