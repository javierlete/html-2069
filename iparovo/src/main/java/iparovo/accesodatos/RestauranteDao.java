package iparovo.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import iparovo.modelos.Cesta;
import iparovo.modelos.Linea;
import iparovo.modelos.Plato;
import iparovo.modelos.Restaurante;

// Data Access Object

public class RestauranteDao {
	private static final String url = "jdbc:sqlite:C:\\Users\\curso.IPARTEKAULA\\git\\html-2069\\iparovo\\bdd\\iparovo.db";

	private static final String sqlSelect = "SELECT * FROM restaurantes";
	private static final String sqlSelectId = sqlSelect + " WHERE id=";
	private static final String sqlSelectIdPlatos = "SELECT * FROM platos WHERE restaurante_id=";

	private static final String sqlSelectPlatoPorId = "SELECT * FROM platos WHERE id=";
	
	private static final String sqlSelectTipos = "SELECT DISTINCT tipo FROM restaurantes";
	private static final String sqlSelectPorTipos = "SELECT * FROM restaurantes WHERE tipo='%s'";

	private static final String sqlSelectPorTexto = "SELECT * FROM restaurantes WHERE nombre LIKE '%%%s%%'";

	private static final String sqlInsertPedido = "INSERT INTO pedidos (fecha, restaurante_id) VALUES ('%s', %s)";
	private static final String sqlInsertLinea = "INSERT INTO lineas (pedido_id, plato_id, cantidad) VALUES (%s, %s, %s)";

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("No se ha encontrado el driver", e);
		}
	}

	public static ArrayList<Restaurante> obtenerTodos() {
		var restaurantes = new ArrayList<Restaurante>();

		try (Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlSelect)) {
			Restaurante restaurante;

			while (rs.next()) {
				restaurante = new Restaurante(rs.getLong("id"), rs.getString("nombre"), rs.getString("tipo"),
						rs.getDouble("estrellas"), rs.getInt("minutos_entrega"), rs.getDouble("precio_entrega"),
						rs.getDouble("precio_minimo"), rs.getInt("descuento"));
				
				restaurantes.add(restaurante);
			}

			return restaurantes;
		} catch (SQLException e) {
			throw new RuntimeException("Ha habido un error en la consulta", e);
		}
	}
	
	public static ArrayList<Restaurante> obtenerPorTipo(String tipo) {
		var restaurantes = new ArrayList<Restaurante>();

		try (Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(String.format(sqlSelectPorTipos, tipo))) {
			Restaurante restaurante;

			while (rs.next()) {
				restaurante = new Restaurante(rs.getLong("id"), rs.getString("nombre"), rs.getString("tipo"),
						rs.getDouble("estrellas"), rs.getInt("minutos_entrega"), rs.getDouble("precio_entrega"),
						rs.getDouble("precio_minimo"), rs.getInt("descuento"));
				
				restaurantes.add(restaurante);
			}

			return restaurantes;
		} catch (SQLException e) {
			throw new RuntimeException("Ha habido un error en la consulta", e);
		}
	}
	
	public static Restaurante obtenerPorId(Long id) {
		try (Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlSelectId + id)) {
			Restaurante restaurante = null;

			if (rs.next()) {
				restaurante = new Restaurante(rs.getLong("id"), rs.getString("nombre"), rs.getString("tipo"),
						rs.getDouble("estrellas"), rs.getInt("minutos_entrega"), rs.getDouble("precio_entrega"),
						rs.getDouble("precio_minimo"), rs.getInt("descuento"));
			}
			
			return restaurante;
		} catch (SQLException e) {
			throw new RuntimeException("Ha habido un error en la consulta", e);
		}
	}
	
	public static ArrayList<Plato> obtenerPlatosPorIdRestaurante(Long id) {
		var platos = new ArrayList<Plato>();
		
		try (Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlSelectIdPlatos + id)) {
			Plato plato;

			while (rs.next()) {
				plato = new Plato(rs.getLong("id"), rs.getString("nombre"), rs.getDouble("precio"));
				
				platos.add(plato);
			}

			return platos;
		} catch (SQLException e) {
			throw new RuntimeException("Ha habido un error en la consulta", e);
		}
	}

	public static Plato obtenerPlatoPorId(Long id) {
		try (Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlSelectPlatoPorId + id)) {
			Plato plato = null;

			if (rs.next()) {
				plato = new Plato(rs.getLong("id"), rs.getString("nombre"), rs.getDouble("precio"));
			}

			return plato;
		} catch (SQLException e) {
			throw new RuntimeException("Ha habido un error en la consulta", e);
		}
	}
	
	public static ArrayList<String> obtenerTipos() {
		var tipos = new ArrayList<String>();

		try (Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlSelectTipos)) {
			while (rs.next()) {
				tipos.add(rs.getString(1));
			}

			return tipos;
		} catch (SQLException e) {
			throw new RuntimeException("Ha habido un error en la consulta", e);
		}
	}

	public static ArrayList<Restaurante> obtenerPorTexto(String busqueda) {
		var restaurantes = new ArrayList<Restaurante>();

		try (Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(String.format(sqlSelectPorTexto, busqueda))) {
			Restaurante restaurante;

			while (rs.next()) {
				restaurante = new Restaurante(rs.getLong("id"), rs.getString("nombre"), rs.getString("tipo"),
						rs.getDouble("estrellas"), rs.getInt("minutos_entrega"), rs.getDouble("precio_entrega"),
						rs.getDouble("precio_minimo"), rs.getInt("descuento"));
				
				restaurantes.add(restaurante);
			}

			return restaurantes;
		} catch (SQLException e) {
			throw new RuntimeException("Ha habido un error en la consulta", e);
		}
	}
	
	public static void insertarPedido(Cesta cesta) {
		try (Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement()) {
			String sql = String.format(sqlInsertPedido, LocalDateTime.now(), cesta.getRestaurante().getId());
			
			st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			
			ResultSet rs = st.getGeneratedKeys();
			rs.next();
			
			Long id = rs.getLong(1);
			
			for(Linea linea: cesta.getLineas()) {
				sql = String.format(sqlInsertLinea, id, linea.getPlato().getId(), linea.getCantidad());
				st.executeUpdate(sql);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Ha habido un error en la consulta", e);
		}
	}
	
}
