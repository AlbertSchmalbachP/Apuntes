import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Path binario = Path.of("datos", "equipos.dat");
        Path xml = Path.of("datos", "equipos_exportados.xml");
        try (Scanner teclado = new Scanner(System.in)) {
            try {
                List<Equipo> equipos = RepositorioEquipos.cargar(binario);
                int opcion = -1;
                while (opcion != 0) {
                    System.out.println("\nARCHIVO DE EQUIPOS");
                    System.out.println("1. Listar | 2. Buscar | 3. Cambiar unidades");
                    System.out.println("4. Guardar binario | 5. Recargar binario | 6. Exportar XML | 0. Salir");
                    System.out.print("Opción: ");
                    try {
                        opcion = Integer.parseInt(teclado.nextLine().trim());
                        switch (opcion) {
                            case 1 -> {
                                if (equipos.isEmpty()) {
                                    System.out.println("No hay equipos.");
                                }
                                for (Equipo equipo : equipos) {
                                    System.out.println(equipo);
                                }
                            }
                            case 2 -> {
                                System.out.print("ID que buscas: ");
                                int id = Integer.parseInt(teclado.nextLine().trim());
                                Equipo encontrado = RepositorioEquipos.buscar(equipos, id);
                                System.out.println(encontrado == null ? "ID no encontrado." : encontrado);
                            }
                            case 3 -> {
                                System.out.print("ID del equipo: ");
                                int id = Integer.parseInt(teclado.nextLine().trim());
                                System.out.print("Nuevas unidades: ");
                                int unidades = Integer.parseInt(teclado.nextLine().trim());
                                boolean cambiado = RepositorioEquipos.cambiarUnidades(equipos, id, unidades);
                                System.out.println(cambiado
                                        ? "Unidades actualizadas en memoria. Usa la opción 4 para guardar."
                                        : "ID no encontrado o unidades negativas. La lista no se modifica.");
                            }
                            case 4 -> {
                                RepositorioEquipos.guardar(binario, equipos);
                                System.out.println("Lista guardada en binario.");
                            }
                            case 5 -> {
                                equipos = RepositorioEquipos.cargar(binario);
                                System.out.println("Lista recargada desde el binario.");
                            }
                            case 6 -> {
                                RepositorioEquipos.exportarXml(xml, equipos);
                                System.out.println("XML exportado en " + xml + ".");
                            }
                            case 0 -> System.out.println("Hasta luego.");
                            default -> System.out.println("Opción desconocida.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Introduce un número entero válido.");
                    } catch (IOException e) {
                        System.out.println("Error de archivo: " + e.getMessage());
                    }
                }
            } catch (IOException e) {
                System.out.println("No se pudo iniciar el programa: " + e.getMessage());
            }
        }
    }
}