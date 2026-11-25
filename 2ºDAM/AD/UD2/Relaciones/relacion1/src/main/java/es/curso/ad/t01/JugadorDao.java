package es.curso.ad.t01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JugadorDao {
    //* EJERCICIO 2
    public int insertarJugador(String nombre, int dorsal, int clubId) throws SQLException {
        String sqlClub = "SELECT id FROM club WHERE id = ?";
        String sqlDorsal = "SELECT id FROM jugador WHERE club_id = ? AND dorsal = ?";
        String sqlInsertar = "INSERT INTO jugador (nombre, dorsal, club_id) VALUES (?, ?, ?)";
        try (Connection conexion = Conexion.abrir()) {
            //* Comprobaciones */
            // 1. Comprobar que el club existe
            try (PreparedStatement sentencia = conexion.prepareStatement(sqlClub)) {
                sentencia.setInt(1, clubId);
                try (ResultSet filas = sentencia.executeQuery()) {
                    if (!filas.next()) {
                        throw new SQLException("El club no existe.");
                    }
                }
            }
            // 2. Comprobar que el dorsal no está usado repetido (en el club)
            try (PreparedStatement sentencia = conexion.prepareStatement(sqlDorsal)) {
                sentencia.setInt(1, clubId);
                sentencia.setInt(2, dorsal);
                try (ResultSet filas = sentencia.executeQuery()) {
                    if (filas.next()) {
                        throw new SQLException("El dorsal " + dorsal + " ya existe en el club.");
                    }
                }
            }
            // 3. Insertar y recuperar el ID generado
            try (PreparedStatement sentencia = conexion.prepareStatement(sqlInsertar, Statement.RETURN_GENERATED_KEYS)) {
                sentencia.setString(1, nombre);
                sentencia.setInt(2, dorsal);
                sentencia.setInt(3, clubId);
                sentencia.executeUpdate();
                try (ResultSet claves = sentencia.getGeneratedKeys()) {
                    if (claves.next()) {
                        return claves.getInt(1);
                    }
                }
            }
        }
        throw new SQLException("No se pudo obtener el ID generado");
    }

    public boolean borrarJugador(int id) throws SQLException {
        try (Connection con = Conexion.abrir();
            PreparedStatement st = con.prepareStatement("DELETE FROM jugador WHERE id = ?")) {
            st.setInt(1, id);
            return st.executeUpdate() == 1;
        }
    }
}
