package es.stemgranada.ed.pruebasunitarias.calculadora;

/**
 * Clase que proporciona operaciones matemáticas básicas y utilidades
 * numéricas con validaciones explícitas de entrada.
 */
public class Calculadora {

    /**
     * Suma dos números enteros.
     *
     * @param a primer sumando
     * @param b segundo sumando
     * @return la suma de a y b
     */
    public int sumar(int a, int b) {
        return a + b;
    }

    /**
     * Resta dos números enteros.
     *
     * @param a minuendo
     * @param b sustraendo
     * @return la resta de a y b
     */
    public int restar(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dos números enteros.
     *
     * @param a primer factor
     * @param b segundo factor
     * @return el producto de a y b
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide dos números.
     *
     * @param a dividendo
     * @param b divisor
     * @return el cociente de dividir a entre b
     * @throws IllegalArgumentException si el divisor es cero
     */
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir entre cero");
        }
        return a / b;
    }

    /**
     * Calcula la potencia base elevado a exponente.
     *
     * @param base valor base de la potencia
     * @param exponente número de veces que se multiplica la base por sí misma
     * @return el resultado de elevar la base al exponente indicado
     * @throws IllegalArgumentException si el exponente es negativo
     */
    public double potencia(double base, int exponente) {
        if (exponente < 0) {
            throw new IllegalArgumentException("El exponente no puede ser negativo");
        }

        double resultado = 1;

        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }

        return resultado;
    }

    /**
     * Calcula la media aritmética de un conjunto de valores.
     *
     * @param valores conjunto de valores del que se calculará la media
     * @return la media aritmética de los valores proporcionados
     * @throws IllegalArgumentException si el array es null o está vacío
     */
    public double media(double[] valores) {
        if (valores == null || valores.length == 0) {
            throw new IllegalArgumentException("El array no puede ser null ni estar vacío");
        }

        double suma = 0;

        for (double valor : valores) {
            suma += valor;
        }

        return suma / valores.length;
    }

    /**
     * Determina si un número es par.
     *
     * @param numero número que se quiere comprobar
     * @return true si el número es par; false en caso contrario
     */
    public boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    /**
     * Calcula el factorial de un número.
     *
     * @param numero número del que se calculará el factorial
     * @return el factorial del número indicado
     * @throws IllegalArgumentException si el número es negativo
     */
    public long factorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El número no puede ser negativo");
        }

        if (numero == 0 || numero == 1) {
            return 1;
        }

        long resultado = 1;

        for (int i = 2; i <= numero; i++) {
            resultado *= i;
        }

        return resultado;
    }
}
