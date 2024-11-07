package iparovo.accesodatos;

import static iparovo.accesodatos.Globales.pass;
import static iparovo.accesodatos.Globales.url;
import static iparovo.accesodatos.Globales.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import iparovo.modelos.Cesta;
import iparovo.modelos.Restaurante;
import iparovo.modelos.Usuario;

public class UsuarioDao {
	private static final String sqlSelectEmail = "SELECT * FROM usuarios WHERE email='%s'";
	private static final String sqlInsert = "INSERT INTO usuarios (nombre, email, password, rol) VALUES ('%s', '%s', '%s', '%s')";
	private static final String sqlSelectPedidos = """
			SELECT p.id, r.nombre, p.fecha 
			FROM pedidos p
			JOIN restaurantes r ON p.restaurante_id = r.id
			WHERE usuario_id = %s
			ORDER BY fecha DESC
			""";
	
	public static void insertar(Usuario usuario) {
		String sql = String.format(sqlInsert, usuario.getNombre(), usuario.getEmail(), usuario.getPassword(), usuario.getRol());

		try (Connection con = DriverManager.getConnection(url, user, pass);
				Statement st = con.createStatement()) {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido realizar la consulta", e);
		}
	}

	public static Usuario buscarPorEmail(String email) {
		String sql = String.format(sqlSelectEmail, email);

		try (Connection con = DriverManager.getConnection(url, user, pass);
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

	public static ArrayList<Cesta> buscarPedidosPorIdUsuario(Long id) {
		var pedidos = new ArrayList<Cesta>();
		
		String sql = String.format(sqlSelectPedidos, id);

		try (Connection con = DriverManager.getConnection(url, user, pass);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			
			Cesta pedido;
			Restaurante restaurante;
			
			while(rs.next()) {
				restaurante = new Restaurante(null, rs.getString("nombre"), null, null, null, null, null, null);
				
				String sFecha = rs.getString("fecha");
				String[] partes = sFecha.split(" ");
				
				if(partes.length == 1) {
					partes = sFecha.split("T");
				}
				
				LocalDate fecha = LocalDate.parse(partes[0]);
				LocalTime hora = LocalTime.parse(partes[1]);
				
				LocalDateTime fechaHora = LocalDateTime.of(fecha, hora);
				
				pedido = new Cesta(rs.getLong("id"), null, restaurante, fechaHora);

				pedidos.add(pedido);
			}
			
			return pedidos;
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido realizar la consulta", e);
		}
	}

}
