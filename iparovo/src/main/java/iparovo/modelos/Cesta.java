package iparovo.modelos;

import java.util.ArrayList;

public class Cesta {
	private static final Double COSTE_GESTION = 0.55;

	private Long id;
	private Usuario usuario;
	private Restaurante restaurante;
	private ArrayList<Linea> lineas = new ArrayList<Linea>();

	public Cesta(Long id, Usuario usuario, Restaurante restaurante) {
		super();
		this.id = id;
		this.setUsuario(usuario);
		this.restaurante = restaurante;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public ArrayList<Linea> getLineas() {
		return lineas;
	}

	public Double getSubTotal() {
		double total = 0.0;

		for (Linea linea : lineas) {
			total += linea.getTotal();
		}

		return total;
	}

	public Double getCosteGestion() {
		return COSTE_GESTION;
	}

	public Double getGastosEnvio() {
		return restaurante.getPrecioEntrega();
	}

	public Double getTotal() {
		return getSubTotal() + restaurante.getPrecioEntrega() + getCosteGestion();
	}

	@Override
	public String toString() {
		return "Cesta [id=" + id + ", usuario=" + usuario + ", restaurante=" + restaurante + ", lineas=" + lineas + "]";
	}
}
