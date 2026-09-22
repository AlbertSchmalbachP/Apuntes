public class Ejercicio8 {
    public static void main(String[] args) {
        Televisor televisor1 = new Televisor("Canal Sur", 26);
        System.out.println(televisor1);
        televisor1.subirVolumen();
        televisor1.bajarVolumen();
        televisor1.subirVolumen();
        televisor1.subirVolumen();
        televisor1.cambiarcanal("La Sexta");
        System.out.println(televisor1);
    }
}
class Televisor {
    String canalActual;
    int volumen;
    Televisor(String canalActual, int volumen) {
        this.canalActual = canalActual;
        this.volumen = volumen;
    }
    void subirVolumen() {
        volumen += 1;
    }
    void bajarVolumen() {
        volumen -= 1;
    }
    void cambiarcanal(String nuevoCanal) {
        canalActual = nuevoCanal;
    }

    @Override
    public String toString() {
        return "Canal actual: " + canalActual + " | Volumen: " + volumen;
    }
}