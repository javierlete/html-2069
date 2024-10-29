package iparovo.modelos;

public class Restaurante {
	private Long id;
	private String nombre;
	private String tipo;
	private Double estrellas;
	private Integer minutosEntrega;
	private Double precioEntrega;
	private Double precioMinimo;
	private Integer descuento;
	
	public Restaurante(Long id, String nombre, String tipo, Double estrellas, Integer minutosEntrega, Double precioEntrega,
			Double precioMinimo, Integer descuento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.setTipo(tipo);
		this.estrellas = estrellas;
		this.minutosEntrega = minutosEntrega;
		this.precioEntrega = precioEntrega;
		this.precioMinimo = precioMinimo;
		this.descuento = descuento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(Double estrellas) {
		this.estrellas = estrellas;
	}

	public Integer getMinutosEntrega() {
		return minutosEntrega;
	}

	public void setMinutosEntrega(Integer minutosEntrega) {
		this.minutosEntrega = minutosEntrega;
	}

	public Double getPrecioEntrega() {
		return precioEntrega;
	}

	public void setPrecioEntrega(Double precioEntrega) {
		this.precioEntrega = precioEntrega;
	}

	public Double getPrecioMinimo() {
		return precioMinimo;
	}

	public void setPrecioMinimo(Double precioMinimo) {
		this.precioMinimo = precioMinimo;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "Restaurante [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", estrellas=" + estrellas
				+ ", minutosEntrega=" + minutosEntrega + ", precioEntrega=" + precioEntrega + ", precioMinimo="
				+ precioMinimo + ", descuento=" + descuento + "]";
	}

}
