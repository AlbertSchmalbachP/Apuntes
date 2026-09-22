package programacion.ud5.relacion2.ejercicio1;
public class Estudiante {
    private String nombre;
    private int edad;
    private String numeroMatricula;
    Estudiante(String nombre, int edad, String numeroMatricula) {
        this.nombre = nombre;
        this.edad = edad;
        this.numeroMatricula = numeroMatricula;
    }

    // getter/setter para el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    // getter/setter para la edad
    public void setEdad(int edad) {
        if (edad >= 17) {
            this.edad = edad; 
        }
    }
    public int getEdad() {
        return edad;
    }
    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    // metodo para el output
    @Override
    public String toString() {
        return nombre + " | " + edad + " años | " + numeroMatricula;
    }
}
