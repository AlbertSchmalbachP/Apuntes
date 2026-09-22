package programacion.ud5.relacion2.ejercicio4;

public class Ejercicio4 {
    public static void main(String[] args) {
        Cancion tigers = new Cancion("Tigers", "Desconocido", 3.12);
        System.out.println(tigers);
        tigers.setArtista("Zebrahead");
        System.out.println(tigers);
        Playlist miPlaylist = new Playlist();
        System.out.println(miPlaylist.mostrarCanciones());
        miPlaylist.agregarCanciones(tigers);
        System.out.println(miPlaylist.mostrarCanciones());
        System.out.println(miPlaylist.mostrarDuracion());
    }
}
