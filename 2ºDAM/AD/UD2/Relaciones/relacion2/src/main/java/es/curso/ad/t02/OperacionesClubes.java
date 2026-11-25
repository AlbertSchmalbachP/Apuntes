package es.curso.ad.t02;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class OperacionesClubes {
    public void transferir(int origenId, int destinoId,
            BigDecimal importe) throws SQLException {
        if (origenId == destinoId || importe == null ||
                importe.signum() <= 0) {
            throw new IllegalArgumentException("Transferencia no válida");
        }

        try (Connection conexion = Conexion.abrir()) {
            conexion.setAutoCommit(false);
            try {
                String descuento = "UPDATE club SET presupuesto = presupuesto - ? " +
                        "WHERE id = ? AND presupuesto >= ?";
                try (PreparedStatement sentencia = conexion.prepareStatement(descuento)) {
                    sentencia.setBigDecimal(1, importe);
                    sentencia.setInt(2, origenId);
                    sentencia.setBigDecimal(3, importe);
                    if (sentencia.executeUpdate() != 1) {
                        throw new SQLException("Origen inexistente o saldo insuficiente");
                    }
                }

                String abono = "UPDATE club SET presupuesto = presupuesto + ? WHERE id = ?";
                try (PreparedStatement sentencia = conexion.prepareStatement(abono)) {
                    sentencia.setBigDecimal(1, importe);
                    sentencia.setInt(2, destinoId);
                    if (sentencia.executeUpdate() != 1) {
                        throw new SQLException("El club destino no existe");
                    }
                }

                String registrar = "INSERT INTO movimiento(" +
                        "club_origen_id, club_destino_id, importe) VALUES (?, ?, ?)";
                try (PreparedStatement sentencia = conexion.prepareStatement(registrar)) {
                    sentencia.setInt(1, origenId);
                    sentencia.setInt(2, destinoId);
                    sentencia.setBigDecimal(3, importe);
                    sentencia.executeUpdate();
                }
                conexion.commit();
            } catch (SQLException | RuntimeException e) {
                try {
                    conexion.rollback();
                } catch (SQLException errorRollback) {
                    e.addSuppressed(errorRollback);
                }
                throw e;
            }
        }
    }

    public int contarJugadores(int clubId) throws SQLException {
        try (Connection conexion = Conexion.abrir();
                CallableStatement sentencia = conexion.prepareCall(
                        "{call contar_jugadores(?, ?)}")) {
            sentencia.setInt(1, clubId);
            sentencia.registerOutParameter(2, Types.INTEGER);
            sentencia.execute();
            return sentencia.getInt(2);
        }
    }

    public BigDecimal obtenerPresupuesto(int clubId) throws SQLException {
        try (Connection conexion = Conexion.abrir();
                PreparedStatement sentencia = conexion.prepareStatement(
                        "SELECT presupuesto FROM club WHERE id = ?")) {
            sentencia.setInt(1, clubId);
            try (ResultSet filas = sentencia.executeQuery()) {
                if (filas.next())
                    return filas.getBigDecimal(1);
                throw new SQLException("No existe el club " + clubId);
            }
        }
    }

    public boolean deshacerUltimoMovimiento(long idMovimiento) throws SQLException {
        try (Connection con = Conexion.abrir()) {
            con.setAutoCommit(false);
            try {
                long ultimoId;
                int origen, destino;
                BigDecimal importe;
                try (PreparedStatement st = con.prepareStatement(
                        "SELECT id, club_origen_id, club_destino_id, importe " +
                                "FROM movimiento ORDER BY id DESC LIMIT 1 FOR UPDATE");
                        ResultSet rs = st.executeQuery()) {
                    if (!rs.next()) {
                        con.rollback();
                        return false;
                    }
                    origen = rs.getInt("club_origen_id");
                    destino = rs.getInt("club_destino_id");
                    importe = rs.getBigDecimal("importe");
                }


                // La devolución falla si el destino ya no tiene suficiente saldo.
                try (PreparedStatement st = con.prepareStatement(
                        "UPDATE club SET presupuesto = presupuesto - ? " +
                                "WHERE id = ? AND presupuesto >= ?")) {
                    st.setBigDecimal(1, importe);
                    st.setInt(2, destino);
                    st.setBigDecimal(3, importe);
                    if (st.executeUpdate() != 1)
                        throw new SQLException("No existe destino o no puede devolver el importe");
                }
                try (PreparedStatement st = con.prepareStatement(
                        "UPDATE club SET presupuesto = presupuesto + ? WHERE id = ?")) {
                    st.setBigDecimal(1, importe);
                    st.setInt(2, origen);
                    if (st.executeUpdate() != 1)
                        throw new SQLException("No existe club de origen");
                }
                try (PreparedStatement st = con.prepareStatement(
                        "DELETE FROM movimiento WHERE id = ?")) {
                    st.setLong(1, idMovimiento);
                    if (st.executeUpdate() != 1)
                        throw new SQLException("Movimiento no encontrado al eliminar");
                }
                con.commit();
                return true;
            } catch (SQLException | RuntimeException e) {
                try {
                    con.rollback();
                } catch (SQLException error) {
                    e.addSuppressed(error);
                }
                throw e;
            }
        }
    }

}
