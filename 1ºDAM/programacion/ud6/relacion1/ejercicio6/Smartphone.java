package programacion.ud6.ejercicio6;

public class Smartphone implements DispositivoInteligente {
    @Override
    public void encender() {
        System.out.println("El smartphone se ha encendido.");
    }
    @Override
    public void apagar() {
        System.out.println("El smartphone se ha apagado.");
    }
    @Override
    public void conectarWiFi() {
        System.out.println("El smartphone se ha conectado a la WiFi");
    }
}
