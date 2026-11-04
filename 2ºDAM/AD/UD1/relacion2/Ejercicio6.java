import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio6 {
    public static void main(String[] args) {
        Path productosDefectuosos = Path.of("2ºDAM","AccesoDatos","UD1","resources","productos_errores.csv");
        Path productosValidos = Path.of("2ºDAM","AccesoDatos","UD1","resources","productos_validos.csv");

        try {
            if (!Files.exists(productosDefectuosos)) {
                System.out.println("El archivo no existe.");
                return;
            }

            List<String> lineasArchivoDefectuoso = Files.readAllLines(productosDefectuosos, StandardCharsets.UTF_8);
            List<String> lineasCorrectas = new ArrayList<>();

            List<String> idRegistradas = new ArrayList<>();

            boolean lineaCorrecta;
            String mensajeLineaIncorrecta, idLinea;

            String[] filaArchDefectuoso;

            int columnasEsperadas = lineasArchivoDefectuoso.get(0).split(";", -1).length;

            lineasCorrectas.add(lineasArchivoDefectuoso.get(0));

            for (int i = 1; i < lineasArchivoDefectuoso.size(); i++) {
                lineaCorrecta = true;
                mensajeLineaIncorrecta = "";
                filaArchDefectuoso = lineasArchivoDefectuoso.get(i).split(";", -1);

                idLinea = filaArchDefectuoso[0].trim();
                try {

                    if (filaArchDefectuoso.length != columnasEsperadas) {
                        lineaCorrecta = false;
                    }

                    if (!idLinea.matches("\\d+")) {
                        mensajeLineaIncorrecta += "    - La id no era un núm. entero positivo mayor que 0. \n";
                        lineaCorrecta = false;  
                    }

                    if (lineaCorrecta && idRegistradas.contains(idLinea)) {
                        mensajeLineaIncorrecta += "    - La id de esta linea ya estaba registrada. \n";
                        lineaCorrecta = false;
                    }

                    if (filaArchDefectuoso[1].isEmpty()) {
                        mensajeLineaIncorrecta += "    - El nombre del producto estaba vacío. \n";
                        lineaCorrecta = false;  
                    }

                    if (!filaArchDefectuoso[2].matches("\\d+")) {
                        mensajeLineaIncorrecta += "    - El stock no era un numero entero positivo. \n";
                        lineaCorrecta = false;  
                    }

                    if (lineaCorrecta) {
                        idRegistradas.add(idLinea);
                    }

                } catch (IndexOutOfBoundsException e) {
                    mensajeLineaIncorrecta += "    - No tenia el núm. esperado de columnas. \n";

                }

                if (!lineaCorrecta) {
                    System.out.println("La linea con id " + filaArchDefectuoso[0] + " No era correcta por los siguientes motivos: \n" + mensajeLineaIncorrecta);
                } else {
                    lineasCorrectas.add(lineasArchivoDefectuoso.get(i));
                }
            }

            // crear archivo desde cero y escribir las lineas
            Files.deleteIfExists(productosValidos);
            Files.createFile(productosValidos);            
            Files.write(productosValidos, lineasCorrectas, StandardCharsets.UTF_8);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}