package iparchat.modelos;

import java.time.LocalDateTime;

public class Mensaje {
	private Long id;
	private String emisor;
	private String mensaje;
	private LocalDateTime fechaHora;

	public Mensaje(Long id, String emisor, String mensaje, LocalDateTime fechaHora) {
		super();
		this.id = id;
		this.emisor = emisor;
		this.mensaje = mensaje;
		this.fechaHora = fechaHora;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", emisor=" + emisor + ", mensaje=" + mensaje + ", fechaHora=" + fechaHora + "]";
	}

}
