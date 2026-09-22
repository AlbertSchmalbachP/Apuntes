public class Televisor extends Electrodomestico {
    double tamañoPantalla;

    Televisor(String marca, String modelo, double tamañoPantalla) {
        super(marca, modelo);
        this.tamañoPantalla = tamañoPantalla;
    }

    @Override
    public String toString() {
        return "Televisor de marca " + marca + " y modelo " + modelo + ", con pantalla de " + tamañoPantalla + " pulgadas de tamaño.";
    }
}