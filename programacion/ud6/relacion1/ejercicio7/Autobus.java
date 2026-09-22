package programacion.ud6.ejercicio7;

public class Autobus implements Transporte {
    String horaInicio;
    String horaFin;
    public Autobus(String horaInicio, String horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    @Override
    public String arrancar() {
        return "El autobus arranca a las " + horaInicio + ".";
    }
    @Override
    public String detener() {
        return "El autobus se detiene a las " + horaFin + ".";
    }
}
