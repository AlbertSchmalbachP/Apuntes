import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GuardarProductosBinario {

    public static void main(String[] args) {

        Path archivo = Path.of("2ºDAM", "AccesoDatos", "UD1", "resources", "productos.dat");

        // 1: crear una lista con al menos cuatro Producto.
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "RAM 8GB DDR4", 59.99, 25));
        productos.add(new Producto(2, "Ratón Inalámbrico Logitech", 24.99, 40));
        productos.add(new Producto(3, "Ryzen 7 5800X\"", 189.99, 12));
        productos.add(new Producto(4, "Ventiladores de hidrógeno líquido", 74999.99, 1));
        try {
            // 2: crear la carpeta datos si hace falta.
            Files.createDirectories(archivo.getParent());
            // 3: guardar la lista completa con ObjectOutputStream.
            try (ObjectOutputStream salida = new ObjectOutputStream(
                    Files.newOutputStream(archivo))) {
                salida.writeObject(productos);
            }
            System.out.println("Productos guardados en " + archivo.toAbsolutePath());
        // 4: controlar IOException.
        } catch (IOException e) {
            // 4: mensaje comprensible
            System.err.println("No se pudieron guardar los productos: " + e.getMessage());
        }
    }
}