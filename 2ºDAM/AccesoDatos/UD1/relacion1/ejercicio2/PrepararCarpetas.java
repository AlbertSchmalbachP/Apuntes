import java.nio.file.Files;
import java.nio.file.Path;
public class PrepararCarpetas {
    public static void main(String[] args) {
        Path datos = Path.of("datos");
        Path copias = datos.resolve("copias");
        Files.createDirectories(datos, copias);
    }
}
