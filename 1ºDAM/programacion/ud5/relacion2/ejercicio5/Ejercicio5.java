package programacion.ud5.relacion2.ejercicio5;

public class Ejercicio5 {
    public static void main(String[] args) {
        Pelicula memento = new Pelicula("Memento", "Una persona pierde la memoria y busca culpables a la muerte de su mujer", "Chris Nolan", 122);
        System.out.println(memento);
        Cine cinePistacho = new Cine();
        System.out.println(cinePistacho.mostrarPeliculas());
        cinePistacho.agregarPelicula(memento);
        System.out.println(cinePistacho.mostrarPeliculas());
        System.out.println(cinePistacho.buscarPelicula("Memento"));
        System.out.println(cinePistacho.mostrarDuracionMedia());
        System.out.println(cinePistacho.mostrarPeliculas());
    }
}
