public class Ejercicio4 {
    public static void main(String[] args) {
        Auto auto1 = new Auto("SEAT", "Alhambra", 54.8);
        auto1.acelerar(12);
        auto1.frenar(5);
        System.out.println(auto1);
    }
}
class Auto {
    String marca;
    String modelo;
    double velocidadActual;
    Auto(String marca, String modelo, double velocidadActual) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadActual = velocidadActual;
    }
    double acelerar(double cantidad) {
        return velocidadActual += cantidad;
    }
    double frenar(double cantidad) {
        return velocidadActual -= cantidad;
    }

    // Convertir objeto a String (override es para evitar errores)
    @Override
    public String toString() {
        return "Marca: " + marca + " | Modelo: " + modelo + " | Velocidad actual: " + velocidadActual;
    }
}