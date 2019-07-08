package Entidades;

import java.util.Date;

public class Libro extends DatosComunes {
	private String autor_es;
	private String editorial;
	private String genero;
	private String serie;
	private String pelicula;
	
	public Libro(String idUsuario, String nombreLibro, String autor_es, String editorial, String genero, Date fecha, int puntaje, String serie, String pelicula) {
		super(idUsuario, nombreLibro, fecha, puntaje);
		this.autor_es = autor_es;
		this.editorial = editorial;
		this.genero = genero;
		this.serie = serie;
		this.pelicula = pelicula;
	}
	public String getAutor_es() {
		return autor_es;
	}
	public void setAutor_es(String autor_es) {
		this.autor_es = autor_es;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getPelicula() {
		return pelicula;
	}
	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}
}
