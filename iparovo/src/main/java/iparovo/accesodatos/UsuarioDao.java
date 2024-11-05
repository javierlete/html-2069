package iparovo.accesodatos;

import static iparovo.accesodatos.Globales.url;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import iparovo.modelos.Usuario;

public class UsuarioDao {
	private static final String sqlSelectEmail = "SELECT * FROM usuarios WHERE email='%s'";
	private static final String sqlInsert = "INSERT INTO usuarios (nombre, email, password, rol) VALUES ('%s', '%s', '%s', '%s')";
	
	public static void insertar(Usuario usuario) {
		String sql = String.format(sqlInsert, usuario.getNombre(), usuario.getEmail(), usuario.getPassword(), usuario.getRol());

		try (Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement()) {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido realizar la consulta", e);
		}
	}

	public static Usuario buscarPorEmail(String email) {
		String sql = String.format(sqlSelectEmail, email);

		try (Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			if(rs.next()) {
				return new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getString("email"), rs.getString("password"), rs.getString("rol"));
			}
			
			return null;
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido realizar la consulta", e);
		}
	}

}
