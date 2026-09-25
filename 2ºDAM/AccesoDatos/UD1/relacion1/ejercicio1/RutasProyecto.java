import java.nio.file.Files;
import java.nio.file.Path;
public class RutasProyecto {
    public static void main(String[] args) {
        Path datos = Path.of("datos");
        Path fichCopias = datos.resolve("copias");
        Path archClubes = datos.resolve("clubes.txt");
        
        try {
            Files.createDirectory(datos);
            if (Files.notExists(fichCopias)) {
                Files.createDirectory(fichCopias);
            }
            if (Files.notExists(archClubes)) {
                Files.createFile(archClubes);
            }
        } catch (Exception e) {
        }
    }
}
