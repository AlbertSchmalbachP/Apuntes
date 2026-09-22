package ejercicio8;

public class Arquero implements Jugador {
    String nombre;
    String agilidad;
    String arco;
    public Arquero(String nombre, String agilidad, String arco) {
        this.nombre = nombre;
        this.agilidad = agilidad;
        this.arco = arco;
    }
    @Override
    public String mover() {
        return "El Arquero " + nombre + " se mueve ágilmente con agilidad " + agilidad + ".";
    }
    @Override
    public String atacar() {
        return "El Arquero " + nombre + " dispara una flecha con su " + arco + ".";
    }
}