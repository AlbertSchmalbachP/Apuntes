# main_talleres.py
import csv
from modelos_talleres import CentroTalleres, Participante, Taller

def main():
    centro = CentroTalleres()

    # 1. CARGA DE DATOS (Simulada para ir directo al grano)[cite: 4]
    # Creamos un par de talleres por defecto para probar rápido
    centro.talleres["T01"] = Taller("T01", "Python Básico", 2)
    centro.talleres["T02"] = Taller("T02", "Odoo Avanzado", 5)

    opcion = "-1"
    while opcion != "0":
        print("\n--- CENTRO DE TALLERES ---")
        print("1) Ver Participantes | 2) Alta participante | 3) Inscribir | 4) Cancelar")
        print("5) Ver taller | 6) Buscar participante | 7) Guardar | 0) Salir")
        opcion = input("Elige una opción: ")

        if opcion == "1":
            for email, p in centro.participantes.items():
                print(f"- {p.nombre} ({email})")

        elif opcion == "2":
            email = input("Email del participante: ")
            nombre = input("Nombre completo: ")
            if email not in centro.participantes:
                centro.participantes[email] = Participante(email, nombre)
                print("Participante registrado.")
            else:
                print("Error: Ya existe un participante con ese email.")

        elif opcion == "3":
            email = input("Email del participante: ")
            codigo = input("Código del taller (ej. T01, T02): ")
            # El método inscribir ya comprueba aforo y duplicados y devuelve el texto de error o éxito[cite: 4]
            resultado = centro.inscribir(email, codigo)
            print(resultado)

        elif opcion == "4":
            email = input("Email del participante: ")
            codigo = input("Código del taller: ")
            if codigo in centro.talleres:
                taller = centro.talleres[codigo]
                if email in taller.inscritos:
                    taller.inscritos.remove(email) # Libera la plaza[cite: 4]
                    print("Inscripción cancelada. Plaza liberada.")
                else:
                    print("El participante no estaba inscrito.")
            else:
                print("Taller no encontrado.")

        elif opcion == "5":
            codigo = input("Código del taller: ")
            if codigo in centro.talleres:
                taller = centro.talleres[codigo]
                disponibles = taller.plazas - len(taller.inscritos)
                print(f"\n--- {taller.titulo} ---")
                print(f"Plazas totales: {taller.plazas} | Libres: {disponibles}")
                print("Inscritos:")
                for email_inscrito in taller.inscritos:
                    # Buscamos el nombre del email en el diccionario de participantes
                    nombre_part = centro.participantes[email_inscrito].nombre
                    print(f" - {nombre_part} ({email_inscrito})")
            else:
                print("Taller no existe.")

        elif opcion == "6":
            busqueda = input("Buscar nombre: ").lower()
            encontrados = False
            for p in centro.participantes.values():
                if busqueda in p.nombre.lower():
                    print(f"Encontrado: {p.nombre} ({p.email})")
                    encontrados = True
            if not encontrados:
                print("No hay coincidencias.")

        elif opcion == "0":
            print("Saliendo del sistema...")

if __name__ == "__main__":
    main()