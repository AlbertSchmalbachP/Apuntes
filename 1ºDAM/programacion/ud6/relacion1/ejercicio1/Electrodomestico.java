public class Electrodomestico {
    String marca;
    String modelo;

    Electrodomestico(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    
    @Override
    public String toString() {
        return "Electrodoméstico de marca " + marca + " y modelo " + modelo + ".";
    }
}