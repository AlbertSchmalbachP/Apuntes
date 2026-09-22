package programacion.ud5.relacion2.ejercicio2;

public class Ejercicio2 {
    public static void main(String[] args) {
        int opcion = -1;
        // todo: implementar menú

        Biblioteca biblioteca = new Biblioteca();
        Libro libro1 = new Libro("001", "Nada", "Carmen Laforet", "Nada es una novela de llegada en la que su protagonista, Andrea, se presenta en un mundo que no solo no es el suyo, sino que la va defraudando progresivamente.", true);
        biblioteca.agregarLibro(libro1);
        System.out.println(libro1);
        biblioteca.prestarLibro("Nada");
        System.out.println(libro1);
        biblioteca.devolverLibro("Nada");
        System.out.println(libro1);
    }
}
