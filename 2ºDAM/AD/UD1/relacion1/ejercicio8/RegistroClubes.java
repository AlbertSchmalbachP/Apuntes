
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class RegistroClubes {
    public static void main(String[] args) {
        Path carpeta = Path.of("datos");
        Path archivo = carpeta.resolve("clubes.csv");
        try {
            Files.createDirectories(carpeta);
            if (Files.notExists(archivo)) {
                Files.createFile(archivo);
            }
            Scanner escaner = new Scanner(System.in);
            System.out.println("Introduce una ID:");
            String inputId = escaner.nextLine();
            boolean idRepetida;
            do {
                idRepetida = false;
                try (BufferedReader entrada = Files.newBufferedReader(
                    archivo, StandardCharsets.UTF_8)) {
                    String linea;
                    while ((linea = entrada.readLine()) != null) {
                        String[] valoresLinea = linea.split(";");
                        if (valoresLinea.length > 0 && valoresLinea[0].equals(inputId)) {
                            idRepetida = true;
                        }
                    }
                }
                if (idRepetida) {
                    System.out.println("ID duplicado. Introduce una ID:");
                    inputId = escaner.nextLine();
                }
            } while (idRepetida);
            System.out.println("Introduce un nombre:");
            String inputNombre = escaner.nextLine();
            System.out.println("Introduce una ciudad:");
            String inputCiudad = escaner.nextLine();
            escaner.close();
            try (BufferedWriter salida = Files.newBufferedWriter(
                    archivo, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND)) {
                salida.write(inputId + ";" + inputNombre + ";" + inputCiudad);
                salida.newLine();
            } catch (Exception e) {
                System.err.println("Error al insertar los datos. Comprueba que has introcido el formato especificado: " + e.getMessage());
            }
            try (BufferedReader entrada = Files.newBufferedReader(archivo, StandardCharsets.UTF_8)) {
                String linea;
                while ((linea = entrada.readLine()) != null) {
                    System.out.println(linea); } } catch (IOException e) {
                        System.err.println("Error al leer: " + e.getMessage());
                    }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}