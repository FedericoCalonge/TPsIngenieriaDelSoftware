package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;



public class ConexionBD {
	private static String driver = "com.mysql.jdbc.Driver";
	//?useSSL=false es para que no me tire el error de Verificaci�n de SSL:
	private static String urlBD = "jdbc:mysql://localhost:3306/TPFINAL?useSSL=false";
	private static String usuario = "root";
	private static String pass = "0202";

	protected static Connection establecerConexion() {
			try { //Si no encuentra ninguno de los errores del catch se ejecuta el bloque try...
				Class.forName(ConexionBD.driver).newInstance(); //Creo una nueva instancia del objeto con el nombre com.mysql.jdbc.Driver.
				Connection conexion = DriverManager.getConnection(ConexionBD.urlBD, ConexionBD.usuario, ConexionBD.pass);
				if (conexion!=null)System.out.println("Conexion a la BD OK");
				return conexion; //Retorno la conexion para luego usarla si es que no hubo ningun error.
			} catch (SQLException e) {
				//Si capturo algun error SQLException entonces imprime...
				System.out.println("Error de BD en el metodo establecerConexion: " + e.getMessage());
				//Sino puedo imprimir la pila en ejecucion del error que me aparece en consola en rojo con --> e.printStackTrace();
			} catch (Exception ex) {
				//Si capturo algun error Exception entonces imprime...
				System.out.println("Error general en el metodo establecerConexion: " + ex.getMessage());
			}
			return null; //Si no se ejecuta el try por algun error (porque luego del catch del error
			//sigue la ejecuci�n del programa), devuelve null.
		}

	//Todo metodo con un trows lo que hace es: Si todo va bien hace lo que esta dentro del metodo
	//(en este caso el try que contiene --> conexion.close).
	//Y si ocurre algun error lo que hace es LANZAR (Throw) un Objeto que CREA de clase SQLException.
	protected static void cerrarConexion(Connection conexion)throws SQLException {
			try{ conexion.close();}
			catch (SQLException e) {
				System.out.println("Error de BD en el metodo cerrarConexion: " + e.getMessage());
			}
	}
	public static void ejecutarConsulta(String sql) throws SQLException {
		Connection conexion = ConexionBD.establecerConexion();
		Statement st = conexion.createStatement();

		st.executeUpdate(sql);

		st.close(); //Cierro el objeto Statement.
		ConexionBD.cerrarConexion(conexion);  //Cierro la conexi�n a la BD.
	}
	public static boolean idExistente(String sql) {
		boolean resultado = false;

		try {
		    Connection conexion = ConexionBD.establecerConexion();
		    Statement st = conexion.createStatement();
		    ResultSet rs = st.executeQuery(sql);

		          if(rs.next()) {
		            resultado = true;
		          }

		          rs.close();
		          st.close();
		          ConexionBD.cerrarConexion(conexion);
		}
		catch (SQLException e) {
			System.out.println("Error de BD en el metodo idExistente: " + e.getMessage());
		}
		return resultado;
	}
	public static String obtenerContrasena(String sql) {
		  String contrasena = "";

		  try {
		    Connection conexion = ConexionBD.establecerConexion();
		    Statement st = conexion.createStatement();
		    ResultSet rs = st.executeQuery(sql);

		        while(rs.next()){
		        	contrasena = rs.getString("contrasena");
		        }

		        rs.close();
		        st.close();
		        ConexionBD.cerrarConexion(conexion);
		  }
		  catch (SQLException e) {
		    System.out.println("Error de BD en el m�todo obtenerContrasena: " + e.getMessage());
		  }
		  return contrasena;
	}

	public static DefaultTableModel obtenerListadoTop5(String sql,String tipo) {
		DefaultTableModel modelo = new DefaultTableModel();
		try {
			Connection conexion = ConexionBD.establecerConexion();
		    Statement st = conexion.createStatement();

		    ResultSet rs = st.executeQuery(sql);

		    //Transformamos el ResultSet en DefaultTableModel
		    modelo.addColumn("Nombre");
		    modelo.addColumn("Puntaje");

		    //Recorremos los registros del ResultSet
		    Object[] registro;
		    while(rs.next()) {
			    registro = new Object[2];

			    registro[0] = rs.getObject("nombre" + tipo);
			    registro[1] = rs.getObject("puntaje");
			    modelo.addRow(registro);
		    }

		    rs.close();
		    st.close();
		    conexion.close();
		} catch (SQLException e) {
		   e.printStackTrace();
		}
		return modelo;
	}

	public static DefaultTableModel obtenerListadoLast5(String sql, String tipo) {
		DefaultTableModel modelo = new DefaultTableModel();
		try {
			Connection conexion = ConexionBD.establecerConexion();
		    Statement st = conexion.createStatement();

		    ResultSet rs = st.executeQuery(sql);

		    //Transformamos el ResultSet en DefaultTableModel
		    modelo.addColumn("Nombre");
		    modelo.addColumn("Fecha");

		    //Recorremos los registros del ResultSet
		    Object[] registro;
		    while(rs.next()) {
			    registro = new Object[2];

			    registro[0] = rs.getObject("nombre" + tipo);
			    registro[1] = rs.getObject("fecha");
			    modelo.addRow(registro);
		    }

		    rs.close();
		    st.close();
		    conexion.close();
		} catch (SQLException e) {
		   e.printStackTrace();
		}
		return modelo;
	}

	public static DefaultTableModel obtenerContactos(String sql) {
		DefaultTableModel modelo = new DefaultTableModel();


		try {
			Connection conexion = ConexionBD.establecerConexion();
		    Statement st = conexion.createStatement();

		    ResultSet rs = st.executeQuery(sql);

		    //Transformamos el ResultSet en DefaultTableModel
		    modelo.addColumn("E_mail");

		    //Recorremos los registros del ResultSet
		    Object[] registro;
		    while(rs.next()) {
			    registro = new Object[1];

			    registro[0] = rs.getObject("e_mail");
			    modelo.addRow(registro);
		    }

		    rs.close();
		    st.close();
		    conexion.close();
		} catch (SQLException e) {
		   e.printStackTrace();
		}
		return modelo;
	}
}
