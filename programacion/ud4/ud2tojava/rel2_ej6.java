package programacion.ud4.ud2tojava;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class rel2_ej6 {
    public static void main(String[] args) {
        ArrayList<String> tareas = new ArrayList<String>(Arrays.asList("Estudiar", "Practicar código"));
        ArrayList<Boolean> estadoTareas = new ArrayList<Boolean>(Arrays.asList(false, true));
        int opcion;
        String nuevaTarea;
        String inputEstadoTarea;
        boolean estadoNuevaTarea;
        String tareaCompletar;
        boolean tareaExistente;
        int contadorLista;
        final int OPCIONMINIMA = 1;
        final int OPCIONMAXIMA = 5;
        System.out.println("Opciones:\n1. Añadir una nueva tarea\n2. Marcar una tarea como completada\n3. Ver la lista de tareas pendientes\n4. Ver la lista de tareas completadas\n5. Salir del programa.");
        Scanner scanner1 = new Scanner(System.in);
        do {
            System.out.print("Introduce una opción: ");
            opcion = scanner1.nextInt();
            scanner1.nextLine();
            if (opcion == 1) {
                System.out.print("Introduce el nombre de la nueva tarea: ");
                nuevaTarea = scanner1.nextLine();
                System.out.print("Introduce el estado de la nueva tarea: completada (c) o pendiente (p): ");
                inputEstadoTarea = scanner1.nextLine().toUpperCase();
                // Según sea completada o pendiente, se le asigna un booleano, luego se añade el nombre y el estado a los arrays
                if (inputEstadoTarea.equals("C") || inputEstadoTarea.equals("COMPLETADA")) {
                    estadoNuevaTarea = true;
                } else {
                    estadoNuevaTarea = false;
                }
                tareas.add(nuevaTarea);
                estadoTareas.add(estadoNuevaTarea);
            } else if (opcion == 2) {
                tareaExistente = false;
                System.out.print("Introduce el nombre de la tarea a marcar como completada: ");
                tareaCompletar = scanner1.nextLine();
                // bucle que comprueba si la tarea existe y si la tarea ya está completada
                for (int i = 0; i < tareas.size(); i++) {
                    if (tareaCompletar.equals(tareas.get(i)) && estadoTareas.get(i) == false) {
                        estadoTareas.set(i, true);
                        tareaExistente = true;
                    } else if (tareaCompletar == tareas.get(i) && estadoTareas.get(i) == true) {
                        System.out.println("¡La tarea ya está completada!");
                        scanner1.nextLine();
                    }
                }
                if (tareaExistente == false) {
                    System.out.println("¡El nombre introducido NO corresponde a ninguna tarea existente!");
                }
            } else if (opcion == 3) {
                contadorLista = 0;
                System.out.println("Tareas pendientes:");
                // bucle que busca y muestra las tareas pendientes y las muestra, mostrando un mensaje si no hay ninguna tarea pendiente
                for (int i = 0; i < tareas.size(); i++) {
                    if (estadoTareas.get(i) == false) {
                        System.out.println(tareas.get(i));
                        contadorLista++;
                    }
                }
                if (contadorLista == 0) {
                    System.out.println("¡No hay tareas pendientes!");
                }
            } else if (opcion == 4) {
                contadorLista = 0;
                System.out.println("Tareas completadas: ");
                // bucle que busca y muestra las tareas completadas y las muestra, mostrando un mensaje si no hay ninguna tarea completada
                for (int i = 0; i < tareas.size(); i++) {
                    if (estadoTareas.get(i) == true) {
                        System.out.println(tareas.get(i));
                        contadorLista++;
                    }
                }
                if (contadorLista == 0) {
                    System.out.println("¡No hay tareas completadas!");
                }
            // else if que checkea que la opcion introducida no se salga del rango deseado mínimo y máximo
            } else if (opcion < OPCIONMINIMA || opcion > OPCIONMAXIMA) {
                System.out.println("¡El valor introducido no corresponde con ninguna opción!");
            }
            // DEV
            System.out.println(tareas);
            System.out.println(estadoTareas);
        } while (!(opcion == 5));
        scanner1.close();
    }
}
// FALTA CONTROL DE ERRORES Y TRASLADARLO A FUNCIONES