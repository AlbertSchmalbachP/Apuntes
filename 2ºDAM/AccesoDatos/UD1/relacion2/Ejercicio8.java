
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Path prestamos = Path.of("2ºDAM", "AccesoDatos", "UD1", "resources", "prestamos.csv");
        try (Scanner escaner = new Scanner(System.in)) {
            if (Files.notExists(prestamos)) {
                Files.createFile(prestamos);
            }
            String opcion = "0";
            while (!(opcion.equals("-1"))) {
                System.out.println("1. Dar de alta un registro");
                System.out.println("2. Listar registros");
                System.out.println("3. Buscar registro por ID");
                System.out.println("4. Modificar material de un registro");
                System.out.println("5. Dar de baja un registro");
                System.out.println("6. Crear una copia de seguridad");
                System.out.println("7. Restaurar copia de seguridad");
                System.out.println("\n-1. Salir del programa");
                System.out.print("\nIntroduce una opción: ");
                opcion = escaner.nextLine();
                if (opcion.equals("1")) {

                } else if (opcion.equals("2")) {

                } else if (opcion.equals("3")) {

                } else if (opcion.equals("4")) {

                } else if (opcion.equals("5")) {

                } else if (opcion.equals("6")) {

                } else if (opcion.equals("7")) {

                } else if (opcion.equals("8")) {

                } else if (opcion.equals("-1")) {
                    System.out.println("Programa finalizado.");
                } else {
                    System.out.println("Opción no válida");
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}