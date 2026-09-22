package programacion.ud4.pttojava;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PT_recu_T1{
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<String>(Arrays.asList("Ana", "Luis"));
        ArrayList<Double> notas = new ArrayList<Double>(Arrays.asList(7.5, 9.2));
        ArrayList<Double> asistencias = new ArrayList<Double>(Arrays.asList(0.9, 0.85));
        int opcion;
        String nuevoNombre;
        Double nuevaNota;
        Double nuevaAsistencia;
        Double notaMaxima;
        String nombreNotaMaxima;
        Double asistenciaMaxima;
        String nombreAsistenciaMaxima;
        String estudianteEliminar;
        Boolean nombreExiste;
        System.out.println("Opciones:\n1. Añadir estudiante\n2. Mostrar listado completo\n3. Mostrar estudiante con más nota y más asistencia\n4. Eliminar estudiante\n5. Salir");
        Scanner scanner1 = new Scanner(System.in);
        do {
            System.out.print("Introduce una opción: ");
            while (!(scanner1.hasNextInt())) {
                scanner1.nextLine();
                System.out.print("¡Opcion fuera de rango! Introduce una opción: ");
                opcion = scanner1.nextInt();
            }
            opcion = scanner1.nextInt();
            scanner1.nextLine();
            if (opcion == 1) {
                System.out.print("Introduce el nombre del nuevo estudiante: ");
                nuevoNombre = scanner1.nextLine();
                System.out.print("Introduce la nota del nuevo estudiante: ");
                while (!(scanner1.hasNextInt())) {
                    scanner1.nextLine();
                    System.out.print("¡Entrada inválida! Introduce la nota del nuevo estudiante: ");
                }
                nuevaNota = scanner1.nextDouble();
                while (nuevaNota < 0.0 || nuevaNota > 10.0) {
                    System.out.print("¡Nota fuera de rango (0 - 10)! Introduce la nota del nuevo estudiante: ");
                    nuevaNota = scanner1.nextDouble();
                }
                System.out.print("Introduce la asistencia del nuevo estudiante: ");
                while (!(scanner1.hasNextInt())) {
                    scanner1.nextLine();
                    System.out.print("¡Entrada inválida! Introduce la nota del nuevo estudiante: ");
                    nuevaNota = scanner1.nextDouble();
                }
                nuevaAsistencia = scanner1.nextDouble();
                while (nuevaAsistencia < 0 || nuevaAsistencia > 1) {
                    scanner1.nextLine();
                    System.out.print("¡Asistencia fuera de rango (0 - 1)! Introduce la asistencia del nuevo estudiante: ");
                    nuevaAsistencia = scanner1.nextDouble();
                }
                nombres.add(nuevoNombre);
                notas.add(nuevaNota);
                asistencias.add(nuevaAsistencia);
            } else if (opcion == 2) {
                if (nombres.isEmpty()) {
                    System.out.println("¡No hay estudiantes!");
                } else {
                    for (int i = 0; i < nombres.size(); i++) {
                        System.out.println(nombres.get(i) + " - " + notas.get(i) + " - " + asistencias.get(i) * 100 + "%");
                    }
                }
            } else if (opcion == 3) {
                if (nombres.isEmpty()) {
                    System.out.println("¡No hay estudiantes!");
                } else {
                    notaMaxima = notas.get(0);
                    nombreNotaMaxima = nombres.get(0);
                    for (int i = 1; i < notas.size(); i++) {
                        if (notaMaxima < notas.get(i)) {
                            notaMaxima = notas.get(i);
                            nombreNotaMaxima = nombres.get(i);
                        }
                    }
                    asistenciaMaxima = asistencias.get(0);
                    nombreAsistenciaMaxima = nombres.get(0);
                    for (int i = 1; i < asistencias.size(); i++) {
                        if (asistenciaMaxima < asistencias.get(i)) {
                            asistenciaMaxima = asistencias.get(i);
                            nombreAsistenciaMaxima = nombres.get(i);
                        }
                    }
                    System.out.println("Mejor nota: " + nombreNotaMaxima + " (" + notaMaxima + ")");
                    System.out.println("Mayor asistencia: " + nombreAsistenciaMaxima + " (" + asistenciaMaxima * 100 + "%)");
                }  
            } else if (opcion == 4) {
                nombreExiste = false;
                System.out.print("Introduce el nombre del estudiante a eliminar: ");
                estudianteEliminar = scanner1.nextLine();
                for (int i = 0; i < nombres.size(); i++) {
                    if (estudianteEliminar.equalsIgnoreCase(nombres.get(i))) {
                        nombreExiste = true;
                        nombres.remove(i);
                        notas.remove(i);
                        asistencias.remove(i);
                        System.out.println("Estudiante eliminado correctamente.");
                    }
                }
                if (nombreExiste == false) {
                    System.out.println("El nombre introducido no corresponde con ningún usuario.");
                }
            }
        } while (!(opcion == 5));
        scanner1.close();
    }
}
