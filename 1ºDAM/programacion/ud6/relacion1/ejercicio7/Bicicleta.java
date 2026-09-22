package programacion.ud6.ejercicio7;

public class Bicicleta implements Transporte {
    @Override
    public String arrancar() {
        return "El bicicleta arranca.";
    }
    @Override
    public String detener() {
        return "El bicicleta se detiene.";
    }
}
