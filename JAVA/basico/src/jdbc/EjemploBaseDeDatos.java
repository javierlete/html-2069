package jdbc;

import java.sql.*;

public class EjemploBaseDeDatos {
	public static void main(String[] args) throws SQLException {
//		String url = "jdbc:mysql://basededatos.com:3306/basededatos";
//		String user = "root";
//		String pass = "";

		String url = "jdbc:sqlite:bdd/ejemplo.db";

		String sql = "SELECT * FROM productos";

		Connection con = DriverManager.getConnection(url);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			System.out.println(String.format("%3s %-15s %10s", rs.getString("id"), rs.getString("nombre"),
					rs.getString("precio")));
		}
	}
}
