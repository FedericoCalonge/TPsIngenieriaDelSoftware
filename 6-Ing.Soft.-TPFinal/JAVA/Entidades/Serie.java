package Entidades;

import java.util.Date;

public class Serie extends DatosComunes {

	private int temporadas;
	private int capitulos;
	private String plataforma;
	private String actor_es;
	private String actriz_es;
	private String libro;
	private String pelicula;
	private boolean finalizada;
	private String links;
	private int temporadaActual;
	private int capituloActual;

	public Serie(String idUsuario, String nombreSerie, int temporadas, int capitulos, String plataforma, String actor_es, String actriz_es, Date fecha, String libro, String pelicula, boolean finalizada, String links, int temporadaActual, int capituloActual, int puntaje) {
		super(idUsuario, nombreSerie, fecha, puntaje);
		this.temporadas = temporadas;
		this.capitulos = capitulos;
		this.plataforma = plataforma;
		this.actor_es = actor_es;
		this.actriz_es = actriz_es;
		this.libro = libro;
		this.pelicula = pelicula;
		this.finalizada = finalizada;
		this.links = links;
		this.temporadaActual = temporadaActual;
		this.capituloActual = capituloActual;
	}
	
	public int getTemporadas() {
		return temporadas;
	}
	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}
	public int getCapitulos() {
		return capitulos;
	}
	public void setCapitulos(int capitulos) {
		this.capitulos = capitulos;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
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
	public String getPelicula() {
		return pelicula;
	}
	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}
	public boolean isFinalizada() {
		return finalizada;
	}
	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
	public String getLinks() {
		return links;
	}
	public void setLinks(String links) {
		this.links = links;
	}
	public int getTemporadaActual() {
		return temporadaActual;
	}
	public void setTemporadaActual(int temporadaAcual) {
		this.temporadaActual = temporadaAcual;
	}
	public int getCapituloActual() {
		return capituloActual;
	}
	public void setCapituloActual(int capituloActual) {
		this.capituloActual = capituloActual;
	}	
}
