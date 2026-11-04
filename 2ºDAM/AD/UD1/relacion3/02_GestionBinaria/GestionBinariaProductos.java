import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionBinariaProductos {
    public static void main(String[] args) {
        Path archivo = Path.of("datos", "productos.dat");
        if (!Files.exists(archivo)) {
            System.out.println("No existe " + archivo);
            return;
        }
        try {
            List<Producto> productos = cargar(archivo);
            System.out.println("Productos recuperados:");
            productos.forEach(System.out::println);

            Scanner teclado = new Scanner(System.in);
            System.out.print("ID del producto: ");
            int id = Integer.parseInt(teclado.nextLine().trim());
            System.out.print("Nuevo stock (>= 0): ");
            int stock = Integer.parseInt(teclado.nextLine().trim());
            if (stock < 0) {
                System.out.println("El stock no puede ser negativo. No se guardan cambios.");
                return;
            }

            Producto encontrado = null;
            for (Producto producto : productos) {
                if (producto.getId() == id) {
                    encontrado = producto;
                }
            }
            if (encontrado == null) {
                System.out.println("ID no encontrado. El fichero no se modifica.");
                return;
            }

            encontrado.setStock(stock);
            try (ObjectOutputStream salida =
                    new ObjectOutputStream(Files.newOutputStream(archivo))) {
                salida.writeObject(productos);
            }
            // Verificación: se abre de nuevo el fichero recién guardado.
            List<Producto> comprobacion = cargar(archivo);
            for (Producto producto : comprobacion) {
                if (producto.getId() == id) {
                    System.out.println("Stock persistido: " + producto);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Introduce números enteros válidos. No se guardan cambios.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo leer o guardar el fichero: " + e.getMessage());
        }
    }

    private static List<Producto> cargar(Path archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream entrada =
                new ObjectInputStream(Files.newInputStream(archivo))) {
            Object objeto = entrada.readObject();
            if (!(objeto instanceof List<?> lista)) {
                throw new IOException("El fichero no contiene una lista.");
            }
            List<Producto> productos = new ArrayList<>();
            for (Object elemento : lista) {
                if (!(elemento instanceof Producto producto)) {
                    throw new IOException("La lista contiene un elemento que no es Producto.");
                }
                productos.add(producto);
            }
            return productos;
        }
    }
}
