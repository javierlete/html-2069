package iparovo.accesodatos;

class Globales {
	static final String url;
	static final String user;
	static final String pass;
	
	static {
		url = "jdbc:sqlite:C:\\Users\\curso.IPARTEKAULA\\git\\html-2069\\iparovo\\bdd\\iparovo.db";
		//url = "jdbc:mysql://localhost:3306/iparovo";
		user = "root";
		pass = "1234";

		try {
			Class.forName("org.sqlite.JDBC");
			//Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("No se ha encontrado el driver", e);
		}
	}
}
