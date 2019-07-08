package Controladores;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Dao.ConexionBD;
import Dao.Consultas;

public class Controlador {
	public int guardarDenunciaAnimal(String descripcion, String observaciones, String nombreDenunciante, String calleD, String numeroD,String distritoD, String ciudadD, String provinciaD, String codigoPostalD, String telefonoD, String tipo, String cantidad, String fecha, String calle, String numero,String distrito, String ciudad, String provincia, String codigoPostal, String telefono) throws SQLException {
		return Consultas.insertAnimal(descripcion, observaciones, nombreDenunciante, calleD, numeroD, distritoD, ciudadD, provinciaD, codigoPostalD, telefonoD, tipo, cantidad, fecha, calle, numero, distrito, ciudad, provincia, codigoPostal, telefono);
	}

	public int guardarDenunciaEspecial(String descripcion, String observaciones, String nombreDenunciante, String calleD, String numeroD,String distritoD, String ciudadD, String provinciaD, String codigoPostalD, String telefonoD, String edad, String nivelAcademico, String ocupacion, String calle,String numero, String distrito,String ciudad,String provincia, String codigoPostal,String telefono) throws SQLException{
		return Consultas.insertEspecial(descripcion, observaciones, nombreDenunciante, calleD, numeroD, distritoD, ciudadD, provinciaD, codigoPostalD, telefonoD, edad, nivelAcademico, ocupacion, calle, numero, distrito, ciudad, provincia, codigoPostal, telefono);
	}
	public int guardarDenunciasComida(String descripcion, String observaciones, String nombreDenunciante, String calleD, String numeroD, String distritoD, String ciudadD, String provinciaD, String codigoPostalD, String telefonoD, String nombreVictima, String calleV,  String numeroV, String distritoV, String ciudadV, String provinciaV, String codigoPostalV, String telefonoV, String cantVictimas, String cantEnfermos, String cantInternados, String cantMuertos, String calleH, String numeroH, String distritoH, String ciudadH, String provinciaH, String codigoPostalH, String telefonoH, String comida) throws SQLException{
		return Consultas.insertComidas(descripcion, observaciones, nombreDenunciante, calleD, numeroD, distritoD, ciudadD, provinciaD, codigoPostalD, telefonoD, nombreVictima, calleV, numeroV, distritoV, ciudadV, provinciaV, codigoPostalV, telefonoV, cantVictimas, cantEnfermos, cantInternados, cantMuertos, calleH, numeroH, distritoH, ciudadH, provinciaH, codigoPostalH, telefonoH, comida);
	}
	
	public int guardarEmpleadoActualizado(Integer idEmpleado, String nombre, String contraseña) throws SQLException {
		  return Consultas.ActualizarEmpleado(idEmpleado,nombre,contraseña);
		 }
	
	public int guardarAltaEmpleado(int idEmpleado, String nombre, String contraseña) throws SQLException {
		  return Consultas.insertEmpleado(idEmpleado,nombre,contraseña);
		 }
	
	public String[] obtenerEmpleado(DefaultTableModel modelo) throws SQLException {
		  String resultado[] = {"","",""};
		  for (int i = 0; i < 3; i ++){
		   resultado[i] =  modelo.getValueAt(0, i).toString();
		  }
		  return resultado;
		 }

	public static int insertEmpleado(int idEmpleado, String nombre, String contraseña) throws SQLException {
		  String sql = "INSERT INTO empleado (id_Empleado,nombre,contraseña) VALUES (?,?,?);";
		  int idConsulta = ConexionBD.guardarNuevoEmpleado(sql,idEmpleado,nombre,contraseña);
		  return idConsulta;
	}

	 public static DefaultTableModel buscarEmpleado(String palabras) {
		  DefaultTableModel modelo = ConexionBD.buscarEmpleado(armarSqlBuscarEmpleado(palabras));
		  return modelo;
	 }
	 
	 public static String armarSqlBuscarEmpleado(String txt){
		  String frase = "SELECT id_Empleado,nombre,contraseña FROM empleado WHERE (";
		  String [] palabras = txt.split(" ");
		  int longitud = palabras.length;
		  int vuelta = 0;
		  for(String aux:palabras){
			   frase = frase + "id_Empleado LIKE '%" + aux +"%' OR nombre LIKE '%" + aux + "%'";
			   vuelta ++;
			   if (longitud != vuelta){
			    frase = frase + " OR ";
			   }
		  }
		  return frase + ");";
	 }

	 public static int ActualizarEmpleado(Integer idEmpleado, String nombre, String contraseña) throws SQLException {
		  String sql = "UPDATE empleado SET nombre = '" + nombre + "', contraseña = '" + contraseña + "' WHERE id_Empleado = " + idEmpleado + ";";
		  int idConsulta = ConexionBD.ejectuarSql3(sql,idEmpleado);
		  return idConsulta;
	 }
	 
	 public static boolean verificarDatos(String idIngresado, String passIngresada) {
		  return Consultas.verificarContraseña(idIngresado, passIngresada);
	}
	 
	 public static boolean verificarDatos(String idIngresado) {
		  return Consultas.idExistente(idIngresado);
	 }
	 

	 
}
