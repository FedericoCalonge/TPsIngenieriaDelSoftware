package com.company;

public class Maquinista {
	
	private String idConductor;
	private String nombre;
	private String apellido;
	
	public Maquinista(String idConductor, String nombre, String apellido) {
		super();
		this.idConductor = idConductor;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public String getIdConductor() {
		return idConductor;
	}
	public void setIdConductor(String idConductor) {
		this.idConductor = idConductor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
}
