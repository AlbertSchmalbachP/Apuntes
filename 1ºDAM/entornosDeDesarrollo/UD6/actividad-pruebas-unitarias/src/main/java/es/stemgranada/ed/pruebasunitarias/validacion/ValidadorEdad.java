package es.stemgranada.ed.pruebasunitarias.validacion;

public class ValidadorEdad {

    public boolean esMayorDeEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        return edad >= 18;
    }

    public String clasificarEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("Edad inválida");
        }

        if (edad < 18) {
            return "menor";
        } else if (edad <= 65) {
            return "adulto";
        } else {
            return "mayor senior";
        }
    }
}
