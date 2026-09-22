public class Ejercicio3 {
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Fernando", "Programación", 5.9);
        System.out.println(alumno1);
    }
}

class Alumno {
    String nombre;
    String materia;
    double calificacion;
    Alumno(String nombre, String materia, double calificacion) {
        this.nombre = nombre;
        this.materia = materia;
        this.calificacion = calificacion;
    }
    boolean aprobo() {
        return calificacion >= 6;
    }

    // Convertir objeto a String (override es para evitar errores)
    @Override
    public String toString() {
        String mensajeAprobo = (this.aprobo()) ? "Está aprobado" : "Está suspenso";
        return "Nombre: " + this.nombre + " | Materia: " + this.materia + " | Calificación: " + this.calificacion + "\n" + mensajeAprobo;
    }
}