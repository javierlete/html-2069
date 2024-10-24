package tienda.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tienda.modelos.Producto;

public class ProductosAccesoDatos {
	private final static String url = "jdbc:sqlite:C:\\Users\\curso.IPARTEKAULA\\git\\html-2069\\ejemploweb\\bdd\\ejemplo.db";

	private final static String sqlSelect = "SELECT * FROM productos";
	private final static String sqlSelectId = sqlSelect + " WHERE id=";
	private final static String sqlInsertFormato = "INSERT INTO productos (nombre, precio) VALUES ('%s', %s)";
	private final static String sqlUpdateFormato = "UPDATE productos SET nombre='%s', precio=%s WHERE id=%s";
	private final static String sqlDelete = "DELETE FROM productos WHERE id=";
	
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver de SQLite");
		}
	}
	
	public static ArrayList<Producto> listadoProductos() {
		try (Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlSelect)) {
			ArrayList<Producto> productos = new ArrayList<Producto>();
			
			Producto producto;
			
			while(rs.next()) {
				producto = new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getDouble("precio"));
				productos.add(producto);
			}
			
			return productos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Producto buscarProducto(Long id) {
		try (Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlSelectId + id)) {
			if(rs.next()) {
				return new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getDouble("precio"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void agregarProducto(Producto producto) {
		try (Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement()) {
			String sqlInsert = String.format(sqlInsertFormato, producto.getNombre(), producto.getPrecio());
			
			System.out.println(sqlInsert);
			
			st.executeUpdate(sqlInsert);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void modificarProducto(Producto producto) {
		try (Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement()) {
			String sqlUpdate = String.format(sqlUpdateFormato, producto.getNombre(), producto.getPrecio(), producto.getId());
			
			System.out.println(sqlUpdate);
			
			st.executeUpdate(sqlUpdate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void borrarProducto(Long id) {
		try (Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement()) {
			st.executeUpdate(sqlDelete + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
