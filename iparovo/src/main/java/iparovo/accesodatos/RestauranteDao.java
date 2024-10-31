package iparovo.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	
}
