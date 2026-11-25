package es.curso.ad.t01;

import java.math.BigDecimal;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ClubDao clubes = new ClubDao();
        JugadorDao jugadores = new JugadorDao();
        Integer clubTemporal = null;
        Integer jugadorTemporal = null;
        try {
            System.out.println("R01.1 | Clubes de Granada: " + clubes.listarPorCiudad("Granada"));
            System.out.println("Ciudad inexistente: " + clubes.listarPorCiudad("Nyiregyhaza"));
            System.out.println("Ciudad con comilla: " + clubes.listarPorCiudad("L'Hospitalet de Llobregat"));

            System.out.println("R01.3 | Resumen por club:");
            clubes.resumenes().forEach(System.out::println);

            System.out.println("R01.4 | Borrar id inexistente: " +
                    clubes.borrarControlado(99999));
            System.out.println("Borrar club 1 (con jugadores): " +
                    clubes.borrarControlado(1));
            System.out.println("R01.5 | Aumentar id inexistente: " +
                    clubes.aumentarPresupuesto(99999, new BigDecimal("0.10")));
            try {
                clubes.aumentarPresupuesto(1, BigDecimal.ZERO);
            } catch (IllegalArgumentException e) {
                System.out.println("Cantidad inválida rechazada: " + e.getMessage());
            }

            // Valores efímeros. El borrado final permite repetir el programa.
            String nombre = "Prueba R01 " + System.nanoTime();
            clubTemporal = clubes.insertar(nombre, "Granada", new BigDecimal("10.50"));
            int idCreado = clubTemporal;
            System.out.println("Club vacío, resumen: " + clubes.resumenes().stream()
                    .filter(c -> c.id() == idCreado).findFirst().orElseThrow());
            System.out.println("Presupuesto incrementado: " +
                    clubes.aumentarPresupuesto(clubTemporal, new BigDecimal("0.25")));
            jugadorTemporal = jugadores.insertarJugador("Prueba R01", 1, clubTemporal);
            System.out.println("R01.2 | Jugador creado con ID: " + jugadorTemporal);
            try {
                jugadores.insertarJugador("Duplicado", 1, clubTemporal);
            } catch (SQLException e) {
                System.out.println("Dorsal duplicado rechazado, SQLState=" + e.getSQLState());
            }
            try {
                jugadores.insertarJugador("Sin club", 12, 99999);
            } catch (SQLException e) {
                System.out.println("Club inexistente rechazado, SQLState=" + e.getSQLState());
            }
            System.out.println("Club con jugador, no se borra: " +
                    clubes.borrarControlado(clubTemporal));
        } catch (SQLException e) {
            System.err.println("Error SQL [" + e.getSQLState() + "]: " + e.getMessage());
        } finally {
            try {
                if (jugadorTemporal != null) jugadores.borrarJugador(jugadorTemporal);
                if (clubTemporal != null)
                    System.out.println("Limpieza del club: " + clubes.borrarControlado(clubTemporal));
            } catch (SQLException e) {
                System.err.println("Limpieza incompleta: " + e.getMessage());
            }
        }
    }
}
