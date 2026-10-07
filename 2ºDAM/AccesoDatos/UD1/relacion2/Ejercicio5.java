import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Path bibliotecaCSV = Path.of("2ºDAM","AccesoDatos","UD1","resources","biblioteca.csv");

        try (Scanner scanner = new Scanner(System.in)) {
            if (Files.notExists(bibliotecaCSV)) {
                System.out.println(("El archivo no existe."));
                return;
            }

            List<String> datosBiblioteca = Files.readAllLines(bibliotecaCSV, StandardCharsets.UTF_8);
            List<String> datosActualizados = new ArrayList<>();

            List<String> idRegistradas = new ArrayList<>();
            List<String> titulosRegistrados = new ArrayList<>();

            String idRegistrar, tituloRegistrar, autorRegistrar, lineaNueva;

            String[] lineaBiblioteca;

            boolean autorValido = false;

            datosActualizados.addAll(datosBiblioteca);
            for(int i = 1; i < datosBiblioteca.size(); i++) {
                lineaBiblioteca = datosBiblioteca.get(i).split(";", -1);

                idRegistradas.add(lineaBiblioteca[0]);
                titulosRegistrados.add(lineaBiblioteca[1].toLowerCase());
            }

            // Validar ID introducida
            do {
                System.out.println("Introduce una ID  para registrar: ");
                idRegistrar = scanner.nextLine();

                if (idRegistrar.isEmpty() || idRegistrar.isBlank()) {
                    System.out.println("Debes introducir algo para registrar la id.");
                    continue;
                }

                if (!idRegistrar.matches("\\d+")) {
                    System.out.println("Debes introducir un número entero positivo para registrar la id.");
                    continue;
                }

                if (idRegistradas.contains(idRegistrar)) {
                    System.out.println("Debes iuntroducir una id nueva. Esta está ocupada.");
                    continue;
                }

                idRegistradas.add(idRegistrar);

            } while (!idRegistradas.contains(idRegistrar));

            // validar título introducido
            do {
                System.out.println("Introduce un título para registrar: ");
                tituloRegistrar = scanner.nextLine();

                if (tituloRegistrar.isEmpty() || tituloRegistrar.isBlank()) {
                    System.out.println("Debes introducir algo para registrar el título.");
                    continue;
                }

                if (titulosRegistrados.contains(tituloRegistrar.toLowerCase().trim())) {
                    System.out.println("Este título ya está registrado. Prueba otro");
                    continue;
                }

                titulosRegistrados.add(tituloRegistrar);

            } while (!titulosRegistrados.contains(tituloRegistrar));

            // Validar autor introducido
            do {
                System.out.println("Introduce un autor para registrar: ");
                autorRegistrar = scanner.nextLine();

                if (tituloRegistrar.isEmpty() || tituloRegistrar.isBlank()) {
                    System.out.println("Tienes que introducir un autor para poder registrarlo.");
                    continue;
                }

                autorValido = true;
            } while (!autorValido);

            lineaNueva = idRegistrar + ";" + tituloRegistrar + ";" + autorRegistrar;
            datosActualizados.add(lineaNueva);
            Files.write(bibliotecaCSV, datosActualizados, StandardCharsets.UTF_8);

            System.out.println("Programa terminado con éxito.");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}