package iparchat.modelos;

import java.time.LocalDate;
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

	public String getFechaHoraFormateado() {
		LocalDate diaMensaje = fechaHora.toLocalDate();
		LocalDate hoy = LocalDate.now();
		
		if(diaMensaje.equals(hoy)) {
			return String.format("%1$tH:%1$tM", fechaHora);
		} else {
			return String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM", fechaHora);
		}
	}
	
	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", emisor=" + emisor + ", mensaje=" + mensaje + ", fechaHora=" + fechaHora + "]";
	}

}
