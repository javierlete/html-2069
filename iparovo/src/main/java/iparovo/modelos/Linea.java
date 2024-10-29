package iparovo.modelos;

public class Linea {
	private Long id;
	private Plato plato;
	private Integer cantidad;

	public Linea(Long id, Plato plato, Integer cantidad) {
		super();
		this.id = id;
		this.plato = plato;
		this.cantidad = cantidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getTotal() {
		return plato.getPrecio() * cantidad;
	}
	
	@Override
	public String toString() {
		return "Linea [id=" + id + ", plato=" + plato + ", cantidad=" + cantidad + "]";
	}

}
