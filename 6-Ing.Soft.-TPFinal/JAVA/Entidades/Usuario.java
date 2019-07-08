package Entidades;

public class Usuario {
	private String eMail;
	private String nombreUsuario;
	private String contrasena;

	public Usuario(String eMail, String nombreUsuario, String contrasena) {
		this.seteMail(eMail);
		this.setNombreUsuario(nombreUsuario);
		this.contrasena = contrasena;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}
