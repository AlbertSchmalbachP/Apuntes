import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Path prestamos = Path.of("2ºDAM", "AccesoDatos", "UD1", "resources", "prestamos.csv");
        Path carpetaCopias = prestamos.getParent().resolve("copias");
        Path copia = carpetaCopias.resolve("prestamos.bak");
        try (Scanner escaner = new Scanner(System.in)) {
            if (Files.notExists(prestamos)) {
                Files.createFile(prestamos);
            }
            String opcion = "0";
            while (!(opcion.equals("-1"))) {
                System.out.println("1. Dar de alta un registro");
                System.out.println("2. Listar registros");
                System.out.println("3. Buscar registro por ID");
                System.out.println("4. Modificar material de un registro");
                System.out.println("5. Dar de baja un registro");
                System.out.println("6. Crear una copia de seguridad");
                System.out.println("7. Restaurar copia de seguridad");
                System.out.println("\n-1. Salir del programa");
                System.out.print("\nIntroduce una opción: ");
                opcion = escaner.nextLine();
                if (opcion.equals("1")) {
                    System.out.print("ID del préstamo: ");
                    String textoId = escaner.nextLine().trim();
                    System.out.print("Persona: ");
                    String persona = escaner.nextLine().trim();
                    System.out.print("Material: ");
                    String material = escaner.nextLine().trim();

                    int id = 0;
                    boolean idValido = false;
                    try {
                        id = Integer.parseInt(textoId);
                        idValido = id > 0;
                    } catch (NumberFormatException e) {
                        idValido = false;
                    }

                    if (!idValido) {
                        System.out.println("El ID debe ser un número entero mayor que cero.");
                    } else if (persona.isEmpty() || material.isEmpty()) {
                        System.out.println("La persona y el material no pueden estar vacíos.");
                    } else if (persona.split(";", -1).length != 1 || material.split(";", -1).length != 1) {
                        System.out.println("La persona y el material no pueden contener ';'.");
                    } else {
                        try {
                            List<String> lineas = Files.readAllLines(prestamos, StandardCharsets.UTF_8);
                            boolean repetido = false;
                            for (String linea : lineas) {
                                String[] campos = linea.split(";", -1);
                                if (campos.length == 3) {
                                    try {
                                        if (Integer.parseInt(campos[0].trim()) == id) {
                                            repetido = true;
                                        }
                                    } catch (NumberFormatException e) {
                                        // Línea con ID no válido: no se compara
                                    }
                                }
                            }
                            if (repetido) {
                                System.out.println("Ya existe un préstamo con ese ID.");
                            } else {
                                try (BufferedWriter salida = Files.newBufferedWriter(
                                        prestamos, StandardCharsets.UTF_8,
                                        StandardOpenOption.CREATE,
                                        StandardOpenOption.APPEND)) {
                                    salida.write(id + ";" + persona + ";" + material);
                                    salida.newLine();
                                }
                                System.out.println("Préstamo añadido.");
                            }
                        } catch (IOException e) {
                            System.err.println("No se pudo dar de alta: " + e.getMessage());
                        }
                    }
                } else if (opcion.equals("2")) {
                    try {
                        List<String> lineas = Files.readAllLines(prestamos, StandardCharsets.UTF_8);
                        int total = 0;
                        for (int i = 0; i < lineas.size(); i++) {
                            String linea = lineas.get(i);
                            if (!linea.trim().isEmpty()) {
                                String[] campos = linea.split(";", -1);
                                boolean valida = false;
                                if (campos.length == 3) {
                                    try {
                                        int id = Integer.parseInt(campos[0].trim());
                                        System.out.println("[" + id + "] " + campos[1] + " - " + campos[2]);
                                        total++;
                                        valida = true;
                                    } catch (NumberFormatException e) {
                                        valida = false;
                                    }
                                }
                                if (!valida) {
                                    System.out.println("Línea " + (i + 1) + " ignorada: formato incorrecto.");
                                }
                            }
                        }
                        if (total == 0) {
                            System.out.println("No hay préstamos registrados.");
                        }
                    } catch (IOException e) {
                        System.err.println("No se pudo leer: " + e.getMessage());
                    }
                } else if (opcion.equals("3")) {
                    System.out.print("ID del préstamo a buscar: ");
                    String textoId = escaner.nextLine().trim();
                    int id = 0;
                    boolean idValido = false;
                    try {
                        id = Integer.parseInt(textoId);
                        idValido = id > 0;
                    } catch (NumberFormatException e) {
                        idValido = false;
                    }

                    if (!idValido) {
                        System.out.println("El ID debe ser un número entero mayor que cero.");
                    } else {
                        try {
                            List<String> lineas = Files.readAllLines(prestamos, StandardCharsets.UTF_8);
                            boolean encontrado = false;
                            for (String linea : lineas) {
                                String[] campos = linea.split(";", -1);
                                boolean coincide = false;
                                if (campos.length == 3) {
                                    try {
                                        coincide = Integer.parseInt(campos[0].trim()) == id;
                                    } catch (NumberFormatException e) {
                                        coincide = false;
                                    }
                                }
                                if (coincide) {
                                    System.out.println("Persona: " + campos[1] + " | Material: " + campos[2]);
                                    encontrado = true;
                                }
                            }
                            if (!encontrado) {
                                System.out.println("No existe ningún préstamo con el ID " + id + ".");
                            }
                        } catch (IOException e) {
                            System.err.println("No se pudo leer: " + e.getMessage());
                        }
                    }
                } else if (opcion.equals("4")) {
                    System.out.print("ID del préstamo a modificar: ");
                    String textoId = escaner.nextLine().trim();
                    System.out.print("Nuevo material: ");
                    String nuevoMaterial = escaner.nextLine().trim();

                    int id = 0;
                    boolean idValido = false;
                    try {
                        id = Integer.parseInt(textoId);
                        if (id > 0) {
                            idValido = true;
                        }
                    } catch (NumberFormatException e) {
                        idValido = false;
                    }

                    if (!idValido) {
                        System.out.println("El ID debe ser un número entero mayor que cero.");
                    } else if (nuevoMaterial.isEmpty()) {
                        System.out.println("El material no puede estar vacío.");
                    } else {
                        try {
                            List<String> originales = Files.readAllLines(prestamos, StandardCharsets.UTF_8);
                            List<String> nuevas = new ArrayList<>();
                            boolean encontrado = false;
                            for (String linea : originales) {
                                String[] campos = linea.split(";", -1);
                                boolean coincide = false;
                                if (campos.length == 3) {
                                    try {
                                        coincide = Integer.parseInt(campos[0].trim()) == id;
                                    } catch (NumberFormatException e) {
                                        coincide = false;
                                    }
                                }
                                if (coincide) {
                                    nuevas.add(campos[0] + ";" + campos[1] + ";" + nuevoMaterial);
                                    encontrado = true;
                                } else {
                                    nuevas.add(linea);
                                }
                            }
                            if (encontrado) {
                                Files.createDirectories(carpetaCopias);
                                Files.copy(prestamos, copia, StandardCopyOption.REPLACE_EXISTING);
                                Files.write(prestamos, nuevas, StandardCharsets.UTF_8);
                                System.out.println("Material actualizado.");
                            } else {
                                System.out.println("No existe ningún préstamo con el ID " + id + ".");
                            }
                        } catch (IOException e) {
                            System.err.println("No se pudo modificar: " + e.getMessage());
                        }
                    }
                } else if (opcion.equals("5")) {
                    System.out.print("ID del préstamo a dar de baja: ");
                    String textoId = escaner.nextLine().trim();
                    int id = 0;
                    boolean idValido = false;
                    try {
                        id = Integer.parseInt(textoId);
                        idValido = id > 0;
                    } catch (NumberFormatException e) {
                        idValido = false;
                    }

                    if (!idValido) {
                        System.out.println("El ID debe ser un número entero mayor que cero.");
                    } else {
                        try {
                            List<String> originales = Files.readAllLines(prestamos, StandardCharsets.UTF_8);
                            List<String> nuevas = new ArrayList<>();
                            boolean encontrado = false;
                            for (String linea : originales) {
                                String[] campos = linea.split(";", -1);
                                boolean coincide = false;
                                if (campos.length == 3) {
                                    try {
                                        coincide = Integer.parseInt(campos[0].trim()) == id;
                                    } catch (NumberFormatException e) {
                                        coincide = false;
                                    }
                                }
                                if (coincide) {
                                    encontrado = true;
                                } else {
                                    nuevas.add(linea);
                                }
                            }
                            if (encontrado) {
                                Files.createDirectories(carpetaCopias);
                                Files.copy(prestamos, copia, StandardCopyOption.REPLACE_EXISTING);
                                Files.write(prestamos, nuevas, StandardCharsets.UTF_8);
                                System.out.println("Préstamo dado de baja.");
                            } else {
                                System.out.println("No existe ningún préstamo con el ID " + id + ".");
                            }
                        } catch (IOException e) {
                            System.err.println("No se pudo dar de baja: " + e.getMessage());
                        }
                    }
                } else if (opcion.equals("6")) {
                    try {
                        Files.createDirectories(carpetaCopias);
                        Files.copy(prestamos, copia, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Copia creada: " + copia.toAbsolutePath());
                    } catch (IOException e) {
                        System.err.println("No se pudo crear la copia: " + e.getMessage());
                    }
                } else if (opcion.equals("7")) {
                    if (Files.notExists(copia)) {
                        System.out.println("No existe ninguna copia de seguridad.");
                    } else {
                        try {
                            System.out.print("Se sustituirán los datos actuales por la copia. ¿Continuar? (s/n): ");
                            String respuesta = escaner.nextLine().trim();
                            if (respuesta.equalsIgnoreCase("s")) {
                                Files.copy(prestamos, carpetaCopias.resolve("prestamos_anterior.bak"),
                                        StandardCopyOption.REPLACE_EXISTING);
                                Files.copy(copia, prestamos, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("Copia restaurada correctamente.");
                            } else {
                                System.out.println("Restauración cancelada.");
                            }
                        } catch (IOException e) {
                            System.err.println("No se pudo restaurar: " + e.getMessage());
                        }
                    }
                } else if (opcion.equals("-1")) {
                    System.out.println("Programa finalizado.");
                } else {
                    System.out.println("Opción no válida");
                }
            }
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
}