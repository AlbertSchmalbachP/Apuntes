package programacion.ud6.ejercicio7;

public class Metro implements Transporte {
    int numVagones;
    Metro(int numVagones) {
        this.numVagones = numVagones;
    }
    @Override
    public String arrancar() {
        return "El metro arranca con " + numVagones + " vagones.";
    }
    @Override
    public String detener() {
        return "El metro se detiene.";
    }
}
