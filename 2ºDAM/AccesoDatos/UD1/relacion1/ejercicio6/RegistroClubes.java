
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class RegistroClubes {
    public static void main(String[] args) {
        Path ruta = Path.of("datos", "clubes.txt");
        try {
            if (Files.notExists(ruta)) {
                System.out.println("Todavía no hay un archivo de clubes.");
            } else {
                Files.createDirectories(ruta.getParent());
                Scanner escaner = new Scanner(System.in);
                System.out.println("Introduce una ID");
                String inputId = escaner.nextLine();
                System.out.println("Introduce un nombre:");
                String inputNombre = escaner.nextLine();
                System.out.println("Introduce una ciudad:");
                String inputCiudad = escaner.nextLine();
                escaner.close();
                try (BufferedWriter salida = Files.newBufferedWriter(
                        ruta, StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND)) {
                    salida.write(inputId + ";" + inputNombre + ";" + inputCiudad);
                    salida.newLine();
                } catch (Exception e) {
                    System.err.println("Ha habido un error. Comprueba que has introcido el formato especificado: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}