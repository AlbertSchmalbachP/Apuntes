package programacion.ud5.pt5;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Funciones {

    /** Recibe un mensaje y hace un sys.out SIN "ln"
     * @param mensaje mensaje a imprimir
     */
    public static void print(String mensaje) {
        System.out.print(mensaje);
    }

    /** Recibe un mensaje y hace un sys.out CON "ln"
     * 
     * @param mensaje mensaje a imprimir
     */
    public static void printLn(Object objeto) {
        System.out.println(objeto);
    }

    /** Pide un numero entero hasta que el usuario introduza un entero entre el valor especificado 
     *
     * @param mensajeUsuario        Mensaje para que el usuario sepa que valores introducir.
     * @param scanner               leer input del usuario.
     * @param valorMinimoAcptado    Valor para comprobar el mínimo.
     * @param valorMaxAceptado      Valor para comprobar el máximo.
     * 
     * @return int -> Numero mayor al minimo y menor al maximo
     */
    public static int pedirNumeroEntero2valores(Scanner scanner, int valorMinimoAceptado, int valorMaxAceptado, String mensajeUsuario) {
        printLn("");
        int numero = valorMinimoAceptado - 1;
        String mensajeError = "ERROR: Ese valor no se encuentra dentro del rango permitido"; 
        boolean valido;

        do {
            valido = true;
            try {
                print(mensajeUsuario);
                numero = scanner.nextInt();
            
                if (numero < valorMinimoAceptado || numero > valorMaxAceptado) {
                    printLn(mensajeError);
                    valido = false;
                }
            
            } catch (InputMismatchException e) {
                scanner.nextLine();
                printLn(mensajeError);
                valido = false;
            }
        
        } while (!valido);
        
        return numero;
    }

    /** Pide un numero hasta que el usuario introduza un entero menor al máximo permitido.
     * 
     * @param mensajeUsuario        Mensaje para que el usuario sepa que valores introducir.
     * @param scanner               leer input del usuario.
     * @param valorMaxAceptado      Valor para comprobar el máximo.
     * 
     * @return int -> Numero menor al valor máx. permitido.
     */
    public static int pedirNumeroEntero1valorMAX(Scanner scanner, int valorMaxAceptado, String mensajeUsuario) {
        printLn("");
        int numero = valorMaxAceptado + 1 ;
        String mensajeError = "ERROR: Ese valor no se encuentra dentro del rango permitido"; 
        boolean valido;

        do {
            valido = true;
            try {
                print(mensajeUsuario);
                numero = scanner.nextInt();
            
                if (numero > valorMaxAceptado) {
                    printLn(mensajeError);
                    valido = false;
                }
            
            } catch (InputMismatchException e) {
                scanner.nextLine();
                printLn(mensajeError);
                valido = false;
            }
        
        } while (!valido);
        
        return numero;
    }

    /** Pide un numero hasta que el usuario introduza un entero mayor al mínimo permitido.
     * 
     * @param mensajeUsuario        Mensaje para que el usuario sepa que valores introducir.
     * @param scanner               leer input del usuario.
     * @param valorMinimoAcptado    Valor para comprobar el mínimo.
     * 
     * @return int -> Numero mayor al mínimo permitido.
     */
    public static int pedirNumeroEntero1valorMIN(Scanner scanner, int valorMinimoAcptado, String mensajeUsuario) {
        printLn("");
        int numero = valorMinimoAcptado - 1;
        String mensajeError = "ERROR: Ese valor no se encuentra dentro del rango permitido"; 
        boolean valido;

        do {
            valido = true;
            try {
                print(mensajeUsuario);
                numero = scanner.nextInt();
            
                if (numero < valorMinimoAcptado) {
                    printLn(mensajeError);
                    valido = false;
                }
            
            } catch (InputMismatchException e) {
                scanner.nextLine();
                printLn(mensajeError);
                valido = false;
            }
        
        } while (!valido);
        
        return numero;
    }

    /** Pide un double hasta que el usuario introduzca uno establecido por el rango.
     *  
     * @param mensajeUsuario        Mensaje para que el usuario sepa que valores introducir.
     * @param scanner               leer input del usuario.
     * @param valorMinimoAcptado    Valor para comprobar el mínimo.
     * @param valorMaxAceptado      Valor para comprobar el máximo.
     * 
     * @return double -> numero introducido por el usuario ceñido al rango establecido
     */
    public static double pedirDouble2valores(Scanner scanner, double valorMinimoAcptado, double valorMaxAceptado, String mensajeUsuario) {
        
        double numero = valorMinimoAcptado - 1.00;
        String mensajeError = "ERROR: Ese valor no se encuentra dentro del rango permitido";
        boolean valido;

        do {
            valido = true;
            try {
                print(mensajeUsuario);
                numero = scanner.nextDouble();
            
                if (numero < valorMinimoAcptado || numero > valorMaxAceptado) {
                    printLn(mensajeError);
                    valido = false;
                }
            
            } catch (InputMismatchException e) {
                scanner.nextLine();
                printLn(mensajeError);
                valido = false;
            }
        
        } while (!valido);

        
        return numero;
    }

    /** Pide un numero hasta que el usuario introduza un double menor al máximo permitido.

     * @param mensajeUsuario        Mensaje para que el usuario sepa que valores introducir.
     * @param scanner               leer input del usuario.
     * @param valorMaxAceptado      Valor para comprobar el máximo.
     * 
     * @return double -> Numero menor al valor máx. permitido.
     */
    public static double pedirDouble1valorMAX(Scanner scanner, double valorMaxAceptado, String mensajeUsuario) {
        printLn("");
        double numero = valorMaxAceptado + 1 ;
        String mensajeError = "ERROR: Ese valor no se encuentra dentro del rango permitido"; 
        boolean valido;

        do {
            valido = true;
            try {
                print(mensajeUsuario);
                numero = scanner.nextDouble();
            
                if (numero > valorMaxAceptado) {
                    printLn(mensajeError);
                    valido = false;
                }
            
            } catch (InputMismatchException e) {
                scanner.nextLine();
                printLn(mensajeError);
                valido = false;
            }
        
        } while (!valido);
        
        return numero;
    }

    /** Pide un numero hasta que el usuario introduza un double mayor al mínimo permitido.
     * 
     * @param mensajeUsuario        Mensaje para que el usuario sepa que valores introducir.
     * @param scanner               leer input del usuario.
     * @param valorMinimoAcptado    Valor para comprobar el mínimo.
     * 
     * @return double -> Numero mayor al mínimo permitido.
     */
    public static double pedirDouble1valorMIN(Scanner scanner, double valorMinimoAcptado, String mensajeUsuario) {
        printLn("");
        double numero = valorMinimoAcptado - 1;
        String mensajeError = "ERROR: Ese valor no se encuentra dentro del rango permitido"; 
        boolean valido;

        do {
            valido = true;
            try {
                print(mensajeUsuario);
                numero = scanner.nextDouble();
            
                if (numero < valorMinimoAcptado) {
                    printLn(mensajeError);
                    valido = false;
                }
            
            } catch (InputMismatchException e) {
                scanner.nextLine();
                printLn(mensajeError);
                valido = false;
            }
        
        } while (!valido);
        
        return numero;
    }

    /** Coge los elementos de un array y los separa con un "separador"
     * 
     * @param ArrayAMostrar     ArrayList de String a mostrar
     * @param separador         (String) -> Elemento a separar el array: Ej: ", " && " | " && " ~ "
     * 
     * @return String -> String con cada elemento del ArrayList separado por "separador"
     */
    public static String mostrarArrayString(ArrayList<String> ArrayAMostrar, String separador) {
        return String.join(separador, ArrayAMostrar);
    }
}