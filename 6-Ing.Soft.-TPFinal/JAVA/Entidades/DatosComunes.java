package Entidades;

import java.util.Date;

public class DatosComunes {
	private String idUsuario;
	private String nombre;
	private Date fecha;
	private int puntaje;
	
	public DatosComunes(String idUsuario, String nombre, Date fecha, int puntaje) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.fecha = fecha;
		this.puntaje = puntaje;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
}
