
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Path ruta = Path.of("alumnos.csv");
        try (Scanner escaner = new Scanner(System.in)) {
            if (Files.notExists(ruta)) {
                System.out.println("No existe el archivo.");
                return;
            }
            List<String> lineaArchivo = Files.readAllLines(
                    ruta, StandardCharsets.UTF_8);
            System.out.println("Introduce una ID:");
            int idBuscar = escaner.nextInt();
            int idLinea;
            if (idBuscar <= 0) {
                System.out.println("No puedes introducir una ID negativa.");
            } else {
                String[] lineaSplit;
                String nombreLinea, grupoLinea;
                for (int i = 1; i < lineaArchivo.size(); i++) {
                    lineaSplit = lineaArchivo.get(i).split(";", -1);
                    idLinea = Integer.parseInt(lineaSplit[0]);
                    if (idLinea == idBuscar) {
                        nombreLinea = lineaSplit[1];
                        grupoLinea = lineaSplit[2];
                        System.out.println("Nombre: " + nombreLinea + " | Grupo: " + grupoLinea + ".");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo acceder al archivo: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("No has introducido un entero: ");
        } catch (Exception e) {
            System.out.println("No se.");
        }
    }
}
