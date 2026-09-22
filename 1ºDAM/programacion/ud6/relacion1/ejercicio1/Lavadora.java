public class Lavadora extends Electrodomestico {
    double capacidadCarga;

    Lavadora(String marca, String modelo, double capacidadCarga) {
        super(marca, modelo);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String toString() {
        return "Lavadora de marca " + marca + " y modelo " + modelo + ", con capacidad de carga para " + capacidadCarga + " kilogramos.";
    }
}