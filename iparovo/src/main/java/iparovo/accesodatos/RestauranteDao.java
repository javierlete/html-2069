package iparovo.accesodatos;

import java.util.ArrayList;

import iparovo.modelos.Restaurante;

// Data Access Object

public class RestauranteDao {
	public static ArrayList<Restaurante> obtenerTodos() {
		var restaurantes = new ArrayList<Restaurante>();

		restaurantes.add(new Restaurante(1L, "IparBurger", "Americana", 4.0, 20, 1.23, 10.0, 5));
		restaurantes.add(new Restaurante(2L, "IparPizza", "Italiana", 3.3, 25, 1.24, 6.0, 0));
		restaurantes.add(new Restaurante(3L, "McIpartek", "Americana", 5.0, 30, 1.23, 10.0, 5));

		return restaurantes;
	}
}
