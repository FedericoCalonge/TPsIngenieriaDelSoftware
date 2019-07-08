package Entidades;

import java.util.Date;

public class Pelicula extends DatosComunes {
	
	private String director_a;
	private String actor_es;
	private String actriz_es;
	private String libro;
	private String serie;

	public Pelicula(String idUsuario, String nombrePelicula, String director_a, String actor_es, String actriz_es, Date fecha, int puntaje, String libro, String serie) {
		super(idUsuario, nombrePelicula, fecha, puntaje);
		this.director_a = director_a;
		this.actor_es = actor_es;
		this.actriz_es = actriz_es;
		this.libro = libro;
		this.serie = serie;
	}

	public String getDirector_a() {
		return director_a;
	}
	public void setDirector_a(String director_a) {
		this.director_a = director_a;
	}
	public String getActor_es() {
		return actor_es;
	}
	public void setActor_es(String actor_es) {
		this.actor_es = actor_es;
	}
	public String getActriz_es() {
		return actriz_es;
	}
	public void setActriz_es(String actriz_es) {
		this.actriz_es = actriz_es;
	}
	public String getLibro() {
		return libro;
	}
	public void setLibro(String libro) {
		this.libro = libro;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
}
