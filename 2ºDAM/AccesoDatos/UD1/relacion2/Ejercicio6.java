import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio6 {
    public static void main(String[] args) {
        Path productosDefectuosos = Path.of("productos_errores.csv");
        Path productosValidos = Path.of("productos_validos.csv");
        try {
            if (Files.notExists(productosDefectuosos)) {
                System.err.println("El archivo no existe.");
                return
            }

            List<String> lineasDefectuosas
        } catch (Exception e) {
            
        }
    }
}
