import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GuardarProductosBinario {
    public static void main(String[] args) {
        Path archivo = Path.of("datos", "productos.dat");
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Teclado", 59.90, 8));
        productos.add(new Producto(2, "Ratón", 24.50, 15));
        productos.add(new Producto(3, "Monitor", 219.00, 4));
        productos.add(new Producto(4, "Memoria USB", 14.95, 30));

        try {
            Files.createDirectories(archivo.getParent());
            // No se usa APPEND: se sustituye la lista completa.
            try (ObjectOutputStream salida =
                    new ObjectOutputStream(Files.newOutputStream(archivo))) {
                salida.writeObject(productos);
            }
            if (Files.exists(archivo) && Files.size(archivo) > 0) {
                System.out.println("Guardados " + productos.size() + " productos en " + archivo);
                System.out.println("Tamaño: " + Files.size(archivo) + " bytes");
            } else {
                System.out.println("No se ha podido verificar el fichero de salida.");
            }
        } catch (IOException e) {
            System.out.println("Error al guardar productos: " + e.getMessage());
        }
    }
}
