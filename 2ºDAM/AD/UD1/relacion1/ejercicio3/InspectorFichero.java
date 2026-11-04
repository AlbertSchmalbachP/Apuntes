
import java.nio.file.Files;
import java.nio.file.Path;

public class InspectorFichero {
    public static void main(String[] args) {
        Path ruta = Path.of("datos", "clubes.txt");
        System.out.println("Ruta absoluta archivo: " + ruta.toAbsolutePath());
        try {
            if (Files.exists(ruta)) {
                System.out.println(Files.size(ruta));
            }
        } catch (Exception e) {
            System.out.println("Error al acceder al archivo: " + e);
        }
    }
}
