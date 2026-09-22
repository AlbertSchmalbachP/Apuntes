package programacion.ud5.pt5;

import java.util.ArrayList;
import java.util.Scanner;

public class ASP_PT5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int MAXANIMALES = 1000;
        final int OPCIONSALIR = 6;
        int opciónUsuario = 0;
        int cantidadModificar;

        String codigoBuscar = "";
        String mensajeMenu = "===== GESTIÓN DE ZOOLÓGICO =====\n\n" +
                "    1. Mostrar todos los animales\n" +
                "    2. Buscar un animal por código\n" +
                "    3. Agregar ejemplares a un animal\n" +
                "    4. Retirar ejemplares de un animal\n" +
                "    5. Eliminar un animal\n" +
                "    6. Salir\n\n" +
                "Seleccione una opción: ";

        ArrayList<Animal> animalesBase = new ArrayList<>();
        for (int i = 0; i < MAXANIMALES; i++) {
            animalesBase.add(new Animal(Faker.nombreAnimal(), Faker.cantidadAnimal(), Faker.precioAnimal()));
        }
        Zoologico LoroParque = new Zoologico("zoo1", animalesBase);
        // En caso de que sea para más de un zoo
        Zoologico zooIterar = LoroParque;

        while (opciónUsuario != OPCIONSALIR) {
            opciónUsuario = Funciones.pedirNumeroEntero2valores(scanner, 1, OPCIONSALIR, mensajeMenu);
            scanner.nextLine();
            // enseña todos los animales
            if (opciónUsuario == 1) {
                Funciones.printLn(zooIterar.mostrarTodosAnimales());
            }
            // Buscar animal por codigo. Hace un toString() del animal
            if (opciónUsuario == 2) {
                Funciones.print("Introduce el código del animal a buscar: ");
                codigoBuscar = scanner.nextLine();

                try {
                    Funciones.printLn(zooIterar.buscarAnimal(codigoBuscar));
                } catch (NullPointerException excepcion) {
                    Funciones.printLn("Error: " + excepcion.getMessage());
                }
            }
            // agregar ejemplares a una especie (por codigo)
            if (opciónUsuario == 3) {
                Funciones.print("Introduce el código del animal al que quieras agregar ejemplares: ");
                codigoBuscar = scanner.nextLine();

                try {
                    if (zooIterar.buscarAnimal(codigoBuscar) == null) throw new NullPointerException("Animal no encontrado.");

                    cantidadModificar = Funciones.pedirNumeroEntero1valorMIN(scanner, 0, "Introduce la cantidad para agregar: ");
                    zooIterar.agregarEjemplares(codigoBuscar, cantidadModificar);
                    Funciones.printLn("Ejemplares añadidos correctamente");
                } catch (NullPointerException excepcion) {
                    Funciones.printLn("Error: " + excepcion.getMessage());
                }
            }
            // retirar ejemplares de un animal (por codigo)
            if (opciónUsuario == 4) {
                Funciones.print("Introduce el código del animal al que quieras retirar ejemplares: ");
                codigoBuscar = scanner.nextLine();
                try {
                    if (zooIterar.buscarAnimal(codigoBuscar) == null) throw new NullPointerException("Animal no encontrado.");

                    cantidadModificar = Funciones.pedirNumeroEntero1valorMIN(scanner, 0, "Introduce la cantidad para retirar: ");
                    zooIterar.eliminarEjemplares(codigoBuscar, cantidadModificar);
                    Funciones.printLn("Ejemplares retirados correctamente");
                } catch (NullPointerException excepcion) {
                    Funciones.printLn("Error: " + excepcion.getMessage());
                } catch (IllegalStateException excepcion) {
                    Funciones.printLn("Error: " + excepcion.getMessage());
                }
            }
            // Eliminar animal (codigo)
            if (opciónUsuario == 5) {
                Funciones.print("introduce el codigo del animal que quieras eliminar: ");
                codigoBuscar = scanner.nextLine();
                try {
                    zooIterar.eliminarEspecie(codigoBuscar);
                    Funciones.printLn("Animal eliminado correctamente");
                } catch (NullPointerException excepcion) {
                    Funciones.printLn("Error: " + excepcion.getMessage());
                } catch (IllegalStateException excepcion) {
                    Funciones.printLn("Error: " + excepcion.getMessage());
                }
            }
        }
        scanner.close();
    }
}