package es.curso.ad.t01;

import java.math.BigDecimal;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ClubDao dao = new ClubDao();
        try {
            System.out.println("CLUBES INICIALES");
            for (Club club : dao.listar()) {
                System.out.println(club);
            }

            String nombreTemporal = "Club de prueba JDBC";
            int id = dao.insertar(nombreTemporal, "Granada", new BigDecimal("120.50"));
            System.out.println("Creado con ID " + id);
            System.out.println("Buscado: " + dao.buscar(id).orElseThrow());
            System.out.println("Actualizado: " + dao.cambiarCiudad(id, "Jaén"));
            System.out.println("Tras cambiar: " + dao.buscar(id).orElseThrow());
            System.out.println("Borrado: " + dao.borrar(id));
            System.out.println("¿Sigue existiendo? " + dao.buscar(id).isPresent());
            System.out.println("EJERCICIOS RELACION 1");
            // ej1
            System.out.println("Clubes de Granada: " + dao.listarPorCiudad("Granada"));
            System.out.println("Clubes de Málaga: " + dao.listarPorCiudad("Malaga")); //! No funciona como se esperaba. Resultado real: []
            System.out.println("Clubes de Barcelona: " + dao.listarPorCiudad("Barcelona"));
            // ej2
            try {
                System.out.println("Jugador válido: " +
                    dao.insertarJugador("Leo Pessi", 10, 2));
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
            try {
                System.out.println("Jugador en club no existente: " + dao.insertarJugador("Cristiano Penaldo", 15, 8));
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
            try {
                System.out.println("Jugador con dorsal repetido: " + dao.insertarJugador("Sofía Bergona", 10, 2));
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
            // ej3
            
        } catch (SQLException e) {
            System.err.println("Error de base de datos: " + e.getMessage());
        }
    }
}
