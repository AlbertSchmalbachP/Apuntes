import java.nio.file.Files;
import java.nio.file.Path;

public class GestionBinariaProductos {
    public static void main(String[] args) {

        Path archivo = Path.of("2ºDAM", "AccesoDatos", "UD1", "relacion3", "02_GestionBinaria", "datos", "productos.dat");

        // 1: comprobar que el archivo existe
        if (Files.notExists(archivo)) {
            System.out.println("El archivo no existe.");
        } else {
            // TODO 2: recuperar el objeto y comprobar que es una lista de Producto.
            // TODO 3: mostrar los productos.
            // TODO 4: pedir un ID y un nuevo stock.
            // TODO 5: si existe, modificarlo y guardar de nuevo la lista completa.
            // TODO 6: volver a cargar para comprobar la persistencia.
        }
    }
}
