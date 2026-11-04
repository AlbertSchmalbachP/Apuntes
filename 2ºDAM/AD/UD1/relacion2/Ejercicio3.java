
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        Path ruta = Path.of("inventario.csv");
        try (Scanner escaner = new Scanner(System.in)) {
            if (Files.notExists(ruta)) {
                System.out.println("No existe el archivo.");
            } else {
                List<String> originales = Files.readAllLines(
                    ruta, StandardCharsets.UTF_8);
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
                if (encontrado) {
                    Files.write(ruta, nuevas, StandardCharsets.UTF_8);
                    System.out.println("Stock actualizado.");
                } else {
                    System.out.println("No existe ningun producto con el ID introducido.");
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudo modificar: " + e.getMessage());
        }
    }
}
