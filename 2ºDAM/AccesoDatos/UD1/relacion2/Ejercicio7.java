
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio7 {

    public static void main(String[] args) {
        Path inventario = Path.of("2ºDAM", "AccesoDatos", "UD1", "resources", "inventario.csv");
        Path inventarioBackup = Path.of("2ºDAM", "AccesoDatos", "UD1", "resources", "copias", "inventario.bak");

        try {
            // crear backup
            if (Files.notExists(inventario)) {
                System.out.println("No hay datos que copiar.");
                return;
            }
            Files.createDirectories(inventarioBackup.getParent());
            Files.copy(inventario, inventarioBackup, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Copia creada: " + inventarioBackup.toAbsolutePath());

            // modificar stock
            try (Scanner escaner = new Scanner(System.in)) {
                if (Files.notExists(inventario)) {
                    System.out.println("No existe el archivo.");
                } else {
                    List<String> originales = Files.readAllLines(
                            inventario, StandardCharsets.UTF_8);
                    List<String> nuevas = new ArrayList<>();
                    boolean encontrado = false;
                    System.out.println("Introduce el ID a modificar: ");
                    String idSolicitado = escaner.next();
                    System.out.println("Introduce el stock nuevo: ");
                    int stockNuevo = escaner.nextInt();
                    for (String linea : originales) {
                        String[] campos = linea.split(";", -1);
                        if (campos.length == 3 && campos[0].equals(idSolicitado)) {
                            nuevas.add(campos[0] + ";" + campos[1] + ";" + stockNuevo);
                            encontrado = true;
                        } else {
                            nuevas.add(linea);
                        }
                    }

                    // restaurar cambios
                    if (encontrado) {
                        Files.write(inventario, nuevas, StandardCharsets.UTF_8);
                        System.out.println("¿Quieres guardar los cambios? S/N: ");
                        String inputGuardarCambios = escaner.nextLine();
                        while (!inputGuardarCambios.equalsIgnoreCase("S") && !inputGuardarCambios.equalsIgnoreCase("N")) {
                            System.out.println("Introduce S o N. ¿Quieres guardar los cambios? S/N: ");
                            inputGuardarCambios = escaner.nextLine();
                        }
                        if (inputGuardarCambios.equalsIgnoreCase("N")) {
                            if (Files.notExists(inventarioBackup)) {
                                System.out.println("No se ha podido restaurar la versión anterior. La copia de seguridad no ha sido encontrada.");
                                return;
                            }
                            Files.copy(inventarioBackup, inventario, StandardCopyOption.REPLACE_EXISTING);
                            System.out.println("Versión anterior restaurada satisfactoriamente. Los cambios NO se han aplicado.");
                        } else {
                            System.out.println("Stock actualizado.");
                        }
                    } else {
                        System.out.println("No existe ningun producto con el ID introducido.");
                    }
                }
            } catch (Exception e) {
                System.err.println("No se pudo modificar: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
