package programacion.ud4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class plantilla {
    /**
     * FUNCIÓN PARA IMPRIMIR POR PANTALLA UN MENSAJE DE SEGUIDO
     * 
     * @param mostrarPorPantalla Mensaje que se imprime por pantalla
     */
    public static void mostrarPorPantalla(String mensajeMostrar) {
        System.out.print(mensajeMostrar);
    }

    /**
     * FUNCIÓN PARA IMPRIMIR POR PANTALLA EN LA SIGUIENTE LINEA
     * 
     * @param mostrarLineaPorPantalla Mensaje que se imprime por pantalla
     */
    public static void mostrarLineaPorPantalla(String mensajeMostrar) {
        System.out.println(mensajeMostrar);
    }

    // FUNCIÓN PARA COMPROBAR EL INPUT EN UNA LISTA
    public static int comprobarInputLista(String inputComprobar, Scanner scanner) {
        int opcionSeleccionada;
        mostrarPorPantalla("Introduce una opción: ");
        // control de errores para el input de la opción
        while (!(scanner.hasNextInt())) {
            scanner.nextLine();
            mostrarPorPantalla("¡Se debe introducir un número entero! Introduce una opción: ");
        }
        opcionSeleccionada = scanner.nextInt();
        scanner.nextLine();
        return opcionSeleccionada;
    }

    // FUNCIÓN PARA COMPROBAR EL 
    public static double pideNumeroDouble(String mensajeInput,
            String mensajeError, Scanner scanner) {
        boolean noEsDouble = true;
        double numeroDouble = 0;
        do {
            try {
                noEsDouble = false;
                mostrarPorPantalla(mensajeInput);
                numeroDouble = Double.parseDouble(scanner.nextLine());

            } catch (Exception e) {
                noEsDouble = true;
                mostrarLineaPorPantalla(mensajeError);
            }
        } while (noEsDouble);
        return numeroDouble;
    }

    // FUNCIÓN QUE COMPRUEBA SI UN NÚMERO (entero) ESTÁ EN UN RANGO NUMÉRICO
    public static int comprobarEntero(int valorMinimo, int valorMaximo, String mensajeInput, Scanner scanner) {
        String mensajeError = "El número introducido no se encuentra dentro del rango permitido!";
        int numeroAComprobar;
        do {
            numeroAComprobar = pideNumeroEntero(mensajeInput, mensajeError, scanner);
            if (numeroAComprobar < valorMinimo || numeroAComprobar > valorMaximo) {
                mostrarLineaPorPantalla(mensajeError);
            }
        } while (numeroAComprobar < valorMinimo || numeroAComprobar > valorMaximo);

        return numeroAComprobar;
    }

    /**
     * FUNCIÓN QUE COMPRUEBA SI UN NÚMERO DOUBLE ESTÁ EN UN RANGO NUMÉRICO
     * 
     * @param valorMinimo  Valor mínimo que debe tener el número double
     * @param valorMaximo  Valor máximo que debe tener el número double
     * @param mensajeInput Mensaje de petición del número
     * @param mensajeError Mensaje de error del número en caso de que no cumpla las
     *                     condiciones
     * @param scanner      Objeto de tipo scanner
     * @return Devuelve el número double ingresado
     */
    public static double comprobar(int valorMinimo, int valorMaximo,
            String mensajeInput, String mensajeError, Scanner scanner) {
        double numeroAComprobar;
        do {
            numeroAComprobar = pideNumeroDouble(mensajeInput, mensajeError, scanner);
            if (numeroAComprobar < valorMinimo || numeroAComprobar > valorMaximo) {
                mostrarLineaPorPantalla(mensajeError);
            }
        } while (numeroAComprobar < valorMinimo || numeroAComprobar > valorMaximo);

        return numeroAComprobar;
    }

    /**
     * AÑADE A UNA LISTA DE ENTEROS SI EL ELEMENTO NO ESTABA PREVIAMENTE
     * 
     * @param elemento     elemento que vamos a añadir
     * @param listaEnteros lista a la que vamos a añadir el entero
     * @return devuelve true si se pudo añadir, false si ya estaba en la lista.
     */
    public static boolean addToListInt(int elemento, ArrayList<Integer> listaEnteros) {
        boolean aniadidoConExito;
        if (listaEnteros.contains(elemento)) {
            aniadidoConExito = false;
        } else {
            listaEnteros.add(elemento);
            aniadidoConExito = true;
        }
        return aniadidoConExito;
    }

    /**
     * AÑADE A UNA LISTA DE CADENAS SI EL ELEMENTO NO ESTABA PREVIAMENTE
     * 
     * @param elemento     elemento que vamos a añadir
     * @param listaCadenas lista a la que vamos a añadir la cadena
     * @return devuelve true si se pudo añadir, false si ya estaba en la lista.
     */
    public static boolean addToListString(String elemento, ArrayList<String> listaCadenas) {
        boolean aniadidoConExito;
        if (listaCadenas.contains(elemento)) {
            aniadidoConExito = false;
        } else {
            listaCadenas.add(elemento);
            aniadidoConExito = true;
        }
        return aniadidoConExito;
    }

    /**
    * FUNCIÓN PARA VISUALIZAR DE FORMA AMIGABLE UN ARRAY DE ENTEROS
    *
    * @param separador    El separador por el cual vamos "separar" cada elemento de la cadena de numeros
    * @param listaEnteros Array de tipo Integer que queremos mostrar de forma amigable
    * @return devuelve el array pero en forma de cadena, amigable a nivel de usuario
    */
    public static String joinArrayInt(String separador, ArrayList<Integer> listaEnteros){
        String listaNumerosEnCadena = "";
        for (int numero : listaEnteros) {
            listaNumerosEnCadena += numero + separador;
        }
        listaNumerosEnCadena = listaNumerosEnCadena.substring(0, listaNumerosEnCadena.length() - separador.length());
        return listaNumerosEnCadena;
    }

    /**
    * FUNCIÓN PARA VISUALIZAR DE FORMA AMIGABLE UN ARRAY DOUBLE
    *
    * @param separador   El separador por el cual vamos "separar" cada elemento de la cadena de numeros double
    * @param listaDouble Array de tipo Double que queremos mostrar de forma amigable
    * @return devuelve el array pero en forma de cadena, amigable a nivel de usuario
    */
    public static String joinArrayDouble(String separador, ArrayList<Double> listaDouble){
        String listaDoubleEnCadena = "";
        for (double numero : listaDouble) {
            listaDoubleEnCadena += numero + separador;
        }
        listaDoubleEnCadena = listaDoubleEnCadena.substring(0, listaDoubleEnCadena.length() - separador.length());
        return listaDoubleEnCadena;
    }

    // ============================= MAIN ======================== //
    public static void main(String[] args) {

        // VARIABLES MENÚ
        final String OPCION1 = "1", OPCION2 = "2", OPCION3 = "3", OPCION4 = "4", OPCIONSALIR = "5";
        ArrayList<String> opcionesMenu = new ArrayList<>(
                Arrays.asList(OPCION1, OPCION2, OPCION3, OPCION4, OPCIONSALIR));
        boolean sigueEnMenu = true;
        final String INTERFAZMENU = "==== MENU ====\n(1) Opción1\n(2) Opción2\n(3) Opción3\n(4) Opción4\n(5) Salir";
        String seleccionMenu = "";

        // ================ INTERACCIÓN MENÚ ============================== //
        Scanner input = new Scanner(System.in);

        while (sigueEnMenu) {
            do {
                mostrarLineaPorPantalla(INTERFAZMENU);
                seleccionMenu = input.nextLine();

                // Mensaje de error Menu
                if (!opcionesMenu.contains(seleccionMenu)) {
                    mostrarLineaPorPantalla("Debes ingresar una opción válida");
                }

            } while (!opcionesMenu.contains(seleccionMenu));

            // ----------------- OPCIÓN 1 ---------------------------------- //
            if (seleccionMenu.equals(OPCION1)) {
                mostrarLineaPorPantalla("En desarrollo");

                // ----------------- OPCIÓN 2 ---------------------------------- //
            } else if (seleccionMenu.equals(OPCION2)) {
                mostrarLineaPorPantalla("En desarrollo");

                // ----------------- OPCIÓN 3 ---------------------------------- //
            } else if (seleccionMenu.equals(OPCION3)) {
                mostrarLineaPorPantalla("En desarrollo");

                // ----------------- OPCIÓN 4 ---------------------------------- //
            } else if (seleccionMenu.equals(OPCION4)) {
                mostrarLineaPorPantalla("En desarrollo");

                // ----------------- OPCIÓN SALIR ---------------------------------- //
            } else {
                mostrarLineaPorPantalla("¡BYE!");
                sigueEnMenu = false;
            }

        }
        input.close();
    }
}
