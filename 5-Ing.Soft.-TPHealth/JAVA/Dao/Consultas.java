package Dao;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class Consultas extends ConexionBD { //Consultas es subclase de ConexionBD (así podemos llamar a sus metodos)
	
	public static int insertAnimal(String descripcion, String observaciones, String nombreDenunciante, String calleD, String numeroD,String distritoD, String ciudadD, String provinciaD, String codigoPostalD, String telefonoD, String tipo, String cantidad, String fecha, String calle, String numero,String distrito, String ciudad, String provincia, String codigoPostal, String telefono) throws SQLException{
		String sql = "insert into DenunciaAnimal (descripcion_denuncia, observaciones_denuncia, nombre_den, calle_den, numero_den, distrito_den, ciudad_den, provincia_den, codigoPostal_den, telefono_den, estado_denuncia, tipo_an, cantidad_an, fecha_an, calle_an, numero_an, distrito_an, ciudad_an, provincia_an, codigoPostal_an, telefono_an) " + "VALUES "
				+ "('" + descripcion +"','"+ observaciones +"','"+ nombreDenunciante +"','"+ calleD +"','"+ numeroD +"','"+ distritoD +"','"+ ciudadD +"','"+ provinciaD +"','"+ codigoPostalD +"','"+ telefonoD +"','"+ "OPENED" +"','"+ tipo +"','"+ cantidad +"','"+ fecha +"','"+ calle +"','"+ numero +"','"+ distrito +"','"+ ciudad +"','"+ provincia +"','"+ codigoPostal +"','"+ telefono +"');";
		int idConsulta = ConexionBD.ejectuarSql2(sql); //Hago el insert y me devulve el id de ese insert nuevo.
		return idConsulta;
	}
	
	public static int insertComidas(String descripcion, String observaciones, String nombreDenunciante, String calleD, String numeroD,String distritoD, String ciudadD, String provinciaD, String codigoPostalD, String telefonoD, String nombreVictima, String calleV, String numeroV, String distritoV, String ciudadV,String provinciaV, String codigoPostalV, String telefonoV, String cantVictimas, String cantEnfermos, String cantInternados, String cantMuertos, String calleH, String numeroH, String distritoH, String ciudadH, String provinciaH, String codigoPostalH, String telefonoH, String comida) throws SQLException{
		String sql = "insert into DenunciaComida (descripcion_denuncia, observaciones_denuncia, nombre_den, calle_den, numero_den, distrito_den, ciudad_den, provincia_den, codigoPostal_den, telefono_den, estado_denuncia, nombreVictima, calle_vic, numero_vic, distrito_vic, ciudad_vic, provincia_vic, codigoPostal_vic, telefono_vic, cantVictimas, cantEnfermos, cantInternados, cantMuertos, calle_hospi, numero_hospi, distrito_hospi, ciudad_hospi, provincia_hospi, codigoPostal_hospi, telefono_hospi, comida ) " + "VALUES "
				+ "('" + descripcion +"','"+ observaciones +"','"+ nombreDenunciante +"','"+ calleD +"','"+ numeroD +"','"+ distritoD +"','"+ ciudadD +"','"+ provinciaD +"','"+ codigoPostalD +"','"+ telefonoD +"','"+ "OPENED" +"','"+ nombreVictima +"','"+ calleV +"','"+ numeroV +"','"+ distritoV +"','"+ ciudadV +"','"+ provinciaV +"','"+ codigoPostalV +"','"+ telefonoV +"','"+ cantVictimas +"','"+ cantEnfermos +"','"+ cantInternados +"','"+ cantMuertos +"','"+ calleH +"','"+ numeroH +"','"+ distritoH +"','"+ ciudadH +"','"+ provinciaH +"','"+ codigoPostalH +"','"+ telefonoH +"','"+ comida +"');";
		int idConsulta = ConexionBD.ejectuarSql2(sql); //Hago el insert y me devulve el id de ese insert nuevo.
		return idConsulta;
	}
	
	public static int insertEspecial(String descripcion, String observaciones, String nombreDenunciante, String calleD, String numeroD,String distritoD, String ciudadD, String provinciaD, String codigoPostalD, String telefonoD, String edad, String nivelAcademico, String ocupacion, String calle,String numero, String distrito,String ciudad,String provincia, String codigoPostal,String telefono) throws SQLException{
		String sql = "insert into DenunciaEspecial (descripcion_denuncia, observaciones_denuncia, nombre_den, calle_den, numero_den, distrito_den, ciudad_den, provincia_den, codigoPostal_den, telefono_den, estado_denuncia, edad_esp, nivelAcademico_esp, ocupacion_esp, calle_esp, numero_esp, distrito_esp, ciudad_esp, provincia_esp, codigoPostal_esp, telefono_esp) " + "VALUES "
				+ "('" + descripcion +"','"+ observaciones +"','"+ nombreDenunciante +"','"+ calleD +"','"+ numeroD +"','"+ distritoD +"','"+ ciudadD +"','"+ provinciaD +"','"+ codigoPostalD +"','"+ telefonoD +"','"+ "OPENED" +"','"+ edad +"','"+ nivelAcademico +"','"+ ocupacion +"','"+ calle +"','"+ numero +"','"+ distrito +"','"+ ciudad +"','"+ provincia +"','"+ codigoPostal +"','"+ telefono +"');";
		int idConsulta = ConexionBD.ejectuarSql2(sql); //Hago el insert y me devulve el id de ese insert nuevo.
		return idConsulta;	
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

	public static DefaultTableModel traerEspecialidades() {
		String sql = "select * from Especialidad";
		DefaultTableModel modelo = ConexionBD.traerEspecialidades(sql);
		
		return modelo;
	}

	public static DefaultTableModel traerHospitales() {
		String sql = "select idHospital, nombre from Hospital";
		DefaultTableModel modelo = ConexionBD.traerHospitales(sql);
		
		return modelo;
	}
	
	public static DefaultTableModel traerEnfermedades() {
		String sql = "select idEnfermedad, descripcion from Enfermedad";
		DefaultTableModel modelo = ConexionBD.traerEnfermedades(sql);
		
		return modelo;
	}
	
	public static DefaultTableModel traerDatosEnfermedades(int idEnfermedad) {
		String sql = "select * from Enfermedad where idEnfermedad = "+idEnfermedad;
		DefaultTableModel modelo = ConexionBD.traerDatosEnfermedades(sql);
		
		return modelo;
	}
	
	public static DefaultTableModel traerHospitalesPorEspecialidad(int idEspecialidad){
		String sql = "select Hospital.idHospital, Hospital.nombre, Hospital.direccion from (EspecialidadesHospital inner join Hospital on EspecialidadesHospital.idHospital = Hospital.idHospital) where EspecialidadesHospital.idEspecialidad ="+idEspecialidad;
		DefaultTableModel modelo = ConexionBD.traerHospitalesPorEspecialidad(sql);
		
		return modelo;
	}
	
	public static DefaultTableModel traerEspecialidadesPorHospital(int idHospital){
		String sql = "select Especialidad.idEspecialidad, Especialidad.nombre from (EspecialidadesHospital inner join Especialidad on EspecialidadesHospital.idEspecialidad = Especialidad.idEspecialidad) where EspecialidadesHospital.idHospital ="+idHospital;
		DefaultTableModel modelo = ConexionBD.traerEspecialidades(sql);
		
		return modelo;
	}
	
	public static DefaultTableModel traerDenunciaAnimal(int numero) {
		String sql = "select id_Animal, descripcion_denuncia, estado_denuncia, tipo_an, cantidad_an from DenunciaAnimal where id_Animal="+numero;
		DefaultTableModel modelo = ConexionBD.traerDenunciaAnimal(sql);
		
		return modelo;
	}
	
	public static DefaultTableModel traerDenunciaEspecial(int numero) {
		String sql = "select id_Especial, descripcion_denuncia, estado_denuncia, edad_esp, nivelAcademico_esp, ocupacion_esp from DenunciaEspecial where id_Especial="+numero;
		DefaultTableModel modelo = ConexionBD.traerDenunciaEspecial(sql);
		
		return modelo;
	}
	
	public static DefaultTableModel traerDenunciaComida(int numero) {
		String sql = "select id_Comida, descripcion_denuncia, estado_denuncia, comida, cantVictimas, cantEnfermos, cantInternados, cantMuertos from DenunciaComida where id_Comida="+numero;
		DefaultTableModel modelo = ConexionBD.traerDenunciaComida(sql);
		
		return modelo;
	}
	
	//Login:
	public static boolean verificarContraseña(String idIngresado, String passIngresada) {
		  String sql = "select contraseña from Empleado where id_Empleado="+idIngresado+";";
		  String password = ConexionBD.traerContraseña(sql);
		  System.out.println("Pass ingresada = "+passIngresada+" - password = "+password);
		  return password.equals(passIngresada);
		}

		public static boolean idExistente(String idIngresado) {
		  String sql = "select * from Empleado where id_Empleado="+idIngresado+";";
		  return ConexionBD.idExistente(sql);
		}

}