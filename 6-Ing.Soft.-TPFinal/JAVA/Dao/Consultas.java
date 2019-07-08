package Dao;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

import Entidades.Libro;
import Entidades.Mensaje;
import Entidades.Pelicula;
import Entidades.Serie;
import Entidades.Usuario;

public class Consultas {

	public static boolean insertUsuario(Usuario usuario) {
		boolean resultado = false;
		String sql = "INSERT INTO Usuario (e_Mail,nombre,contrasena) VALUES ('" + usuario.geteMail() + "','" + usuario.getNombreUsuario() + "','" + usuario.getContrasena() + "');";

		try {
			ConexionBD.ejecutarConsulta(sql);
			resultado = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return resultado;
	}
	public static boolean idExistente(String eMail) {
		String sql = "select * from Usuario where e_Mail = '" + eMail + "';";
		return ConexionBD.idExistente(sql);
	}
	public static boolean verificarContrasena(String eMail, String contrasenaIngresada) {
		String sql = "select contrasena from Usuario where e_Mail = '" + eMail + "';";
		String contrasenaBD = ConexionBD.obtenerContrasena(sql);
		return contrasenaBD.equals(contrasenaIngresada);
	}
	public static boolean insertLibro(Libro libro) {
		boolean resultado = false;
		if (!datosExistentes("Libro",libro.getIdUsuario(),libro.getNombre(),libro.getFecha())) {
			
			String sql = "INSERT INTO Libro (idUsuario,nombreLibro,autor_es,editorial,genero,fecha,puntaje,serie,pelicula) VALUES ('" + libro.getIdUsuario() + "','" + libro.getNombre() + "','" + libro.getAutor_es() + "','" + libro.getEditorial() + "','" + libro.getGenero() + "','" + fechaAString(libro.getFecha()) + "','" + libro.getPuntaje() + "','" + libro.getSerie() + "','" + libro.getPelicula() + "');";
			try {
				ConexionBD.ejecutarConsulta(sql);
				resultado = true;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return resultado;
	}
	public static boolean insertPelicula(Pelicula pelicula) {
		boolean resultado = false;
		if (!datosExistentes("Pelicula",pelicula.getIdUsuario(),pelicula.getNombre(),pelicula.getFecha())) {
			String sql = "INSERT INTO Pelicula (idUsuario,nombrePelicula,director_a,actor_es,actriz_es,fecha,puntaje,libro,serie) VALUES ('" + pelicula.getIdUsuario() + "','" + pelicula.getNombre() + "','" + pelicula.getDirector_a() + "','" + pelicula.getActor_es() + "','" + pelicula.getActriz_es() + "','" + fechaAString(pelicula.getFecha()) + "','" + pelicula.getPuntaje() + "','" + pelicula.getLibro() + "','" + pelicula.getSerie() + "');";
			try {
				ConexionBD.ejecutarConsulta(sql);
				resultado = true;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return resultado;
	}
	public static boolean insertSerie(Serie serie) {
		boolean resultado = false;
		if (!datosExistentes("Serie",serie.getIdUsuario(),serie.getNombre(),serie.getFecha())) {
			String sql = "INSERT INTO Serie (idUsuario,nombreSerie,temporadas,capitulos,plataforma,actor_es,actriz_es,libro,pelicula,fecha,finalizada,links,temporadaActual,capituloActual,puntaje) VALUES ('" + serie.getIdUsuario() + "','" + serie.getNombre() + "','" + serie.getTemporadas() + "','" + serie.getCapitulos() + "','" + serie.getPlataforma()  + "','" + serie.getActor_es() + "','" + serie.getActriz_es()  + "','" + serie.getLibro() + "','" + serie.getPelicula() + "','" + fechaAString(serie.getFecha())  + "', " + serie.isFinalizada() + " ,'" + serie.getLinks() + "','" + serie.getTemporadaActual() + "','" + serie.getCapituloActual()  + "','" + serie.getPuntaje() + "');";
			try {
				ConexionBD.ejecutarConsulta(sql);
				resultado = true;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return resultado;
	}
	private static boolean datosExistentes(String tabla, String idUsuario, String nombre, Date fecha) {
		String sql = "select * from " + tabla + " where idUsuario = '" + idUsuario + "' AND nombre" + tabla + " = '" + nombre + "' AND fecha = '" + fecha + "';";
		return ConexionBD.idExistente(sql);
	}
	public static DefaultTableModel obtenerTop5(String idUsuario, String tipo) {
		//select nombreLibro,puntaje from Libro where  idUsuario = 'profe@gmail.com' order by puntaje desc limit 5;
		String sql = "select nombre" + tipo + ",puntaje from " + tipo + " where idUsuario = '" + idUsuario + "' order by puntaje desc limit 5;";
		return ConexionBD.obtenerListadoTop5(sql,tipo);
	}
	public static DefaultTableModel obtenerLast5(String idUsuario, String tipo) {
		//select nombreLibro,fecha from Libro where  idUsuario = 'profe@gmail.com' order by fecha desc limit 5;
		String sql = "select nombre" + tipo + ",fecha from " + tipo + " where idUsuario = '" + idUsuario + "' order by fecha desc limit 5;";
		return ConexionBD.obtenerListadoLast5(sql,tipo);
	}
	public static DefaultTableModel obtenerContactos(String idUsuario) {
		String sql = "select e_mail from Usuario where e_mail not like '" + idUsuario + "';";
		return ConexionBD.obtenerContactos(sql);
	}
	public static String fechaAString(Date fechaIngresada) {
		DateFormat df = new SimpleDateFormat("yyy-MM-dd");
		return df.format(fechaIngresada);
	}
	public static boolean insertMensaje(Mensaje mensaje) {
		boolean resultado = false;
		String sql = "INSERT INTO Mensaje (idUsuarioEmisor,idUsuarioReceptor,mensaje) VALUES ('" + mensaje.geteMailEmisor() + "','" + mensaje.geteMailReceptor() + "','" + mensaje.getMensaje() + "');";

		try {
			ConexionBD.ejecutarConsulta(sql);
			resultado = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return resultado;
	}
}