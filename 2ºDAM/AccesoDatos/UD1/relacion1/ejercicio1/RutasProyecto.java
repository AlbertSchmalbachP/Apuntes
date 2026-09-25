import java.nio.file.Path;
public class RutasProyecto {
    public static void main(String[] args) {
        Path datos = Path.of("datos");
        Path copias = datos.resolve("copias");
        Path clubes = datos.resolve("clubes.txt");
        
        try {
            System.out.println("Ruta relativa carpeta: " + datos);
            System.out.println("Ruta relativa copias: " + copias);
            System.out.println("Ruta relativa clubes: " + clubes);
            System.out.println("Ruta absoluta carpeta: " + datos.toAbsolutePath());
            System.out.println("Ruta absoluta copias: " + copias.toAbsolutePath());
            System.out.println("Ruta absoluta clubes: " + clubes.toAbsolutePath());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
