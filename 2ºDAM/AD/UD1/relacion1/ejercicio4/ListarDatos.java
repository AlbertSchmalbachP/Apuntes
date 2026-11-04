
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;

public class ListarDatos {
    public static void main(String[] args) {
        Path ruta = Path.of("datos");
        try (DirectoryStream<Path> elementos = Files.newDirectoryStream(ruta)) {
            for (Path elemento : elementos) {
                if (Files.isRegularFile(elemento)) {
                    System.out.println(elemento.getFileName());
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
