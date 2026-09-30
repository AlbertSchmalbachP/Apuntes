
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {

    public static void main(String[] args) {
        Path ruta = Path.of("videojuegos.csv");
        try {
            if (Files.notExists(ruta)) {
                System.out.println("No existe el archivo.");
            } else {
                try (BufferedReader entrada = Files.newBufferedReader(
                        ruta, StandardCharsets.UTF_8)) {
                    System.out.println("------- ARCHIVO ORIGINAL -------");
                    String linea;
                    while ((linea = entrada.readLine()) != null) {
                        System.out.println(linea);
                    }
                    System.out.println("------- FIN ARCHIVO -------");
                } catch (IOException e) {
                    System.err.println("No se pudo leer: " + e.getMessage());
                }
                List<String> lineaOriginales = Files.readAllLines(
                        ruta, StandardCharsets.UTF_8);
                List<String> lineaNuevas = new ArrayList<>();
                for (String linea : lineaOriginales) {
                    String[] campos = linea.split(";", -1);
                    if (campos.length == 3) {
                        lineaNuevas.add("[" + campos[0] + "] " + campos[1] + " - " + campos[2]);
                    } else {
                        lineaNuevas.add(linea);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("No se pudo acceder al archivo: " + e.getMessage());
        }
        try (BufferedReader entrada = Files.newBufferedReader(
                ruta, StandardCharsets.UTF_8)) {
            System.out.println("------- ARCHIVO NUEVO -------");
            String linea;
            while ((linea = entrada.readLine()) != null) {
                System.out.println(linea);
            }
            System.out.println("------- FIN ARCHIVO -------");
        } catch (IOException e) {
            System.err.println("No se pudo leer: " + e.getMessage());
        }
    }
}
