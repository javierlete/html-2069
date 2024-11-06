package iparovo.accesodatos;

import static iparovo.accesodatos.Globales.url;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import iparovo.modelos.Cesta;
import iparovo.modelos.Restaurante;
import iparovo.modelos.Usuario;

public class AdminDao {
	private static final String sqlSelectPedidos = """
			SELECT p.id AS p_id, p.fecha AS p_fecha, 
			    r.id AS r_id, r.nombre AS r_nombre, 
			    u.id AS u_id, u.nombre AS u_nombre
			FROM pedidos p
			JOIN restaurantes r ON p.restaurante_id = r.id
			JOIN usuarios u ON p.usuario_id = u.id
			ORDER BY fecha DESC;
			""";
	
	public static ArrayList<Cesta> getPedidos() {
		var pedidos = new ArrayList<Cesta>();
		
		String sql = String.format(sqlSelectPedidos);

		try (Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			
			Cesta pedido;
			Restaurante restaurante;
			Usuario usuario;
			
			while(rs.next()) {
				usuario = new Usuario(rs.getLong("u_id"), rs.getString("u_nombre"), null, null, null);
				restaurante = new Restaurante(rs.getLong("r_id"), rs.getString("r_nombre"), null, null, null, null, null, null);
				pedido = new Cesta(rs.getLong("p_id"), usuario, restaurante, LocalDateTime.parse(rs.getString("p_fecha")));

				pedidos.add(pedido);
			}
			
			return pedidos;
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido realizar la consulta", e);
		}
	}

}
