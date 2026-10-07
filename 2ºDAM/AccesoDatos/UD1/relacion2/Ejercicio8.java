
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio8 {
    public static void main(String[] args) {
        Path prestamos = Path.of("2ºDAM", "AccesoDatos", "UD1", "resources", "prestamos.csv");
        try {
            if (Files.notExists(prestamos)) {
                Files.createFile(prestamos);
            }
            String opcionMenu = "0";
            while (opcionMenu.equals("-1")) { 
                
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}