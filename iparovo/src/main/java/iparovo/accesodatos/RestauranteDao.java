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
		
		for(int i = 0; i < 20; i++) {
			platos.add(new Plato((long)i, "Plato " + i, id * i * 1.0));
		}
		
		return platos;
	}
}
