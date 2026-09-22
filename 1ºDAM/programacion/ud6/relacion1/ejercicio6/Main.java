package programacion.ud6.ejercicio6;

// Define una interfaz DispositivoInteligente con los métodos encender(), apagar() y conectarWiFi(). 
// Cada método debe devolver una cadena indicando la acción realizada.
// Luego, crea dos clases concretas: Smartphone y SmartTV. 
// Cada clase debe implementar la interfaz y proporcionar una implementación específica para cada método.
// Implementa una clase Main para probar la creación de objetos y la llamada a los métodos de la interfaz.
public class Main {
    public static void main(String[] args) {
        Smartphone vivo520 = new Smartphone();
        SmartTv sonyS55 = new SmartTv();
        vivo520.encender();
        vivo520.apagar();
        vivo520.conectarWiFi();
        sonyS55.encender();
        sonyS55.apagar();
        sonyS55.conectarWiFi();
    }
}