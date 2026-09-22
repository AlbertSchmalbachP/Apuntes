public class Ejercicio5 {
    public static void main(String[] args) {
        Termometro termometro1 = new Termometro(13.0);
        termometro1.convertirAFarenheit();
        System.out.println(termometro1);
    }
}
class Termometro {
    double temperatura;
    Termometro(double temperatura) {
        this.temperatura = temperatura;
    }
    double convertirAFarenheit() {
        return temperatura = temperatura * 1.8 + 32;
    }

    @Override
    public String toString() {
        return "Temperatura en Farenheit: " + String.format("%.1f", temperatura);
    }
}