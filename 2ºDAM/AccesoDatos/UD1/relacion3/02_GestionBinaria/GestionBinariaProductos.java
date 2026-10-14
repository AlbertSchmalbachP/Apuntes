
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class GestionBinariaProductos {

    public static void main(String[] args) {

        Path archivo = Path.of("2ºDAM", "AccesoDatos", "UD1", "relacion3", "02_GestionBinaria", "datos", "productos.dat");

        // 1: comprobar que el archivo existe
        if (Files.notExists(archivo)) {
            System.out.println("El archivo no existe.");
        } else {
            // 2: recuperar el objeto y comprobar que es una lista de Producto.
            try (ObjectInputStream entrada = new ObjectInputStream(
                    Files.newInputStream(archivo))) {
                Object dato = entrada.readObject();
                if (!(dato instanceof List<?> lista)) {
                    System.out.println("El archivo no contiene una lista.");
                } else {
                    // 3: mostrar los productos.
                    for (Object elemento : lista) {
                        if (!(elemento instanceof Producto producto)) {
                            System.out.println("Se ha encontrado un dato inesperado.");
                        } else {
                            System.out.println(producto);
                        }
                    }
                    // 4: pedir un ID y un nuevo stock.
                    try (Scanner escaner = new Scanner(System.in)) {
                        System.out.print("Introduce un ID: ");
                        int buscarId = escaner.nextInt();
                        try {
                            System.out.print("Introduce el nuevo stock: ");
                            int nuevoStock = escaner.nextInt();
                            if (nuevoStock < 0) {
                                System.out.println("El stock no puede ser negativo.");
                            } else {
                                // 5: si existe, modificarlo y guardar de nuevo la lista completa.
                                boolean encontrado = false;
                                for (Object elemento : lista) {
                                    if (elemento instanceof Producto producto && producto.getId() == buscarId) {
                                        producto.setStock(nuevoStock);
                                        encontrado = true;
                                    }
                                }
                                if (encontrado) {
                                    try (ObjectOutputStream salida = new ObjectOutputStream(Files.newOutputStream(archivo))) {
                                        salida.writeObject(lista);
                                    }
                                    System.out.println("Stock actualizado.");
                                } else {
                                    System.out.println("No existe el producto con ID " + buscarId + ".");
                                }
                            }
                        } catch (Exception e) {
                            System.err.println("Ha habido algun problema al modificar el stock.");
                        }
                    } catch (Exception e) {
                        System.err.println("El ID introducido no es válido.");
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("No se pudo recuperar: " + e.getMessage());
            }
        }
    }
}
