package ejercicio8;

public class Mago implements Jugador {
    String nombre;
    int mana;
    String hechizo;
    public Mago(String nombre, int mana, String hechizo) {
        this.nombre = nombre;
        this.mana = mana;
        this.hechizo = hechizo;
    }
    @Override
    public String mover() {
        return "El Mago " + nombre + " se desplaza utilizando su mana " + mana + ".";
    }
    @Override
    public String atacar() {
        return "El Mago " + nombre + " lanza un hechizo " + hechizo + ".";
    }
}
