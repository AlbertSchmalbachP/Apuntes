package ejercicio8;

public class Guerrero implements Jugador {
    String nombre;
    int fuerza;
    String arma;
    public Guerrero(String nombre, int fuerza, String arma) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.arma = arma;
    }
    @Override
    public String mover() {
        return "El Guerrero " + nombre + " se mueve con fuerza " + fuerza + ".";
    }
    @Override
    public String atacar() {
        return "El Guerrero " + nombre + " ataca con su " + arma + ".";
    }
}
