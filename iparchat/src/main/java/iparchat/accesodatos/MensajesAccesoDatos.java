package iparchat.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import iparchat.modelos.Mensaje;

public class MensajesAccesoDatos {
	// Configuración
	private static final String URL = "jdbc:sqlite:C:\\Users\\curso.IPARTEKAULA\\git\\html-2069\\iparchat\\bdd\\iparchat.db";

	private static final String SQL_SELECT = "SELECT * FROM mensajes";
	private static final String SQL_INSERT = "INSERT INTO mensajes (emisor, texto, fecha_hora) VALUES ('%s', '%s', '%s')";

	// Cargar driver de JDBC
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha podido cargar el driver");
		}
	}

	public static final ArrayList<Mensaje> getMensajes() {
		var mensajes = new ArrayList<Mensaje>();

		try (Connection con = DriverManager.getConnection(URL);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			Mensaje mensaje = null;

			while (rs.next()) {
				mensaje = new Mensaje(null, rs.getString("emisor"), rs.getString("texto"),
						LocalDateTime.parse(rs.getString("fecha_hora")));

				mensajes.add(mensaje);
			}

			return mensajes;
		} catch (SQLException e) {
			System.out.println("Ha habido un error en la SELECT");
			System.out.println(SQL_SELECT);
			e.printStackTrace();
		}

		return null;
	}

	public static final void mandarMensaje(Mensaje mensaje) {
		try (Connection con = DriverManager.getConnection(URL); Statement st = con.createStatement()) {
			System.out.println(st.executeQuery(String.format(SQL_INSERT, mensaje.getEmisor(), mensaje.getTexto(),
					mensaje.getFechaHora().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))));
		} catch (SQLException e) {
			System.out.println("Ha habido un error en la INSERT");
			System.out.println(
					String.format(SQL_INSERT, mensaje.getEmisor(), mensaje.getTexto(), mensaje.getFechaHora()));
			e.printStackTrace();
		}
	}
}
