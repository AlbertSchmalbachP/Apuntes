package programacion.ud6.ejercicio6;

public class SmartTv implements DispositivoInteligente {
    @Override
    public void encender() {
        System.out.println("La Smart TV se ha encendido.");
    }
    @Override
    public void apagar() {
        System.out.println("La Smart TV se ha apagado.");
    }
    @Override
    public void conectarWiFi() {
        System.out.println("La Smart TV se ha conectado a la WiFi");
    }
}
