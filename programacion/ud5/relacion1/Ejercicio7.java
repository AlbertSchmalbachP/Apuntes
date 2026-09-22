public class Ejercicio7 {
    public static void main(String[] args) {
        Lampara lampara1 = new Lampara(false);
        System.out.println(lampara1);
        lampara1.encender();
        System.out.println(lampara1);
        lampara1.apagar();
        System.out.println(lampara1);
    }
}
class Lampara {
    boolean estado;
    Lampara(boolean estado) {
        this.estado = estado;
    }
    void encender() {
        estado = true;
    }
    void apagar() {
        estado = false;
    }

    @Override
    public String toString() {
        if (estado == true) {
            return "Lampara encendida";
        } else {
            return "Lampara apagada";
        }
    }
}