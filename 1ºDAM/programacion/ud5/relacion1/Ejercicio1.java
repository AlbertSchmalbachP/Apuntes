public class Ejercicio1 {

    public static void main(String[] args) {
        Circulo circulo1 = new Circulo(5);
        Circulo circulo2 = new Circulo(1);

        System.out.println("Círculo de radio " + circulo1.radio + " Area: " + circulo1.calcularArea() + " Perímetro: "
                + circulo1.calcularPerimetro());
        System.out.println("Círculo de radio " + circulo2.radio + " Area: " + circulo2.calcularArea() + " Perímetro: "
                + circulo2.calcularPerimetro());
    }
}

class Circulo {

    final double PI = 3.1415;
    double radio;

    Circulo(double radio) {
        this.radio = radio;
    }

    double calcularArea() {
        return PI * this.radio * this.radio;
    }

    double calcularPerimetro() {
        return 2 * PI * this.radio;
    }

}
