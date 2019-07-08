package Entidades;

public class Mensaje {
	private String eMailEmisor;
	private String eMailReceptor;
	private String mensaje;
	
	

	public Mensaje(String eMailEmisor, String eMailReceptor, String mensaje) {
		super();
		this.eMailEmisor = eMailEmisor;
		this.eMailReceptor = eMailReceptor;
		this.mensaje = mensaje;
	}
	public String geteMailEmisor() {
		return eMailEmisor;
	}
	public void seteMailEmisor(String eMailEmisor) {
		this.eMailEmisor = eMailEmisor;
	}
	public String geteMailReceptor() {
		return eMailReceptor;
	}
	public void seteMailReceptor(String eMailReceptor) {
		this.eMailReceptor = eMailReceptor;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}	
}
