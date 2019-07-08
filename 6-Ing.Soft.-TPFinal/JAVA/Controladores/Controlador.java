package Controladores;

import java.util.Date;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Dao.Consultas;
import Entidades.*;

public class Controlador {
	public static boolean altaUsuario(String eMail, String nombreUsuario, String contrasena) {
		Usuario usuario = new Usuario (eMail,nombreUsuario,contrasena);	
		return Consultas.insertUsuario(usuario);
	}
	public static boolean eMailExistente(String eMail) {
		return Consultas.idExistente(eMail);
	}
	public static boolean verificarDatos(String eMail, String contrasena) {
		return Consultas.verificarContrasena(eMail, contrasena);
	}
	public static boolean altaLibro(String idUsuario, String nombreLibro, String autor_es, String editorial, String genero,
		Date fechaLectura, int puntaje, String serie, String pelicula) {
		Libro libro = new Libro(idUsuario,nombreLibro,autor_es,editorial,genero,fechaLectura,puntaje,serie,pelicula);
		return Consultas.insertLibro(libro);
	}
	public static boolean altaPelicula(String idUsuario, String nombrePelicula, String director_a, String actor_es, String actriz_es,
		Date fechaLectura, int puntaje, String libro, String serie) {
		Pelicula pelicula = new Pelicula(idUsuario,nombrePelicula,director_a,actor_es,actriz_es,fechaLectura,puntaje,libro,serie);
		return Consultas.insertPelicula(pelicula);
	}
	public static boolean altaSerie(String idUsuario, String nombreSerie, int temporadas, int capitulos, String plataforma,
		String actor_es, String actriz_es, String libro, String pelicula, Date fecha, boolean finalizada, String links,
		int temporadaActual, int capituloActual,int puntaje) {
		Serie serie = new Serie(idUsuario,nombreSerie,temporadas,capitulos,plataforma,actor_es,actriz_es,fecha,libro,pelicula,finalizada,links,temporadaActual,capituloActual,puntaje);
		return Consultas.insertSerie(serie);
	}
	public static DefaultTableModel obtenerTop5(String idUsuario, String tipo) {
		return Consultas.obtenerTop5(idUsuario,tipo);
	}
	public static DefaultTableModel obtenerLast5(String idUsuario, String tipo) {
		return Consultas.obtenerLast5(idUsuario,tipo);
	}
	public static DefaultTableModel obtenerContactos(String IdUsuario) {
		return Consultas.obtenerContactos(IdUsuario);
	}
	public static boolean altaMensaje(String idUsuarioEmisor, String idUsuarioReceptor, String mensaje) {
		Mensaje msj = new Mensaje(idUsuarioEmisor,idUsuarioReceptor,mensaje);
		return Consultas.insertMensaje(msj);
	}
	public static String crearMensaje(TableModel model) {
		String mensaje = "";
		
		if (model.getColumnName(1).equals("Puntaje")){
			//TOP 5
			mensaje = "Listado TOP 5\n";
		}
		else {
			//LAST 5
			mensaje = "Listado LAST 5\n";
		}
		
		for(int i=0; i<model.getRowCount();i++) {
			mensaje += "\n" + model.getValueAt(i, 0)+" - "+model.getValueAt(i, 1);
		}
		
		return mensaje;
	}
}
