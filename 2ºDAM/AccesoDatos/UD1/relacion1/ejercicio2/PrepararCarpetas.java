import java.nio.file.Path;
public class PrepararCarpetas {
    public static void main(String[] args) {
        Path carpeta1 = Path.of("datos");
        Path carpeta2 = carpeta1.resolve("copias");
        Path archivo1 = carpeta1.resolve("clubes.txt");
        Path archivo2 = carpeta2.resolve("respaldo.txt");
    }
}
