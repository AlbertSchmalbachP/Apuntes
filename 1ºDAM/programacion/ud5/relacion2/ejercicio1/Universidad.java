package programacion.ud5.relacion2.ejercicio1;
import java.util.ArrayList;
public class Universidad {
    ArrayList<Estudiante> alumnado;
    Universidad() {
        this.alumnado = new ArrayList<>();
    }
    // metodos
    public void agregarEstudiante(Estudiante estudiante) {
        this.alumnado.add(estudiante);
    }
    public String mostrarEstudiantes() {
        String lista = "";
        for (Estudiante estudiante : alumnado) { // forma de escribir for...of en Java
            lista += " | " + estudiante.getNombre();
        }
        return lista;
    }
    public String mostrarEstudiantesCompletos() {
        String lista = "";
        for (Estudiante estudiante : alumnado) {
            lista += estudiante + "\n";
        }
        return lista;
    }
    //Devuelve el estudiante si lo encuentra, null en otro caso
    public Estudiante buscarEstudiante(String numeroMatricula) {
        Estudiante estudianteEncontrado = null;
        for (Estudiante estudiante : alumnado) {
            if(estudiante.getNumeroMatricula().equals(numeroMatricula)){
                estudianteEncontrado = estudiante;
            }
        }
        return estudianteEncontrado;
    }
}
