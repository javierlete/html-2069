package iparovo.accesodatos;

class Globales {
	static final String url;
	static final String user;
	static final String pass;
	
	static {
		url = "jdbc:mysql://localhost:3306/iparovo";
		user = "root";
		pass = "1234";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("No se ha encontrado el driver", e);
		}
	}
}
